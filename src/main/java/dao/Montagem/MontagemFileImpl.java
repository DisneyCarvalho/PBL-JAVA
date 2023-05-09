package dao.Montagem;

import Ultilidades.Arquivo;
import com.example.fbl.model.Montagem;
import dao.DAO;

import java.util.ArrayList;

public class MontagemFileImpl implements MontagemDAO {

    private String nome = "Montagem";

    private int NID;




    public MontagemFileImpl(){
        ArrayList<Montagem> lista = Arquivo.ler(nome);

        if (lista.size() > 0){

            this.NID = lista.get(lista.size()-1).getId()+ 1;


        } else {

            this.NID = 0;

        }

    }



    public Montagem create(Montagem Obj) {

        ArrayList<Montagem> lista = Arquivo.ler(nome);

        Obj.setId(NID);
        this.NID++;
        lista.add(Obj);
        Arquivo.gravar(lista,nome);


        return Obj;

    }

    @Override
    public ArrayList<Montagem> getObj() {
        ArrayList<Montagem> lista = Arquivo.ler(nome);
        return lista;


    }

    @Override
    public Montagem getById(int id) {
        ArrayList<Montagem> lista = Arquivo.ler(nome);
        for (Montagem i : lista) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void update(Montagem Obj) {
        ArrayList<Montagem> lista = Arquivo.ler(nome);
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
        ArrayList<Montagem> lista = Arquivo.ler(nome);
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
        Arquivo.gravar(new ArrayList<Montagem>(),nome);
        this.NID = 0;

    }


}
    
    
    

