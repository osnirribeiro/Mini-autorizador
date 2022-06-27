package br.com.mini.autorizador.core.utils.exceptions;

import br.com.mini.autorizador.core.utils.Mensagem;
import lombok.Getter;

@Getter
public class CartaoExisteBusinessException extends RuntimeException {
    private final Mensagem mensagem;

    public CartaoExisteBusinessException() {
        super(Mensagem.CARTAO_JA_EXITE.toString());
        this.mensagem = Mensagem.CARTAO_JA_EXITE;
    }

}
