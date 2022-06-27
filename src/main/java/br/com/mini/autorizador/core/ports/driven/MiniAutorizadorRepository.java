package br.com.mini.autorizador.core.ports.driven;

import br.com.mini.autorizador.core.entities.Cartao;
import br.com.mini.autorizador.core.utils.exceptions.CartaoExisteBusinessException;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public interface MiniAutorizadorRepository {

   Cartao incluir(@Valid Cartao inclusao) throws CartaoExisteBusinessException;

   Cartao obterSaldoCartao(String numeroCartao);

   Cartao validarSaldo(BigDecimal saldo);

   Cartao obterSenha(@NotBlank String senha);

}
