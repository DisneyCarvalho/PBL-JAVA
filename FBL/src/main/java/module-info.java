module com.example.fbl {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.fbl to javafx.fxml;
    exports com.example.fbl;
}