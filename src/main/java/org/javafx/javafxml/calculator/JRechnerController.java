package org.javafx.javafxml.calculator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class JRechnerController {
    @FXML private Button btnWurzeln;
    @FXML private Button btnDivision;
    @FXML private Button btnBackspace;



    @FXML public void initialize(){
        System.out.println("Die Anwendung wurde gestartet!");
        btnWurzeln.setText("\u221A");
        btnDivision.setText("\u00F7");
        btnBackspace.setText("\u232B");
    }

    public void setKehrtwert(ActionEvent actionEvent) {
    }

    public void setSieben(ActionEvent actionEvent) {
    }

    public void setVier(ActionEvent actionEvent) {
    }

    public void setEins(ActionEvent actionEvent) {
    }

    public void setVorzeichen(ActionEvent actionEvent) {
    }

    public void setExp(ActionEvent actionEvent) {
    }

    public void setAcht(ActionEvent actionEvent) {
    }

    public void setFunf(ActionEvent actionEvent) {
    }

    public void setZwei(ActionEvent actionEvent) {
    }

    public void setNull(ActionEvent actionEvent) {
    }

    public void setWurzeln(ActionEvent actionEvent) {
    }

    public void setNeun(ActionEvent actionEvent) {
    }

    public void setSechs(ActionEvent actionEvent) {
    }

    public void setDrei(ActionEvent actionEvent) {
    }

    public void setKomma(ActionEvent actionEvent) {
    }

    public void setDivision(ActionEvent actionEvent) {
    }

    public void setMal(ActionEvent actionEvent) {
    }

    public void setMinus(ActionEvent actionEvent) {
    }

    public void setPlus(ActionEvent actionEvent) {
    }

    public void getErgebnis(ActionEvent actionEvent) {
    }

    public void setModulo(ActionEvent actionEvent) {
    }

    public void setClearEntry(ActionEvent actionEvent) {
    }

    public void setClearAll(ActionEvent actionEvent) {
    }

    public void setBackspace(ActionEvent actionEvent) {
    }
}
