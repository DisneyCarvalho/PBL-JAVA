package dao.Instalacao;

import com.example.fbl.model.Instalacao;
import com.example.fbl.model.Instalacao;

import java.util.ArrayList;

public class InstalacaoListImpl implements InstalacaoDAO{
    private int NID;
    private ArrayList<Instalacao> ListInstalacao;


    public InstalacaoListImpl() {
        this.NID = 0;
        this.ListInstalacao = new ArrayList<Instalacao>();
    }

    @Override
    public Instalacao create(Instalacao Obj) {
        Obj.setId(NID);
        this.NID++;
        this.ListInstalacao.add(Obj);
        return Obj;
    }

    @Override
    public ArrayList<Instalacao> getObj() {
        return this.ListInstalacao;
    }

    @Override
    public Instalacao getById(int id) {
        for (Instalacao i : this.ListInstalacao) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void update(Instalacao Obj) {

        for(int i =0; i < this.ListInstalacao.size();i++) {
            if (this.ListInstalacao.get(i).getId() == Obj.getId()) {
                this.ListInstalacao.add(i, Obj);
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < this.ListInstalacao.size(); i++) {
            if (this.ListInstalacao.get(i).getId() == id) {
                this.ListInstalacao.remove(i);
                return;
            }
        }
    }

    @Override
    public void deleteAll() {
        this.ListInstalacao.clear();
        this.NID=0;
    }
}