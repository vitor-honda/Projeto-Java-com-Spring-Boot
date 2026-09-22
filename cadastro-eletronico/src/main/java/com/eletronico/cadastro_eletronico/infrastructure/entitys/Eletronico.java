package com.eletronico.cadastro_eletronico.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table (name = "eletronico")
@Entity

public class Eletronico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Interger id;

    @Column (name = "modelo")
    private String modelo;

    @Column (name = "cor")
    private String cor;

}
