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

public class ControllerCreate implements Initializable {

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
    private ComboBox<String> cxmetpag;

    @FXML
    private TextField cxpreco;

    @FXML
    private ComboBox<String> cxstatus;

    @FXML
    private TextField cxtecnico;

    @FXML
    private Button botAddServ;


    @FXML
    private Label erro;

    private ArrayList<Servico> lisitaServ;





    @FXML
    private ComboBox<String> cxservicos;

    private ObservableList<String> cxobstatus;

    private ObservableList<String> cxobsMetodo;

    private ObservableList<String> cxobsServico;

    private ArrayList<String> listStatus = new ArrayList<String>();
    private ArrayList<String> listServ = new ArrayList<String>();
    private  ArrayList<String> listMetodo = new ArrayList<String>();
    private Stage stage;


    @FXML
    void cancelarActiion(ActionEvent event) {

        abrirTecnicMenu();



    }

    @FXML
    void editAction(ActionEvent event) {


        if (this.cxstatus.getSelectionModel().getSelectedItem() != null && this.cxdtcriacao.getText() != null && this.cxmetpag.getSelectionModel().getSelectedItem() != null && this.cxcliente.getText() != null && this.cxdtcriacao.getText() != null && lisitaServ.size() >0 ) {
            OrdenServico a = new OrdenServico(Integer.parseInt(this.cxcliente.getText()),this.cxdtcriacao.getText());
            a.setStatus(this.cxstatus.getSelectionModel().getSelectedItem());
            if (this.cxdescricao.getText() != null) {
                a.setDescricao(this.cxdescricao.getText());
            }
            a.setMetPagamento(this.cxmetpag.getSelectionModel().getSelectedItem());

            for (Servico b : lisitaServ){
                a.addServico(b);

            }

            DAO.getOrdenServico().create(a);

            abrirTecnicMenu();
            stage.close();





        }else erro.setText("Preencha os campos 'STATUS','DATA DE CRIAÇÃO',MET. PAGAMENTO E O ID DO CLIENTE\n    E Adicione pelo menos um servico a ordem.");





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
                controler.setVtta(1);
                controler.setServ(lisitaServ);
                controler.setStage(st);
                stage.close();


            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarMetodos();
        carregarStatus();
        if (lisitaServ ==null) {
            lisitaServ = new ArrayList<Servico>();
        }


    }


    public void setStage(Stage st) {
        this.stage = st;
    }

    public void setServ(ArrayList<Servico> a) {
        this.lisitaServ = a;
        float preco = 0;
        float custo = 0;
        for (Servico i : lisitaServ){
            custo += i.getCusto();
            preco += i.getPreco();
        }
        cxcusto.setText(Float.toString(custo));
        cxpreco.setText(Float.toString(preco));

        carregarServicos();


    }

    private void carregarServicos() {
        ArrayList<String> listaservicos = new ArrayList<String>();

        for (Servico a : lisitaServ){
            listaservicos.add(a.getName());
            System.out.println(a.getName());
        }
        cxobsServico = FXCollections.observableArrayList(listaservicos);

        cxservicos.setItems(cxobsServico);



    }


    private void abrirTecnicMenu(){
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


}
