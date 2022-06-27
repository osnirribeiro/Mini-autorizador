package br.com.mini.autorizador.core.services;

import br.com.mini.autorizador.core.entities.Cartao;
import br.com.mini.autorizador.core.ports.driven.MiniAutorizadorRepository;
import br.com.mini.autorizador.core.ports.driver.MiniAutorizadorService;
import br.com.mini.autorizador.core.utils.exceptions.CartaoNaoExisteBusinessException;
import br.com.mini.autorizador.core.utils.exceptions.SaldoInsuficienteBusinessException;
import br.com.mini.autorizador.core.utils.exceptions.SenhaInvalidaBusinessException;
import br.com.mini.autorizador.dtos.CartaoValorDTO;
import br.com.mini.autorizador.repositories.MiniAutorizadorRepositoryImpl;
import br.com.mini.autorizador.support.TestSupport;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import java.math.BigDecimal;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

public class TransacaoServiceImplTest extends TestSupport {

    @InjectMocks
    private TransacaoServiceImpl service;


    @Mock
    private TransacaoServiceImpl serviceTransacao;
    @Mock
    private MiniAutorizadorRepositoryImpl repository;
    @Mock
    private  MiniAutorizadorService serviceMiniAutorizador;



    @Test
    void transacaoTest(){

        Cartao cartao = Cartao.builder().numeroCartao("6549873025634501").senha("1234").saldo(new BigDecimal(500)).build();
        when(serviceMiniAutorizador.obter(any())).thenReturn(cartao);
        when(serviceMiniAutorizador.obterSenha(any())).thenReturn(cartao);
        when(serviceMiniAutorizador.validarSaldo(any())).thenReturn(cartao);

        when(repository.obterSaldoCartao(any())).thenReturn(cartao);
        when(repository.incluir(any())).thenReturn(cartao);

        CartaoValorDTO cartaoValorDto = CartaoValorDTO.builder().numeroCartao("6549873025634501").senha("1235").valor(new BigDecimal(500)).build();

        var resultado = service.validarTransacao(cartaoValorDto);

        assertNotNull(resultado);
    }

    //    realização de diversas transações, verificando-se o saldo em seguida, até que o sistema retorne informação de saldo insuficiente
    @Test
    void transacaoSaldoInsuficienteTest(){
        Cartao cartao = Cartao.builder().numeroCartao("6549873025634501").senha("1234").saldo(new BigDecimal(500)).build();
        when(serviceMiniAutorizador.obter(any())).thenReturn(cartao);
        when(serviceMiniAutorizador.obterSenha(any())).thenReturn(cartao);

        CartaoValorDTO cartaoValorDto = CartaoValorDTO.builder().numeroCartao("6549873025634501").senha("1235").valor(new BigDecimal(600)).build();
        assertThrows(SaldoInsuficienteBusinessException.class, () -> service.validarTransacao(cartaoValorDto));
    }

    //    realização de uma transação com senha inválida
    @Test
    void transacaoSenhaInvalidaTest() {

        Cartao cartao = Cartao.builder().numeroCartao("6549873025634501").senha("1235").build();
        when(serviceMiniAutorizador.obter(any())).thenReturn(cartao);

        CartaoValorDTO cartaoValorDto = CartaoValorDTO.builder().numeroCartao("6549873025634501").senha("1235").build();
        assertThrows(SenhaInvalidaBusinessException.class, () -> service.validarTransacao(cartaoValorDto));

    }

    //    realização de uma transação com cartão inexistente
    @Test
    void transacaoCartaoInexistenteTest() {

        CartaoValorDTO cartaoValorDto = CartaoValorDTO.builder().numeroCartao("6549873025634501").senha("1235").build();
        assertThrows(CartaoNaoExisteBusinessException.class, () -> service.validarTransacao(cartaoValorDto));

    }


}
