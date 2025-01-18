package org.javafx.javafxml.jhotelres;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import java.sql.*;

public class KundenController {

    @FXML private VBox vbCenter;
    @FXML private TextField tfVorname;
    @FXML private TextField tfNachname;
    @FXML private TextField tfGeburtsdatum;
    @FXML private TextField tfAlter;
    @FXML private TextField tfStrasse;
    @FXML private TextField tfNr;
    @FXML private TextField tfPostleitzahl;
    @FXML private TextField tfStadt;
    @FXML private TextField tfLand;
    @FXML private TableView<Kunde> tvKunde;
    @FXML private  TableColumn<Kunde, Integer> tcID;
    @FXML private TableColumn<Kunde, String> tcVorname;
    @FXML private TableColumn<Kunde, String> tcNachname;
    @FXML private TableColumn<Kunde, String> tcGeburtsdatum;
    @FXML private TableColumn<Kunde, Integer> tcAlter;
    @FXML private TableColumn<Kunde, String> tcStrasse;
    @FXML private TableColumn<Kunde, Integer> tcNr;
    @FXML private TableColumn<Kunde, String> tcPostleitzahl;
    @FXML private TableColumn<Kunde, String> tcStadt;
    @FXML private  TableColumn<Kunde, String> tcLand;

    @FXML
    public void initialize() {
        // Spalten mit den Attributen der User-Klasse verknüpfen
        tcID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcVorname.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        tcNachname.setCellValueFactory(new PropertyValueFactory<>("nachname"));
        tcGeburtsdatum.setCellValueFactory(new PropertyValueFactory<>("geburtsdatum"));
        tcAlter.setCellValueFactory(new PropertyValueFactory<>("age"));
        tcStrasse.setCellValueFactory(new PropertyValueFactory<>("strasse"));
        tcNr.setCellValueFactory(new PropertyValueFactory<>("nr"));
        tcPostleitzahl.setCellValueFactory(new PropertyValueFactory<>("postleitzahl"));
        tcStadt.setCellValueFactory(new PropertyValueFactory<>("stadt"));
        tcLand.setCellValueFactory(new PropertyValueFactory<>("land"));
        // Daten aus der Datenbank laden
        tvKunde.setItems(readData());
        // Bind TableView size to VBox size
        tvKunde.prefWidthProperty().bind(vbCenter.widthProperty());
        tvKunde.prefHeightProperty().bind(vbCenter.heightProperty());
        // Bind column widths to TableView width
        tcID.prefWidthProperty().bind(tvKunde.widthProperty().multiply(0.05));
        tcVorname.prefWidthProperty().bind(tvKunde.widthProperty().multiply(0.15));
        tcNachname.prefWidthProperty().bind(tvKunde.widthProperty().multiply(0.15));
        tcGeburtsdatum.prefWidthProperty().bind(tvKunde.widthProperty().multiply(0.10));
        tcAlter.prefWidthProperty().bind(tvKunde.widthProperty().multiply(0.05));
        tcStrasse.prefWidthProperty().bind(tvKunde.widthProperty().multiply(0.15));
        tcNr.prefWidthProperty().bind(tvKunde.widthProperty().multiply(0.05));
        tcPostleitzahl.prefWidthProperty().bind(tvKunde.widthProperty().multiply(0.10));
        tcStadt.prefWidthProperty().bind(tvKunde.widthProperty().multiply(0.10));
        tcLand.prefWidthProperty().bind(tvKunde.widthProperty().multiply(0.10));
    }


    public ObservableList<Kunde> readData()
    {
        ObservableList<Kunde> kunde =  FXCollections.observableArrayList();
        // Schritt 1 : url von der Datenbank notieren
        String url = "jdbc:sqlite:src/main/resources/kundschaft.db";
        // Schritt 2 : sql-query notieren
        String sql = "SELECT * FROM kunde";

        // Schritt 3: Connection Instanz bilden mit try catch
        try{
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next())
            {
                kunde.add(new Kunde(
                        rs.getInt("ID"),
                        rs.getString("Vorname"),
                        rs.getString("Nachname"),
                        rs.getString("Geburtsdatum"),
                        rs.getInt("age"),
                        rs.getString("Strasse"),
                        rs.getInt("Nr"),
                        rs.getString("PLZ"),
                        rs.getString("Stadt"),
                        rs.getString("Land")
                ));
            }

        }catch (SQLException e){ System.out.println(e.getMessage()); }

