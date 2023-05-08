package dao.Tecnic;

import com.example.fbl.model.Tecnic;
import dao.DAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TecnicListImplTest {

    Tecnic tecnico1;
    Tecnic tecnico2;


    @BeforeEach
    public void setUp(){
        TecnicDAO tecT= DAO.getTecnic();

        Tecnic tecnic1 = new Tecnic(551);
        Tecnic tecnic2 = new Tecnic(511);

        this.tecnico2 = tecnic2;
        this.tecnico1 = tecnic1;

        tecT.create(tecnic1);
        tecT.create(tecnic2);



    }



    @Test
    void create() {
        TecnicDAO tecT= DAO.getTecnic();


        Tecnic tecnic = new Tecnic(221);

        tecT.create(tecnic);

        assertEquals(3,tecT.getTecnicos().size());
        assertEquals(2,tecT.getTecnicos().get(2).getId());




    }

    @Test
    void getTecnicos() {
        TecnicDAO tecT= DAO.getTecnic();
        ArrayList<Tecnic> lista = new ArrayList<Tecnic>();

        lista.add(tecnico1);
        lista.add(tecnico2);

        assertEquals(lista,tecT.getTecnicos());



    }

    @Test
    void getById() {
        TecnicDAO tecT= DAO.getTecnic();

        assertEquals(tecnico2,tecT.getById(tecnico2.getId()));


    }

    @Test
    void update() {
        TecnicDAO tecT= DAO.getTecnic();

        Tecnic novo = new Tecnic(891);
        novo.setId(1);

        tecT.update(novo);

        assertEquals(891,tecT.getById(1).getSenha());




    }

    @Test
    void delete() {
        TecnicDAO tecT= DAO.getTecnic();

        tecT.delete(1);

        assertEquals(1,tecT.getTecnicos().size());
    }


    @AfterEach
    public void tearDown(){
        TecnicDAO tecT= DAO.getTecnic();
        tecT.deleteAll();


    }
}