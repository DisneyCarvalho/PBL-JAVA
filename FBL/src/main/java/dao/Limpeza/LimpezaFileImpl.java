package dao.Limpeza;

import Ultilidades.Arquivo;
import com.example.fbl.model.Limpeza;

import java.util.ArrayList;

public class LimpezaFileImpl implements LimpezaDAO{
    private String nome = "Limpeza";

    private int NID;




    public LimpezaFileImpl(){
        ArrayList<Limpeza> lista = Arquivo.ler(nome);

        if (lista.size() > 0){

            this.NID = lista.get(lista.size()-1).getId()+ 1;


        } else {

            this.NID = 0;

        }

    }



    public Limpeza create(Limpeza Obj) {

        ArrayList<Limpeza> lista = Arquivo.ler(nome);

        Obj.setId(NID);
        this.NID++;
        lista.add(Obj);
        Arquivo.gravar(lista,nome);


        return Obj;

    }

    @Override
    public ArrayList<Limpeza> getObj() {
        ArrayList<Limpeza> lista = Arquivo.ler(nome);
        return lista;


    }

    @Override
    public Limpeza getById(int id) {
        ArrayList<Limpeza> lista = Arquivo.ler(nome);
        for (Limpeza i : lista) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void update(Limpeza Obj) {
        ArrayList<Limpeza> lista = Arquivo.ler(nome);
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
        ArrayList<Limpeza> lista = Arquivo.ler(nome);
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
        Arquivo.gravar(new ArrayList<Limpeza>(),nome);
        this.NID = 0;

    }


}






