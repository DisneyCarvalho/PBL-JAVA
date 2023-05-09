package dao.Cliente;

import Ultilidades.Arquivo;
import com.example.fbl.model.Cliente;

import java.util.ArrayList;

public class ClienteFileImpl implements ClienteDAO{
    private String nome = "Cliente";

    private int NID;




    public ClienteFileImpl(){
        ArrayList<Cliente> lista = Arquivo.ler(nome);

        if (lista.size() > 0){

            this.NID = lista.get(lista.size()-1).getId()+ 1;


        } else {

            this.NID = 0;

        }

    }



    public Cliente create(Cliente Obj) {

        ArrayList<Cliente> lista = Arquivo.ler(nome);

        Obj.setId(NID);
        this.NID++;
        lista.add(Obj);
        Arquivo.gravar(lista,nome);


        return Obj;

    }

    @Override
    public ArrayList<Cliente> getObj() {
        ArrayList<Cliente> lista = Arquivo.ler(nome);
        return lista;


    }

    @Override
    public Cliente getById(int id) {
        ArrayList<Cliente> lista = Arquivo.ler(nome);
        for (Cliente i : lista) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void update(Cliente Obj) {
        ArrayList<Cliente> lista = Arquivo.ler(nome);
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
        ArrayList<Cliente> lista = Arquivo.ler(nome);
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
        Arquivo.gravar(new ArrayList<Cliente>(),nome);
        this.NID = 0;

    }
}
