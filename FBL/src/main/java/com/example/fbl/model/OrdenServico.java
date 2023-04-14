package com.example.fbl.model;

import java.util.ArrayList;
import java.util.Date;

public class OrdenServico {
    Cliente cliente;
    Tecnic tecnico;
    int id;
    int status;
    ArrayList<Servico> Servicos;
    String descricao;
    float price;
    int metPagamento;
    Date dataCriacao;
    Date dataFinalizacao;

    public OrdenServico(){
        this.tecnico = null;


    }
}
