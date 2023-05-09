package dao.Instalacao;

import com.example.fbl.model.Instalacao;
import dao.DAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InstalacaoListImplTest {

    Instalacao Inst1;
    Instalacao Inst2;


    @BeforeEach
    public void setUp(){
        InstalacaoDAO instaL= DAO.getInstalacao();

        Instalacao int1= new Instalacao(1,2);
        Instalacao int2= new Instalacao(789,61);

        this.Inst1 = int1;
        this.Inst2 = int2;

        instaL.create(int1);
        instaL.create(int2);




    }

    @Test
    void create() {
        InstalacaoDAO instaL= DAO.getInstalacao();
        Instalacao inta = new Instalacao(75,15);

        instaL.create(inta);

        assertEquals(3,instaL.getObj().size());
        assertEquals(2,instaL.getById(2).getId());


    }

    @Test
    void getObj() {
        InstalacaoDAO instaL= DAO.getInstalacao();

        ArrayList<Instalacao> lista = new ArrayList<Instalacao>();

        lista.add(Inst1);
        lista.add(Inst2);

        assertEquals(2,instaL.getObj().size());
        assertEquals(1,instaL.getById(0).getPreco());
        assertEquals(2,instaL.getById(0).getCusto());
        assertEquals(789,instaL.getById(1).getPreco());
        assertEquals(61,instaL.getById(1).getCusto());



    }

    @Test
    void getById() {
        InstalacaoDAO instaL= DAO.getInstalacao();

        assertEquals(1, instaL.getById(1).getId());

    }

    @Test
    void update() {
        InstalacaoDAO instaL= DAO.getInstalacao();

        Instalacao novo = new Instalacao(10,5);
        novo.setId(1);

        instaL.update(novo);

        assertEquals(10,instaL.getById(1).getPreco());

    }

    @Test
    void delete() {
        InstalacaoDAO instaL= DAO.getInstalacao();

        instaL.delete(1);

        assertEquals(1,instaL.getObj().size());

    }

    @AfterEach
    public void tearDown(){
        InstalacaoDAO instaL= DAO.getInstalacao();
        instaL.deleteAll();

    }

}