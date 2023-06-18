module com.example.fbl {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.fbl to javafx.fxml;
    exports com.example.fbl;
    exports  com.example.fbl.controle;
    opens com.example.fbl.controle to javafx.fxml;
    opens com.example.fbl.model;
}