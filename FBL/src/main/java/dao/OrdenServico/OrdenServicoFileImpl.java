package dao.OrdenServico;

import Ultilidades.Arquivo;
import com.example.fbl.model.OrdenServico;
import dao.DAO;

import java.util.ArrayList;

public class OrdenServicoFileImpl implements OrdenServicoDAO{
    private String nome = "OrdenServico";

    private int NID;




    public OrdenServicoFileImpl(){
        ArrayList<OrdenServico> lista = Arquivo.ler(nome);

        if (lista.size() > 0){

            this.NID = lista.get(lista.size()-1).getId()+ 1;


        } else {

            this.NID = 0;

        }

    }



    public OrdenServico create(OrdenServico Obj) {

        ArrayList<OrdenServico> lista = Arquivo.ler(nome);
        Obj.setId(NID);
        this.NID++;
        lista.add(Obj);

        Arquivo.gravar(lista,nome);


        return Obj;

    }

    @Override
    public ArrayList<OrdenServico> getObj() {
        ArrayList<OrdenServico> lista = Arquivo.ler(nome);
        return lista;


    }

    @Override
    public OrdenServico getById(int id) {
        ArrayList<OrdenServico> lista = Arquivo.ler(nome);
        for (OrdenServico i : lista) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void update(OrdenServico Obj) {
        ArrayList<OrdenServico> lista = Arquivo.ler(nome);


        for(int i =0; i < lista.size();i++) {
            if (lista.get(i).getId() == Obj.getId()) {
                lista.set(i, Obj);
                Arquivo.gravar(lista,nome);
                return;
            }
        }

    }

    @Override
    public void delete(int id) {
        ArrayList<OrdenServico> lista = Arquivo.ler(nome);
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                lista.remove(i);
                Arquivo.gravar(lista,nome);
                return;
            }

        }
    }

    @Override
    public void deleteAll() {
        Arquivo.gravar(new ArrayList<OrdenServico>(),nome);
        this.NID = 0;

    }

    @Override
    public ArrayList<OrdenServico> buscaPorTecnico(int id) {
        ArrayList<OrdenServico> OrdemTec = new ArrayList<OrdenServico>();
        for (OrdenServico ordem: DAO.getOrdenServico().getObj()){
            if (ordem.getTecnico() == id){
                OrdemTec.add(ordem);
            }
        }
        return OrdemTec;
    }


    @Override
    public ArrayList<OrdenServico> buscaPorCliente(int id) {
        ArrayList<OrdenServico> OrdemCli = new ArrayList<OrdenServico>();
        for (OrdenServico ordem: DAO.getOrdenServico().getObj()){
            if (ordem.getCliente() == id){
                OrdemCli.add(ordem);
            }
        }
        return OrdemCli;
    }

    @Override
    public float avaiacaoCliente(int cliente) {
        float soma = 0;
        int total = 0;
        for (OrdenServico ordem : DAO.getOrdenServico().getObj()){
            if (ordem.getCliente() == cliente){
                soma += ordem.getAvaliaçãoDoCliente();
                total +=1;
            }
        }
        return soma/total;
    }

    @Override
    public float avaliacaoTodos() {
        float soma = 0;
        int total = 0;
        for (OrdenServico ordem : DAO.getOrdenServico().getObj()){
            soma += ordem.getAvaliaçãoDoCliente();
            total +=1;

        }
        return soma/total;
    }

    @Override
    public float avaiacaoTecnico(int tecnico) {
        float soma = 0;
        int total = 0;
        for (OrdenServico ordem : DAO.getOrdenServico().getObj()){
            if (ordem.getTecnico() == tecnico){
                soma += ordem.getAvaliaçãoDoCliente();
                total +=1;
            }
        }
        return soma/total;
    }

    @Override
    public void pegaServico(int idtec) {
        ArrayList<OrdenServico> lista = Arquivo.ler(nome);
        for (OrdenServico a : lista){
            if (a.getTecnico() == -1 && a.getStatus().equals("Em Andamento")  ){
                a.setTecnico(idtec);
                Arquivo.gravar(lista,nome);
                return;
            }
        }

    }
}
