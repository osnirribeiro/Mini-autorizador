package br.com.mini.autorizador.dtos;


import lombok.*;


import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartaoDTO {

    private String numeroCartao;

    private String senha;

    private BigDecimal saldo;

}


