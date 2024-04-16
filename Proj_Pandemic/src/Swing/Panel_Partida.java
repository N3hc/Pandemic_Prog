package Swing;

import javax.swing.*;


import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Panel_Partida extends JPanel {

	JButton[] btnCiudad;
	private JTextField txtProgresoInvasiones;

	public Panel_Partida() {
		setLayout(null);
		setBounds(0, 0, 1550, 775);
		InitComponentes();
		InitCiudadesBtn();
		InitFondo();

	}

	private void InitFondo() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		ImageIcon imagen = new ImageIcon(
				"C:\\Users\\chenp\\Documents\\GitHub\\Pandemic_Prog\\Mapa_Pandemic\\Worldmap_1550.png");

		Image imgEscalada = imagen.getImage().getScaledInstance(screenSize.width, screenSize.height,
				Image.SCALE_SMOOTH);
		ImageIcon imagenEscalada = new ImageIcon(imgEscalada);

		JLabel fondoLabel = new JLabel(imagenEscalada);
		fondoLabel.setBounds(0, 10, screenSize.width, screenSize.height); // Posicionamos el fondoLabel para cubrir todo
		setOpaque(true); // el panel.

		add(fondoLabel);
		
		JButton btnLog = new JButton("Log");
		btnLog.setBounds(1275, 691, 144, 56);
		add(btnLog);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(30, 60, 46, 46);
		add(btnNewButton);
		
		setVisible(true);
	}

	private void InitComponentes() {

		JButton btn1 = new JButton("Campeones");
		btn1.setBounds(1040, 691, 144, 56);
		add(btn1);

		JButton btn2 = new JButton("Craftear");
		btn2.setBounds(840, 691, 144, 56);
		add(btn2);

		JButton btn3 = new JButton("Matar");
		btn3.setBounds(640, 691, 144, 56);
		add(btn3);
		
		JButton btnLog = new JButton("Log");
		btnLog.setBounds(1240, 691, 144, 56);
		add(btnLog);

		JButton btnAjustes = new JButton("Ajustes");
		btnAjustes.setBounds(1437, 31, 85, 74);
		add(btnAjustes);

		JProgressBar tritones_progressBar = new JProgressBar();
		tritones_progressBar.setValue(50);
		tritones_progressBar.setForeground(Color.BLUE);
		tritones_progressBar.setStringPainted(true);
		tritones_progressBar.setBounds(10, 296, 239, 30);
		add(tritones_progressBar);

		JProgressBar manshaum_progressBar = new JProgressBar();
		manshaum_progressBar.setValue(50);
		manshaum_progressBar.setForeground(Color.GREEN);
		manshaum_progressBar.setStringPainted(true);
		manshaum_progressBar.setBounds(10, 336, 239, 30);
		add(manshaum_progressBar);

		JProgressBar goblin_progressBar = new JProgressBar();
		goblin_progressBar.setValue(50);
		goblin_progressBar.setForeground(new Color(128, 64, 64));
		goblin_progressBar.setStringPainted(true);
		goblin_progressBar.setBounds(10, 376, 239, 30);
		add(goblin_progressBar);

		JProgressBar momias_progressBar = new JProgressBar();
		momias_progressBar.setValue(50);
		momias_progressBar.setForeground(new Color(0, 0, 0));
		momias_progressBar.setStringPainted(true);
		momias_progressBar.setBounds(10, 416, 239, 30);
		add(momias_progressBar);
		

		JProgressBar tritones_inectionbar = new JProgressBar();
		tritones_inectionbar.setMaximum(144);
		tritones_inectionbar.setValue(50);
		tritones_inectionbar.setForeground(Color.BLUE);
		tritones_inectionbar.setStringPainted(true);
		tritones_inectionbar.setBounds(1312, 651, 210, 30);
		add(tritones_inectionbar);
		
		JProgressBar manshaum_inectionbar = new JProgressBar();
		manshaum_inectionbar.setMaximum(144);
		manshaum_inectionbar.setStringPainted(true);
		manshaum_inectionbar.setValue(50);
		manshaum_inectionbar.setForeground(Color.GREEN);
		manshaum_inectionbar.setBounds(1312, 611, 210, 30);
		add(manshaum_inectionbar);
		
		JProgressBar goblin_inectionbar = new JProgressBar();
		goblin_inectionbar.setMaximum(144);
		goblin_inectionbar.setStringPainted(true);
		goblin_inectionbar.setValue(50);
		goblin_inectionbar.setForeground(new Color(128, 64, 64));
		goblin_inectionbar.setBounds(1312, 571, 210, 30);
		add(goblin_inectionbar);
		
		JProgressBar momias_inectionbar = new JProgressBar();
		momias_inectionbar.setMaximum(144);
		momias_inectionbar.setStringPainted(true);
		momias_inectionbar.setValue(50);
		momias_inectionbar.setForeground(new Color(0, 0, 0));
		momias_inectionbar.setBounds(1312, 531, 210, 30);
		add(momias_inectionbar);
		
		TextField textField = new TextField();
		textField.setText("Progreso Armas");
		textField.setEditable(false);
		textField.setBounds(10, 258, 107, 21);
		add(textField);
		
		TextField textField_1 = new TextField();
		textField_1.setText("Progreso Invasion enemiga");
		textField_1.setEditable(false);
		textField_1.setBounds(1328, 491, 166, 21);
		add(textField_1);
		
	}

	private void InitCiudadesBtn() {
		btnCiudad = new JButton[48];
		String[] nombres = { "Puerto Rath", "Isla Kuix", "Rosevan", "Trent", "Isla Khan", "Isla Paxid", "Isla Danton",
				"Isla Lisz", "Isla Lemma", "Isla Hiwua", "Cresta del Cuervo", "Ojo de Odquilla", "Isla Narvo",
				"Puerto Epheria", "Olvia", "Velia", "Castillo Cron", "Kusha", "Florin", "Finistella", "Calpheon",
				"Bosque Ceniza", "Grana", "Tunkuta", "Keplan", "Duvencrue", "Odyllita", "Cubil Escarlata", "Glish",
				"Heidel", "Bosque Tungrad", "Asparkan", "Tarif", "Altinova", "Ruinas de Kadry", "Ruinas de Waragon",
				"Templo Medialuna", "Bazar GranArena", "Shakatu", "Valle Bambu", "Minas de Sulfuro", "Valencia Ciudad",
				"Arehaza", "Cantusa", "Ibeilab Oasis", "Valle de Titum", "Miuquuu", "Pila Ku" };
	}
}

