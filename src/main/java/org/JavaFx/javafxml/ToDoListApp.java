package org.JavaFx.javafxml;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ToDoListApp extends JFrame {

    private DefaultListModel<String> listModel;
    private JList<String> taskList;
    private JTextField tftaskInput;
    private final String fileName = "tasks.txt";


    public ToDoListApp(){
        setTitle("To-Do Liste");
        setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Layout-Manager
        setLayout(new BorderLayout());
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        add(new JScrollPane(taskList), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        tftaskInput = new JTextField();
        JButton btnAdd = new JButton("Hinzufügen");
        JButton btnRemove = new JButton("Löschen");

        panel.add(tftaskInput, BorderLayout.CENTER);
        panel.add(btnAdd, BorderLayout.EAST);
        add(panel, BorderLayout.NORTH);
        add(btnRemove, BorderLayout.SOUTH);

        btnAdd.addActionListener(e -> addTask());
        btnRemove.addActionListener(e -> removeTask());
        loadTask();
        setVisible(true);

    }

    private void loadTask() {

        File file = new File(fileName);
        if(file.exists()){
            try(BufferedReader reader = new BufferedReader(new FileReader(file))){
                String line;
                while((line = reader.readLine()) != null){
                    listModel.addElement(line);
                }
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Fehler beim Laden der Aufgaben!");
            }
        }

    }

    private void saveTasks() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            for(int i= 0; i< listModel.size(); i++){
                writer.write(listModel.getElementAt(i));
            }
            writer.newLine();
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(this, "Fehler beim Speichern!", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if(selectedIndex != -1){
            listModel.remove(selectedIndex);
            saveTasks();
        }
    }

    private void addTask() {
        String task = tftaskInput.getText().trim();
        if(!task.isEmpty()){
            listModel.addElement(task);
            tftaskInput.setText("");
            saveTasks();
        }
    }


    public static void main(String[] args) {
       // System.out.println("Hello, World!");
        //new ToDoListApp();
        SwingUtilities.invokeLater(ToDoListApp::new);
    }
}