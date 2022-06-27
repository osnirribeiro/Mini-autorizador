package br.com.mini.autorizador.core.utils.exceptions;

import br.com.mini.autorizador.core.utils.Mensagem;
import lombok.Getter;

@Getter
public class SenhaInvalidaBusinessException extends RuntimeException {
    private final Mensagem mensagem;

    public SenhaInvalidaBusinessException() {
        super(Mensagem.SENHA_INVALIDA.toString());
        this.mensagem = Mensagem.SENHA_INVALIDA;
    }

}
