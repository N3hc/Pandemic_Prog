package Swing;

import javax.swing.*;

import Func_Partida.DatosPartida;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Panel_Partida extends JPanel implements ActionListener{

	JButton[] btnCiudad;
	JButton[] btnComponentes;
	JLabel PanelBrotes;
	int cosa = 1;
	JTextField txtProgresoInvasiones;

	DatosPartida partida = new DatosPartida();
	
	public Panel_Partida() {
		
		setLayout(null);
		setBounds(0, 0, 1550, 775);
		InitComponentes();
		InitCiudadesBtn();
		InitFondo();
		
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
		fondoLabel.setText("Hola");
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
		btnComponentes = new JButton[5];

		btnComponentes[0] = new JButton("Campeones");
		btnComponentes[0].setBounds(1040, 691, 144, 56);
		add(btnComponentes[0]);
		btnComponentes[0].addActionListener(this);

		btnComponentes[1] = new JButton("Craftear");
		btnComponentes[1].setBounds(840, 691, 144, 56);
		add(btnComponentes[1]);
		btnComponentes[1].addActionListener(this);
		
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

		TextField textField = new TextField();
		textField.setText("Progreso Armas");
		textField.setEditable(false);
		textField.setBounds(10, 258, 107, 21);
		add(textField);
		
		PanelBrotes = new JLabel("New label");
		PanelBrotes.setBounds(804, 93, 190, 38);
		PanelBrotes.setText("Brotes Totales = " + partida.getBrotes());
		add(PanelBrotes);

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

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnComponentes[0]) {
			partida.setBrotes(1);
			System.out.println(partida.getBrotes());
			PanelBrotes.setText("Brotes Totales = " + partida.getBrotes());
			
		}
	}
}