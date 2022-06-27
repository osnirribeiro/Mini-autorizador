package br.com.mini.autorizador.core.utils.exceptions;

import br.com.mini.autorizador.core.utils.Mensagem;
import lombok.Getter;

@Getter
public class SaldoInsuficienteBusinessException extends RuntimeException {
    private final Mensagem mensagem;

    public SaldoInsuficienteBusinessException() {
        super(Mensagem.SALDO_INSUFICIENTE.toString());
        this.mensagem = Mensagem.SALDO_INSUFICIENTE;
    }

}
