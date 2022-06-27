package br.com.mini.autorizador.controllers;


import br.com.mini.autorizador.api.TransacaoApi;
import br.com.mini.autorizador.core.ports.driver.TransacaoService;
import br.com.mini.autorizador.dtos.CartaoValorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class TransacaoController implements TransacaoApi {

    @Autowired
    private TransacaoService service;

    @Override
    public String efetuarTransacao(@Valid CartaoValorDTO transacao) {
        return Optional.of(transacao)
                .map(service::validarTransacao).get();
    }
}
