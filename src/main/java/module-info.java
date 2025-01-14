module org.javafx.javafxml.propertiesbind {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens org.javafx.javafxml.propertiesbind to javafx.fxml;
    exports org.javafx.javafxml.propertiesbind;
}