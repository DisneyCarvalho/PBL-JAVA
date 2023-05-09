package dao.Instalacao;

import Ultilidades.Arquivo;
import com.example.fbl.model.Instalacao;

import java.util.ArrayList;

public class InstalacaoFileImpl implements InstalacaoDAO{
    private String nome = "Instalacao";

    private int NID;




    public InstalacaoFileImpl(){
        ArrayList<Instalacao> lista = Arquivo.ler(nome);

        if (lista.size() > 0){

            this.NID = lista.get(lista.size()-1).getId()+ 1;


        } else {

            this.NID = 0;

        }

    }



    public Instalacao create(Instalacao Obj) {

        ArrayList<Instalacao> lista = Arquivo.ler(nome);

        Obj.setId(NID);
        this.NID++;
        lista.add(Obj);
        Arquivo.gravar(lista,nome);


        return Obj;

    }

    @Override
    public ArrayList<Instalacao> getObj() {
        ArrayList<Instalacao> lista = Arquivo.ler(nome);
        return lista;


    }

    @Override
    public Instalacao getById(int id) {
        ArrayList<Instalacao> lista = Arquivo.ler(nome);
        for (Instalacao i : lista) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void update(Instalacao Obj) {
        ArrayList<Instalacao> lista = Arquivo.ler(nome);
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
        ArrayList<Instalacao> lista = Arquivo.ler(nome);
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
        Arquivo.gravar(new ArrayList<Instalacao>(),nome);
        this.NID = 0;

    }


}

