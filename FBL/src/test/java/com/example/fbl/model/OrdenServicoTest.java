package com.example.fbl.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrdenServicoTest {

    @Test
    void addServico() {


        OrdenServico nova = new OrdenServico(16,"01/06/1021");
        Instalacao ints = new Instalacao(15,9);

        ArrayList<Servico> lista= new ArrayList<Servico>();
        lista.add(ints);

        nova.addServico(ints);

        assertEquals(lista,nova.getServicos());



    }

    @Test
    void finalizar() {
        OrdenServico nova = new OrdenServico(16,"01/06/1021");
        nova.finalizar();

        assertEquals("Finalizado",nova.getStatus());


    }

    @Test
    void cancelar() {
        OrdenServico nova = new OrdenServico(16,"01/06/1021");
        nova.cancelar();

        assertEquals("Cancelado",nova.getStatus());


    }

    @Test
    void andamento() {
        OrdenServico nova = new OrdenServico(16,"01/06/1021");
        nova.andamento();

        assertEquals("Em Andamento",nova.getStatus());
    }
}