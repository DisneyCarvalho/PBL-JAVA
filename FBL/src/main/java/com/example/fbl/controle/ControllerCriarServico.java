package com.example.fbl.controle;

import com.example.fbl.HelloApplication;
import com.example.fbl.model.Instalacao;
import com.example.fbl.model.Limpeza;
import com.example.fbl.model.Montagem;
import com.example.fbl.model.Servico;
import dao.DAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.DragEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class ControllerCriarServico implements Initializable {

    @FXML
    private Button botCriar;

    @FXML
    private Button botFechar;

    @FXML
    private Label Erro;

    @FXML
    private TextField cxCusto;

    @FXML
    private TextArea cxNome;

    @FXML
    private TextField cxPreco;

    @FXML
    private ComboBox<String> cxServico;

    private ArrayList<String> listServico = new ArrayList<String>();

    private ObservableList<String> cxobServico;

    private Stage dialog;
    private ArrayList<Servico> listvServ;
    private int vtta;


    @FXML
    void criarAction(ActionEvent event) {
        String tipo = cxServico.getSelectionModel().getSelectedItem();
        if (this.cxNome.getText() == null || this.cxServico.getSelectionModel().getSelectedItem() == null || this.cxPreco.getText() == null || this.cxCusto.getText() == null){
            this.Erro.setText("Preencha todos os campos");

        }
        else if  (tipo.equals("Limpeza")) {
            Limpeza limp = new Limpeza(Float.parseFloat(this.cxPreco.getText()), Float.parseFloat(this.cxCusto.getText()));
            limp.setName(this.cxNome.getText());
            DAO.getLimpeza().create(limp);

            fechar();
        }

        else if  (tipo.equals("Montagem")) {
            Montagem limp = new Montagem(Float.parseFloat(this.cxPreco.getText()), Float.parseFloat(this.cxCusto.getText()));
            limp.setName(this.cxNome.getText());
            DAO.getMontagem().create(limp);

            fechar();
        }
        else if  (tipo.equals("Instalação")){
            Instalacao limp = new Instalacao(Float.parseFloat( this.cxPreco.getText()),Float.parseFloat( this.cxCusto.getText()));
            limp.setName(this.cxNome.getText());
            DAO.getInstalacao().create(limp);

            fechar();


        }

    }


    private void carregarServicos(){

        String fina = "Limpeza";
        String anda = "Montagem";
        String conc = "Instalação";
        listServico.add(fina);
        listServico.add(anda);
        listServico.add(conc);

        cxobServico = FXCollections.observableArrayList(listServico);

        cxServico.setItems(cxobServico);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarServicos();

    }

    @FXML
    void fecharAction(ActionEvent event) {





        fechar();
    }



    private void fechar(){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("servicoMenu.fxml"));


        try {
            Scene scene = new Scene(fxmlLoader.load());
            Stage st = new Stage();
            st.setTitle("Servico");
            st.setScene(scene);
            st.show();

            ControllerServico controler = fxmlLoader.getController();
            controler.setServ(listvServ);
            controler.setStage(st);
            controler.setVtta(vtta);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.dialog.close();



    }

    public void setVtta(int a ){
        this.vtta = a;
    }

    public void setDialogStage(Stage st) {
        this.dialog = st;
    }

    public void setServ(ArrayList<Servico> listvServ) {
        this.listvServ = listvServ;
    }
}
