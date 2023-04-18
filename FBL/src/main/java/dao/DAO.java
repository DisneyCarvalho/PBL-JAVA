package dao;

import dao.Cliente.ClienteDAO;
import dao.Cliente.ClienteListImpl;
import dao.CompComp.CompCompDAO;
import dao.CompComp.CompCompListImpl;
import dao.Instalacao.InstalacaoDAO;
import dao.Instalacao.InstalacaoListImpl;
import dao.Limpeza.LimpezaDAO;
import dao.Limpeza.LimpezaListImpl;
import dao.Montagem.MontagemDAO;
import dao.Montagem.MontagemListImpl;
import dao.OrdenServico.OrdenServicoDAO;
import dao.OrdenServico.OrdenServicoListImpl;

import dao.OutroComp.OutroCompDAO;
import dao.OutroComp.OutroCompListImpl;
import dao.Tecnic.TecnicDAO;
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

    public static TecnicDAO getTecnic() {
        if (tenicDAO == null){
            DAO.tenicDAO = new TecnicListImpl();
        }
        return DAO.tenicDAO;
    }

    public static OrdenServicoDAO getOrdenServico(){
        if (ordenServicoDAO == null){
            DAO.ordenServicoDAO = new OrdenServicoListImpl();
        }
        return DAO.ordenServicoDAO;
    }

    public static ClienteDAO getCliente(){
        if (clienteDAO == null){
            DAO.clienteDAO = new ClienteListImpl();
        }
        return DAO.clienteDAO;
    }

    public static OutroCompDAO getOutroComp(){
        if (outrocompDAO == null){
            DAO.outrocompDAO = new OutroCompListImpl();
        }
        return DAO.outrocompDAO;
    }


    public static MontagemDAO getMontagem(){
        if (montagemDAO == null){
            DAO.montagemDAO = new MontagemListImpl();
        }
        return DAO.montagemDAO;
    }

    public static LimpezaDAO getLimpeza(){
        if (limpezaDAO == null){
            DAO.limpezaDAO = new LimpezaListImpl();
        }
        return DAO.limpezaDAO;
    }


    public static CompCompDAO getCompComp(){
        if (compCompDAO == null){
            DAO.compCompDAO = new CompCompListImpl();
        }
        return DAO.compCompDAO;
    }

    public static InstalacaoDAO getInstalacao(){
        if (instalacaoDAO == null){
            DAO.instalacaoDAO = new InstalacaoListImpl();
        }
        return DAO.instalacaoDAO;
    }

}
