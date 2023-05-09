package com.example.fbl.model;

import java.io.Serializable;

public abstract class Componentes implements Serializable {
    private float Custo;
    private float Preco;
    private int id;
    private int quantidade;

    public Componentes(int quantidade,float custo,float preco){
        this.quantidade = quantidade;
        this.Preco = preco;
        this.Custo = custo;
    }


    public Componentes pegaItem;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getCusto() {
        return Custo;
    }
    public void setCusto(float custo) {
        Custo = custo;
    }

    public float getPreco() {
        return Preco;
    }
    public void setPreco(float preco) {
        Preco = preco;
    }
}

