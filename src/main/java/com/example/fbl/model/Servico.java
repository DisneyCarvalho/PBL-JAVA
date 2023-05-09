package com.example.fbl.model;

import java.io.Serializable;

public abstract class Servico  implements Serializable {
    private float Preco;
    private float Custo;
    private int id;

    public Servico(float preco, float custo){
        this.Custo = custo;
        this.Preco = preco;
    }



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public float getPreco() {
        return Preco;
    }
    public void setPreco(float preco) {
        Preco = preco;
    }


    public float getCusto() {
        return Custo;
    }
    public void setCusto(float custo) {
        Custo = custo;
    }
}
