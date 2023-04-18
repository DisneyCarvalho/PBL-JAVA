package dao.OrdenServico;

import com.example.fbl.model.OrdenServico;
import dao.DAO;

import java.util.ArrayList;

public class OrdenServicoListImpl implements OrdenServicoDAO{

    private int NID;
    private ArrayList<OrdenServico> Ordens;


    public OrdenServicoListImpl() {
        this.NID = 0;
        this.Ordens = new ArrayList<OrdenServico>();
    }

    @Override
    public OrdenServico create(OrdenServico Obj) {
        Obj.setId(NID);
        this.NID++;
        this.Ordens.add(Obj);
        return Obj;
    }

    @Override
    public ArrayList<OrdenServico> getObj() {
        return this.Ordens;
    }

    @Override
    public OrdenServico getById(int id) {
        for (OrdenServico i : this.Ordens) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void update(OrdenServico Obj) {

        for(int i =0; i < this.Ordens.size();i++) {
            if (this.Ordens.get(i).getId() == Obj.getId()) {
                this.Ordens.add(i, Obj);
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < this.Ordens.size(); i++) {
            if (this.Ordens.get(i).getId() == id) {
                this.Ordens.remove(i);
                return;
            }
        }
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
    public void pegaServico(int idtec) {
        for (OrdenServico a : DAO.getOrdenServico().getObj()){
            if (a.getTecnico() == -1 && a.getStatus() == "Em Andamento" ){
                a.setTecnico(idtec);
                return;
            }
        }

    }

    @Override
    public int avaiacaoCliente(int cliente) {
        int soma = 0;
        int total = 0;
        for (OrdenServico ordem : DAO.getOrdenServico().getObj()){
            if (ordem.getId() == cliente){
                soma += ordem.getAvaliaçãoDoCliente();
                total +=1;
            }
        }
        return soma/total;
    }

    @Override
    public int avaliacaoTodos() {
        int soma = 0;
        int total = 0;
        for (OrdenServico ordem : DAO.getOrdenServico().getObj()){
            soma += ordem.getAvaliaçãoDoCliente();
            total +=1;

        }
        return soma/total;
    }

    @Override
    public int avaiacaoTecnico(int tecnico) {
        int soma = 0;
        int total = 0;
        for (OrdenServico ordem : DAO.getOrdenServico().getObj()){
            if (ordem.getTecnico() == tecnico){
                soma += ordem.getAvaliaçãoDoCliente();
                total +=1;
            }
        }
        return soma/total;
    }




}
