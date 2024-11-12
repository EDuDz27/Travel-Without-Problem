package com.example.twp_project.data;

public class DadosCliente {

    public DadosCliente(String id, String nome, String cpf, String celular) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
    }

    private String id;
    private String nome;
    private String cpf;
    private String celular;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }





}
