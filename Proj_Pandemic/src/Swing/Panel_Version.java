package Swing;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

public class Panel_Version extends JPanel implements ActionListener {

	Button Boton;

	public Panel_Version() {
		setLayout(null);
		setBounds(0, 0, 1550, 775);
		

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(685, 295, 170, 50);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(685, 355, 170, 50);
		add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(685, 415, 170, 50);
		add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(685, 475, 170, 50);
		add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(685, 535, 170, 50);
		add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBounds(685, 595, 170, 50);
		add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setBounds(685, 655, 170, 50);
		add(btnNewButton_6);

		
		InitFondo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

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
}