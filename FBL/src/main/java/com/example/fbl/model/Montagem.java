package com.example.fbl.model;

public class Montagem extends Servico{
    private int id;


    public Montagem(float preco, float custo) {
        super(preco, custo);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
