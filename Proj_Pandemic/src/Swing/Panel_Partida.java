package Swing;

import javax.swing.*;

import Func_Partida.DatosPartida;
import Func_Partida.Vacuna;
import Func_Partida.control_de_partida;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Panel_Partida extends JPanel implements ActionListener {
	JButton[] btnCiudad;
	JButton[] btnComponentes;
	JButton[] btnAccCiudades;
	JLabel[] Paneltxt;
	JProgressBar[] ProgressBar;
	String[] Vacunas;
	JTextField txtProgresoInvasiones;
	static JTextArea consola;
	DatosPartida partida = new DatosPartida();
	control_de_partida cPartida = new control_de_partida();
	String[] nombres = { "Puerto Rath", "Isla Kuix", "Isla Danton", "Isla Paxid", "Isla Khan", "Isla Hiwua",
			"Isla Lemma", "Isla Lisz", "Isla Narvo", "Ojo de Odquilla", "Cresta del Cuervo", "Rosevan",
			"Puerto Epheria", "Finistella", "Calpheon", "Bosque Ceniza", "Grana", "Trent", "Tunkuta", "Duvencrue",
			"Odyllita", "Cubil Escarlata", "Keplan", "Florin", "Olvia", "Velia", "Castillo Cron", "Kusha", "Heidel",
			"Glish", "Bosque Tungrad", "Tarif", "Altinova", "Asparkan", "Ruinas de Waragon", "Ruinas de Kadry",
			"Bazar GranArena", "Shakatu", "Valle Bambu", "Minas de Sulfuro", "Ibellab Oasis", "Valencia Ciudad",
			"Arehaza", "Templo Medialuna", "Valle de Titum", "Miuquu", "Cantusa", "Pila Ku" };

	public Panel_Partida() {
		setLayout(null);
		setBounds(0, 0, 1550, 775);
		Image iconImage = new ImageIcon("img/Logo_inicial.jpeg").getImage();
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/Logo_inicial.jpeg"));
		
		InitComponentes();
		InitCiudadesBtn();
		generarIcono();
		InitFondo();
		Paneltxt[3].setText("Turno: 1");
		partida.cargarDatos(mostrarPopupDificultad());
		cPartida.gestionarTurno(partida, 0);
		generarVariables();
	}

	private void generarVariables() {
		Vacunas = new String[4];
		int i = 0;
		for (Vacuna vacuna : partida.getVacunas()) {
			Vacunas[i] = vacuna.getArma();
			i++;
		}

	}

	private void panelCiudad(String nombre) {
		btnAccCiudades = new JButton[2];

		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
		// Crear y mostrar el JDialog con las opciones
		JDialog dialog = new JDialog(frame, "Ciudad", true); // true para hacerlo modal
		dialog.getContentPane().setLayout(null);
		dialog.setSize(300, 300);
		dialog.setLocation(690, 386);

		JLabel lblCosa = new JLabel(nombre);
		lblCosa.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCosa.setBounds(10, 10, 280, 46);
		dialog.getContentPane().add(lblCosa);

		JLabel nombreInvasor = new JLabel("Invasor: " + partida.getVirusCiudad(nombre));
		nombreInvasor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nombreInvasor.setBounds(10, 64, 175, 46);
		dialog.getContentPane().add(nombreInvasor);

		JLabel nivelConquista = new JLabel("Nivel Conquista: " + partida.getNivelInfeccionCiudad(nombre));
		nivelConquista.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nivelConquista.setBounds(10, 120, 175, 46);
		dialog.getContentPane().add(nivelConquista);

		btnAccCiudades[0] = new JButton("Matar");
		btnAccCiudades[0].setBounds(10, 200, 120, 50);
		btnAccCiudades[0].setToolTipText("Matar elimina a uno la infeccion de la ciudad seleccionada y consume 1 accion");
		dialog.getContentPane().add(btnAccCiudades[0]);
		btnAccCiudades[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Acción a realizar cuando se hace clic en el botón
				cPartida.ciudadesCura(partida, nombre);
				actualizarDatos();
				nivelConquista.setText("Nivel Conquista: " + partida.getNivelInfeccionCiudad(nombre));
				partida.setAcciones((partida.getAcciones()) - 1);
				popUpAcciones();
			}
		});

		btnAccCiudades[1] = new JButton("Ayudar");
		btnAccCiudades[1].setBounds(140, 200, 120, 50);
		btnAccCiudades[1].setToolTipText("Ayudar pide ayuda a nuestros dos heroes, nos ayudan con sus funciones especiales");
		dialog.getContentPane().add(btnAccCiudades[1]);
		btnAccCiudades[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelHeroes(nombre);
				nivelConquista.setText("Nivel Conquista: " + partida.getNivelInfeccionCiudad(nombre));
			}
		});

		dialog.setVisible(true);
	}

	public void PanelHeroes(String nombre) {
		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

		ImageIcon originalIcon = new ImageIcon("img/support.jpg"); // Ruta de tu imagen
		Image image = originalIcon.getImage();
		Image newImage = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH); // Ajusta al tamaño deseado
		ImageIcon Support = new ImageIcon(newImage);

		ImageIcon originalIcon1 = new ImageIcon("img/guerrero.jpg"); // Ruta de tu imagen
		Image image1 = originalIcon1.getImage();
		Image newImage1 = image1.getScaledInstance(300, 300, Image.SCALE_SMOOTH); // Ajusta al tamaño deseado
		ImageIcon Guerrero = new ImageIcon(newImage1);

		ImageIcon originalIcon2 = new ImageIcon("img/supportCD.jpg"); // Ruta de tu imagen
		Image image2 = originalIcon2.getImage();
		Image newImage2 = image2.getScaledInstance(300, 300, Image.SCALE_SMOOTH); // Ajusta al tamaño deseado
		ImageIcon supportCD = new ImageIcon(newImage2);

		ImageIcon originalIcon3 = new ImageIcon("img/guerreroCD.jpg"); // Ruta de tu imagen
		Image image3 = originalIcon3.getImage();
		Image newImage3 = image3.getScaledInstance(300, 300, Image.SCALE_SMOOTH); // Ajusta al tamaño deseado
		ImageIcon guerreroCD = new ImageIcon(newImage3);

		JDialog selector = new JDialog(frame,
				"Support                                                                          Guerrero   ", true); // true
																														// para
																														// hacerlo
																														// modal
		selector.getContentPane().setLayout(null);
		selector.setSize(600, 300);
		selector.setLocationRelativeTo(null);

		JButton guerrero = new JButton("Botón 1");
		guerrero.setBounds(300, 0, 300, 300);
		guerrero.setContentAreaFilled(false);
		guerrero.setToolTipText("El guerrero ayuda a eliminar la infeccion en 1 en la ciudad seleccionada y sus colindantes, tiene un cooldown de 3 turnos y consume una accion en su uso");

		if (cPartida.estadoPej(partida, 0)) {
			guerrero.setIcon(Guerrero);
		} else {
			guerrero.setIcon(guerreroCD);
		}

		guerrero.setText(null);
		selector.getContentPane().add(guerrero);
		guerrero.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Acción a realizar cuando se hace clic en el botón
				cPartida.gestionarHeroesAtc(partida, nombre);
				partida.setAcciones(partida.getAcciones() - 1);
				actualizarDatos();
				popUpAcciones();
				selector.dispose();
			}
		});

		JButton support = new JButton("Botón 2");
		support.setBounds(0, 0, 300, 300);
		support.setContentAreaFilled(false);
		support.setToolTipText("El support ayuda a augmentar un 5% el progresso de cada arma, tiene un cooldown de 5 turnos y consume una accion en su uso");

		if (cPartida.estadoPej(partida, 1)) {
			support.setIcon(Support);
		} else {
			support.setIcon(supportCD);
		}

		support.setText(null);
		selector.getContentPane().add(support);
		support.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Acción a realizar cuando se hace clic en el botón
				cPartida.gestionarHeroeSup(partida, nombre);
				partida.setAcciones((partida.getAcciones()) - 1);
				actualizarDatos();
				popUpAcciones();
				selector.dispose();
			}
		});

		selector.setVisible(true);
	}

	public void panelAjustes() {

		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
		// Crear y mostrar el JDialog con las opciones
		JDialog dialog = new JDialog(frame, "Ajustes", true); // true para hacerlo modal
		dialog.getContentPane().setLayout(null);
		dialog.setSize(164, 157);
		dialog.setLocationRelativeTo(null);
		
		JButton guardar = new JButton("Guardar Partida");
		guardar.setBounds(0, 0, 150, 60);
		guardar.setToolTipText("Guardar Partida dentro de la base de datos con el usuario en la cual entraste al juego");
		dialog.getContentPane().add(guardar);
		
		JButton salir = new JButton("Salir del juego");
		salir.setBounds(0, 60, 150, 60);
		salir.setToolTipText("Salir del juego");
		dialog.getContentPane().add(salir);
		
		dialog.setVisible(true);
	
	}
	
	public String Craftear() {
		String armaSeleccionada = (String) JOptionPane.showInputDialog(this, "Seleccione la cual quiera investigar:",
				"Seleccione la cual quiera investigar:", JOptionPane.QUESTION_MESSAGE, null, Vacunas, Vacunas[0]);
		if (armaSeleccionada != null) {
			System.out.println("Arma seleccionada: " + armaSeleccionada);
		}
		return armaSeleccionada;
	}

	public void popUpAcciones() {
		JOptionPane.showMessageDialog(this, "Te queda " + partida.getAcciones() + " restantes", "Acciones Restantes",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static void GuardarDatos(String datos) {
		consola.append(datos + "\n");
		int maxLines = 12; // Set the maximum number of lines you want to display
		int lineCount = consola.getLineCount();
		if (lineCount > maxLines) {
			try {
				int startOffset = consola.getLineStartOffset(0);
				int endOffset = consola.getLineEndOffset(lineCount - maxLines);
				consola.replaceRange("", startOffset, endOffset);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public void actualizarDatos() {
		Paneltxt[3].setText("Turno: " + partida.getRondas());
		Paneltxt[0].setText("Brotes Totales = " + partida.getBrotes());
		int i = 0;
		for (Vacuna viruses : partida.getVacunas()) {
			ProgressBar[i].setValue(partida.getNivelVacuna(Vacunas[i]));
			i++;
		}
		i = 0;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnComponentes[1]) {
			// Craftear
			if (partida.getAcciones() != 4) {
				JOptionPane.showMessageDialog(this, "Esta accion requiere 4 acciones", "Acciones insuficientes",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				cPartida.gestionarVacuna(partida, Craftear());
				actualizarDatos();
			}
			popUpAcciones();
		}
		if (e.getSource() == btnComponentes[2]) {
			// Ajustes
			panelAjustes();
		}

		if (e.getSource() == btnComponentes[3]) {
			// siguiente turno
			if (cPartida.ganarPartida(partida)) {
				JOptionPane.showMessageDialog(this, "Has GANADO!!!!!!", "Ganaste", JOptionPane.INFORMATION_MESSAGE);
				JFrame partida = (JFrame) SwingUtilities.getWindowAncestor(this);
				partida.getContentPane().removeAll();
			}else{
				cPartida.gestionarTurno(partida, 1);
				actualizarDatos();
				if (cPartida.gestionarFinPartida(partida)) {
					JOptionPane.showMessageDialog(this, "Has perdido", "Perdiste", JOptionPane.INFORMATION_MESSAGE);
					JFrame partida = (JFrame) SwingUtilities.getWindowAncestor(this);
					partida.getContentPane().removeAll();
				}
			}
			;

		}

		if (e.getSource() == btnCiudad[0]) {
			String nCiudad = nombres[0];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[1]) {
			String nCiudad = nombres[1];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[2]) {
			String nCiudad = nombres[2];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[3]) {
			String nCiudad = nombres[3];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[4]) {
			String nCiudad = nombres[4];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[5]) {
			String nCiudad = nombres[5];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[6]) {
			String nCiudad = nombres[6];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[7]) {
			String nCiudad = nombres[7];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[8]) {
			String nCiudad = nombres[8];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[9]) {
			String nCiudad = nombres[9];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[10]) {
			String nCiudad = nombres[10];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[11]) {
			String nCiudad = nombres[11];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[12]) {
			String nCiudad = nombres[12];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[13]) {
			String nCiudad = nombres[13];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[14]) {
			String nCiudad = nombres[14];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[15]) {
			String nCiudad = nombres[15];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[16]) {
			String nCiudad = nombres[16];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[17]) {
			String nCiudad = nombres[17];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[18]) {
			String nCiudad = nombres[18];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[19]) {
			String nCiudad = nombres[19];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[20]) {
			String nCiudad = nombres[20];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[21]) {
			String nCiudad = nombres[21];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[22]) {
			String nCiudad = nombres[22];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[23]) {
			String nCiudad = nombres[23];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[24]) {
			String nCiudad = nombres[24];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[25]) {
			String nCiudad = nombres[25];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[26]) {
			String nCiudad = nombres[26];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[27]) {
			String nCiudad = nombres[27];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[28]) {
			String nCiudad = nombres[28];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[29]) {
			String nCiudad = nombres[29];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[30]) {
			String nCiudad = nombres[30];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[31]) {
			String nCiudad = nombres[31];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[32]) {
			String nCiudad = nombres[32];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[33]) {
			String nCiudad = nombres[33];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[34]) {
			String nCiudad = nombres[34];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[35]) {
			String nCiudad = nombres[35];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[36]) {
			String nCiudad = nombres[36];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[37]) {
			String nCiudad = nombres[37];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[38]) {
			String nCiudad = nombres[38];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[39]) {
			String nCiudad = nombres[39];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[40]) {
			String nCiudad = nombres[40];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[41]) {
			String nCiudad = nombres[41];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[42]) {
			String nCiudad = nombres[42];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[43]) {
			String nCiudad = nombres[43];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[44]) {
			String nCiudad = nombres[44];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[45]) {
			String nCiudad = nombres[45];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[46]) {
			String nCiudad = nombres[46];
			panelCiudad(nCiudad);
		}
		if (e.getSource() == btnCiudad[47]) {
			String nCiudad = nombres[47];
			panelCiudad(nCiudad);
		}
	}

	private void generarIcono() {
		// Crea un ImageIcon con la imagen
		ImageIcon icono = new ImageIcon("img/gateway_0.png");
		ImageIcon icono1 = new ImageIcon("img/gateway_1.png");
		ImageIcon icono2 = new ImageIcon("img/gateway_2.png");
		ImageIcon icono3 = new ImageIcon("img/gateway_3.png");
		ImageIcon icono4 = new ImageIcon("img/Ajustes.png");

		// Escala el ImageIcon al tamaño del botón
		Image imagenEscalada = icono.getImage().getScaledInstance(btnCiudad[0].getWidth(), btnCiudad[0].getHeight(),
				Image.SCALE_SMOOTH);
		Image imagenEscalada1 = icono1.getImage().getScaledInstance(btnCiudad[0].getWidth(), btnCiudad[0].getHeight(),
				Image.SCALE_SMOOTH);
		Image imagenEscalada2 = icono2.getImage().getScaledInstance(btnCiudad[0].getWidth(), btnCiudad[0].getHeight(),
				Image.SCALE_SMOOTH);
		Image imagenEscalada3 = icono3.getImage().getScaledInstance(btnCiudad[0].getWidth(), btnCiudad[0].getHeight(),
				Image.SCALE_SMOOTH);

		// Crea un nuevo ImageIcon con la imagen escalada
		ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
		ImageIcon iconoEscalado1 = new ImageIcon(imagenEscalada1);
		ImageIcon iconoEscalado2 = new ImageIcon(imagenEscalada2);
		ImageIcon iconoEscalado3 = new ImageIcon(imagenEscalada3);

		btnComponentes[2].setIcon(icono4);
		btnComponentes[2].setText(null);

		btnCiudad[0].setIcon(iconoEscalado);
		btnCiudad[0].setText(null);

		btnCiudad[1].setIcon(iconoEscalado);
		btnCiudad[1].setText(null);

		btnCiudad[2].setIcon(iconoEscalado);
		btnCiudad[2].setText(null);

		btnCiudad[3].setIcon(iconoEscalado);
		btnCiudad[3].setText(null);

		btnCiudad[4].setIcon(iconoEscalado);
		btnCiudad[4].setText(null);

		btnCiudad[5].setIcon(iconoEscalado);
		btnCiudad[5].setText(null);

		btnCiudad[6].setIcon(iconoEscalado);
		btnCiudad[6].setText(null);

		btnCiudad[7].setIcon(iconoEscalado);
		btnCiudad[7].setText(null);

		btnCiudad[8].setIcon(iconoEscalado);
		btnCiudad[8].setText(null);

		btnCiudad[9].setIcon(iconoEscalado);
		btnCiudad[9].setText(null);

		btnCiudad[10].setIcon(iconoEscalado);
		btnCiudad[10].setText(null);

		btnCiudad[11].setIcon(iconoEscalado);
		btnCiudad[11].setText(null);

		btnCiudad[12].setIcon(iconoEscalado1);
		btnCiudad[12].setText(null);

		btnCiudad[13].setIcon(iconoEscalado1);
		btnCiudad[13].setText(null);

		btnCiudad[14].setIcon(iconoEscalado1);
		btnCiudad[14].setText(null);

		btnCiudad[15].setIcon(iconoEscalado1);
		btnCiudad[15].setText(null);

		btnCiudad[16].setIcon(iconoEscalado1);
		btnCiudad[16].setText(null);

		btnCiudad[17].setIcon(iconoEscalado1);
		btnCiudad[17].setText(null);

		btnCiudad[18].setIcon(iconoEscalado1);
		btnCiudad[18].setText(null);

		btnCiudad[19].setIcon(iconoEscalado1);
		btnCiudad[19].setText(null);

		btnCiudad[20].setIcon(iconoEscalado1);
		btnCiudad[20].setText(null);

		btnCiudad[21].setIcon(iconoEscalado1);
		btnCiudad[21].setText(null);

		btnCiudad[22].setIcon(iconoEscalado1);
		btnCiudad[22].setText(null);

		btnCiudad[23].setIcon(iconoEscalado1);
		btnCiudad[23].setText(null);

		btnCiudad[24].setIcon(iconoEscalado2);
		btnCiudad[24].setText(null);

		btnCiudad[25].setIcon(iconoEscalado2);
		btnCiudad[25].setText(null);

		btnCiudad[26].setIcon(iconoEscalado2);
		btnCiudad[26].setText(null);

		btnCiudad[27].setIcon(iconoEscalado2);
		btnCiudad[27].setText(null);

		btnCiudad[28].setIcon(iconoEscalado2);
		btnCiudad[28].setText(null);

		btnCiudad[29].setIcon(iconoEscalado2);
		btnCiudad[29].setText(null);

		btnCiudad[30].setIcon(iconoEscalado2);
		btnCiudad[30].setText(null);

		btnCiudad[31].setIcon(iconoEscalado2);
		btnCiudad[31].setText(null);

		btnCiudad[32].setIcon(iconoEscalado2);
		btnCiudad[32].setText(null);

		btnCiudad[33].setIcon(iconoEscalado2);
		btnCiudad[33].setText(null);

		btnCiudad[34].setIcon(iconoEscalado2);
		btnCiudad[34].setText(null);

		btnCiudad[35].setIcon(iconoEscalado2);
		btnCiudad[35].setText(null);

		btnCiudad[36].setIcon(iconoEscalado3);
		btnCiudad[36].setText(null);

		btnCiudad[37].setIcon(iconoEscalado3);
		btnCiudad[37].setText(null);

		btnCiudad[38].setIcon(iconoEscalado3);
		btnCiudad[38].setText(null);

		btnCiudad[39].setIcon(iconoEscalado3);
		btnCiudad[39].setText(null);

		btnCiudad[40].setIcon(iconoEscalado3);
		btnCiudad[40].setText(null);

		btnCiudad[41].setIcon(iconoEscalado3);
		btnCiudad[41].setText(null);

		btnCiudad[42].setIcon(iconoEscalado3);
		btnCiudad[42].setText(null);

		btnCiudad[43].setIcon(iconoEscalado3);
		btnCiudad[43].setText(null);

		btnCiudad[44].setIcon(iconoEscalado3);
		btnCiudad[44].setText(null);

		btnCiudad[45].setIcon(iconoEscalado3);
		btnCiudad[45].setText(null);

		btnCiudad[46].setIcon(iconoEscalado3);
		btnCiudad[46].setText(null);

		btnCiudad[47].setIcon(iconoEscalado3);
		btnCiudad[47].setText(null);

	}

	private void InitCiudadesBtn() {

		btnCiudad = new JButton[48];

		btnCiudad[0] = new JButton("PuertoRath");
		btnCiudad[0].setBounds(42, 67, 35, 35);
		add(btnCiudad[0]);

		btnCiudad[1] = new JButton("IslaKuix");
		btnCiudad[1].setBounds(359, 167, 35, 35);
		add(btnCiudad[1]);

		btnCiudad[2] = new JButton("IslaDanton");
		btnCiudad[2].setBounds(287, 299, 35, 35);
		add(btnCiudad[2]);

		btnCiudad[3] = new JButton("IslaPaxid");
		btnCiudad[3].setBounds(359, 224, 35, 35);
		add(btnCiudad[3]);

		btnCiudad[4] = new JButton("IslaKhan");
		btnCiudad[4].setBounds(376, 89, 35, 35);
		add(btnCiudad[4]);

		btnCiudad[5] = new JButton("IslaHiwua");
		btnCiudad[5].setBounds(678, 89, 35, 35);
		add(btnCiudad[5]);

		btnCiudad[6] = new JButton("IslaLemma");
		btnCiudad[6].setBounds(515, 167, 35, 35);
		add(btnCiudad[6]);

		btnCiudad[7] = new JButton("IslaLisz");
		btnCiudad[7].setBounds(420, 257, 35, 35);
		add(btnCiudad[7]);

		btnCiudad[8] = new JButton("IslaNarvo");
		btnCiudad[8].setBounds(563, 236, 35, 35);
		add(btnCiudad[8]);

		btnCiudad[9] = new JButton("OjoDeOdquilla");
		btnCiudad[9].setBounds(653, 224, 35, 35);
		add(btnCiudad[9]);

		btnCiudad[10] = new JButton("CrestaDelCuervo");
		btnCiudad[10].setBounds(752, 153, 35, 35);
		add(btnCiudad[10]);

		btnCiudad[11] = new JButton("Rosevan");
		btnCiudad[11].setBounds(815, 212, 35, 35);
		add(btnCiudad[11]);

		btnCiudad[12] = new JButton("PuertoEpheria");
		btnCiudad[12].setBounds(335, 423, 35, 35);
		add(btnCiudad[12]);

		btnCiudad[13] = new JButton("Finistella");
		btnCiudad[13].setBounds(276, 511, 35, 35);
		add(btnCiudad[13]);

		btnCiudad[14] = new JButton("Calphen");
		btnCiudad[14].setBounds(385, 499, 35, 35);
		add(btnCiudad[14]);

		btnCiudad[15] = new JButton("BosqueCeniza");
		btnCiudad[15].setBounds(239, 645, 35, 35);
		add(btnCiudad[15]);

		btnCiudad[16] = new JButton("Grana");
		btnCiudad[16].setBounds(306, 732, 35, 35);
		add(btnCiudad[16]);

		btnCiudad[17] = new JButton("Trent");
		btnCiudad[17].setBounds(359, 599, 35, 35);
		add(btnCiudad[17]);

		btnCiudad[18] = new JButton("Tunkuta");
		btnCiudad[18].setBounds(433, 718, 35, 35);
		add(btnCiudad[18]);

		btnCiudad[19] = new JButton("DuvenCrune");
		btnCiudad[19].setBounds(515, 645, 35, 35);
		add(btnCiudad[19]);

		btnCiudad[20] = new JButton("Odyllita");
		btnCiudad[20].setBounds(570, 704, 35, 35);
		add(btnCiudad[20]);

		btnCiudad[21] = new JButton("CubilEscarlata");
		btnCiudad[21].setBounds(594, 599, 35, 35);
		add(btnCiudad[21]);

		btnCiudad[22] = new JButton("Keplan");
		btnCiudad[22].setBounds(458, 568, 35, 35);
		add(btnCiudad[22]);

		btnCiudad[23] = new JButton("Florin");
		btnCiudad[23].setBounds(458, 438, 35, 35);
		add(btnCiudad[23]);

		btnCiudad[24] = new JButton("Olvia");
		btnCiudad[24].setBounds(483, 355, 35, 35);
		add(btnCiudad[24]);

		btnCiudad[25] = new JButton("Velia");
		btnCiudad[25].setBounds(569, 379, 35, 35);
		add(btnCiudad[25]);

		btnCiudad[26] = new JButton("CastilloCron");
		btnCiudad[26].setBounds(621, 356, 35, 35);
		add(btnCiudad[26]);

		btnCiudad[27] = new JButton("Kusha");
		btnCiudad[27].setBounds(690, 386, 35, 35);
		add(btnCiudad[27]);

		btnCiudad[28] = new JButton("Heidel");
		btnCiudad[28].setBounds(584, 463, 35, 35);
		add(btnCiudad[28]);

		btnCiudad[29] = new JButton("Glish");
		btnCiudad[29].setBounds(552, 536, 35, 35);
		add(btnCiudad[29]);

		btnCiudad[30] = new JButton("BosqueTungrad");
		btnCiudad[30].setBounds(675, 532, 35, 35);
		add(btnCiudad[30]);

		btnCiudad[31] = new JButton("Tarif");
		btnCiudad[31].setBounds(716, 475, 35, 35);
		add(btnCiudad[31]);

		btnCiudad[32] = new JButton("Altinova");
		btnCiudad[32].setBounds(777, 482, 35, 35);
		add(btnCiudad[32]);

		btnCiudad[33] = new JButton("Asparcan");
		btnCiudad[33].setBounds(777, 579, 35, 35);
		add(btnCiudad[33]);

		btnCiudad[34] = new JButton("RuinasDeWaragon");
		btnCiudad[34].setBounds(867, 525, 35, 35);
		add(btnCiudad[34]);

		btnCiudad[35] = new JButton("RuinasDeKadry");
		btnCiudad[35].setBounds(815, 391, 35, 35);
		add(btnCiudad[35]);

		btnCiudad[36] = new JButton("BazarGranArena");
		btnCiudad[36].setBounds(905, 412, 35, 35);
		add(btnCiudad[36]);

		btnCiudad[37] = new JButton("Shakatu");
		btnCiudad[37].setBounds(894, 302, 35, 35);
		add(btnCiudad[37]);

		btnCiudad[38] = new JButton("ValleBambu");
		btnCiudad[38].setBounds(968, 212, 35, 35);
		add(btnCiudad[38]);

		btnCiudad[39] = new JButton("MinasDeSulfuro");
		btnCiudad[39].setBounds(1213, 108, 35, 35);
		add(btnCiudad[39]);

		btnCiudad[40] = new JButton("IbellaBOasis");
		btnCiudad[40].setBounds(1043, 382, 35, 35);
		add(btnCiudad[40]);

		btnCiudad[41] = new JButton("ValenciaCiudad");
		btnCiudad[41].setBounds(1187, 279, 35, 35);
		add(btnCiudad[41]);

		btnCiudad[42] = new JButton("Arehaza");
		btnCiudad[42].setBounds(1303, 257, 35, 35);
		add(btnCiudad[42]);

		btnCiudad[43] = new JButton("TemploMedialuna");
		btnCiudad[43].setBounds(968, 568, 35, 35);
		add(btnCiudad[43]);

		btnCiudad[44] = new JButton("ValleTitum");
		btnCiudad[44].setBounds(1086, 539, 35, 35);
		add(btnCiudad[44]);

		btnCiudad[45] = new JButton("Miuquuu");
		btnCiudad[45].setBounds(1213, 550, 35, 35);
		add(btnCiudad[45]);

		btnCiudad[46] = new JButton("Cantusa");
		btnCiudad[46].setBounds(1251, 374, 35, 35);
		add(btnCiudad[46]);

		btnCiudad[47] = new JButton("PilaKu");
		btnCiudad[47].setBounds(1289, 453, 35, 35);
		add(btnCiudad[47]);

		for (int i = 0; i < 47; i++) {
		    btnCiudad[i].addActionListener(this);
		}
	
	}

	private void InitFondo() {
		setOpaque(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		ImageIcon imagen = new ImageIcon("img/Worldmap_1920.png");

		Image imgEscalada = imagen.getImage().getScaledInstance(screenSize.width, screenSize.height,
				Image.SCALE_SMOOTH);
		ImageIcon imagenEscalada = new ImageIcon(imgEscalada);

		JLabel fondoLabel = new JLabel(imagenEscalada);
		fondoLabel.setBounds(0, 10, screenSize.width, screenSize.height); // Posicionamos el fondoLabel para cubrir todo
		setOpaque(true); // el panel.

		add(fondoLabel);

		setVisible(true);
	}

	private String mostrarPopupDificultad() {
		String[] opcionesDificultad = { "Facil", "Normal", "Dificil" };
		String dificultadSeleccionada = (String) JOptionPane.showInputDialog(this, "Seleccione la dificultad:",
				"Selección de Dificultad", JOptionPane.QUESTION_MESSAGE, null, opcionesDificultad,
				opcionesDificultad[0]);
		if (dificultadSeleccionada != null) {
			System.out.println("Dificultad seleccionada: " + dificultadSeleccionada);
		}
		return dificultadSeleccionada;
	}

	private void InitComponentes() {
		btnComponentes = new JButton[4];
		Paneltxt = new JLabel[4];
		ProgressBar = new JProgressBar[4];

		btnComponentes[1] = new JButton("Craftear");
		btnComponentes[1].setBounds(823, 691, 144, 56);
		btnComponentes[1].setToolTipText("Crafetar nos ayuda a augmentar el progresso del arma, consume 4 acciones");
		add(btnComponentes[1]);
		btnComponentes[1].addActionListener(this);

		btnComponentes[2] = new JButton("Ajustes");
		btnComponentes[2].setBounds(1463, 48, 48, 48);
		btnComponentes[2].setToolTipText("Nos muestra un panel para guardar la partido o/i salir del juego");
		add(btnComponentes[2]);
		btnComponentes[2].addActionListener(this);

		btnComponentes[3] = new JButton("Siguiente Turno");
		btnComponentes[3].setBounds(1009, 691, 144, 56);
		btnComponentes[3].setToolTipText("Saltamos el turno actual y passamos en la siguiente, se descubren nuevas infeccioens y se nos renuevan las acciones");
		add(btnComponentes[3]);
		btnComponentes[3].addActionListener(this);

		ProgressBar[0] = new JProgressBar();
		ProgressBar[0].setValue(partida.getNivelVacuna("Corazon de Vell"));
		ProgressBar[0].setForeground(Color.BLUE);
		ProgressBar[0].setStringPainted(true);
		ProgressBar[0].setBounds(10, 296, 239, 30);
		add(ProgressBar[0]);

		ProgressBar[1] = new JProgressBar();
		ProgressBar[1].setValue(partida.getNivelVacuna("Dandelion"));
		ProgressBar[1].setForeground(Color.GREEN);
		ProgressBar[1].setStringPainted(true);
		ProgressBar[1].setBounds(10, 336, 239, 30);
		add(ProgressBar[1]);

		ProgressBar[2] = new JProgressBar();
		ProgressBar[2].setValue(partida.getNivelVacuna("Kzarka"));
		ProgressBar[2].setForeground(new Color(128, 64, 64));
		ProgressBar[2].setStringPainted(true);
		ProgressBar[2].setBounds(10, 376, 239, 30);
		add(ProgressBar[2]);

		ProgressBar[3] = new JProgressBar();
		ProgressBar[3].setValue(partida.getNivelVacuna("Kutum"));
		ProgressBar[3].setForeground(new Color(0, 0, 0));
		ProgressBar[3].setStringPainted(true);
		ProgressBar[3].setBounds(10, 416, 239, 30);
		add(ProgressBar[3]);

		Paneltxt[1] = new JLabel("Progreso Armas");
		Paneltxt[1].setFont(new Font("Tahoma", Font.PLAIN, 19));
		Paneltxt[1].setText("   Progreso Armas");
		Paneltxt[1].setBounds(10, 250, 190, 46);
		add(Paneltxt[1]);

		Paneltxt[0] = new JLabel("Brotes");
		Paneltxt[0].setFont(new Font("Tahoma", Font.PLAIN, 28));
		Paneltxt[0].setBounds(804, 93, 308, 56);
		Paneltxt[0].setText("Brotes Totales = " + partida.getBrotes());
		add(Paneltxt[0]);

		Paneltxt[2] = new JLabel("Historial");
		Paneltxt[2].setFont(new Font("Tahoma", Font.PLAIN, 28));
		Paneltxt[2].setBounds(1290, 547, 260, 56);
		add(Paneltxt[2]);

		Paneltxt[3] = new JLabel("Turno: ");
		Paneltxt[3].setFont(new Font("Tahoma", Font.PLAIN, 28));
		Paneltxt[3].setBounds(1316, 61, 260, 56);
		Paneltxt[3].setText(("Turno: " + partida.getRondas()));
		add(Paneltxt[3]);

		consola = new JTextArea();
		consola.setBackground(Color.DARK_GRAY);
		consola.setText("Bienvenidos al juego\r\n");
		consola.setFont(new Font("Courier New", Font.PLAIN, 12));
		consola.setForeground(Color.GREEN);
		consola.setBounds(1167, 613, 369, 162);
		add(consola);
	}
}