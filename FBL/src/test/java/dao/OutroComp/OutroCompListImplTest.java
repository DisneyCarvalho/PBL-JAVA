package dao.OutroComp;

import com.example.fbl.model.OutroComp;
import dao.DAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OutroCompListImplTest {
    OutroComp outroComp;
    OutroComp outroComp2;


    @BeforeEach
    void setUp(){
        OutroCompDAO oComp = DAO.getOutroComp();
        OutroComp Comp = new OutroComp(1,500.0F,1000.0F);
        OutroComp Comp2 = new OutroComp(15,5.0F,17.7F);
        this.outroComp = Comp;
        this.outroComp2 = Comp2;
        oComp.create(Comp);
        oComp.create(Comp2);

    }

    @Test
    void create() {

        OutroCompDAO oComp = DAO.getOutroComp();
        OutroComp Comp = new OutroComp(5,5.6F,10.0F);
        OutroComp Comp2 = new OutroComp(2,50.8F,173.7F);

        oComp.create(Comp);
        oComp.create(Comp2);



        assertEquals(4,oComp.getObj().size());
        assertEquals(3,oComp.getObj().get(3).getId());


    }

    @Test
    void getObj() {
        OutroCompDAO oComp = DAO.getOutroComp();
        ArrayList<OutroComp> lista = new ArrayList<OutroComp>();

        lista.add(outroComp);
        lista.add(outroComp2);

        assertEquals(2,oComp.getObj().size());
        assertEquals(1,oComp.getById(0).getQuantidade());
        assertEquals(500.0,oComp.getById(0).getCusto());
        assertEquals(15,oComp.getById(1).getQuantidade());
        assertEquals(5.0,oComp.getById(1).getCusto());



    }

    @Test
    void getById() {
        OutroCompDAO oComp = DAO.getOutroComp();

        assertEquals(5.0,oComp.getById(1).getCusto());


    }

    @Test
    void update() {
        OutroCompDAO oComp = DAO.getOutroComp();
        OutroComp novo = new OutroComp(15,16,15);
        novo.setId(1);
        oComp.update(novo);

        assertEquals(15,oComp.getById(1).getQuantidade());

    }

    @Test
    void delete() {
        OutroCompDAO oComp = DAO.getOutroComp();
        oComp.delete(1);
        assertEquals(1,oComp.getObj().size());

    }
    @AfterEach
    void tearDown(){
        OutroCompDAO oComp = DAO.getOutroComp();
        oComp.deleteAll();
    }
}