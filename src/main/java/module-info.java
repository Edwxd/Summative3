module com.example.summative3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.summative3 to javafx.fxml;
    exports com.example.summative3;
}