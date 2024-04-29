package Swing;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class Marco_Menu extends JFrame{
	
//	Panel_Version MenuLayout;
	Panel_Menu_Principal MenuLayout;
	
	Marco_Menu(){
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        // Obtener tamaño de la pantalla
	        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	        int screenWidth = screenSize.width;
	        int screenHeight = screenSize.height;
	        setSize(screenWidth, screenHeight); // Tamaño del JFrame
	        setTitle("Menu De Opciones");
	        
	        //AñadirLayout
//	        MenuLayout = new Panel_Version();
	        MenuLayout = new Panel_Menu_Principal();
	        add(MenuLayout);
	        //Hacer visible el JFrame
	        setVisible(true);
	}
}
