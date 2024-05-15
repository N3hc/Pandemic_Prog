package Swing;

import javax.swing.*;

import Func_Partida.DatosPartida;
import Func_Partida.Vacuna;
import Func_Partida.control_de_partida;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Panel_Partida_Cargada extends JPanel implements ActionListener {
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

	public Panel_Partida_Cargada() {
		setLayout(null);
        setBounds(0, 0, 1550, 775);
        InitComponentes();
        InitCiudadesBtn();
        InitFondo();
        partida.cargarDatos();
        cPartida.iniciarPartidaGuardada(partida);
        cPartida.gestionarTurno(partida, 1);
        generarIcono();
        generarVariables();
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
	
	public void volverMenuPrincipal() {
		JFrame partidaInit = (JFrame) SwingUtilities.getWindowAncestor(this);
		partidaInit.getContentPane().removeAll();
		partidaInit.getContentPane().add(new Panel_Menu_Principal());
		partidaInit.revalidate();
		partidaInit.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
				if(cPartida.estadoPej(partida, 0) && partida.getAcciones() > 0) {
					cPartida.gestionarHeroesAtc(partida, nombre);
					partida.setAcciones(partida.getAcciones() - 1);
				}
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
				if(cPartida.estadoPej(partida, 1) && partida.getAcciones() > 0) {
					cPartida.gestionarHeroeSup(partida, nombre);
					partida.setAcciones(partida.getAcciones() - 1);
				}
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
		guardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Acción a realizar cuando se hace clic en el botón
				cPartida.guardarPartida(partida);
				volverMenuPrincipal();
				dialog.dispose();
			}
		});
		dialog.getContentPane().add(guardar);
		
		JButton salir = new JButton("Salir del juego");
		salir.setBounds(0, 60, 150, 60);
		salir.setToolTipText("Salir del juego");
		salir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Acción a realizar cuando se hace clic en el botón
				volverMenuPrincipal();
				dialog.dispose();
			}
		});
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
		try {
		consola.append(datos + "\n");
		}catch (NullPointerException e) {
			System.out.println("NullPointer");
		}
	}

	public void actualizarDatos() {
		diferenciarInfeccion();
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
			cPartida.gestionarCura(partida);
			if (cPartida.ganarPartida(partida)) {
				JOptionPane.showMessageDialog(this, "Has GANADO!!!!!\n" +
						"Tu puntuaje total ha sido " + cPartida.calcularPuntuajeFinal(), "Ganaste", JOptionPane.INFORMATION_MESSAGE);
				cPartida.guardarPartida(partida);
				volverMenuPrincipal();
			}else{
				cPartida.gestionarTurno(partida, 1);
				actualizarDatos();
				if (cPartida.gestionarFinPartida(partida)) {
					JOptionPane.showMessageDialog(this, "Has perdidon\n"
							+ 						"Tu puntuaje total ha sido " + cPartida.calcularPuntuajeFinal(), "Perdiste", JOptionPane.INFORMATION_MESSAGE);
					volverMenuPrincipal();
					cPartida.guardarPartida(partida);
				}
			}
			;

		}

		for (int i = 0; i < nombres.length; i++) {
			if (e.getSource() == btnCiudad[i]) {
				String nCiudad = nombres[i];
				panelCiudad(nCiudad);
			}
		}
	}

	private void diferenciarInfeccion() {// Crea un ImageIcon con la imagen
		ImageIcon icono = new ImageIcon("img/gateway_0.png");
		ImageIcon icono1 = new ImageIcon("img/gateway_1.png");
		ImageIcon icono2 = new ImageIcon("img/gateway_2.png");
		ImageIcon icono3 = new ImageIcon("img/gateway_3.png");

		for (int i = 0; i < btnCiudad.length; i++) {
		    int nivelInfeccion = partida.getNivelInfeccionCiudad(nombres[i]);
		    ImageIcon iconoActual;
		    
		    if (i < 12) {
		        iconoActual = icono;
		    } else if (i < 24) {
		        iconoActual = icono1;
		    } else if (i < 36) {
		        iconoActual = icono2;
		    } else if (i < 48) {
		        iconoActual = icono3;
		    } else {
		        continue; // Si el índice es mayor o igual a 47, no hacer nada
		    }

		    if (nivelInfeccion == 0) {
		        // Escala el ImageIcon al tamaño del botón
		        Image imagenEscalada = iconoActual.getImage().getScaledInstance(15,15, Image.SCALE_SMOOTH);
		        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
		        btnCiudad[i].setIcon(iconoEscalado);
		    } else if (nivelInfeccion == 1) {
		        Image imagenEscalada = iconoActual.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
		        btnCiudad[i].setIcon(iconoEscalado);
		    } else if (nivelInfeccion == 2) {
		        Image imagenEscalada = iconoActual.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
		        btnCiudad[i].setIcon(iconoEscalado);
		    } else if (nivelInfeccion >= 3) {
		        Image imagenEscalada = iconoActual.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
		        btnCiudad[i].setIcon(iconoEscalado);
		    }
		}
}
	
	private void generarIcono() {
		diferenciarInfeccion();
		ImageIcon icono4 = new ImageIcon("img/Ajustes.png");


		btnComponentes[2].setIcon(icono4);
		btnComponentes[2].setText(null);
		btnCiudad[0].setText(null);
		btnCiudad[1].setText(null);
		btnCiudad[2].setText(null);
		btnCiudad[3].setText(null);
		btnCiudad[4].setText(null);
		btnCiudad[5].setText(null);
		btnCiudad[6].setText(null);
		btnCiudad[7].setText(null);
		btnCiudad[8].setText(null);
		btnCiudad[9].setText(null);
		btnCiudad[10].setText(null);
		btnCiudad[11].setText(null);
		btnCiudad[12].setText(null);
		btnCiudad[13].setText(null);
		btnCiudad[14].setText(null);
		btnCiudad[15].setText(null);
		btnCiudad[16].setText(null);
		btnCiudad[17].setText(null);
		btnCiudad[18].setText(null);
		btnCiudad[19].setText(null);
		btnCiudad[20].setText(null);
		btnCiudad[21].setText(null);
		btnCiudad[22].setText(null);
		btnCiudad[23].setText(null);
		btnCiudad[24].setText(null);
		btnCiudad[25].setText(null);
		btnCiudad[26].setText(null);
		btnCiudad[27].setText(null);
		btnCiudad[28].setText(null);
		btnCiudad[29].setText(null);
		btnCiudad[30].setText(null);
		btnCiudad[31].setText(null);
		btnCiudad[32].setText(null);
		btnCiudad[33].setText(null);
		btnCiudad[34].setText(null);
		btnCiudad[35].setText(null);
		btnCiudad[36].setText(null);
		btnCiudad[37].setText(null);
		btnCiudad[38].setText(null);
		btnCiudad[39].setText(null);
		btnCiudad[40].setText(null);
		btnCiudad[41].setText(null);
		btnCiudad[42].setText(null);
		btnCiudad[43].setText(null);
		btnCiudad[44].setText(null);
		btnCiudad[45].setText(null);
		btnCiudad[46].setText(null);
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


	private void InitComponentes() {
		btnComponentes = new JButton[4];
		Paneltxt = new JLabel[4];
		ProgressBar = new JProgressBar[4];

		btnComponentes[1] = new JButton("Investigar");
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
        JScrollPane scrollPane = new JScrollPane(consola);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(1167, 613, 369, 162);
		add(scrollPane);
	}
	
	private void generarVariables() {
		Vacunas = new String[4];
		int i = 0;
		for (Vacuna vacuna : partida.getVacunas()) {
			Vacunas[i] = vacuna.getArma();
			i++;
		}

	}
}