package com.example.fbl;

import com.example.fbl.controle.ControllerMenu;
import com.example.fbl.model.OrdenServico;
import com.example.fbl.model.Tecnic;
import dao.DAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("viewMenu.fxml"));


        DAO.getTecnic().create(new Tecnic(5));




        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Login!");
        stage.setScene(scene);
        stage.show();
        ControllerMenu cont = fxmlLoader.getController();
        cont.setStage(stage);

    }

    public static void main(String[] args) {
        launch();
    }
}