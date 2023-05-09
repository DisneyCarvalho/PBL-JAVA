package dao.Tecnic;

import com.example.fbl.model.Tecnic;

import java.util.ArrayList;

public interface TecnicDAO {


    /**
     * Cria um tecnico e adiciona a implementação do DAO
     * @param tecnic Obj tecnico
     * @return
     */
    public Tecnic create(Tecnic tecnic);

    /**
     * Retorna a implementação dos tecnicos
     * @return
     */

    public ArrayList<Tecnic> getTecnicos();

    /**
     * Retorna o tecnico pelo id
     * @param id id do tecnico
     * @return
     */

    public Tecnic getById(int id);


    /**
     * Atualiza as informações de um tecnico
     * @param tecnico
     */
    public void update(Tecnic tecnico);

    /**
     * deleta um tecnico da lista pelo id
     * @param id
     */
    public void delete (int id);

    /**
     * deleta toda a lista implementada e reinicia o id
     */

    public void deleteAll();

}
