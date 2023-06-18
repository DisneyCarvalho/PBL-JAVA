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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerServico implements Initializable {

    @FXML
    private TableView<Servico> Serv;

    @FXML
    private TableView<Servico> ServOrd;

    @FXML
    private Button AualizarBot;

    @FXML
    private Button addBot;

    @FXML
    private Button criarBot;

    @FXML
    private Button removeBot;

    @FXML
    private TableColumn<Servico, Float> colDesc;

    @FXML
    private TableColumn<Servico, Float> colDesc1;

    @FXML
    private TableColumn<Servico, String> colName;

    @FXML
    private TableColumn<Servico, String> colName1;

    @FXML
    private TableColumn<Servico, Float> colValor;

    @FXML
    private TableColumn<Servico, Float> colValor1;

    private ArrayList<Servico> listvServ;

    private ObservableList<Servico> odds2;
    private Stage stage;

    @FXML
    private Button voltarBot;
    private  int ID;


    public void setVtta(int vtta) {
        this.vtta = vtta;
    }

    private int vtta;


    @FXML
    void addAction(ActionEvent event) {

        Servico a = this.Serv.getSelectionModel().getSelectedItem();
        listvServ.add(a);
        preecher();



    }

    @FXML
    void criarAction(ActionEvent event) {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("criarServicoMenu.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load());
            Stage st = new Stage();
            st.setTitle("Criar Servico");
            st.setScene(scene);
            st.show();

            ControllerCriarServico control = fxmlLoader.getController();
            control.setDialogStage(st);
            control.setServ(listvServ);
            control.setVtta(vtta);

            stage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void removeAction(ActionEvent event) {
        listvServ.remove(this.ServOrd.getSelectionModel().getSelectedItem());
        preecher();


    }

     public void preecher(){

        ObservableList<Servico> ords = FXCollections.observableArrayList(DAO.getLimpeza().getObj());
        ords.addAll(DAO.getMontagem().getObj());
        ords.addAll(DAO.getInstalacao().getObj());

        ObservableList<Servico> ordem = FXCollections.observableArrayList(listvServ);

        ServOrd.setItems(ordem);
        Serv.setItems(ords);



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        colName.setCellValueFactory(new PropertyValueFactory<Servico,String>("Name"));
        colDesc.setCellValueFactory(new PropertyValueFactory<Servico,Float>("Custo"));
        colValor.setCellValueFactory(new PropertyValueFactory<Servico,Float>("Preco"));

        colName1.setCellValueFactory(new PropertyValueFactory<Servico,String>("Name"));
        colDesc1.setCellValueFactory(new PropertyValueFactory<Servico,Float>("Custo"));
        colValor1.setCellValueFactory(new PropertyValueFactory<Servico,Float>("Preco"));






    }



    public void setID(int ID) {
        this.ID = ID;
    }

    @FXML
    void voltarAction(ActionEvent event) {

        System.out.println(vtta);
        if (vtta == 1) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("criarMenu.fxml"));

            try {
                Scene scene = new Scene(fxmlLoader.load());
                Stage st = new Stage();
                st.setTitle("Criar");
                st.setScene(scene);
                st.show();

                ControllerCreate cont = fxmlLoader.getController();
                cont.setStage(st);
                cont.setServ(listvServ);
                stage.close();




            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }else if (vtta == 2){

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("editMenu.fxml"));
            try {

                Scene scene = new Scene(fxmlLoader.load());
                Stage st = new Stage();
                st.setTitle("Edit");
                st.setScene(scene);
                st.show();

                ControllerEdit cont = fxmlLoader.getController();
                cont.setOrdem(DAO.getOrdenServico().getById(ID));
                cont.setStage(st);




                cont.setServ(listvServ);

                stage.close();


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }




    @FXML
    void atualizarAction(ActionEvent event) {
        preecher();
    }

    public void setServ(ArrayList<Servico> a){
        this.listvServ = a;
        preecher();
    }

    public void setStage(Stage st) {
        this.stage = st;
    }
}
