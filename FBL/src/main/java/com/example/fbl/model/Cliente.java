package com.example.fbl.model;

public class Cliente extends Usuario {
    private String Endenreco;
    private String Telefone;
    private String Nome;




    Cliente(int key, String email,String endenreco, String telefone, String nome) {
        super(key, email);
        this.Endenreco = endenreco;
        this.Nome = nome;
        this.Telefone = telefone;
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
}
