package com.example.fbl.model;

public abstract class Servico {
    private float Preco;
    private float Custo;

    public Servico(float preco, float custo){
        this.Custo = custo;
        this.Preco = preco;
    }
}
