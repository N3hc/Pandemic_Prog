package Swing;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class Marco_Menu extends JFrame{
	
	Panel_Menu_Principal MenuLayout;
	
	Marco_Menu(){

	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(400, 300); // Tamaño del JFrame
	        
	        // Obtener tamaño de la pantalla
	        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	        int screenWidth = screenSize.width;
	        int screenHeight = screenSize.height;
	        
	        // Calcular coordenadas para centrar el JFrame
	        int frameWidth = getWidth();
	        int frameHeight = getHeight();
	        int x = (screenWidth - frameWidth) / 2;
	        int y = (screenHeight - frameHeight) / 2;
	        
	        setTitle("Menu De Opciones");
	        
	        // Establecer coordenadas
	        setLocation(x, y);
	        
	        //AñadirLayout
	        MenuLayout = new Panel_Menu_Principal();
	        add(MenuLayout);
	        //Hacer visible el JFrame
	        setVisible(true);
	}
}
