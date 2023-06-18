package com.example.fbl.controle;

import com.example.fbl.HelloApplication;
import com.example.fbl.model.OrdenServico;
import com.example.fbl.model.Servico;
import dao.DAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class ControllerEdit implements Initializable {

    @FXML
    private Button botCancel;

    @FXML
    private Button botEditr;

    @FXML
    private TextField cxavaliacao;

    @FXML
    private TextField cxcliente;

    @FXML
    private TextField cxcusto;

    @FXML
    private TextField cxdatafinalizacao;

    @FXML
    private TextField cxdescricao;

    @FXML
    private TextField cxdtcriacao;

    @FXML
    private TextField cxid;

    @FXML
    private TextField cxpreco;

    @FXML
    private TextField cxtecnico;

    @FXML
    private ComboBox<String> cxservicos;

    @FXML
    private ComboBox<String> cxstatus;
    private ObservableList<String> cxobstatus;

    @FXML
    private ComboBox<String> cxmetpag;
    private ObservableList<String> cxobsMetodo;

    private ObservableList<String> cxobsServico;

    private ArrayList<String> listStatus = new ArrayList<String>();
    private ArrayList<Servico> listServ = new ArrayList<Servico>();
    private  ArrayList<String> listMetodo = new ArrayList<String>();

    @FXML
    private Button botAddServ;

    private Stage stage;


    @FXML
    private Label erro;


    @FXML
    void cancelarActiion(ActionEvent event) {
        carregaMenuTecnic();

    }

    @FXML
    void editAction(ActionEvent event) {

        if (this.cxstatus.getSelectionModel().getSelectedItem() != null && this.cxdtcriacao.getText() != null && this.cxmetpag.getSelectionModel().getSelectedItem() != null && this.cxcliente.getText() != null && this.cxdtcriacao.getText() != null && DAO.getOrdenServico().getById(Integer.parseInt(this.cxid.getText())).getServicos().size() >0 ) {


            OrdenServico a = new OrdenServico(Integer.parseInt(this.cxcliente.getText()),this.cxdtcriacao.getText());

            a.setStatus(this.cxstatus.getValue());
            a.setDescricao(this.cxdtcriacao.getText());
            a.setDataCriacao(this.cxdtcriacao.getText());
            a.setDataFinalizacao(this.cxdatafinalizacao.getText());

            a.setId(Integer.parseInt( this.cxid.getText()));
            a.setPreco(Float.parseFloat( this.cxpreco.getText()));
            a.setCusto(Float.parseFloat(this.cxcusto.getText()));
            a.setId(Integer.parseInt( this.cxid.getText()));
            a.setTecnico(Integer.parseInt(this.cxtecnico.getText()));

            a.setServicos(DAO.getOrdenServico().getById(a.getId()).getServicos());

            DAO.getOrdenServico().update(a);
            carregaMenuTecnic();

        }else erro.setText("Preencha os campos 'STATUS','DATA DE CRIAÇÃO',MET. PAGAMENTO E O ID DO CLIENTE\n    E Adicione pelo menos um servico a ordem.");







    }

    public void setOrdem(OrdenServico a){
        this.cxcliente.setText(Integer.toString(a.getCliente()));
        this.cxdescricao.setText(a.getDescricao());
        this.cxid.setText(Integer.toString(a.getId()));
        this.cxtecnico.setText(Integer.toString(a.getTecnico()));
        this.cxcusto.setText(Float.toString(a.getCusto()));
        this.cxpreco.setText(Float.toString(a.getPreco()));
        this.cxdatafinalizacao.setText(a.getDataCriacao());
        this.cxdtcriacao.setText(a.getDataCriacao());
        this.cxavaliacao.setText(Integer.toString(a.getAvaliaçãoDoCliente()));


        carregarServicos(a);


    }

    private void carregarStatus(){
        String fina = "Finalizado";
        String anda = "Em Andamento";
        String conc = "Finalizado";
        listStatus.add(fina);
        listStatus.add(anda);
        listStatus.add(conc);

        cxobstatus = FXCollections.observableArrayList(listStatus);

        cxstatus.setItems(cxobstatus);

    }

    private void carregarServicos(OrdenServico a){


        ArrayList<String> listaservicos = new ArrayList<String>();

        for (Servico i : a.getServicos()){
            listaservicos.add(i.getName());
            System.out.println(i.getName());
        }
        cxobsServico = FXCollections.observableArrayList(listaservicos);

        cxservicos.setItems(cxobsServico);


    }

    private void carregarMetodos(){
        String fina = "A vista";
        String anda = "Debito";
        String conc = "Credito";
        listMetodo.add(fina);
        listMetodo.add(anda);
        listMetodo.add(conc);

        cxobsMetodo = FXCollections.observableArrayList(listMetodo);

        cxmetpag.setItems(cxobsMetodo);

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarStatus();
        carregarMetodos();

    }

    private void carregaMenuTecnic(){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menuTecnic.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load());
            Stage st = new Stage();
            st.setTitle("Ordens de Servico");
            st.setScene(scene);
            st.show();

            ControllerTecnic cont = fxmlLoader.getController();
            cont.setStage(st);

            stage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void addservAction(ActionEvent event) {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("servicoMenu.fxml"));


        {
            try {
                Scene scene = new Scene(fxmlLoader.load());
                Stage st = new Stage();
                st.setTitle("Servico");
                st.setScene(scene);
                st.show();



                ControllerServico controler = fxmlLoader.getController();

                controler.setServ(DAO.getOrdenServico().getById(Integer.parseInt(this.cxid.getText())).getServicos());
                controler.setStage(st);
                controler.setVtta(2);
                controler.setID(Integer.parseInt(cxid.getText()));
                stage.close();


            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

    public void setStage(Stage st) {
        this.stage = st;
    }

    public void setServ(ArrayList<Servico> listvServ) {
        this.listServ = listServ;
    }
}
