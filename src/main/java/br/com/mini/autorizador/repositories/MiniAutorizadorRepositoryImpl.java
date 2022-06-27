package br.com.mini.autorizador.repositories;

import br.com.mini.autorizador.core.entities.Cartao;
import br.com.mini.autorizador.core.ports.driven.MiniAutorizadorRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Repository
public interface MiniAutorizadorRepositoryImpl extends MiniAutorizadorRepository, JpaRepository<Cartao, Long> {


    default Cartao incluir(@Valid Cartao inclusao){

        try {
            return  save(inclusao);
        } catch (DataIntegrityViolationException e) {
            return null;
        }
    }


    default  Cartao obterSaldoCartao(String numeroCartao){
        return findByNumeroCartao(numeroCartao);
    }

    default  Cartao validarSaldo(BigDecimal saldo){
        return findBySaldoGreaterThan(saldo);
    }

    default Cartao obterSenha(@NotBlank String senha){
        return findBySenha(senha);
    }

    Cartao findByNumeroCartao(String numeroCartao);

    Cartao findBySenha(String Senha);

    Cartao findBySaldoGreaterThan(BigDecimal saldo);





}
