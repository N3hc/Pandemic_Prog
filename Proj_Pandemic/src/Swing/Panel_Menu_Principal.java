package Swing;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import Func_Partida.DatosPartida;
import Func_Partida.bbdd;
import Func_Partida.control_de_partida;

public class Panel_Menu_Principal extends JPanel implements ActionListener {

	Button Boton[];
	private static String diff;
	DefaultTableModel rankingModel; // Modelo de la tabla para el ranking
	JTable rankingTable; // Tabla para mostrar el ranking
	DatosPartida partida = new DatosPartida();
	/**
	 * Constructor para llamar las funciones pertinenetes del panel
	 */
	public Panel_Menu_Principal() {
		reproducirMusica();
		setLayout(null);
		setBounds(0, 0, 1550, 775);
		setOpaque(false); // Establecer el fondo transparente
		InitCartel();
		addButtons();
		InitFondo();
	}

	@Override
	/**
	 * Action listener con las acciones correspondientes al momento de apretar el boton
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Boton[0]) {
			showDifficultyButtons();
		} else if (e.getSource() == Boton[1]) {
			JFrame partida = (JFrame) SwingUtilities.getWindowAncestor(this);
			partida.getContentPane().removeAll();
			partida.getContentPane().add(new Panel_Partida_Cargada());
			partida.revalidate();
			partida.setExtendedState(JFrame.MAXIMIZED_BOTH);
		} else if (e.getSource() == Boton[2]) {
			JOptionPane.showMessageDialog(this, "Jugador:\r\n" + "\r\n" + "Un jugador tiene 4 acciones.\r\n"
					+ "El Jugador en su turno puede usar sus acciones de dos maneras.\r\n"
					+ "    - Matar: Consume una acción, limpia una unidad de monstruos de la ciudad elegida.\r\n"
					+ "    - Investigar arma: Consume 4 acciones para aumentar el porcentage de obtención del arma legendaria para cada tipo de plaga.\r\n"
					+ "      Una vez creada una de las armas el tipo de enemigo ligado a ella al usarla contra el tipo de enemigo eliminará todos los tokens de la ciudad\r\n"
					+ "        * Dandelion (Ents)\r\n" + "        * Kzarka (Goblos)\r\n"
					+ "        * Kutum (Momias)\r\n" + "        * Corazón de Vell (Tritones)\r\n" + "\r\n"
					+ "Partida:\r\n" + "\r\n"
					+ "Cada turno que pasas el tablero jugará contra ti y diferentes ciudades del mapa se verán afectados por las plagas que azotan al mundo\r\n"
					+ "    -El número de ciudades infectadas por turno dependerá de tu criterio al iniciar el juego en el apartado parametros.\r\n"
					+ "\r\n" + " -Los turnos se pasan cuando aprietes el botón de siguiente turno. \r\n"
					+ "Cada vez que una ciudad supera los tres brotes esta no sube más sus contadores sinó que exparce un contador a cada una de las ciudades lindantes\r\n"
					+ "    -Efectivamente un brote puede implicar una cadena de infecciones en masa\r\n" + "\r\n"
					+ "Las ciudades pueden tener en ellas diferentes héroes que te pueden ayudar en la partida:\r\n"
					+ "    -Guerreros, estos conquistaran una ciudad y  matara plagas en cada una de las ciudades lindantes de la ciudad principal.\r\n"
					+ "    -Soportes, estos son héroes que una vez conseguidos te ayudarán en la obtención de las armas, dándote un porcentage plano en cada farméo\r\n"
					+ "        * Los Héroes entran en recarga durante unos turnos luego de ser usados.\r\n"
					+ "\r\n"
					+ "La partida se gana cuando consigues fabricar las 4 armas para conquistar todas las ciudades o se pierde una vez que el número de infecciones \r\n"
					+ "ha llegado al límite dispuesto en parametros, cuando llega acaba la partida y pierdes.\r\n"
					+ "\r\n" + "Héroes:\r\n"
					+ "Activar su habilidad es una acción\r\n");
		} else if (e.getSource() == Boton[3]) {
			// Código para el botón "Resumen de puntuaciones"
			ranking();
		} else if (e.getSource() == Boton[4]) {
			JOptionPane.showMessageDialog(this,
					"Autores:\n\nArduí Pulido Bosch arduipulido@gmail.com\nChenping Guo Chen chenpinguo3@gmail.com ",
					"Autores", JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getSource() == Boton[5]) {
			JOptionPane.showMessageDialog(this, "Version 1.0 ", "Version", JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getSource() == Boton[6]) {
			System.exit(0);
		}
	}
	/**
	 * Funcion para añadir los botones en el panel principal
	 */
	public void addButtons() {
		Boton = new Button[7];
		String[] nombres = { "Nueva Partida", "Cargar Partida", "Información", "Ranking", "Autores", "Versión",
				"Salir" };
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
	/**
	 * Funcion para elegir la dificultad deseada
	 */
	private void showDifficultyButtons() {
		// Eliminar los botones actuales
		removeAll();

		// Crear nuevos botones de dificultad
		Button botonFacil = new Button("Facil");
		Button botonNormal = new Button("Normal");
		Button botonDificil = new Button("Dificil");

		// Agregar ActionListeners a los nuevos botones
		botonFacil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setDiff("Facil");
				iniciarPartidaConDificultad();
			}
		});
		botonNormal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setDiff("Normal");
				iniciarPartidaConDificultad();
			}
		});
		botonDificil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setDiff("Dificil");
				iniciarPartidaConDificultad();
			}
		});

		// Establecer los nuevos botones en el panel
		botonFacil.setBounds(685, 415, 170, 50);
		botonNormal.setBounds(685, 475, 170, 50);
		botonDificil.setBounds(685, 535, 170, 50);

		add(botonFacil);
		add(botonNormal);
		add(botonDificil);

		revalidate();
		repaint();
		reproducirMusica();
		InitCartel();
		InitFondo();
	}
	/**
	 * Funcion para imprimir y selecionar los usuarios del ranking
	 */
	private void ranking() {
	    JFrame frame = new JFrame("Ranking");
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setSize(400, 300);
	    frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
	    
	    JPanel panel = new JPanel();
	    panel.setLayout(new BorderLayout());

	    // Crear el modelo de la tabla
	    String[] columnNames = {"Ranking", "Jugador", "Puntuación"};
        Object[][] data = {
                {"1", " ", " "},
                {"2", " ", " "},
                {"3", " ", " "},
                {"4", " ", " "},
                {"5", " ", " "}
        };
		
		Connection con = bbdd.conectarBaseDatos();
		String[] listaElementosSeleccionados = { "COUNT(*)" };
		String[] Select = bbdd.select(con, "SELECT count(*) FROM datospartidatabla GROUP BY Jugador", listaElementosSeleccionados);
		System.out.println(Select[0]);
		int num = Integer.parseInt(Select[0]);
		String[] listaElementosSeleccionados1 = { "Jugador" };
		String[] listaElementosSeleccionados2 = {"Puntuacion"};
		if (num >= 1) {
			String[] Select1 = bbdd.select(con, "SELECT Jugador FROM (Select Jugador from (Select Jugador, MAX(puntuacion) AS puntuacion FROM datospartidatabla GROUP BY Jugador) ORDER BY puntuacion DESC)Where ROWNUM <= 1", listaElementosSeleccionados1);
			String[] Select2 = bbdd.select(con, "SELECT puntuacion FROM (SELECT puntuacion FROM (SELECT MAX(puntuacion) AS puntuacion FROM datospartidatabla GROUP BY Jugador)ORDER BY puntuacion DESC) WHERE ROWNUM <= 1", listaElementosSeleccionados2);
			data[0][1] = Select1[0];
			data[0][2] = Select2[0];
		}
		if (num >= 2) {
			String[] Select1 = bbdd.select(con, "SELECT Jugador FROM (Select Jugador from (Select Jugador, MAX(puntuacion) AS puntuacion FROM datospartidatabla GROUP BY Jugador) ORDER BY puntuacion DESC)Where ROWNUM <= 2", listaElementosSeleccionados1);
			String[] Select2 = bbdd.select(con, "SELECT puntuacion FROM (SELECT puntuacion FROM (SELECT MAX(puntuacion) AS puntuacion FROM datospartidatabla GROUP BY Jugador)ORDER BY puntuacion DESC) WHERE ROWNUM <= 2", listaElementosSeleccionados2);
			data[1][1] = Select1[0];
			data[1][2] = Select2[0];			
		}
		if (num >= 3) {
			String[] Select1 = bbdd.select(con, "SELECT Jugador FROM (Select Jugador from (Select Jugador, MAX(puntuacion) AS puntuacion FROM datospartidatabla GROUP BY Jugador) ORDER BY puntuacion DESC)Where ROWNUM <= 3", listaElementosSeleccionados1);
			String[] Select2 = bbdd.select(con, "SELECT puntuacion FROM (SELECT puntuacion FROM (SELECT MAX(puntuacion) AS puntuacion FROM datospartidatabla GROUP BY Jugador)ORDER BY puntuacion DESC) WHERE ROWNUM <= 3", listaElementosSeleccionados2);
			data[2][1] = Select1[0];
			data[2][2] = Select2[0];	
		}
		if (num >= 4) {
			String[] Select1 = bbdd.select(con, "SELECT Jugador FROM (Select Jugador from (Select Jugador, MAX(puntuacion) AS puntuacion FROM datospartidatabla GROUP BY Jugador) ORDER BY puntuacion DESC)Where ROWNUM <= 4", listaElementosSeleccionados1);
			String[] Select2 = bbdd.select(con, "SELECT puntuacion FROM (SELECT puntuacion FROM (SELECT MAX(puntuacion) AS puntuacion FROM datospartidatabla GROUP BY Jugador)ORDER BY puntuacion DESC) WHERE ROWNUM <= 4", listaElementosSeleccionados2);
			data[3][1] = Select1[0];
			data[3][2] = Select2[0];
		}
		if (num >= 5) {
			String[] Select1 = bbdd.select(con, "SELECT Jugador FROM (Select Jugador from (Select Jugador, MAX(puntuacion) AS puntuacion FROM datospartidatabla GROUP BY Jugador) ORDER BY puntuacion DESC)Where ROWNUM <= 5", listaElementosSeleccionados1);
			String[] Select2 = bbdd.select(con, "SELECT puntuacion FROM (SELECT puntuacion FROM (SELECT MAX(puntuacion) AS puntuacion FROM datospartidatabla GROUP BY Jugador)ORDER BY puntuacion DESC) WHERE ROWNUM <= 5", listaElementosSeleccionados2);
			data[4][1] = Select1[0];
			data[4][2] = Select2[0];
		}


	    rankingModel = new DefaultTableModel(data, columnNames);
	    
	    // Crear la tabla con el modelo
	    rankingTable = new JTable(rankingModel);
	    rankingTable.setFillsViewportHeight(true);
	    rankingTable.setRowHeight(40); // Ajustar la altura de las filas
	    rankingTable.setFont(new Font("Pixelade", Font.PLAIN, 20)); // Fuente retro
	    rankingTable.getTableHeader().setFont(new Font("Pixelade", Font.BOLD, 22)); // Fuente retro para el encabezado
	    rankingTable.setGridColor(Color.BLACK); // Color de las líneas de la tabla
	    rankingTable.setBackground(Color.BLACK); // Color de fondo de la tabla
	    rankingTable.setForeground(Color.WHITE); // Color del texto de la tabla
	    rankingTable.setSelectionBackground(Color.GRAY); // Color de fondo de la selección
	    rankingTable.setSelectionForeground(Color.WHITE); // Color del texto de la selección
	    // Añadir la tabla a un JScrollPane para que tenga scroll si es necesario
	    JScrollPane scrollPane = new JScrollPane(rankingTable);
	    panel.add(scrollPane, BorderLayout.CENTER);

	    frame.add(panel);
	    frame.setVisible(true);
	}


	/**
	 * Funcion para iniciar la partida o llamar al panel de la partida
	 */
	private void iniciarPartidaConDificultad() {
		// Implementar la lógica para iniciar la partida con la dificultad seleccionada
//        System.out.println("Iniciando partida con dificultad: " + dificultad);
		JFrame partidaInit = (JFrame) SwingUtilities.getWindowAncestor(this);
		partidaInit.getContentPane().removeAll();
		partidaInit.getContentPane().add(new Panel_Partida());
		partidaInit.revalidate();
		partidaInit.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        partida.cargarDatos(dificultad);
	}
	
	/**
	 * Funcion para iniciar el fondo del panel
	 */
	private void InitCartel() {
		setOpaque(true);
		ImageIcon imagen = new ImageIcon("img/logo.png");

		Image imgEscalada = imagen.getImage().getScaledInstance(590, 180, Image.SCALE_SMOOTH);
		ImageIcon imagenEscalada = new ImageIcon(imgEscalada);

		JLabel fondoLabel = new JLabel(imagenEscalada);
		fondoLabel.setBounds(473, 84, 590, 180);
		add(fondoLabel);
	}
	/**
	 * Funcion para Iniciar el logo del fondo del panel
	 */
	private void InitFondo() {
		setOpaque(true);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		ImageIcon imagen = new ImageIcon("img/Loding.png");

		Image imgEscalada = imagen.getImage().getScaledInstance(screenSize.width, screenSize.height,
				Image.SCALE_SMOOTH);
		ImageIcon imagenEscalada = new ImageIcon(imgEscalada);

		JLabel fondoLabel = new JLabel(imagenEscalada);
		fondoLabel.setBounds(0, 10, screenSize.width, screenSize.height); // Posicionamos el fondoLabel para cubrir todo
		setOpaque(true); // el panel.
		add(fondoLabel);

		setVisible(true);
	}
	/**
	 * Funcion para reproducir la musica del juego en bucle
	 */
	private void reproducirMusica() {
		String filePath = "img/SoundTrack.wav";
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
	/**
	 * Getter
	 * @return
	 */
	public static String getDiff() {
		return diff;
	}
	/**
	 * Setter
	 * @param diff
	 */
	public void setDiff(String diff) {
		this.diff = diff;
	}
}
