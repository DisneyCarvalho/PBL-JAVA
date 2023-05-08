package dao.Tecnic;

import com.example.fbl.model.Tecnic;

import java.util.ArrayList;

public interface TecnicDAO {

    public Tecnic create(Tecnic tecnic);

    public ArrayList<Tecnic> getTecnicos();

    public Tecnic getById(int id);

    public void update(Tecnic tecnico);

    public void delete (int id);

    public void deleteAll();

}
