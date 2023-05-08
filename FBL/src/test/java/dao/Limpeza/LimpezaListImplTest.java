package dao.Limpeza;

import com.example.fbl.model.Limpeza;
import dao.DAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LimpezaListImplTest {

    Limpeza Limp1;
    Limpeza Limp2;


    @BeforeEach
    public void setUp(){
        LimpezaDAO limT= DAO.getLimpeza();

        Limpeza limp1 = new Limpeza(51,13);
        Limpeza limp2 = new Limpeza(89,5);

        this.Limp1 = limp1;
        this.Limp2 = limp2;

        limT.create(limp1);
        limT.create(limp2);


    }

    @Test
    void create() {
        LimpezaDAO limT= DAO.getLimpeza();

        Limpeza lim1 = new Limpeza(1,1);

        limT.create(lim1);

        assertEquals(3,limT.getObj().size());
        assertEquals(2,limT.getObj().get(2).getId());


    }

    @Test
    void getObj() {
        LimpezaDAO limT= DAO.getLimpeza();

        ArrayList<Limpeza> lista = new ArrayList<Limpeza>();

        lista.add(Limp1);
        lista.add(Limp2);

        assertEquals(lista,limT.getObj());



    }

    @Test
    void getById() {
        LimpezaDAO limT= DAO.getLimpeza();

        assertEquals(Limp2,limT.getById(1));



    }

    @Test
    void update() {
        LimpezaDAO limT= DAO.getLimpeza();

        Limpeza novo = new Limpeza(100,1);
        novo.setId(1);

        limT.update(novo);

        assertEquals(100,limT.getById(1).getPreco());

    }

    @Test
    void delete() {
        LimpezaDAO limT= DAO.getLimpeza();
        limT.delete(1);
        assertEquals(1, limT.getObj().size());
    }

    @AfterEach
    public void tearDown(){
        LimpezaDAO limT= DAO.getLimpeza();
        limT.deleteAll();
    }
}