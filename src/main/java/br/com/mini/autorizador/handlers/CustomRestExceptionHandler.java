package br.com.mini.autorizador.handlers;


import br.com.mini.autorizador.core.utils.exceptions.CartaoExisteBusinessException;
import br.com.mini.autorizador.core.utils.exceptions.CartaoNaoExisteBusinessException;
import br.com.mini.autorizador.core.utils.exceptions.SaldoInsuficienteBusinessException;
import br.com.mini.autorizador.core.utils.exceptions.SenhaInvalidaBusinessException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    MessageSource messageSource;

    @Autowired
    ObjectMapper objectMapper;


     @ExceptionHandler({CartaoExisteBusinessException.class})
    public ResponseEntity<Object> handleCartaoExisteBusinessException(
            final CartaoExisteBusinessException ex,
            final WebRequest request) {
        logger.info(ex.getClass().getName(), ex);

        final ApiError apiError = new ApiError(
                HttpStatus.UNPROCESSABLE_ENTITY,
                "Esse cartão ja exite na base de dados",
                ex.getMensagem(),
                Collections.emptyList());

        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }


    @ExceptionHandler({CartaoNaoExisteBusinessException.class})
    public ResponseEntity<Object> handleCartaoNaoExisteBusinessException(
            final CartaoNaoExisteBusinessException ex,
            final WebRequest request) {
        logger.info(ex.getClass().getName(), ex);

        final ApiError apiError = new ApiError(
                HttpStatus.NOT_FOUND,
                "Esse cartão não exite na base de dados",
                ex.getMensagem(),
                Collections.emptyList());

        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }


    @ExceptionHandler({SenhaInvalidaBusinessException.class})
    public ResponseEntity<Object> handleCartaoNaoExisteBusinessException(
            final SenhaInvalidaBusinessException ex,
            final WebRequest request) {
        logger.info(ex.getClass().getName(), ex);

        final ApiError apiError = new ApiError(
                HttpStatus.UNPROCESSABLE_ENTITY,
                "Senha invalida",
                ex.getMensagem(),
                Collections.emptyList());

        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler({SaldoInsuficienteBusinessException.class})
    public ResponseEntity<Object> handleCartaoNaoExisteBusinessException(
            final SaldoInsuficienteBusinessException ex,
            final WebRequest request) {
        logger.info(ex.getClass().getName(), ex);

        final ApiError apiError = new ApiError(
                HttpStatus.UNPROCESSABLE_ENTITY,
                "Saldo insuficiente",
                ex.getMensagem(),
                Collections.emptyList());

        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }



}
