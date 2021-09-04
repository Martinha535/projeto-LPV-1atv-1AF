package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column
    @Email
    private String email;
    @Column
    private String sexo;
    @Temporal(TemporalType.DATE)
    private String sobrenome;
    private String dataDeNascimento;

    public Pessoa(){}

    public Pessoa(Long id, String nome, String email, String sexo, String sobrenome, String dataDeNascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.sexo = sexo;
        this.sobrenome = sobrenome;
        this.dataDeNascimento = dataDeNascimento;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
}
