package org.jswing.jnote.notebook;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.naming.StringRefAddr;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Notepad extends JFrame{
	
	private JTextArea textArea;
	private JFileChooser fileChooser;
	
	
	
	public Notepad() 
	{
		
		setTitle("Notepad");
		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		textArea = new JTextArea();
		
		add(new JScrollPane(textArea), BorderLayout.CENTER);
		
		//Menüleiste
		
		JMenuBar	menuBar  = new JMenuBar();
		JMenu 		fileMenu = new JMenu("Datei");
		JMenuItem	newItem	 = new JMenuItem("Neu");
		JMenuItem	openItem = new JMenuItem("öffnen");
		JMenuItem	saveItem = new JMenuItem("Speichern");
		JMenuItem	exitItem = new JMenuItem("Beenden");
		
//		
//		newItem.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				textArea.setText("");
//				
//			}
//		});
		
		newItem.addActionListener(e -> textArea.setText(""));
		exitItem.addActionListener(e-> System.exit(0));
		
		openItem.addActionListener(e->{
			
			int result = fileChooser.showOpenDialog(openItem);
			
			if(result == JFileChooser.APPROVE_OPTION) {
				
				File file = fileChooser.getSelectedFile();
				
				try(BufferedReader reader = new BufferedReader(new FileReader(file))){
					
					textArea.read(reader, null);
				} 
				
				catch (FileNotFoundException ex) {
					
					JOptionPane.showMessageDialog(null, "Fehler: Datei nicht gefunden !", "Fehler", JOptionPane.ERROR_MESSAGE);
					
					ex.printStackTrace();
				} 
				
				catch (IOException ex) {
			
					ex.printStackTrace();
				}
				
			}
			
		});
		
		
		saveItem.addActionListener(e ->{
			
			int result = fileChooser.showSaveDialog(saveItem);
			
	        if (result == JFileChooser.APPROVE_OPTION) {
	        	
	            File file = fileChooser.getSelectedFile();
	            
	            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) 
	            {
	                textArea.write(writer);
	            }
	            catch (IOException ex) 
	            {
	                JOptionPane.showMessageDialog(null, "Fehler beim Speichern der Datei!", "Fehler", JOptionPane.ERROR_MESSAGE);
	            }
	        }
		});
		
		
	
//		openItem.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				int result = fileChooser.showOpenDialog(openItem);
//				
//				if(result == JFileChooser.APPROVE_OPTION) {
//					
//					File file = fileChooser.getSelectedFile();
//					
//					try(BufferedReader reader = new BufferedReader(new FileReader(file))){
//						
//						textArea.read(reader, null);
//					} 
//					
//					catch (FileNotFoundException ex) {
//						
//						JOptionPane.showMessageDialog(null, "Fehler: Datei nicht gefunden !", "Fehler", JOptionPane.ERROR_MESSAGE);
//						
//						ex.printStackTrace();
//					} 
//					
//					catch (IOException ex) {
//				
//						ex.printStackTrace();
//					}
//					
//				}
//				
//			}
//		});
//		
//		saveItem.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				int result = fileChooser.showSaveDialog(saveItem);
//				
//		        if (result == JFileChooser.APPROVE_OPTION) {
//		        	
//		            File file = fileChooser.getSelectedFile();
//		            
//		            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) 
//		            {
//		                textArea.write(writer);
//		            }
//		            catch (IOException ex) 
//		            {
//		                JOptionPane.showMessageDialog(null, "Fehler beim Speichern der Datei!", "Fehler", JOptionPane.ERROR_MESSAGE);
//		            }
//		        }
//				
//			}
//		});
//		exitItem.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.exit(0);
//				
//			}
//		});
		
		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
		
		fileChooser = new JFileChooser();
	}
	
	


public static void main(String[] args) 
  {
	  new Notepad();
		
		  try
		  { 
			  SwingUtilities.invokeAndWait(() -> new Notepad().setVisible(true)); 
		  }
		  
		  catch (InvocationTargetException e) 
		  {
			  e.printStackTrace(); 
		  } 
		  catch (InterruptedException e) 
		  {
		  
			  e.printStackTrace(); 
		  }
		 
	  //System.out.println("Hello World!");
    
  }

  
  
}
