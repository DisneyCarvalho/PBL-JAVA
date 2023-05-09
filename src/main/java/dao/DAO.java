package dao;

import dao.Cliente.ClienteDAO;
import dao.Cliente.ClienteFileImpl;
import dao.Cliente.ClienteListImpl;
import dao.CompComp.CompCompDAO;
import dao.CompComp.CompCompFileImpl;
import dao.CompComp.CompCompListImpl;
import dao.Instalacao.InstalacaoDAO;
import dao.Instalacao.InstalacaoFileImpl;
import dao.Instalacao.InstalacaoListImpl;
import dao.Limpeza.LimpezaDAO;
import dao.Limpeza.LimpezaFileImpl;
import dao.Limpeza.LimpezaListImpl;
import dao.Montagem.MontagemDAO;
import dao.Montagem.MontagemFileImpl;
import dao.Montagem.MontagemListImpl;
import dao.OrdenServico.OrdenServicoDAO;
import dao.OrdenServico.OrdenServicoFileImpl;
import dao.OrdenServico.OrdenServicoListImpl;

import dao.OutroComp.OutroCompDAO;
import dao.OutroComp.OutroCompFileImpl;
import dao.OutroComp.OutroCompListImpl;
import dao.Tecnic.TecnicDAO;
import dao.Tecnic.TecnicFileImpl;
import dao.Tecnic.TecnicListImpl;

public class DAO {

    private static TecnicDAO tenicDAO;
    private static OrdenServicoDAO ordenServicoDAO;
    private static ClienteDAO clienteDAO;
    private static OutroCompDAO outrocompDAO;
    private static MontagemDAO montagemDAO;
    private static LimpezaDAO limpezaDAO;
    private  static InstalacaoDAO instalacaoDAO;
    private static CompCompDAO compCompDAO;


    /**
     * Retorna uma instâcia implementada do DAO de tecnicos.
     * @return
     */
    public static TecnicDAO getTecnic() {
        if (tenicDAO == null){
            DAO.tenicDAO = new TecnicFileImpl();
        }
        return DAO.tenicDAO;
    }


    /**
     * Retorna uma instâcia implementada do DAO de OrdenServico.
     * @return
     */

    public static OrdenServicoDAO getOrdenServico(){
        if (ordenServicoDAO == null){
            DAO.ordenServicoDAO = new OrdenServicoFileImpl();
        }
        return DAO.ordenServicoDAO;
    }

    /**
     * Retorna uma instâcia implementada do DAO de Cliente.
     * @return
     */

    public static ClienteDAO getCliente(){
        if (clienteDAO == null){
            DAO.clienteDAO = new ClienteFileImpl();
        }
        return DAO.clienteDAO;
    }


    /**
     * Retorna uma instâcia implementada do DAO de OutroComp.
     * @return
     */
    public static OutroCompDAO getOutroComp(){
        if (outrocompDAO == null){
            DAO.outrocompDAO = new OutroCompFileImpl();
        }
        return DAO.outrocompDAO;
    }




    /**
     * Retorna uma instâcia implementada do DAO de Montagem.
     * @return
     */
    public static MontagemDAO getMontagem(){
        if (montagemDAO == null){
            DAO.montagemDAO = new MontagemFileImpl();
        }
        return DAO.montagemDAO;
    }


    /**
     * Retorna uma instâcia implementada do DAO de Limpeza.
     * @return
     */

    public static LimpezaDAO getLimpeza(){
        if (limpezaDAO == null){
            DAO.limpezaDAO = new LimpezaFileImpl();
        }
        return DAO.limpezaDAO;
    }


    /**
     * Retorna uma instâcia implementada do DAO de CompComp.
     * @return
     */

    public static CompCompDAO getCompComp(){
        if (compCompDAO == null){
            DAO.compCompDAO = new CompCompFileImpl();
        }
        return DAO.compCompDAO;
    }


    /**
     * Retorna uma instâcia implementada do DAO de Instalacao.
     * @return
     */
    public static InstalacaoDAO getInstalacao(){
        if (instalacaoDAO == null){
            DAO.instalacaoDAO = new InstalacaoFileImpl();
        }
        return DAO.instalacaoDAO;
    }

}
