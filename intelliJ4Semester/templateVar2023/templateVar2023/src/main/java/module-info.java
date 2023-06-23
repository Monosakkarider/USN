module com.example.templatevar2023 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.templatevar2023 to javafx.fxml;
    exports com.example.templatevar2023;
    exports com.example.templatevar2023.grensesnitt;
    opens com.example.templatevar2023.grensesnitt to javafx.fxml;
}