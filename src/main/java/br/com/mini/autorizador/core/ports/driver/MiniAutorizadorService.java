package br.com.mini.autorizador.core.ports.driver;

import br.com.mini.autorizador.core.entities.Cartao;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Validated
public interface MiniAutorizadorService {

    Cartao incluir(@NotNull Cartao cartao) ;

    Cartao obter(@NotBlank String numeroCartao);

    Cartao obterSenha(@NotBlank String senha);

    Cartao validarSaldo(@NotNull BigDecimal valor);

}
