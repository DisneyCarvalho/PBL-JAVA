package com.example.fbl.model;

import java.io.Serializable;

public class Cliente implements Serializable {
    private int Id;
    private String Endenreco;
    private String Telefone;
    private String Nome;




    public Cliente(String nome) {
        this.Nome = nome;

    }

    public String getEndenreco() {
        return Endenreco;
    }
    public void setEndenreco(String endenreco) {
        this.Endenreco = endenreco;
    }


    public String getTelefone() {
        return Telefone;
    }
    public void setTelefone(String telefone) {
        this.Telefone = telefone;
    }


    public String getNome() {
        return Nome;
    }
    public void setNome(String nome) {
        this.Nome = nome;
    }


    public int getId() {
        return Id;
    }
    public void setId(int id) {
        this.Id = id;
    }
}
