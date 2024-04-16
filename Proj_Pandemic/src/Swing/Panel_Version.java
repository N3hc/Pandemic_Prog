package Swing;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Panel_Version extends JPanel implements ActionListener {

    Button Boton;

    public Panel_Version() {
    	setLayout(new GridBagLayout());
    	Boton = new Button("Salir");
    	GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(200, 0, 200, 0);
        add(Boton, gbc);
        Boton.addActionListener(this);
        setSize(100, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Boton) {
            JFrame menu_principal = (JFrame) SwingUtilities.getWindowAncestor(this);
            menu_principal.remove(this);
            menu_principal.add(new Panel_Menu_Principal());
            menu_principal.setVisible(true);
        }
    }
}