module com.example.filecompressor {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.filecompressor to javafx.fxml;
    exports com.example.filecompressor;
}