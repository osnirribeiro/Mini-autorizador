package br.com.mini.autorizador.dtos;


import lombok.*;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartaoResponseCriadoDTO {

    private String numeroCartao;

    private String senha;


}


