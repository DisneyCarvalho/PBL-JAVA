package dao.Montagem;

import com.example.fbl.model.Montagem;

import java.util.ArrayList;

public class MontagemListImpl implements MontagemDAO{

    private int NID;
    private ArrayList<Montagem> Montagens;


    public MontagemListImpl() {
        this.NID = 0;
        this.Montagens = new ArrayList<Montagem>();
    }

    @Override
    public Montagem create(Montagem Obj) {
        Obj.setId(NID);
        this.NID++;
        this.Montagens.add(Obj);
        return Obj;
    }

    @Override
    public ArrayList<Montagem> getObj() {
        return this.Montagens;
    }

    @Override
    public Montagem getById(int id) {
        for (Montagem i : this.Montagens) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void update(Montagem Obj) {

        for(int i =0; i < this.Montagens.size();i++) {
            if (this.Montagens.get(i).getId() == Obj.getId()) {
                this.Montagens.add(i, Obj);
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < this.Montagens.size(); i++) {
            if (this.Montagens.get(i).getId() == id) {
                this.Montagens.remove(i);
                return;
            }
        }
    }
}