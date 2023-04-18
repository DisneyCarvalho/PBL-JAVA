package dao.Limpeza;
import com.example.fbl.model.Limpeza;
import com.example.fbl.model.Limpeza;

import java.util.ArrayList;

public class LimpezaListImpl implements LimpezaDAO {

    private int NID;
    private ArrayList<Limpeza> ListLimpeza;


    public LimpezaListImpl() {
        this.NID = 0;
        this.ListLimpeza = new ArrayList<Limpeza>();
    }

    @Override
    public Limpeza create(Limpeza Obj) {
        Obj.setId(NID);
        this.NID++;
        this.ListLimpeza.add(Obj);
        return Obj;
    }

    @Override
    public ArrayList<Limpeza> getObj() {
        return this.ListLimpeza;
    }

    @Override
    public Limpeza getById(int id) {
        for (Limpeza i : this.ListLimpeza) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void update(Limpeza Obj) {

        for(int i =0; i < this.ListLimpeza.size();i++) {
            if (this.ListLimpeza.get(i).getId() == Obj.getId()) {
                this.ListLimpeza.add(i, Obj);
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < this.ListLimpeza.size(); i++) {
            if (this.ListLimpeza.get(i).getId() == id) {
                this.ListLimpeza.remove(i);
                return;
            }
        }
    }
}
