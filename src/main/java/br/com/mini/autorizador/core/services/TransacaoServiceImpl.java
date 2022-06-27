package br.com.mini.autorizador.core.services;

import br.com.mini.autorizador.core.entities.Cartao;
import br.com.mini.autorizador.core.ports.driver.MiniAutorizadorService;
import br.com.mini.autorizador.core.ports.driver.TransacaoService;
import br.com.mini.autorizador.core.utils.exceptions.CartaoNaoExisteBusinessException;
import br.com.mini.autorizador.core.utils.exceptions.SaldoInsuficienteBusinessException;
import br.com.mini.autorizador.core.utils.exceptions.SenhaInvalidaBusinessException;
import br.com.mini.autorizador.dtos.CartaoValorDTO;
import br.com.mini.autorizador.repositories.MiniAutorizadorRepositoryImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
class TransacaoServiceImpl implements TransacaoService {

    private final MiniAutorizadorService serviceMiniAutorizador;

    private final MiniAutorizadorRepositoryImpl repository;

    @Override
    public String validarTransacao(CartaoValorDTO cartaoValorDTO) {

        Optional.of(cartaoValorDTO.getNumeroCartao())
                .map(serviceMiniAutorizador::obter)
                .orElseThrow(CartaoNaoExisteBusinessException::new);

        Optional.of(cartaoValorDTO.getSenha())
                .map(serviceMiniAutorizador::obterSenha)
                .orElseThrow(SenhaInvalidaBusinessException::new);

        Optional.of(cartaoValorDTO.getValor())
                .map(serviceMiniAutorizador::validarSaldo)
                .orElseThrow(SaldoInsuficienteBusinessException::new);

        Cartao cartao = repository.obterSaldoCartao(cartaoValorDTO.getNumeroCartao());
        cartao.setSaldo(cartao.getSaldo().subtract(cartaoValorDTO.getValor()));
        repository.incluir(cartao);
        return HttpStatus.OK.toString();
    }


}
