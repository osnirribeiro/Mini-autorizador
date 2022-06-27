package br.com.mini.autorizador.core.services;

import br.com.mini.autorizador.core.entities.Cartao;
import br.com.mini.autorizador.core.ports.driven.MiniAutorizadorRepository;
import br.com.mini.autorizador.core.ports.driver.MiniAutorizadorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Service
@AllArgsConstructor
class MiniAutorizadorServiceImpl implements MiniAutorizadorService {

    private final MiniAutorizadorRepository repository;

    private final  BigDecimal saldoInicial = new BigDecimal(500);

    @Override
    public Cartao incluir(@NotNull Cartao cartao) {
        cartao.setSaldo(saldoInicial);
        return repository.incluir(cartao);
    }

    @Override
    public Cartao obter(@NotBlank String numeroCartao) {
        return repository.obterSaldoCartao(numeroCartao);
    }

    @Override
    public Cartao obterSenha(@NotBlank String senha) {
        return repository.obterSenha(senha);
    }

    @Override
    public Cartao validarSaldo(@NotNull BigDecimal valor) {
        return  repository.validarSaldo(valor);
    }


}
