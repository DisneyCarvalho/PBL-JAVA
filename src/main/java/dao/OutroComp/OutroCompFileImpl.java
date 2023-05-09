package dao.OutroComp;

import Ultilidades.Arquivo;
import com.example.fbl.model.OutroComp;
import dao.Tecnic.TecnicListImpl;

import java.io.*;
import java.util.ArrayList;


public class OutroCompFileImpl implements OutroCompDAO{
    private String nome = "OutroComp";

    private int NID;




    public OutroCompFileImpl(){
        ArrayList<OutroComp> lista = Arquivo.ler(nome);

        if (lista.size() > 0){

            this.NID = lista.get(lista.size()-1).getId()+ 1;


        } else {

            this.NID = 0;

        }

    }



    public OutroComp create(OutroComp Obj) {

        ArrayList<OutroComp> lista = Arquivo.ler(nome);

        Obj.setId(NID);
        this.NID++;
        lista.add(Obj);
        Arquivo.gravar(lista,nome);


        return Obj;

    }

    @Override
    public ArrayList<OutroComp> getObj() {
        ArrayList<OutroComp> lista = Arquivo.ler(nome);
        return lista;


    }

    @Override
    public OutroComp getById(int id) {
        ArrayList<OutroComp> lista = Arquivo.ler(nome);
        for (OutroComp i : lista) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void update(OutroComp Obj) {
        ArrayList<OutroComp> lista = Arquivo.ler(nome);
        for(int i =0; i < lista.size();i++) {
            if (lista.get(i).getId() == Obj.getId()) {
                lista.add(i, Obj);
                Arquivo.gravar(lista,nome);
                return;
            }
        }


    }

    @Override
    public void delete(int id) {
        ArrayList<OutroComp> lista = Arquivo.ler(nome);
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
        Arquivo.gravar(new ArrayList<OutroComp>(),nome);
        this.NID = 0;

    }


}
