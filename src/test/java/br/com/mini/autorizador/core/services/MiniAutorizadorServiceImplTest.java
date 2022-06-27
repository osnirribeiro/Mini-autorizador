package br.com.mini.autorizador.core.services;

import br.com.mini.autorizador.core.entities.Cartao;
import br.com.mini.autorizador.core.ports.driven.MiniAutorizadorRepository;
import br.com.mini.autorizador.support.TestSupport;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class MiniAutorizadorServiceImplTest extends TestSupport {

    @InjectMocks
    private MiniAutorizadorServiceImpl service;

    @Mock
    private  MiniAutorizadorRepository repository;


    //    criação de um cartão
    @Test
    void incluirCartaoTest() {
        Cartao cartao = Cartao.builder().numeroCartao("6549873025634501").senha("1234").build();
        when(repository.incluir(any())).thenReturn(cartao);
        var result =   service.incluir(cartao);
        assertNotNull(result);
    }

//    verificação do saldo do cartão recém-criado
    @Test
    void obterSaldoTest() {
        Cartao cartao = Cartao.builder().numeroCartao("6549873025634501").senha("1234").build();
        String numeroCartao = "6549873025634501";
        when(repository.obterSaldoCartao(any())).thenReturn(cartao);
        var result =   service.obter(numeroCartao);

        assertNotNull(result);

    }

    }
