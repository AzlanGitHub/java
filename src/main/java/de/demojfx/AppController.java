package de.demojfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;

public class AppController {
    @FXML private Label selectedItemLabel;
    @FXML private ListView<Item> listView;
    @FXML
    private ObservableList<Item> products = FXCollections.observableArrayList();



    @FXML
    public void initialize(){
        DatabaseHelper.intializeDatabase();

        // Event-Handler für Doppelklick
        listView.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                Item selectedItem = listView.getSelectionModel().getSelectedItem();
                if (selectedItem != null) {
                    //handleDoubleClick(selectedItem);
                    editProduct(null);
                }
            }
        });

        // Optional: Beispiel-Daten hinzufügen (nur beim ersten Start notwendig)
        if (DatabaseHelper.getAllProduct().isEmpty()) {
            DatabaseHelper.addProduct("Element 1", "Beschreibung für Element 1");
            DatabaseHelper.addProduct("Element 2", "Beschreibung für Element 2");
            DatabaseHelper.addProduct("Element 3", "Beschreibung für Element 3");
        }
        listView.getItems().addAll(DatabaseHelper.getAllProduct());
        listView.getSelectionModel().selectedItemProperty().addListener((Observable, oldValue, newValue )->{
            if (newValue != null) {
                selectedItemLabel.setText(
                        "Ausgewählt: " + newValue.getName() + "\n" +
                                "Beschreibung: " + newValue.getDescription()
                );
            }
        });
    }

    public void addProdcut(ActionEvent actionEvent) {

        TextInputDialog tiD = new TextInputDialog();

        tiD.setTitle("Add new Product(Item)");
        tiD.setHeaderText("write name and description(separeted by comma");
        tiD.setContentText("name, description");

        tiD.showAndWait().ifPresent(input ->{

            String[] parts = input.split(",",2);

            if(parts.length == 2){
              String name = parts[0].trim();
              String description = parts[1].trim();
              // save in databbase tablle product
              DatabaseHelper.addProduct(name,description);

              //products.add(new Item(name, description));

            }else{
                showAlert("invalid format","please write name and description separted by comma ");
            }
        });

        listView.getItems().clear();
        listView.getItems().addAll(DatabaseHelper.getAllProduct());
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void editProduct(ActionEvent actionEvent) {

        Item selectedItem = listView.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            showAlert("Kein Item ausgewählt", "Bitte wähle ein Item zum Bearbeiten aus.");
            return;
        }

        TextInputDialog dialog = new TextInputDialog(selectedItem.getName() + ", " + selectedItem.getDescription());
        dialog.setTitle("Item bearbeiten");
        dialog.setHeaderText("Bearbeite Name und Beschreibung (getrennt durch ein Komma):");
        dialog.setContentText("Name, Beschreibung:");

        dialog.showAndWait().ifPresent(input -> {
            String[] parts = input.split(",", 2);
            if (parts.length == 2) {
                String name = parts[0].trim();
                String description = parts[1].trim();
                DatabaseHelper.updateProduct(selectedItem.getId(), name, description);

                products.clear();
                products.addAll(DatabaseHelper.getAllProduct());
            } else {
                showAlert("Ungültiges Format", "Bitte gib Name und Beschreibung getrennt durch ein Komma ein.");
            }
        });
    }

    public void deleteProduct(ActionEvent actionEvent)
    {
        Item si = listView.getSelectionModel().getSelectedItem();
        //products.addAll(DatabaseHelper.getAllProduct());

        if(si == null){
            showAlert("No prodct is chosen"," Please chose one product from listview");
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("delete product");
        confirm.setHeaderText("are you sure, you want delete these product?");
        confirm.setContentText(si.getName());

        confirm.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                DatabaseHelper.deleteProduct(si.getId());

                //listView.refresh();

            }
        });
        listView.getItems().clear();
        listView.getItems().addAll(DatabaseHelper.getAllProduct());
        //listView.getItems().addAll(DatabaseHelper.getAllProduct());

    }
}