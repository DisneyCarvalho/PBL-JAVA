package dao.OrdenServico;

import com.example.fbl.model.OrdenServico;
import dao.CRUD;

import java.util.ArrayList;

public interface OrdenServicoDAO extends CRUD<OrdenServico> {

    /**
     * busca todas as ordens de servido de um tecnico
     * @param id
     * @return
     */
    public ArrayList<OrdenServico> buscaPorTecnico(int id);

    /**
     * pega todas as ordens de um cliente
     * @param id
     * @return
     */
    public ArrayList<OrdenServico> buscaPorCliente(int id);

    /**
     * pega a media das avaliacoes de um unico cliente
     * @param cliente
     * @return
     */
    public float avaiacaoCliente(int cliente);

    /**
     * pega a media de avaliação de todas as ordem de servico
     * @return
     */
    public float avaliacaoTodos();

    /**
     * pega a media avaliação de um tecnico
     * @param tecnico
     * @return
     */

    public float avaiacaoTecnico(int tecnico);

    /**
     * Atribui o id do tecnico a primeira ordem de servico disponivel.
     * @param idtec
     */
    public void pegaServico(int idtec);






}
