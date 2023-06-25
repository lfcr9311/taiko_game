module jogopoo {
    requires javafx.controls;
    requires javafx.fxml;

    opens jogopoo to javafx.fxml;
    exports jogopoo;
}
