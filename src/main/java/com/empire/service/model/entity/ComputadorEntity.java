package com.empire.service.model.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="computadores")
public class ComputadorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer id;
    @NotNull
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "id_laboratorio", referencedColumnName = "id")
    private LaboratorioEntity laboratorio;

}
