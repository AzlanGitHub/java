package org.javafx.javafxml.propertiesbind;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class PropertyApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Änderungen für Github
        // push und pull
        Person person = new Person();
        //TextField erzeugen
        TextField nameField = new TextField();
        // Label erzeugen
        Label nameLabel = new Label();

        // Bindung der Textfeld-Eingabe an das Label
        nameLabel.textProperty().bind(person.nameProperty());
        person.nameProperty().bind(nameField.textProperty());

        VBox root = new VBox(nameField, nameLabel);
        Scene scene = new Scene(root, 300, 300);
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("JavaFX Properties Beispiel!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}