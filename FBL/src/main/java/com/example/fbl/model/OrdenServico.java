package com.example.fbl.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class OrdenServico implements Serializable {
    private int cliente;
    private int tecnico;
    private int id;
    private String status;
    private ArrayList<Servico> Servicos;
    private String descricao;
    private float preco;
    private float custo;
    private String metPagamento;
    private String dataCriacao;
    private String dataFinalizacao;
    private int avaliaçãoDoCliente;

    public ArrayList<Servico> getServicos() {
        return Servicos;
    }
    public void setServicos(ArrayList<Servico> servicos) {
        this.Servicos = servicos;
    }



    public OrdenServico(int Cliente,String dataCriacao){
        this.cliente = Cliente;
        this.dataCriacao = dataCriacao;
        this.tecnico = -1;
        this.Servicos = new ArrayList<Servico>();
        this.preco = 0;
        this.custo = 0;


    }

    /**
     * Adiciona um servico a lista de servicos e soma o seu preco e seu custo
     * @param servico
     */
    public void addServico(Servico servico){
        this.preco += servico.getPreco();
        this.custo += servico.getCusto();
        this.Servicos.add(servico);
    }



    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    /***
     * seta o status como Finalizado
     */
    public void finalizar(){
        this.status = "Finalizado";
    }

    /**
     * seta o status como cancelado
     */
    public void cancelar(){
        this.status = "Cancelado";
    }

    /**
     * seta o status como Em andamento.
     */
    public void andamento(){
        this.status = "Em Andamento";
    }







    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public int getTecnico() {
        return tecnico;
    }
    public void setTecnico(int tecnico) {
        this.tecnico = tecnico;
    }


    public int getCliente() {
        return cliente;
    }
    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getCusto() {
        return custo;
    }
    public void setCusto(float custo) {
        this.custo = custo;
    }

    public String getMetPagamento() {
        return metPagamento;
    }
    public void setMetPagamento(String metPagamento) {
        this.metPagamento = metPagamento;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getDataFinalizacao() {
        return dataFinalizacao;
    }
    public void setDataFinalizacao(String dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public int getAvaliaçãoDoCliente() {
        return avaliaçãoDoCliente;
    }
    public void setAvaliaçãoDoCliente(int avaliaçãoDoCliente) {
        this.avaliaçãoDoCliente = avaliaçãoDoCliente;
    }
}
