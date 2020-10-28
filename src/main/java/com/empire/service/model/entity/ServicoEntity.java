package com.empire.service.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.*;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "servicos")
public class ServicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer id;
    @NotNull
    private String descricao;
    @NotNull
    private Character status;
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura;
    @ManyToOne
    @JoinColumn(name = "id_laboratorio", referencedColumnName = "id")
    private LaboratorioEntity laboratorio;
    @ManyToOne
    @JoinColumn(name = "id_computador", referencedColumnName = "id")
    private ComputadorEntity computador;
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private UsuarioEntity usuario;

    @PrePersist
    public void prePersist(){
        setDataAbertura(LocalDate.now());
    }

}
