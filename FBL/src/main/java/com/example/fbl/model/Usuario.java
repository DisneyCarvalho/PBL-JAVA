package com.example.fbl.model;

import java.io.Serializable;

public abstract class Usuario implements Serializable {
    private int Id;
    private int Senha;
    private String Email;


    Usuario (int key){
    this.Senha = key;
    }

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        this.Id = id;
    }

    public int getSenha() {
        return Senha;
    }
    public void setSenha(int senha) {
        this.Senha = senha;
    }



    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        this.Email = email;
    }


}



