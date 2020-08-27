package com.bento.fullstack.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dataCadastro;

    public Produto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
