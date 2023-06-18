package dao.Tecnic;

import Ultilidades.Arquivo;
import com.example.fbl.model.Tecnic;

import java.util.ArrayList;

public class TecnicFileImpl implements TecnicDAO{
    private String nome = "Tecnic";

    private int NID;




    public TecnicFileImpl(){
        ArrayList<Tecnic> lista = Arquivo.ler(nome);

        if (lista.size() > 0){

            this.NID = lista.get(lista.size()-1).getId()+ 1;


        } else {

            this.NID = 0;

        }

    }



    public Tecnic create(Tecnic Obj) {

        ArrayList<Tecnic> lista = Arquivo.ler(nome);

        Obj.setId(NID);
        this.NID++;
        lista.add(Obj);
        Arquivo.gravar(lista,nome);


        return Obj;

    }

    @Override
    public ArrayList<Tecnic> getTecnicos() {
        ArrayList<Tecnic> lista = Arquivo.ler(nome);
        return lista;


    }

    @Override
    public Tecnic getById(int id) {
        ArrayList<Tecnic> lista = Arquivo.ler(nome);
        for (Tecnic i : lista) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void update(Tecnic Obj) {
        ArrayList<Tecnic> lista = Arquivo.ler(nome);
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
        ArrayList<Tecnic> lista = Arquivo.ler(nome);
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
        Arquivo.gravar(new ArrayList<Tecnic>(),nome);
        this.NID = 0;

    }

}
