module org.javafx.javafxml.calculator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires exp4j;
    requires java.desktop;

    opens org.javafx.javafxml.calculator to javafx.fxml;
    exports org.javafx.javafxml.calculator;
}