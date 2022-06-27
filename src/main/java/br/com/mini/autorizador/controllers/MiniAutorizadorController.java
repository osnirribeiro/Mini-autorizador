package br.com.mini.autorizador.controllers;


import br.com.mini.autorizador.api.MiniAutorizadorApi;
import br.com.mini.autorizador.core.ports.driver.MiniAutorizadorService;
import br.com.mini.autorizador.core.utils.exceptions.CartaoExisteBusinessException;
import br.com.mini.autorizador.core.utils.exceptions.CartaoNaoExisteBusinessException;
import br.com.mini.autorizador.dtos.CartaoDTO;
import br.com.mini.autorizador.dtos.CartaoResponseCriadoDTO;
import br.com.mini.autorizador.dtos.CartaoResponseSaldoDTO;
import br.com.mini.autorizador.mappers.CartaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController

public class MiniAutorizadorController implements MiniAutorizadorApi {

    @Autowired
    private  MiniAutorizadorService service;

    @Autowired
    private  CartaoMapper cartaoMapper;


    @Override
    public CartaoResponseCriadoDTO incluir(@Valid CartaoDTO inclusao) {

        return Optional.of(inclusao)
                .map(cartaoMapper::fromDto)
                .map(service::incluir)
                .map(cartaoMapper::toDto)
                .orElseThrow(CartaoExisteBusinessException::new);

    }

    @Override
    public CartaoResponseSaldoDTO obterSaldoCartao(String numeroCartao) {

        return Optional.of(numeroCartao)
                .map(service::obter)
                .map(cartaoMapper::cartaotoDtoSaldo)
                .orElseThrow(CartaoNaoExisteBusinessException::new);
    }



}
