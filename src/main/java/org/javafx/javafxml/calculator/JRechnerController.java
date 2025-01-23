package org.javafx.javafxml.calculator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class JRechnerController {

    @FXML private Button btnDivision;
    @FXML private Button btnBackspace;
    @FXML private Label  lblErgebnis;
    @FXML private Label lblResult;
    private double tempX = 0.0;
    private double tempY = 0.0;


    @FXML public void initialize(){
        System.out.println("Die Anwendung wurde gestartet!");
        btnDivision.setText("\u00F7");
        btnBackspace.setText("\u232B");
    }


    public void setSieben(ActionEvent actionEvent) {
        lblErgebnis.setText(lblErgebnis.getText() + "7");
        tempX = 7.0;
    }

    public void setVier(ActionEvent actionEvent) {
        lblErgebnis.setText(lblErgebnis.getText() + "4");
        tempX = 4.0;
    }


    public void setEins(ActionEvent actionEvent) {
        if(lblErgebnis.getText().startsWith("0")){
            lblErgebnis.setText("1");
        }
        else {
            lblErgebnis.setText(lblErgebnis.getText() + "1");
        }
        tempX = 1.0;
    }

    public void setAcht(ActionEvent actionEvent) {
        lblErgebnis.setText(lblErgebnis.getText() + "8");
        tempX = 8.0;
    }

    public void setFunf(ActionEvent actionEvent) {
        lblErgebnis.setText(lblErgebnis.getText() + "5");
        tempX = 5.0;
    }

    public void setNeun(ActionEvent actionEvent) {
        lblErgebnis.setText(lblErgebnis.getText() + "9");
        tempX = 9.0;
    }

    public void setSechs(ActionEvent actionEvent) {
        lblErgebnis.setText(lblErgebnis.getText() + "6");
        tempX = 6.0;
    }

    public void setDrei(ActionEvent actionEvent) {
        lblErgebnis.setText(lblErgebnis.getText() + "3");
        tempX = 3.0;
    }

    public void setZwei(ActionEvent actionEvent) {
        lblErgebnis.setText(lblErgebnis.getText() + "2");
        tempX = 2.0;
    }

    public void setNull(ActionEvent actionEvent) {
        if(lblErgebnis.getText().isEmpty() ){
            lblErgebnis.setText("0");
        } else
            lblErgebnis.setText(lblErgebnis.getText() + "0");
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
        String cText = lblErgebnis.getText();
        if (cText.endsWith("-") || cText.endsWith("+") || cText.endsWith("*") || cText.endsWith("%") || cText.isEmpty()) {
                return;
        }
        if(lblErgebnis.getText().endsWith("/") || lblErgebnis.getText().length() == 0){
            return;
        }else {
            lblErgebnis.setText(lblErgebnis.getText()+ "/");
        }


    }
    public void setMal(ActionEvent actionEvent) {
        String cText = lblErgebnis.getText();

        // Wenn der Text leer ist oder bereits ein Plus am Ende steht, dann nichts tun
        if (cText.length() == 0 || cText.endsWith("*")) {
            return;
        }

        // Wenn das letzte Zeichen eine Rechenoperation ist, auch nichts tun
        if (cText.endsWith("-") || cText.endsWith("+") || cText.endsWith("/") || cText.endsWith("%")) {
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
        if (cText.endsWith("+") || cText.endsWith("*") || cText.endsWith("/") || cText.endsWith("%")) {
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
        if (cText.endsWith("-") || cText.endsWith("*") || cText.endsWith("/") || cText.endsWith("%")) {
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
        String cText = lblErgebnis.getText();
        if (cText.endsWith("-") || cText.endsWith("*") || cText.endsWith("/") || cText.endsWith("+")) {
            return;
        }
        if(lblErgebnis.getText().isEmpty() || lblErgebnis.getText().endsWith("%")){
            return;
        }else{
            lblErgebnis.setText(lblErgebnis.getText() +  "%" );
        }



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
