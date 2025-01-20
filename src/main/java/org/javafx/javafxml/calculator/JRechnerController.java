package org.javafx.javafxml.calculator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class JRechnerController {
    @FXML private Button btnWurzeln;
    @FXML private Button btnDivision;
    @FXML private Button btnBackspace;
    @FXML private Label  lblErgebnis;
    @FXML private Label lblResult;
    private double tempX = 0.0;
    private double tempY = 0.0;


    @FXML public void initialize(){
        System.out.println("Die Anwendung wurde gestartet!");
        btnWurzeln.setText("\u221A");
        btnDivision.setText("\u00F7");
        btnBackspace.setText("\u232B");
    }

    public void setKehrtwert(ActionEvent actionEvent) {
    }

    public void setSieben(ActionEvent actionEvent) {
        lblErgebnis.setText(lblErgebnis.getText() + "7");
    }

    public void setVier(ActionEvent actionEvent) {
        lblErgebnis.setText(lblErgebnis.getText() + "4");
    }


    public void setEins(ActionEvent actionEvent) {
        if(lblErgebnis.getText().startsWith("0")){
            lblErgebnis.setText("1");
        }
        else {
            lblErgebnis.setText(lblErgebnis.getText() + "1");
        }
    }

    public void setAcht(ActionEvent actionEvent) {
        lblErgebnis.setText(lblErgebnis.getText() + "8");
    }

    public void setFunf(ActionEvent actionEvent) {
        lblErgebnis.setText(lblErgebnis.getText() + "5");
    }

    public void setNeun(ActionEvent actionEvent) {
        lblErgebnis.setText(lblErgebnis.getText() + "9");
    }

    public void setSechs(ActionEvent actionEvent) {
        lblErgebnis.setText(lblErgebnis.getText() + "6");
    }

    public void setDrei(ActionEvent actionEvent) {
        lblErgebnis.setText(lblErgebnis.getText() + "3");
    }

    public void setZwei(ActionEvent actionEvent) {
        lblErgebnis.setText(lblErgebnis.getText() + "2");
    }

    public void setNull(ActionEvent actionEvent) {
        if(lblErgebnis.getText().isEmpty() ){
            lblErgebnis.setText("0");
        } else
            lblErgebnis.setText(lblErgebnis.getText() + "0");
    }

    public void setVorzeichen(ActionEvent actionEvent) {
    }

    public void setExp(ActionEvent actionEvent) {
    }

    public void setWurzeln(ActionEvent actionEvent) {
    }


    public void setKomma(ActionEvent actionEvent) {
        String text = lblErgebnis.getText();

        // Falls das Label leer ist oder das letzte Zeichen ein Operator oder Komma ist, kein Komma setzen
        if (text.isEmpty() || text.endsWith(".") || text.matches(".*[+\\-*/]$")) {
            return;
        }

        // Letzte Zahl im Ausdruck extrahieren (nach dem letzten Operator)
        String[] parts = text.split("[+\\-*/]"); // Trennt an Rechenzeichen
        String lastNumber = parts[parts.length - 1];

        // Falls die letzte Zahl bereits ein Komma enthält, kein weiteres hinzufügen
        if (!lastNumber.contains(".")) {
            lblErgebnis.setText(text + ".");
        }
    }


    public void setDivision(ActionEvent actionEvent) {
    }

    public void setMal(ActionEvent actionEvent) {
        String cText = lblErgebnis.getText();

        // Wenn der Text leer ist oder bereits ein Plus am Ende steht, dann nichts tun
        if (cText.length() == 0 || cText.endsWith("*")) {
            return;
        }

        // Wenn das letzte Zeichen eine Rechenoperation ist, auch nichts tun
        if (cText.endsWith("-") || cText.endsWith("+") || cText.endsWith("/")) {
            return;
        }

        lblErgebnis.setText(cText + "*");
    }

    public void setMinus(ActionEvent actionEvent) {
        String cText = lblErgebnis.getText();

        // Wenn der Text leer ist oder bereits ein Plus am Ende steht, dann nichts tun
        if (cText.length() == 0 || cText.endsWith("-")) {
            return;
        }

        // Wenn das letzte Zeichen eine Rechenoperation ist, auch nichts tun
        if (cText.endsWith("+") || cText.endsWith("*") || cText.endsWith("/")) {
            return;
        }

        lblErgebnis.setText(cText + "-");
    }

    public void setPlus(ActionEvent actionEvent) {
        if(lblErgebnis.getText().endsWith(".")){
            lblErgebnis.setText(lblErgebnis.getText().substring(0, lblErgebnis.getText().length() - 1));
        }
        String cText = lblErgebnis.getText();

        // Wenn der Text leer ist oder bereits ein Plus am Ende steht, dann nichts tun
        if (cText.length() == 0 || cText.endsWith("+")) {
            return;
        }

        // Wenn das letzte Zeichen eine Rechenoperation ist, auch nichts tun
        if (cText.endsWith("-") || cText.endsWith("*") || cText.endsWith("/")) {
            return;
        }

        lblErgebnis.setText(cText + "+");
    }

    public void getErgebnis(ActionEvent actionEvent) {
        try {
            char lastChar = lblErgebnis.getText().charAt(lblErgebnis.getText().length() - 1);

            if (lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/')
            {
                lblErgebnis.setText(lblErgebnis.getText().substring(0, lblErgebnis.getText().length() - 1));
            }
            else {
                
                System.out.println("Das letzte Zeichen ist kein mathematischer Operator.");
            }

            // Ausdruck mit exp4j auswerten
            Expression exp = new ExpressionBuilder( lblErgebnis.getText()).build();
            double result = exp.evaluate();

            // Ergebnis in deutschem Format mit , anzeigen
            lblResult.setText(String.valueOf(result));
            lblErgebnis.setText(String.valueOf(result));
        } catch (Exception e) {
            lblResult.setText("Fehler");
        }
    }


    public void setModulo(ActionEvent actionEvent) {
    }

    public void setClearEntry(ActionEvent actionEvent) {
        // Wenn lblErgebnis kein Rechenzeichen enthält
        String currentText = lblErgebnis.getText();
        Boolean hatPlus = currentText.contains("+");
        Boolean hatMinus = currentText.contains("-");
        Boolean hatMal = currentText.contains("x");
        Boolean hatDiv = currentText.contains("\u00F7");

        if (!(hatPlus || hatMinus || hatMal || hatDiv)) {
            // Löschen des gesamten Textes, wenn keine Rechenoperation vorhanden ist
            lblErgebnis.setText("");
        } else {
            // Entferne die letzte Zahl
            int lastIndex = currentText.length() - 1;

            // Rückwärts durch den Text gehen und die letzte Zahl finden
            while (lastIndex >= 0 && Character.isDigit(currentText.charAt(lastIndex))) {
                lastIndex--;
            }

            // Setze den Text bis zur Stelle, an der die Zahl endet
            lblErgebnis.setText(currentText.substring(0, lastIndex + 1));
        }
    }


    public void setClearAll(ActionEvent actionEvent) {
        lblErgebnis.setText("");
    }

    public void setBackspace(ActionEvent actionEvent) {

        if(lblErgebnis.getText().length() > 0){
            lblErgebnis.setText(lblErgebnis.getText().substring(0, lblErgebnis.getText().length()-1));

        }

        
    }
}
