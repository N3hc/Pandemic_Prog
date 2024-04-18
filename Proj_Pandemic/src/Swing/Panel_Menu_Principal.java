package Swing;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Panel_Menu_Principal extends JPanel implements ActionListener {

	Button Boton[];

	public Panel_Menu_Principal() {
		Boton = new Button[7];
		String[] nombres = { "Nueva Partida", "Cargar Partida", "Información", "Resumen de puntuaciones", "Autores",
				"Versión", "Salir" };
		for (int i = 0; i < 7; i++) {
			Boton[i] = new Button(nombres[i]);
			add(Boton[i]);
		}

		Boton[0].addActionListener(this);
		Boton[1].addActionListener(this);
		Boton[2].addActionListener(this);
		Boton[3].addActionListener(this);
		Boton[4].addActionListener(this);
		Boton[5].addActionListener(this);
		Boton[6].addActionListener(this);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setSize(20, 20);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == Boton[0]) { // Opción de "Nueva Partida"
			mostrarPopupDificultad();
		    JFrame partida = (JFrame) SwingUtilities.getWindowAncestor(this);
		    partida.getContentPane().removeAll(); // Eliminamos todos los componentes existentes del contenido del marco
		    partida.getContentPane().add(new Panel_Partida()); // Agregamos el panel de pantalla completa
		    partida.revalidate(); // Volvemos a validar el contenido del marco
		    partida.setExtendedState(JFrame.MAXIMIZED_BOTH); // Ponemos el marco en pantalla completa
		    partida.setUndecorated(true); // Ocultamos la barra de título y los bordes del marco
		}
		if (e.getSource() == Boton[1]) {
			mostrarPopupCargarPartida();
		    JFrame partida = (JFrame) SwingUtilities.getWindowAncestor(this);
		    partida.getContentPane().removeAll(); // Eliminamos todos los componentes existentes del contenido del marco
		    partida.getContentPane().add(new Panel_Partida()); // Agregamos el panel de pantalla completa
		    partida.revalidate(); // Volvemos a validar el contenido del marco
		    partida.setExtendedState(JFrame.MAXIMIZED_BOTH); // Ponemos el marco en pantalla completa
		    partida.setUndecorated(true); // Ocultamos la barra de título y los bordes del marco
			
		}
		if (e.getSource() == Boton[2]) {

		}
		if (e.getSource() == Boton[3]) {

		}
		if (e.getSource() == Boton[4]) {
			JOptionPane.showMessageDialog(this,
					"Autores:\n\nArduí Pulido Bosch arduipulido@gmail.com\nChenping Guo Chen chenpinguo3@gmail.com ",
					"Autores", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == Boton[5]) {
			JOptionPane.showMessageDialog(this, "Version 1.0 ", "Version", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == Boton[6]) {
			System.exit(0);
		}
	}
    public void mostrarPopupDificultad() {
        String[] opcionesDificultad = {"Fácil", "Normal", "Difícil"};
        String dificultadSeleccionada = (String) JOptionPane.showInputDialog(this, "Seleccione la dificultad:", 
                                            "Selección de Dificultad", JOptionPane.QUESTION_MESSAGE, null, opcionesDificultad, opcionesDificultad[0]);
        if (dificultadSeleccionada != null) {
            System.out.println("Dificultad seleccionada: " + dificultadSeleccionada);
        } else {
            JFrame menu_principal = (JFrame) SwingUtilities.getWindowAncestor(this);
            menu_principal.remove(this);
            menu_principal.add(new Panel_Menu_Principal());
            menu_principal.setVisible(true);
        }
    }
    public void mostrarPopupCargarPartida() {
        String[] opcionesCarga = {"Fácil", "Normal", "Difícil"};
        String dificultadSeleccionada = (String) JOptionPane.showInputDialog(this, "Seleccione la dificultad:", 
                                            "Selección de Dificultad", JOptionPane.QUESTION_MESSAGE, null, opcionesCarga, opcionesCarga[0]);
        if (dificultadSeleccionada != null) {
            System.out.println("Dificultad seleccionada: " + dificultadSeleccionada);
        } else {
            JFrame menu_principal = (JFrame) SwingUtilities.getWindowAncestor(this);
            menu_principal.remove(this);
            menu_principal.add(new Panel_Menu_Principal());
            menu_principal.setVisible(true);
        }
    }

}
