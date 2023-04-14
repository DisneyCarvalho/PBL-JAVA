package com.example.fbl.model;

import java.util.ArrayList;

public class Instalacao extends Servico{
    ArrayList<String> Programas;
    ArrayList<String> Sistemas;
    public Instalacao(float preco, float custo) {
        super(preco, custo);
    }
}
