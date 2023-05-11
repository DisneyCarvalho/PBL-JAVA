module com.example.fbl {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fbl.model;

    opens dao.Cliente;
    opens dao.CompComp;
    opens dao.Instalacao;
    opens dao.Limpeza;
    opens dao.Montagem;
    opens dao.OrdenServico;
    opens dao.OutroComp;
    opens dao.Tecnic;


                            
    opens com.example.fbl to javafx.fxml;
    exports com.example.fbl;
}