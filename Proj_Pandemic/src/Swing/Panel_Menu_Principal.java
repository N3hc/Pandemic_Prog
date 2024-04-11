package Swing;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Panel_Menu_Principal extends JPanel implements ActionListener {
	
	Button Boton[];
	
	public Panel_Menu_Principal(){
		Boton = new Button[7];
		String [] nombres = {"Nueva Partida","Cargar Partida","Información","Resumen de puntuaciones","Autores","Versión","Salir"};
		for (int i = 0; i < 7; i++) {
			Boton[i] = new Button(nombres[i]);
			add(Boton[i]);
		}
	
	setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));  
	setSize(20,20); 
	setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
