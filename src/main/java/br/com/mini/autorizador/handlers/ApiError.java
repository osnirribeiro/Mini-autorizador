package br.com.mini.autorizador.handlers;

import br.com.mini.autorizador.core.utils.Mensagem;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {

    public static final String APLICACAO = "Mini Autorizador";

    private HttpStatus status;
    private String message;
    private Mensagem code;
    private List<String> errors;
    private String aplicacao;

    public ApiError() {
        super();
    }

    public ApiError(final HttpStatus status, final String message, final List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
        this.aplicacao = APLICACAO;
    }

    public ApiError(final HttpStatus status, final String message, final Mensagem code, final List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.code = code;
        this.errors = errors;
        this.aplicacao = APLICACAO;
    }

    public ApiError(final HttpStatus status, final String message, final Mensagem code, final List<String> errors, String aplicacao) {
        super();
        this.status = status;
        this.message = message;
        this.code = code;
        this.errors = errors;
        this.aplicacao = aplicacao;
    }

    public ApiError(final HttpStatus status, final String message, final String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
        this.aplicacao = APLICACAO;
    }
}