        return kunde;

    }

    public void createKunde(ActionEvent actionEvent) {
        // Get the input values
        String vorname = tfVorname.getText();
        String nachname = tfNachname.getText();
        String geburtsdatum = tfGeburtsdatum.getText();
        int alter = Integer.parseInt(tfAlter.getText());
        String strasse = tfStrasse.getText();
        int nr = Integer.parseInt(tfNr.getText());
        String postleitzahl = tfPostleitzahl.getText();
        String stadt = tfStadt.getText();
        String land = tfLand.getText();

        // Create a new Kunde object
        Kunde newKunde = new Kunde(0, vorname, nachname, geburtsdatum, alter, strasse, nr, postleitzahl, stadt, land);
        // Insert the new Kunde object into the database
        String url = "jdbc:sqlite:src/main/resources/kundschaft.db";
        String sql = "INSERT INTO kunde (Vorname, Nachname, Geburtsdatum, age, Strasse, Nr, PLZ, Stadt, Land) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newKunde.getVorname());
            pstmt.setString(2, newKunde.getNachname());
            pstmt.setString(3, newKunde.getGeburtsdatum());
            pstmt.setInt(4, newKunde.getAge());
            pstmt.setString(5, newKunde.getStrasse());
            pstmt.setInt(6, newKunde.getNr());
            pstmt.setString(7, newKunde.getPostleitzahl());
            pstmt.setString(8, newKunde.getStadt());
            pstmt.setString(9, newKunde.getLand());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        // Optionally, refresh the TableView
        tvKunde.setItems(readData());
        // Clear the input fields
        tfVorname.clear();
        tfNachname.clear();
        tfGeburtsdatum.clear();
        tfAlter.clear();
        tfStrasse.clear();
        tfNr.clear();
        tfPostleitzahl.clear();
        tfStadt.clear();
        tfLand.clear();
    }


    public void deleteData(int id) {
        String url = "jdbc:sqlite:src/main/resources/kundschaft.db";
        String sql = "DELETE FROM kunde WHERE ID = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteData(String vorname, String nachname, String geburtsdatum) {
        String url = "jdbc:sqlite:src/main/resources/kundschaft.db";
        String sql = "DELETE FROM kunde WHERE Vorname = ? AND Nachname = ? AND Geburtsdatum = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, vorname);
            pstmt.setString(2, nachname);
            pstmt.setString(3, geburtsdatum);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteKunde(ActionEvent actionEvent)
    {
        Kunde selectedKunde = tvKunde.getSelectionModel().getSelectedItem();

        if (selectedKunde != null) {
            // Delete the selected customer from the database
            deleteData(selectedKunde.getId());
        } else {
            // Get the input values
            String vorname = tfVorname.getText();
            String nachname = tfNachname.getText();
            String geburtsdatum = tfGeburtsdatum.getText();

            if (!vorname.isEmpty() && !nachname.isEmpty() && !geburtsdatum.isEmpty()) {
                // Delete the customer based on the input values
                deleteData(vorname, nachname, geburtsdatum);
            } else {
                // Show an error message if no customer is selected and input values are incomplete
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please select a customer or enter the first name, last name, and birthdate.");
                alert.showAndWait();
            }
        }
        // Refresh the TableView
        tvKunde.setItems(readData());
        // Clear the input fields
        tfVorname.clear();
        tfNachname.clear();
        tfGeburtsdatum.clear();
        tfAlter.clear();
        tfStrasse.clear();
        tfNr.clear();
        tfPostleitzahl.clear();
        tfStadt.clear();
        tfLand.clear();
    }
}