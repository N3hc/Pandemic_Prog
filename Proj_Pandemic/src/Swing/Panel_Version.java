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
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

public class Panel_Version extends JPanel implements ActionListener {

	Button Boton[];

	public Panel_Version() {
		reproducirMusica();
		setLayout(null);
		setBounds(0, 0, 1550, 775);

		Boton = new Button[7];
		String[] nombres = { "Nueva Partida", "Cargar Partida", "Información", "Resumen de puntuaciones", "Autores",
				"Versión", "Salir" };
		for (int i = 0; i < 7; i++) {
			Boton[i] = new Button(nombres[i]);
			add(Boton[i]);
		}

		Boton[0].setBounds(685, 295, 170, 50);
		add(Boton[0]);

		Boton[1].setBounds(685, 355, 170, 50);
		add(Boton[1]);

		Boton[2].setBounds(685, 415, 170, 50);
		add(Boton[2]);

		Boton[3].setBounds(685, 475, 170, 50);
		add(Boton[3]);

		Boton[4].setBounds(685, 535, 170, 50);
		add(Boton[4]);

		Boton[5].setBounds(685, 595, 170, 50);
		add(Boton[5]);

		Boton[6].setBounds(685, 655, 170, 50);
		add(Boton[6]);

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
	
    private void reproducirMusica() {
    	String filePath = "C:\\Users\\chenp\\Documents\\GitHub\\Pandemic_Prog\\Mapa_Pandemic\\SoundTrack.mp3";
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