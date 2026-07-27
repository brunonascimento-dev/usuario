package com.nascimentodev.usuario.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "telefone")
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "telefone", length = 10)
    private String telefone;
    @Column(name = "ddd", length = 3)
    private String ddd;
    @Column(name = "usuario_id")
    private Long usuario_id;
}
