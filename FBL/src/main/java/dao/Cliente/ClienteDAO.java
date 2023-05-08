package dao.Cliente;

import com.example.fbl.model.Cliente;
import dao.CRUD;


public interface ClienteDAO extends CRUD <Cliente> {

    public void deleteAll();


}
