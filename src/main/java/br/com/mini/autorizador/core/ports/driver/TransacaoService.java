package br.com.mini.autorizador.core.ports.driver;

import br.com.mini.autorizador.core.entities.Cartao;
import br.com.mini.autorizador.dtos.CartaoValorDTO;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Validated
public interface TransacaoService {

    String validarTransacao(CartaoValorDTO cartaoValorDTO);

}
