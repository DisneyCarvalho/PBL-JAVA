package dao.CompComp;

import com.example.fbl.model.CompComp;


import java.util.ArrayList;

public class CompCompListImpl implements CompCompDAO {

    private int NID;
    private ArrayList<CompComp> ListComps;


    public CompCompListImpl() {
        this.NID = 0;
        this.ListComps = new ArrayList<CompComp>();
    }

    @Override
    public CompComp create(CompComp Obj) {
        Obj.setId(NID);
        this.NID++;
        this.ListComps.add(Obj);
        return Obj;
    }

    @Override
    public ArrayList<CompComp> getObj() {
        return this.ListComps;
    }

    @Override
    public CompComp getById(int id) {
        for (CompComp i : this.ListComps) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void update(CompComp Obj) {

        for(int i =0; i < this.ListComps.size();i++) {
            if (this.ListComps.get(i).getId() == Obj.getId()) {
                this.ListComps.add(i, Obj);
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < this.ListComps.size(); i++) {
            if (this.ListComps.get(i).getId() == id) {
                this.ListComps.remove(i);
                return;
            }
        }
    }
}