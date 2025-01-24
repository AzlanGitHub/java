package org.jswing.jcalculator.jswing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp extends JFrame {
	
    private JTextField display;
    private double num1, num2, result;
    private char operator;
    private boolean operatorClicked = false;

    
    public MainApp() {
    	
        setTitle("Taschenrechner");
        setSize(210, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Display-Feld
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 20));
        add(display, BorderLayout.NORTH);

        // Panel für Buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 5, 2, 2));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 15));
          
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
    }

    private class ButtonClickListener implements ActionListener {
    	
        @Override
        public void actionPerformed(ActionEvent e) {
        	
            String command = e.getActionCommand();

            if ("0123456789".contains(command)) {
            	
                display.setText(display.getText() + command);
                operatorClicked = false;
            } 
            
            else if (command.equals("C")) {
                display.setText("");
                num1 = num2 = result = 0;
                operatorClicked = false;
            } 
            
            else if (command.equals("=")) {
            	
                if (!operatorClicked) {
                	
                    num2 = Double.parseDouble(display.getText());
                    
                    switch (operator) {
                    
                        case '+': result = num1 + num2; break;
                        case '-': result = num1 - num2; break;
                        case '*': result = num1 * num2; break;
                        case '/':
                            if (num2 == 0) {
                            	
                                JOptionPane.showMessageDialog(null, "Fehler: Division durch Null!");
                                return;
                            }
                            result = num1 / num2;
                            break;
                    }
                    
                    display.setText(String.valueOf(result));
                    
                    operatorClicked = false;
                }
            } 
            else {
            	
                if (!operatorClicked && !display.getText().isEmpty()) {
                	
                    num1 = Double.parseDouble(display.getText());
                    operator = command.charAt(0);
                    display.setText("");
                    operatorClicked = true;
                }
            }
        }
    }
    

    public static void main(String[] args) {
    	
        SwingUtilities.invokeLater(() -> new MainApp().setVisible(true));
    }
}
