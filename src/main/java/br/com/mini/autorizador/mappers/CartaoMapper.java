package br.com.mini.autorizador.mappers;

import br.com.mini.autorizador.core.entities.Cartao;
import br.com.mini.autorizador.dtos.CartaoDTO;
import br.com.mini.autorizador.dtos.CartaoResponseCriadoDTO;
import br.com.mini.autorizador.dtos.CartaoResponseSaldoDTO;
import br.com.mini.autorizador.dtos.CartaoValorDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartaoMapper {

    Cartao fromDto(CartaoDTO cartaoDTO);

    CartaoResponseCriadoDTO toDto(Cartao cartao);

    CartaoResponseSaldoDTO cartaotoDtoSaldo(Cartao cartao);

    Cartao cartaotoDtoValor(CartaoValorDTO cartao);
}
