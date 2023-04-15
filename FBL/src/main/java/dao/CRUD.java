package dao;

import com.example.fbl.model.Tecnic;

import java.util.ArrayList;

public interface CRUD <T> {
    public T create(T Obj);

    public ArrayList<T> getObj();

    public T getById(int id);

    public void update(T Obj);

    public void delete (int id);
}
