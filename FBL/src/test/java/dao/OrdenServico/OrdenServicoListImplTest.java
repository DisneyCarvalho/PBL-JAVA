package dao.OrdenServico;

import com.example.fbl.model.OrdenServico;
import dao.DAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrdenServicoListImplTest {
    OrdenServico ordem;
    OrdenServico ordem2;

    @BeforeEach
    void setUp(){
        OrdenServicoDAO ord = DAO.getOrdenServico();
        OrdenServico Ordem = new OrdenServico(1,"04/05/2023");
        OrdenServico Ordem2 = new OrdenServico(2,"04/05/2023");
        this.ordem = Ordem;
        this.ordem2 = Ordem2;
        ord.create(Ordem);
        ord.create(Ordem2);

    }

    @org.junit.jupiter.api.Test
    void create() {
        OrdenServicoDAO ord =  DAO.getOrdenServico();
        OrdenServico ordem3 = new OrdenServico(33,"04/05/2023");

        OrdenServico ordemt = ord.create(ordem3);

        assertEquals(3,ord.getObj().size());
        assertEquals(ordemt,ordem3);

    }

    @org.junit.jupiter.api.Test
    void getObj() {
        OrdenServicoDAO ord =  DAO.getOrdenServico();
        ArrayList<OrdenServico> lista = new ArrayList<OrdenServico>();
        lista.add(ordem);
        lista.add(ordem2);

        assertEquals(2,ord.getObj().size());
        assertEquals(lista,ord.getObj());


    }

    @org.junit.jupiter.api.Test
    void getById() {
        OrdenServicoDAO ord =  DAO.getOrdenServico();

        OrdenServico ordem3 = new OrdenServico(1,"01/05/2023");
        OrdenServico ordem4 = new OrdenServico(1,"06/05/2023");
        OrdenServico ordem5 = new OrdenServico(2,"05/05/2023");




        ord.create(ordem3);
        ord.create(ordem4);
        ord.create(ordem5);

        assertEquals(ordem4,ord.getById(ordem4.getId()));



    }

    @org.junit.jupiter.api.Test
    void update() {
        OrdenServicoDAO ord =  DAO.getOrdenServico();



        OrdenServico ordt = new OrdenServico(14,"07/08/2115");
        ordt.setId(1);


        assertEquals("04/05/2023",ord.getById(1).getDataCriacao());


        ord.update(ordt);


        assertEquals("07/08/2115",ord.getById(1).getDataCriacao());




    }

    @org.junit.jupiter.api.Test
    void delete() {
        OrdenServicoDAO ord =  DAO.getOrdenServico();

        ord.delete(1);

        assertEquals(1,ord.getObj().size());



    }

    @org.junit.jupiter.api.Test
    void buscaPorTecnico() {

        OrdenServicoDAO ord =  DAO.getOrdenServico();
        ArrayList<OrdenServico>  lista = new ArrayList<OrdenServico>();

        OrdenServico ordem3 = new OrdenServico(1,"01/05/2023");
        OrdenServico ordem4 = new OrdenServico(1,"06/05/2023");
        OrdenServico ordem5 = new OrdenServico(2,"05/05/2023");

        ordem.setTecnico(1);
        ordem3.setTecnico(1);
        ordem4.setTecnico(1);

        lista.add(ordem);
        lista.add(ordem3);
        lista.add(ordem4);

        ord.create(ordem3);
        ord.create(ordem4);
        ord.create(ordem5);

        assertEquals(lista,ord.buscaPorTecnico(1));

    }

    @org.junit.jupiter.api.Test
    void buscaPorCliente() {

        OrdenServicoDAO ord =  DAO.getOrdenServico();
        ArrayList<OrdenServico>  lista = new ArrayList<OrdenServico>();

        OrdenServico ordem3 = new OrdenServico(1,"01/05/2023");
        OrdenServico ordem4 = new OrdenServico(1,"06/05/2023");
        OrdenServico ordem5 = new OrdenServico(2,"05/05/2023");


        lista.add(ordem);
        lista.add(ordem3);
        lista.add(ordem4);

        ord.create(ordem3);
        ord.create(ordem4);
        ord.create(ordem5);

        assertEquals(lista,ord.buscaPorCliente(1));

    }


    @org.junit.jupiter.api.Test
    void pegaServico() {
        OrdenServicoDAO ord = DAO.getOrdenServico();

        OrdenServico Ordem = new OrdenServico(3,"04/05/2023");
        OrdenServico Ordem2 = new OrdenServico(4,"04/05/2023");
        OrdenServico Ordem3 = new OrdenServico(5,"05/05/2023");

        Ordem.finalizar();
        Ordem2.andamento();
        Ordem3.andamento();

        ord.create(Ordem);
        ord.create(Ordem2);
        ord.create(Ordem3);

        ord.pegaServico(1);


        assertEquals(1,Ordem2.getTecnico());






    }

    @org.junit.jupiter.api.Test
    void avaiacaoCliente() {

        OrdenServicoDAO ord = DAO.getOrdenServico();

        OrdenServico Ordem = new OrdenServico(2,"14/05/2023");
        OrdenServico Ordem2 = new OrdenServico(2,"07/05/2023");
        OrdenServico Ordem3 = new OrdenServico(2,"05/05/2023");



        ord.getById(1).setAvaliaçãoDoCliente(10);

        Ordem.setAvaliaçãoDoCliente(10);
        Ordem2.setAvaliaçãoDoCliente(7);
        Ordem3.setAvaliaçãoDoCliente(8);



        ord.create(Ordem);
        ord.create(Ordem2);
        ord.create(Ordem3);

        float av = ord.avaiacaoCliente(2);

        assertEquals(8.75,av);




    }


    @org.junit.jupiter.api.Test
    void avaliacaoTodos() {

        OrdenServicoDAO ord = DAO.getOrdenServico();

        OrdenServico Ordem = new OrdenServico(2,"14/05/2023");
        OrdenServico Ordem2 = new OrdenServico(2,"07/05/2023");
        OrdenServico Ordem3 = new OrdenServico(2,"05/05/2023");


        ord.getById(0).setAvaliaçãoDoCliente(10);
        ord.getById(1).setAvaliaçãoDoCliente(10);

        Ordem.setAvaliaçãoDoCliente(10);
        Ordem2.setAvaliaçãoDoCliente(7);
        Ordem3.setAvaliaçãoDoCliente(8);
        ord.create(Ordem);
        ord.create(Ordem2);
        ord.create(Ordem3);


        assertEquals(9,ord.avaliacaoTodos());
    }

    @org.junit.jupiter.api.Test
    void avaiacaoTecnico() {

        OrdenServicoDAO ord = DAO.getOrdenServico();

        OrdenServico Ordem = new OrdenServico(2,"14/05/2023");
        OrdenServico Ordem2 = new OrdenServico(2,"07/05/2023");
        OrdenServico Ordem3 = new OrdenServico(2,"05/05/2023");



        ord.getById(1).setAvaliaçãoDoCliente(10);

        Ordem.setAvaliaçãoDoCliente(10);
        Ordem2.setAvaliaçãoDoCliente(7);
        Ordem3.setAvaliaçãoDoCliente(8);


        Ordem2.setTecnico(2);
        Ordem3.setTecnico(2);

        ord.create(Ordem);
        ord.create(Ordem2);
        ord.create(Ordem3);


        assertEquals(7.5,ord.avaiacaoTecnico(2));

    }

    @AfterEach
    void tearDown(){
        OrdenServicoDAO ord = DAO.getOrdenServico();
        ord.deleteAll();
    }

}

