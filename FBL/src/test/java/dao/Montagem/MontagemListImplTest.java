package dao.Montagem;

import com.example.fbl.model.Montagem;
import com.example.fbl.model.OrdenServico;
import dao.DAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MontagemListImplTest {

    Montagem Mont1;
    Montagem Mont2;




    @BeforeEach
    public void setUp(){
        MontagemDAO montD= DAO.getMontagem();

        Montagem Mont1 = new Montagem(15,56);
        Montagem Mont2 = new Montagem(5,2);

        this.Mont1 = Mont1;
        this.Mont2 = Mont2;

        montD.create(Mont1);
        montD.create(Mont2);


    }

    @Test
    void create() {
        MontagemDAO montD= DAO.getMontagem();

        Montagem mont1 = new Montagem(5,2);
        Montagem mont2 = new Montagem(6,2);

        montD.create(mont1);
        montD.create(mont2);

        assertEquals(4,montD.getObj().size());
        assertEquals(3,montD.getObj().get(3).getId());


    }

    @Test
    void getObj() {
        MontagemDAO montD= DAO.getMontagem();
        ArrayList<Montagem> lista = new ArrayList<Montagem>();

        lista.add(Mont1);
        lista.add(Mont2);

        assertEquals(lista,montD.getObj());


    }

    @Test
    void getById() {
        MontagemDAO montD= DAO.getMontagem();

        assertEquals(5,montD.getById(1).getPreco());

    }

    @Test
    void update() {
        MontagemDAO montD= DAO.getMontagem();
        Montagem novo = new Montagem(16,15);
        novo.setId(1);
        montD.update(novo);

        assertEquals(16,montD.getById(1).getPreco());

    }

    @Test
    void delete() {
        MontagemDAO montD= DAO.getMontagem();
        montD.delete(1);
        assertEquals(1,montD.getObj().size());

    }

    @AfterEach
    public void tearDown(){
        MontagemDAO montD= DAO.getMontagem();
        montD.deleteAll();

    }
}