module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.example.Controler to javafx.fxml;
    exports org.example.Controler;
}