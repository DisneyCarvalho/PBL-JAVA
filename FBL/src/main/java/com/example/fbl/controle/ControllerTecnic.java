package com.example.fbl.controle;

import com.example.fbl.HelloApplication;
import com.example.fbl.model.OrdenServico;
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
import java.util.ResourceBundle;

public class ControllerTecnic implements Initializable {

    @FXML
    private Button botCancel;

    @FXML
    private Button botPegar;

    @FXML
    private Button botTerminar;

    @FXML
    private TableColumn<OrdenServico,String> colData = new TableColumn<>();;

    @FXML
    private TableColumn<OrdenServico,Integer> colNome = new TableColumn<>();;

    @FXML
    private TableColumn<OrdenServico,Integer> colCusto = new TableColumn<>();;

    @FXML
    private TableColumn<OrdenServico, Integer> colId = new TableColumn<>() ;

    @FXML
    private TableColumn<OrdenServico, String> colSituacao;



    @FXML
    private TableView<OrdenServico> Ordens;


    @FXML
    private Button botCriarOrdem;

    @FXML
    private Button botDelOrdem;

    private Stage stage;
    private String tec;


    @FXML
    void cancelAction(ActionEvent event) {

        for (OrdenServico a : DAO.getOrdenServico().buscaPorTecnico(Integer.parseInt(tec))) {
            if (a.getStatus().equals("Em andamento")) {
                DAO.getOrdenServico().getById(a.getId()).cancelar();
            }
        }

    }

    @FXML
    void pegarAction(ActionEvent event) {

        DAO.getOrdenServico().pegaServico(Integer.parseInt( tec));

    }

    @FXML
    void terminarAction(ActionEvent event) {
        for (OrdenServico a : DAO.getOrdenServico().buscaPorTecnico(Integer.parseInt(tec))) {
            if (a.getStatus().equals("Em andamento")) {
                DAO.getOrdenServico().getById(a.getId()).finalizar();
            }
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new PropertyValueFactory<OrdenServico, Integer>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<OrdenServico, Integer>("cliente"));
        colCusto.setCellValueFactory(new PropertyValueFactory<OrdenServico,Integer>("custo"));
        colData.setCellValueFactory(new PropertyValueFactory<OrdenServico,String>("dataCriacao"));
        colSituacao.setCellValueFactory(new PropertyValueFactory<OrdenServico,String>("status"));

        preencher();





    }

    private void preencher(){
        ObservableList<OrdenServico> OrdensData = FXCollections.observableArrayList(DAO.getOrdenServico().getObj());
        Ordens.setItems(OrdensData);
    }

    @FXML
    void criarordAction(ActionEvent event) {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("criarMenu.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load());
            Stage st = new Stage();
            st.setTitle("Criar");
            st.setScene(scene);
            st.show();

            ControllerCreate cont = fxmlLoader.getController();
            cont.setStage(st);
            stage.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }

    @FXML
    void deleordAction(ActionEvent event) {
        OrdenServico a = this.Ordens.getSelectionModel().getSelectedItem();
        DAO.getOrdenServico().delete(a.getId());
        preencher();

    }

    @FXML
    void editAction(ActionEvent event) {
        OrdenServico a = this.Ordens.getSelectionModel().getSelectedItem();
        if (this.Ordens.getSelectionModel().getSelectedItem() != null ) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("editMenu.fxml"));
            try {

                Scene scene = new Scene(fxmlLoader.load());
                Stage st = new Stage();
                st.setTitle("Edit");
                st.setScene(scene);
                st.show();

                ControllerEdit cont = fxmlLoader.getController();
                cont.setOrdem(DAO.getOrdenServico().getById(this.Ordens.getSelectionModel().getSelectedItem().getId()));
                cont.setStage(st);
                stage.close();


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void setStage(Stage st) {
        this.stage = st;

    }

    public void setTec(String text) {
        this.tec = text;
    }
}
