package com.nascimentodev.usuario.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "rua", length = 50)
    private String rua;
    @Column(name = "numero", length = 10)
    private Long numero;
    @Column(name = "complemento",  length = 150)
    private String complemento;
    @Column(name = "estado", length = 2)
    private String estado;
    @Column(name = "cidade", length = 100)
    private String cidade;
    @Column(name = "cep", length = 9)
    private String cep;
    @Column(name = "usuario_id")
    private Long usuario_id;

}
