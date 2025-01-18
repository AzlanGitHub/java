module org.javafx.javafxml.jhotelres {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.desktop;

    opens org.javafx.javafxml.jhotelres to javafx.fxml;
    exports org.javafx.javafxml.jhotelres;
}