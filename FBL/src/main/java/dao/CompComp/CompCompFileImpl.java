package dao.CompComp;

import Ultilidades.Arquivo;
import com.example.fbl.model.CompComp;

import java.util.ArrayList;

public class CompCompFileImpl implements CompCompDAO{
    private String nome = "CompComp";

    private int NID;




    public CompCompFileImpl(){
        ArrayList<CompComp> lista = Arquivo.ler(nome);

        if (lista.size() > 0){

            this.NID = lista.get(lista.size()-1).getId()+ 1;


        } else {

            this.NID = 0;

        }

    }



    public CompComp create(CompComp Obj) {

        ArrayList<CompComp> lista = Arquivo.ler(nome);

        Obj.setId(NID);
        this.NID++;
        lista.add(Obj);
        Arquivo.gravar(lista,nome);


        return Obj;

    }

    @Override
    public ArrayList<CompComp> getObj() {
        ArrayList<CompComp> lista = Arquivo.ler(nome);
        return lista;


    }

    @Override
    public CompComp getById(int id) {
        ArrayList<CompComp> lista = Arquivo.ler(nome);
        for (CompComp i : lista) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void update(CompComp Obj) {
        ArrayList<CompComp> lista = Arquivo.ler(nome);
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
        ArrayList<CompComp> lista = Arquivo.ler(nome);
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
        Arquivo.gravar(new ArrayList<CompComp>(),nome);
        this.NID = 0;

    }


}
