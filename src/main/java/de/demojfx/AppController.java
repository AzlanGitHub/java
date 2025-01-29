package de.demojfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class AppController {
    @FXML private Label selectedItemLabel;
    @FXML private ListView<Item> listView;


    @FXML
    public void initialize(){
        DatabaseHelper.intializeDatabase();

        // Optional: Beispiel-Daten hinzufügen (nur beim ersten Start notwendig)
        if (DatabaseHelper.getAllItems().isEmpty()) {
            DatabaseHelper.addItem("Element 1", "Beschreibung für Element 1");
            DatabaseHelper.addItem("Element 2", "Beschreibung für Element 2");
            DatabaseHelper.addItem("Element 3", "Beschreibung für Element 3");
        }

        listView.getItems().addAll(DatabaseHelper.getAllItems());

        listView.getSelectionModel().selectedItemProperty().addListener((Observable, oldValue, newValue )->{
            if (newValue != null) {
                selectedItemLabel.setText(
                        "Ausgewählt: " + newValue.getName() + "\n" +
                                "Beschreibung: " + newValue.getDescription()
                );
            }
        });


    }

}