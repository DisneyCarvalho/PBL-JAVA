package dao.Cliente;

import com.example.fbl.model.Cliente;
import dao.CRUD;

import java.util.ArrayList;

public class ClienteListImpl implements ClienteDAO{


    ArrayList<Cliente> Clientes;
    int NID;

    public ClienteListImpl(){
        this.NID = 0;
        this.Clientes = new ArrayList();
    }


    @Override
    public Cliente create(Cliente Obj) {
        Obj.setId(NID);
        this.NID++;
        this.Clientes.add(Obj);
        return Obj;
    }

    @Override
    public ArrayList<Cliente> getObj() {
        return this.Clientes;
    }

    @Override
    public Cliente getById(int id) {
        for (Cliente i : this.Clientes){
            if (i.getId() == id){
                return i;
            }
        }
        return null;
    }

    @Override
    public void update(Cliente Obj) {

        for(int i =0; i < this.Clientes.size();i++) {
            if (this.Clientes.get(i).getId() == Obj.getId()) {
                this.Clientes.add(i, Obj);
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        for(int i =0; i < this.Clientes.size();i++){
            if (this.Clientes.get(i).getId() == id){
                this.Clientes.remove(i);
                return;
            }

        }
    }
}
