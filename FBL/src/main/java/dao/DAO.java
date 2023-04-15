package dao;

import dao.Tecnic.TecnicDAO;
import dao.Tecnic.TecnicListImpl;

public class DAO {

    private static TecnicDAO tenicDAO;

    public static TecnicDAO getTecnic() {
        if (tenicDAO == null){
            DAO.tenicDAO = new TecnicListImpl();
        }
        return DAO.tenicDAO;
    }
}
