package com.example.fbl.model;

import java.util.ArrayList;

public class Instalacao extends Servico{
    private ArrayList<String> Programas;
    private ArrayList<String> Sistemas;
    public Instalacao(float preco, float custo) {
        super(preco, custo);
    }

    public ArrayList<String> getProgramas() {
        return Programas;
    }
    public void setProgramas(ArrayList<String> programas) {
        Programas = programas;
    }

    public ArrayList<String> getSistemas() {
        return Sistemas;
    }
    public void setSistemas(ArrayList<String> sistemas) {
        Sistemas = sistemas;
    }


}
