module com.example.devdeskstopb3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.devdeskstopb3 to javafx.fxml;
    exports com.example.devdeskstopb3;
}