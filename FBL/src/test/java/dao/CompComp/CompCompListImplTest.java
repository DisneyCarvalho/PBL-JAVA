package dao.CompComp;

import com.example.fbl.model.CompComp;
import dao.DAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CompCompListImplTest {
    CompComp comp1;
    CompComp comp2;

    @BeforeEach
    public void setUp(){
        CompCompDAO comP= DAO.getCompComp();

        CompComp cop1 = new CompComp(14,15,80);
        CompComp cop2 = new CompComp(4,5,8);

        this.comp1 = cop1;
        this.comp2 = cop2;

        comP.create(cop1);
        comP.create(comp2);



    }

    @Test
    void create() {
        CompCompDAO comP= DAO.getCompComp();
        CompComp cmp1 = new CompComp(1,1,5);
        comP.create(cmp1);

        assertEquals(3,comP.getObj().size());
        assertEquals(2,comP.getById(2).getId());



    }

    @Test
    void getObj() {
        CompCompDAO comP= DAO.getCompComp();
        ArrayList<CompComp> lista = new ArrayList<CompComp>();

        lista.add(comp1);
        lista.add(comp2);

        assertEquals(lista,comP.getObj());

    }

    @Test
    void update() {
        CompCompDAO comP= DAO.getCompComp();

        CompComp novo = new CompComp(5,56,120);
        novo.setId(1);

        comP.update(novo);

        assertEquals(56,comP.getById(1).getCusto());

    }

    @Test
    void delete() {
        CompCompDAO comP= DAO.getCompComp();

        comP.delete(1);

        assertEquals(1,comP.getObj().size());

    }

    @AfterEach
    public void tearDown(){
        CompCompDAO comP= DAO.getCompComp();
        comP.deleteAll();

    }
}