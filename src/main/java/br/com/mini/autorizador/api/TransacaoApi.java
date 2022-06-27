package br.com.mini.autorizador.api;


import br.com.mini.autorizador.dtos.CartaoValorDTO;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

@Api(tags = "Transacao")
@RequestMapping(TransacaoApi.PATH)
@SwaggerDefinition(tags = {@Tag(name = "Transacao", description = "Endpoints para transações com cartão alimentação")})
public interface TransacaoApi {


    String TRANSACOES = "transacoes";
    String ROOT = "/";
    String PATH = ROOT + TRANSACOES;

    @ApiOperation("Criar novo cartão")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({@ApiResponse(code = 201, message = "Success"),
            @ApiResponse(code = 422, message = "Unprocessable Entity", response = String.class),
            @ApiResponse(code = 500, message = "Internal server error", response = String.class)})
    @ResponseStatus(HttpStatus.CREATED)
    String efetuarTransacao(@Valid @RequestBody final CartaoValorDTO transacao);
}
