package br.com.mini.autorizador.api;

import br.com.mini.autorizador.core.entities.Cartao;
import br.com.mini.autorizador.dtos.CartaoDTO;
import br.com.mini.autorizador.dtos.CartaoResponseCriadoDTO;
import br.com.mini.autorizador.dtos.CartaoResponseSaldoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

@Api(tags = "Mini Autorizador")
@RequestMapping(MiniAutorizadorApi.PATH)
@SwaggerDefinition(tags = {@Tag(name = "Mini Autorizador", description = "Endpoints para validar operações com cartão alimentação")})
public interface MiniAutorizadorApi {

    String CARTOES = "cartoes";
    String ROOT = "/";
    String PATH = ROOT + CARTOES;

    @ApiOperation("Criar novo cartão")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({@ApiResponse(code = 201, message = "Success"),
            @ApiResponse(code = 422, message = "Unprocessable Entity", response = String.class),
            @ApiResponse(code = 500, message = "Internal server error", response = String.class)})
    @ResponseStatus(HttpStatus.CREATED)
    CartaoResponseCriadoDTO incluir(@Valid @RequestBody final CartaoDTO inclusao);


    @ApiOperation("Obter saldo do Cartão")
    @GetMapping(value = "/{numeroCartao}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = Cartao.class),
            @ApiResponse(code = 404, message = "NotFound", response = String.class),
            @ApiResponse(code = 500, message = "Internal server error", response = String.class)})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    CartaoResponseSaldoDTO obterSaldoCartao(@PathVariable String numeroCartao);

}
