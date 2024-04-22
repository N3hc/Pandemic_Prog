package Swing;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Func_Partida.control_de_partida;

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
		if (e.getSource() == Boton[0]) {
			mostrarPopupDificultad();
			JFrame partidaInit = (JFrame) SwingUtilities.getWindowAncestor(this);
			partidaInit.getContentPane().removeAll();
			partidaInit.getContentPane().add(new Panel_Partida());
			partidaInit.revalidate();
			partidaInit.setExtendedState(JFrame.MAXIMIZED_BOTH);
			
		}
		if (e.getSource() == Boton[1]) {
			mostrarPopupCargarPartida();
			JFrame partida = (JFrame) SwingUtilities.getWindowAncestor(this);
			partida.getContentPane().removeAll();
			partida.getContentPane().add(new Panel_Partida());
			partida.revalidate();
			partida.setExtendedState(JFrame.MAXIMIZED_BOTH);

		}
		if (e.getSource() == Boton[2]) {
			JOptionPane.showMessageDialog(this, "Jugador:\r\n" + "\r\n" + "Un jugador tiene 4 acciones.\r\n"
					+ "El Jugador en su turno puede usar sus acciones de dos maneras.\r\n"
					+ "	- Matar: Consume una acción, limpia una unidad de monstruos de la ciudad elegida.\r\n"
					+ "	- Craftear arma: Consume 4 acciones para aumentar el porcentage de obtención del arma legendaria para cada tipo de plaga.\r\n"
					+ "	  Una vez creada una de las armas el tipo de enemigo ligado a ella al usarla contra el tipo de enemigo eliminará todos los tokens de la ciudad\r\n"
					+ "		* Dandelion (Ents)\r\n" + "		* Kzarka (Goblos)\r\n" + "		* Kutum (Momias)\r\n"
					+ "		* Corazón de Vell (Tritones)\r\n" + "\r\n" + "Partida:\r\n" + "\r\n"
					+ "Cada turno que pasas el tablero jugará contra ti y diferentes ciudades del mapa se verán afectados por las plagas que azotan al mundo\r\n"
					+ "	-El número de ciudades infectadas por turno dependerá de tu criterio al iniciar el juego en el apartado parametros.\r\n"
					+ "\r\n"
					+ " -Los turnos se pasan automaticamente cuando hayas usado las 4 acciones. \r\n"
					+ "Cada vez que una ciudad supera los tres brotes esta no sube más sus contadores sinó que exparce un contador a cada una de las ciudades lindantes\r\n"
					+ "	-Efectivamente un brote puede implicar una cadena de infecciones en masa\r\n" + "\r\n"
					+ "Las ciudades pueden tener en ellas diferentes héroes que te pueden ayudar en la partida:\r\n"
					+ "	-Guerreros, estos conquistaran una ciudad y  matara plagas en cada una de las ciudades lindantes de la ciudad principal.\r\n"
					+ "	-Tanques, estos se asignan a una ciudad y evitan que un brote en la ciudad en la que esta o en las que la lindan surta efecto\r\n"
					+ "	-Soportes, estos son héroes que una vez conseguidos te ayudarán en la obtención de las armas, dándote un porcentage plano en cada farméo\r\n"
					+ "		* Los Héroes entran en recarga durante unos turnos luego de ser usados (Parámetro variable)\r\n"
					+ "\r\n"
					+ "La partida se gana cuando consigues fabricar las 4 armas para conquistar todas las ciudades o se pierde una vez que el número de infecciones \r\n"
					+ "ha llegado al límite dispuesto en parametros, cuando llega acaba la partida y es pierdes.\r\n"
					+ "\r\n" + "Héroes:\r\n"
					+ "Tienen un turno a parte, se mueven gratuitamente a una ciudad lindante de la ciudad actual en la cual esta situada una ver por turno.\r\n"
					+ "Activar su habilidad es una acción\r\n");
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

	public String mostrarPopupDificultad() {
		String[] opcionesDificultad = { "Facil", "Normal", "Dificil" };
		String dificultadSeleccionada = (String) JOptionPane.showInputDialog(this, "Seleccione la dificultad:",
				"Selección de Dificultad", JOptionPane.QUESTION_MESSAGE, null, opcionesDificultad,
				opcionesDificultad[0]);
		if (dificultadSeleccionada != null) {
			System.out.println("Dificultad seleccionada: " + dificultadSeleccionada);
		} else {
			JFrame menu_principal = (JFrame) SwingUtilities.getWindowAncestor(this);
			menu_principal.remove(this);
			menu_principal.add(new Panel_Menu_Principal());
			menu_principal.setVisible(true);
		}
		return dificultadSeleccionada;
	}

	public void mostrarPopupCargarPartida() {
		String[] opcionesCarga = { "Facil", "Normal", "Dificil" };
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
