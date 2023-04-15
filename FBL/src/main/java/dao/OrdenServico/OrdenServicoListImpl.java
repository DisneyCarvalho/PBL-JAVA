package dao.OrdenServico;

import com.example.fbl.model.Cliente;
import com.example.fbl.model.OrdenServico;

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
}
