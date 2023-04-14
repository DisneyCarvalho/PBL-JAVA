package dao.Tecnic;

import com.example.fbl.model.Tecnic;

import java.util.ArrayList;

public class TecnicListImpl implements TecnicDAO{
    private ArrayList<Tecnic> tecnicos;
    private int NID;

    public TecnicListImpl(){
        this.tecnicos = new ArrayList<Tecnic>();
        this.NID =  0;
    }
    @Override
    public Tecnic create(Tecnic tecnic) {
        tecnic.setId(NID);
        this.NID++;
        this.tecnicos.add(tecnic);
        return tecnic;
    }

    @Override
    public ArrayList<Tecnic> getTecnicos() {
        return this.tecnicos;
    }

    @Override
    public Tecnic getById(int id) {
        for (Tecnic i: this.tecnicos){
            if (i.getId() == id){
                return i;
            }

        }
        return null;
    }

    @Override
    public void update(Tecnic tecnico) {

        for(int i =0; i < this.tecnicos.size();i++){
            if (this.tecnicos.get(i).getId() == tecnico.getId()){
                this.tecnicos.add(i,tecnico);
                return;

            }
        }

    }

    @Override
    public void delete(int id) {
        for(int i =0; i < this.tecnicos.size();i++){
            if (this.tecnicos.get(i).getId() == id){
                this.tecnicos.remove(i);
                return;
            }

        }
    }
}