//private void InitCiudadesBtn() {
//JButton btnCiudad1 = new JButton("Puerto Rath");
//btnCiudad1.setBounds(40, 70, 40, 35);
//add(btnCiudad1);
//
//JButton btnCiudad2 = new JButton("Isla Kuix");
//btnCiudad2.setBounds(358, 171, 40, 35);
//add(btnCiudad2);
//
//JButton btnCiudad6 = new JButton("Rosevan");
//btnCiudad6.setBounds(816, 216, 40, 35);
//add(btnCiudad6);
//
//JButton btnCiudad7 = new JButton("Trent");
//btnCiudad7.setBounds(358, 594, 40, 35);
//add(btnCiudad7);
//
//JButton btnCiudad5 = new JButton("Isla Khan");
//btnCiudad5.setBounds(373, 80, 40, 35);
//add(btnCiudad5);
//
//JButton btnCiudad4 = new JButton("Isla Paxid");
//btnCiudad4.setBounds(358, 232, 40, 35);
//add(btnCiudad4);
//
//JButton btnCiudad3 = new JButton("Isla Danton");
//btnCiudad3.setBounds(287, 302, 40, 35);
//add(btnCiudad3);
//
//JButton btnCiudad9 = new JButton("Isla Lisz");
//btnCiudad9.setBounds(421, 250, 40, 35);
//add(btnCiudad9);
//
//JButton btnCiudad10 = new JButton("Isla Lemma");
//btnCiudad10.setBounds(510, 160, 40, 35);
//add(btnCiudad10);
//
//JButton btnCiudad11 = new JButton("Isla Hiwua");
//btnCiudad11.setBounds(679, 80, 40, 35);
//add(btnCiudad11);
//
//JButton btnCiudad12 = new JButton("Cresta del Cuervo");
//btnCiudad12.setBounds(752, 148, 40, 35);
//add(btnCiudad12);
//
//JButton btnCiudad13 = new JButton("Ojo de Odquilla");
//btnCiudad13.setBounds(652, 216, 40, 35);
//add(btnCiudad13);
//
//JButton btnCiudad14 = new JButton("Isla Narvo");
//btnCiudad14.setBounds(562, 232, 40, 35);
//add(btnCiudad14);
//
//JButton btnCiudad15 = new JButton("Puerto Epheria");
//btnCiudad15.setBounds(333, 418, 40, 35);
//add(btnCiudad15);
//
//JButton btnCiudad16 = new JButton("Olvia");
//btnCiudad16.setBounds(481, 347, 40, 35);
//add(btnCiudad16);
//
//JButton btnCiudad17 = new JButton("Velia");
//btnCiudad17.setBounds(562, 378, 40, 35);
//add(btnCiudad17);
//
//JButton btnCiudad18 = new JButton("Castillo Cron");
//btnCiudad18.setBounds(617, 347, 40, 35);
//add(btnCiudad18);
//
//JButton btnCiudad19 = new JButton("Kusha");
//btnCiudad19.setBounds(692, 376, 40, 35);
//add(btnCiudad19);
//
//JButton btnCiudad20 = new JButton("Florin");
//btnCiudad20.setBounds(456, 430, 40, 35);
//add(btnCiudad20);
//
//JButton btnCiudad21 = new JButton("Finistella");
//btnCiudad21.setBounds(275, 513, 40, 35);
//add(btnCiudad21);
//
//JButton btnCiudad22 = new JButton("Calpheon");
//btnCiudad22.setBounds(385, 504, 40, 35);
//add(btnCiudad22);
//
//JButton btnCiudad23 = new JButton("Bosque Ceniza");
//btnCiudad23.setBounds(238, 634, 40, 35);
//add(btnCiudad23);
//
//JButton btnCiudad24 = new JButton("Grana");
//btnCiudad24.setBounds(304, 730, 40, 35);
//add(btnCiudad24);
//
//JButton btnCiudad25 = new JButton("Tunkuta");
//btnCiudad25.setBounds(433, 708, 40, 35);
//add(btnCiudad25);
//
//JButton btnCiudad26 = new JButton("Keplan");
//btnCiudad26.setBounds(456, 573, 40, 35);
//add(btnCiudad26);
//
//JButton btnCiudad27 = new JButton("Duvencrue");
//btnCiudad27.setBounds(510, 644, 40, 35);
//add(btnCiudad27);
//
//JButton btnCiudad28 = new JButton("Odyllita");
//btnCiudad28.setBounds(562, 697, 40, 35);
//add(btnCiudad28);
//
//JButton btnCiudad29 = new JButton("Cubil Escarlata");
//btnCiudad29.setBounds(589, 594, 40, 35);
//add(btnCiudad29);
//
//JButton btnCiudad30 = new JButton("Glish");
//btnCiudad30.setBounds(548, 525, 40, 35);
//add(btnCiudad30);
//
//JButton btnCiudad31 = new JButton("Heidel");
//btnCiudad31.setBounds(589, 455, 40, 35);
//add(btnCiudad31);
//
//JButton btnCiudad32 = new JButton("Bosque Tungrad");
//btnCiudad32.setBounds(668, 513, 40, 35);
//add(btnCiudad32);
//
//JButton btnCiudad33 = new JButton("Asparkan");
//btnCiudad33.setBounds(775, 573, 40, 35);
//add(btnCiudad33);
//
//JButton btnCiudad34 = new JButton("Tarif");
//btnCiudad34.setBounds(718, 462, 40, 35);
//add(btnCiudad34);
//
//JButton btnCiudad35 = new JButton("Altinova");
//btnCiudad35.setBounds(775, 462, 40, 35);
//add(btnCiudad35);
//
//JButton btnCiudad36 = new JButton("Ruinas de Kadry");
//btnCiudad36.setBounds(816, 376, 40, 35);
//add(btnCiudad36);
//
//JButton btnCiudad37 = new JButton("Ruinas de Waragon");
//btnCiudad37.setBounds(861, 511, 40, 35);
//add(btnCiudad37);
//
//JButton btnCiudad38 = new JButton("Templo Medialuna");
//btnCiudad38.setBounds(962, 563, 40, 35);
//add(btnCiudad38);
//
//JButton btnCiudad39 = new JButton("Bazar GranArena");
//btnCiudad39.setBounds(903, 418, 40, 35);
//add(btnCiudad39);
//
//JButton btnCiudad40 = new JButton("Shakatu");
//btnCiudad40.setBounds(892, 296, 40, 35);
//add(btnCiudad40);
//
//JButton btnCiudad41 = new JButton("Valle Bambu");
//btnCiudad41.setBounds(962, 204, 40, 35);
//add(btnCiudad41);
//
//JButton btnCiudad42 = new JButton("Minas de Sulfuro");
//btnCiudad42.setBounds(1211, 105, 40, 35);
//add(btnCiudad42);
//
//JButton btnCiudad43 = new JButton("Valencia Ciudad");
//btnCiudad43.setBounds(1185, 271, 40, 35);
//add(btnCiudad43);
//
//JButton btnCiudad44 = new JButton("Arehaza");
//btnCiudad44.setBounds(1301, 250, 40, 35);
//add(btnCiudad44);
//
//JButton btnCiudad45 = new JButton("Cantusa");
//btnCiudad45.setBounds(1246, 369, 40, 35);
//add(btnCiudad45);
//
//JButton btnCiudad46 = new JButton("Ibeilab Oasis");
//btnCiudad46.setBounds(1040, 376, 40, 35);
//add(btnCiudad46);
//
//JButton btnCiudad48 = new JButton("Valle de Titum");
//btnCiudad48.setBounds(1082, 542, 40, 35);
//add(btnCiudad48);
//
//JButton btnCiudad47 = new JButton("Miuquuu");
//btnCiudad47.setBounds(1211, 553, 40, 35);
//add(btnCiudad47);
//
//JButton btnCiudad8 = new JButton("Pila Ku");
//btnCiudad8.setBounds(1287, 455, 40, 35);
//add(btnCiudad8);
//}