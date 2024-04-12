package Swing
;import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class Panel_Partida extends JPanel {

    public Panel_Partida() {
        setBackground(Color.WHITE);
        setLayout(null); // Desactivamos el layout para poder posicionar los componentes manualmente
        JLabel label = new JLabel("Panel de Nueva Partida");
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(0, 100, 800, 50); // Posicionamos el label en el centro horizontalmente
        
        add(label);
    }

}
