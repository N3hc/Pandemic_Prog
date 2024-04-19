package Swing;

import javax.swing.*;

import Func_Partida.DatosPartida;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Panel_Partida extends JPanel implements ActionListener{

	JButton[] btnCiudad;
	JButton[] btnComponentes;
	JLabel[] Paneltxt;
	int cosa = 1;
	JTextField txtProgresoInvasiones;

	DatosPartida partida = new DatosPartida(1);
	
	public Panel_Partida() {
		
		setLayout(null);
		setBounds(0, 0, 1550, 775);
		InitComponentes();
		InitCiudadesBtn();
		InitFondo();
		
	}

	private void InitCiudadesBtn() {
		btnCiudad = new JButton[48];
//		String[] nombres = { "Puerto Rath", "Isla Kuix", "Rosevan", "Trent", "Isla Khan", "Isla Paxid", "Isla Danton",
//				"Isla Lisz", "Isla Lemma", "Isla Hiwua", "Cresta del Cuervo", "Ojo de Odquilla", "Isla Narvo",
//				"Puerto Epheria", "Olvia", "Velia", "Castillo Cron", "Kusha", "Florin", "Finistella", "Calpheon",
//				"Bosque Ceniza", "Grana", "Tunkuta", "Keplan", "Duvencrue", "Odyllita", "Cubil Escarlata", "Glish",
//				"Heidel", "Bosque Tungrad", "Asparkan", "Tarif", "Altinova", "Ruinas de Kadry", "Ruinas de Waragon",
//				"Templo Medialuna", "Bazar GranArena", "Shakatu", "Valle Bambu", "Minas de Sulfuro", "Valencia Ciudad",
//				"Arehaza", "Cantusa", "Ibeilab Oasis", "Valle de Titum", "Miuquuu", "Pila Ku" };
	
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
		
	}
	
	private void InitFondo() {
		setOpaque(true);
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
		
		setVisible(true);
	}

	private void InitComponentes() {
		btnComponentes = new JButton[5];
		Paneltxt = new JLabel[2];

		btnComponentes[0] = new JButton("Campeones");
		btnComponentes[0].setBounds(1040, 691, 144, 56);
		add(btnComponentes[0]);
		btnComponentes[0].addActionListener(this);

		btnComponentes[1] = new JButton("Craftear");
		btnComponentes[1].setBounds(840, 691, 144, 56);
		add(btnComponentes[1]);
		btnComponentes[1].addActionListener(this);
		btnComponentes[1].setToolTipText("sad");
		
		btnComponentes[2] = new JButton("Matar");
		btnComponentes[2].setBounds(640, 691, 144, 56);
		add(btnComponentes[2]);
		btnComponentes[2].addActionListener(this);
		
		btnComponentes[3] = new JButton("Log");
		btnComponentes[3].setBounds(1240, 691, 144, 56);
		add(btnComponentes[3]);
		btnComponentes[3].addActionListener(this);
		
		btnComponentes[4] = new JButton("Ajustes");
		btnComponentes[4].setBounds(1437, 31, 85, 74);
		add(btnComponentes[4]);
		btnComponentes[4].addActionListener(this);
		
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

		Paneltxt[1] = new JLabel("Progreso Armas");
		Paneltxt[1].setText("Progreso Armas");
		Paneltxt[1].setBounds(10, 258, 107, 21);
		add(Paneltxt[1]);
		
		Paneltxt[0] = new JLabel("Brotes");
		Paneltxt[0].setBounds(804, 93, 190, 38);
		Paneltxt[0].setText("Brotes Totales = " + partida.getBrotes());
		add(Paneltxt[0]);
	}



	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnComponentes[0]) {
			partida.setBrotes(1);
			System.out.println(partida.getBrotes());
			Paneltxt[0].setText("Brotes Totales = " + partida.getBrotes());
			
		}
	}
}