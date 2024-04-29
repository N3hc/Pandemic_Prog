package Swing;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Func_Partida.DatosPartida;
import Func_Partida.control_de_partida;

public class Panel_Menu_Principal extends JPanel implements ActionListener {

	Button Boton[];

	public Panel_Menu_Principal() {

		reproducirMusica();
		setLayout(null);
		setBounds(0, 0, 1550, 775);
		InitCartel();
		addButtons();
		InitFondo();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == Boton[0]) {
			JFrame partidaInit = (JFrame) SwingUtilities.getWindowAncestor(this);
			partidaInit.getContentPane().removeAll();
			partidaInit.getContentPane().add(new Panel_Partida());
			partidaInit.revalidate();
			partidaInit.setExtendedState(JFrame.MAXIMIZED_BOTH);

		}
		if (e.getSource() == Boton[1]) {
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
					+ "\r\n" + " -Los turnos se pasan automaticamente cuando hayas usado las 4 acciones. \r\n"
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

	public void addButtons() {

		Boton = new Button[7];
		String[] nombres = { "Nueva Partida", "Cargar Partida", "Información", "Resumen de puntuaciones", "Autores",
				"Versión", "Salir" };
		for (int i = 0; i < 7; i++) {
			Boton[i] = new Button(nombres[i]);
			add(Boton[i]);
		}

		Boton[0].setBounds(685, 295, 170, 50);
		add(Boton[0]);
		Boton[0].addActionListener(this);

		Boton[1].setBounds(685, 355, 170, 50);
		add(Boton[1]);
		Boton[1].addActionListener(this);

		Boton[2].setBounds(685, 415, 170, 50);
		add(Boton[2]);
		Boton[2].addActionListener(this);

		Boton[3].setBounds(685, 475, 170, 50);
		add(Boton[3]);
		Boton[3].addActionListener(this);

		Boton[4].setBounds(685, 535, 170, 50);
		add(Boton[4]);
		Boton[4].addActionListener(this);

		Boton[5].setBounds(685, 595, 170, 50);
		add(Boton[5]);
		Boton[5].addActionListener(this);

		Boton[6].setBounds(685, 655, 170, 50);
		add(Boton[6]);
		Boton[6].addActionListener(this);
	}

	private void InitCartel() {
		setOpaque(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		ImageIcon imagen1 = new ImageIcon(
				"C:\\Users\\chenp\\Documents\\GitHub\\Pandemic_Prog\\Mapa_Pandemic\\logo.png");

		Image imgEscalada1 = imagen1.getImage().getScaledInstance(590, 180,
				Image.SCALE_SMOOTH);
		ImageIcon imagenEscalada1 = new ImageIcon(imgEscalada1);

		JLabel fondoLabel1 = new JLabel(imagenEscalada1);
		fondoLabel1.setBounds(473, 84, 590, 180);
		add(fondoLabel1);
	}

	private void InitFondo() {
		setOpaque(true);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		ImageIcon imagen = new ImageIcon(
				"C:\\Users\\chenp\\Documents\\GitHub\\Pandemic_Prog\\Mapa_Pandemic\\Loding.png");

		Image imgEscalada = imagen.getImage().getScaledInstance(screenSize.width, screenSize.height,
				Image.SCALE_SMOOTH);
		ImageIcon imagenEscalada = new ImageIcon(imgEscalada);

		JLabel fondoLabel = new JLabel(imagenEscalada);
		fondoLabel.setBounds(0, 10, screenSize.width, screenSize.height); // Posicionamos el fondoLabel para cubrir todo
		setOpaque(true); // el panel.
		add(fondoLabel);

		setVisible(true);
	}

	private void reproducirMusica() {
		String filePath = "C:\\Users\\chenp\\Documents\\GitHub\\Pandemic_Prog\\Mapa_Pandemic\\SoundTrack.wav";
		try {
			File file = new File(filePath);
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}
}
