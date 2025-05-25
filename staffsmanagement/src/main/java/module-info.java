module com.cse305 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.cse305 to javafx.fxml;
    exports com.cse305;
}
