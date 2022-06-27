package br.com.mini.autorizador.core.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Cartao")
public class Cartao implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @Column (name="numeroCartao", nullable = false,unique=true)
        private String numeroCartao;
        @Column (name="senha" , nullable = false)
        private String senha;
        @Column (name="saldo",nullable = false)
        private BigDecimal saldo;


    }

