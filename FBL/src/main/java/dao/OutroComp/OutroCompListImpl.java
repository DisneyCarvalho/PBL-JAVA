package dao.OutroComp;

import com.example.fbl.model.OutroComp;
import com.example.fbl.model.OutroComp;

import java.util.ArrayList;

public class OutroCompListImpl implements OutroCompDAO{
    
    private int NID;
    private ArrayList<OutroComp> ListOutroComp;


    public OutroCompListImpl() {
        this.NID = 0;
        this.ListOutroComp = new ArrayList<OutroComp>();
    }

    @Override
    public OutroComp create(OutroComp Obj) {
        Obj.setId(NID);
        this.NID++;
        this.ListOutroComp.add(Obj);
        return Obj;
    }

    @Override
    public ArrayList<OutroComp> getObj() {
        return this.ListOutroComp;
    }

    @Override
    public OutroComp getById(int id) {
        for (OutroComp i : this.ListOutroComp) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void update(OutroComp Obj) {

        for(int i =0; i < this.ListOutroComp.size();i++) {
            if (this.ListOutroComp.get(i).getId() == Obj.getId()) {
                this.ListOutroComp.add(i, Obj);
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < this.ListOutroComp.size(); i++) {
            if (this.ListOutroComp.get(i).getId() == id) {
                this.ListOutroComp.remove(i);
                return;
            }
        }
    }
}