package Swing;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class Marco_Menu extends JFrame{
	
//	Panel_Menu_Principal MenuLayout;
	Panel_Login MenuLayout;
	
	Marco_Menu(){
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        // Obtener tamaño de la pantalla
	        setSize(525, 325); // Tamaño del JFrame
	        setTitle("Menu De Opciones");
	        setLocationRelativeTo(null);
	        
	        //AñadirLayout
	        MenuLayout = new Panel_Login();
//	        MenuLayout = new Panel_Menu_Principal();
	        add(MenuLayout);
	        //Hacer visible el JFrame
	        setVisible(true);
	}
}
