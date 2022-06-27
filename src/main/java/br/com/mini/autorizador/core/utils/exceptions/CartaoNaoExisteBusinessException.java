package br.com.mini.autorizador.core.utils.exceptions;

import br.com.mini.autorizador.core.utils.Mensagem;
import lombok.Getter;

@Getter
public class CartaoNaoExisteBusinessException extends RuntimeException {
    private final Mensagem mensagem;

    public CartaoNaoExisteBusinessException() {
        super(Mensagem.CARTAO_INEXISTENTE.toString());
        this.mensagem = Mensagem.CARTAO_INEXISTENTE;
    }

}
