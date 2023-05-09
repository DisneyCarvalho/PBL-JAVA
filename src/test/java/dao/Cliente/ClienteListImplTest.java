package dao.Cliente;

import com.example.fbl.model.Cliente;
import com.example.fbl.model.Cliente;
import dao.Cliente.ClienteDAO;
import dao.Cliente.ClienteDAO;
import dao.DAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ClienteListImplTest {

    Cliente clie1;
    Cliente clie2;


    @BeforeEach
    public void setUp(){
        ClienteDAO clie= DAO.getCliente();

        Cliente cop1 = new Cliente("Arnold Schwarzenegger");
        Cliente cop2 = new Cliente("Clovis Basilio dos Santos");

        this.clie1 = cop1;
        this.clie2 = cop2;

        clie.create(cop1);
        clie.create(clie2);
        
    }

    @Test
    void create() {
        ClienteDAO clie= DAO.getCliente();
        Cliente cmp1 = new Cliente("Leonardo DiCaprio");
        clie.create(cmp1);

        assertEquals(3,clie.getObj().size());
        assertEquals(2,clie.getById(2).getId());
        
        
        
    }

    @Test
    void getObj() {

        ClienteDAO clie= DAO.getCliente();

        assertEquals(2,clie.getObj().size());
        assertEquals("Arnold Schwarzenegger",clie.getById(0).getNome());
        assertEquals("Clovis Basilio dos Santos",clie.getById(1).getNome());

    }

    @Test
    void getById() {
        ClienteDAO clie= DAO.getCliente();

        assertEquals(1,clie.getById(1).getId());



    }

    @Test
    void update() {

        ClienteDAO clie= DAO.getCliente();

        Cliente novo = new Cliente("Max Weber");
        novo.setId(1);

        clie.update(novo);

        assertEquals("Max Weber",clie.getById(1).getNome());
    }

    @Test
    void delete() {

        ClienteDAO clie= DAO.getCliente();

        clie.delete(1);

        assertEquals(1,clie.getObj().size());
    }

    @AfterEach
    public void tearDown(){
        ClienteDAO cliE= DAO.getCliente();
        cliE.deleteAll();
    }
}