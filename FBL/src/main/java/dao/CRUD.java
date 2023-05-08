package dao;

import com.example.fbl.model.Tecnic;

import java.util.ArrayList;

public interface CRUD <T> {

    /**
     * cria um obj e armazena
     * @param Obj
     * @return
     */
    public T create(T Obj);

    /**
     * retorna a lista implementada
     * @return
     */
    public ArrayList<T> getObj();

    /**
     * retorna um obj pelo id
     * @param id
     * @return
     */
    public T getById(int id);

    /**
     * atualiza um obj
     * @param Obj
     */
    public void update(T Obj);

    /**
     * deleta um obj
     * @param id
     */
    public void delete (int id);

    /**
     * Deleta os elementos da lista do obj e reseta o id
     */
    public void deleteAll();

}
