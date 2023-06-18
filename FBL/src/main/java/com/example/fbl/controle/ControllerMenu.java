package com.example.fbl.controle;

import com.example.fbl.HelloApplication;
import com.example.fbl.model.Tecnic;
import dao.DAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerMenu {
    @FXML
    private Button btlogin;

    @FXML
    private TextField cxkey;

    @FXML
    private TextField cxuser;

    private Stage cea;

    @FXML
    void botAction(ActionEvent event) {


        for (Tecnic a : DAO.getTecnic().getTecnicos()){
            if (a.getId() == Integer.parseInt(this.cxuser.getText()) && a.getSenha() == Integer.parseInt(this.cxkey.getText())){


                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menuTecnic.fxml"));
                try {
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage st = new Stage();
                    st.setTitle("Ordens de Servico");
                    st.setScene(scene);
                    st.show();

                    ControllerTecnic cont = fxmlLoader.getController();
                    cont.setStage(st);
                    cont.setTec(this.cxuser.getText());

                    cea.close();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }





            }
        }

    }


    public void setStage(Stage a ){
        this.cea = a;
    }

}
