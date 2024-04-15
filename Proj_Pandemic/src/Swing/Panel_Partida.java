package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Panel_Partida extends JPanel {

	private final JButton btnNewButton = new JButton("New button");

	public Panel_Partida() {
		setLayout(null);
		setBounds(0, 0, 1550, 775);
		InitComponentes();
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
		fondoLabel.setBounds(0, 0, screenSize.width, screenSize.height); // Posicionamos el fondoLabel para cubrir todo
		setOpaque(true);															// el panel.

		add(fondoLabel); // Agregamos el fondoLabel al panel.
		setVisible(true);
	}
	
	private void InitComponentes() {

		JTextArea textArea = new JTextArea();
		textArea.setForeground(new Color(255, 255, 255));
		textArea.setBackground(Color.DARK_GRAY);
		textArea.setBounds(1246, 598, 294, 177);
		add(textArea);

		JButton btn1 = new JButton("Campeones");
		btn1.setBounds(1052, 690, 144, 56);
		add(btn1);

		JButton btn2 = new JButton("Craftear");
		btn2.setBounds(871, 690, 144, 56);
		add(btn2);

		JButton btn3 = new JButton("Matar");
		btn3.setBounds(679, 690, 144, 56);
		add(btn3);

		JButton btnAjustes = new JButton("Ajustes");
		btnAjustes.setBounds(1437, 31, 85, 74);
		add(btnAjustes);

		JProgressBar tritones_progressBar = new JProgressBar();
		tritones_progressBar.setValue(50);
		tritones_progressBar.setForeground(Color.BLUE);
		tritones_progressBar.setStringPainted(true);
		tritones_progressBar.setBounds(10, 296, 239, 50);
		add(tritones_progressBar);

		JProgressBar manshaum_progressBar = new JProgressBar();
		manshaum_progressBar.setValue(50);
		manshaum_progressBar.setForeground(Color.GREEN);
		manshaum_progressBar.setStringPainted(true);
		manshaum_progressBar.setBounds(10, 363, 239, 50);
		add(manshaum_progressBar);

		JProgressBar goblin_progressBar = new JProgressBar();
		goblin_progressBar.setValue(50);
		goblin_progressBar.setForeground(new Color(128, 64, 64));
		goblin_progressBar.setStringPainted(true);
		goblin_progressBar.setBounds(10, 430, 239, 50);
		add(goblin_progressBar);

		JProgressBar momias_progressBar = new JProgressBar();
		momias_progressBar.setValue(50);
		momias_progressBar.setForeground(new Color(0, 0, 0));
		momias_progressBar.setStringPainted(true);
		momias_progressBar.setBounds(10, 498, 239, 50);
		add(momias_progressBar);
		
	}
}