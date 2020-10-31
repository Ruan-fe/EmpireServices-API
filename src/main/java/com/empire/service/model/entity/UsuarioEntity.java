package com.empire.service.model.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios")
public class UsuarioEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String nome;
    @NotNull
    @Column(unique = true)
    private String email;
    @NotNull
    private String senha;

}
