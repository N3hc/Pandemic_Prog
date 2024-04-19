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
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class Panel_Version extends JPanel implements ActionListener {

    Button Boton;

    public Panel_Version() {
        // true para hacerlo modal
        setSize(300, 300);
        
        JPanel dialog = new JPanel();
        dialog.setSize(300, 300);
        dialog.setLayout(null);
        
        JLabel lblCosa = new JLabel("Cosa");
        lblCosa.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblCosa.setBounds(10, 10, 280, 46);
        dialog.add(lblCosa);
        
        JLabel nombreInvasor = new JLabel("Invasor: ");
        nombreInvasor.setFont(new Font("Tahoma", Font.PLAIN, 18));
        nombreInvasor.setBounds(10, 64, 175, 46);
        dialog.add(nombreInvasor);
        
        JLabel nivelConquista = new JLabel("Nivel Conquista: ");
        nivelConquista.setFont(new Font("Tahoma", Font.PLAIN, 18));
        nivelConquista.setBounds(10, 120, 175, 46);
        dialog.add(nivelConquista);
        
        JButton btnMatar = new JButton("Matar");
        btnMatar.setBounds(10, 200, 120, 50);
        dialog.add(btnMatar);
        
        JButton btnConquistar = new JButton("Conquistar");
        btnConquistar.setBounds(140, 200, 120, 50);
        dialog.add(btnConquistar);

        dialog.add(btnMatar);
        dialog.add(btnConquistar);
        
        

        dialog.setVisible(true);
        
    }
//    	setLayout(null);
//    	
//    	JPanel panel = new JPanel();
//    	panel.setBounds(124, 53, 166, 212);
//    	add(panel);
//    	panel.setLayout(null);
//    	
//    	JLabel lblNewLabel = new JLabel("Nombre Ciudad");
//    	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
//    	lblNewLabel.setBounds(10, -1, 175, 46);
//    	panel.add(lblNewLabel);
//    	
//    	JButton btnNewButton = new JButton("New button");
//    	btnNewButton.setBounds(0, 153, 86, 59);
//    	panel.add(btnNewButton);
//    	
//    	JButton btnNewButton_1 = new JButton("New button");
//    	btnNewButton_1.setBounds(80, 153, 86, 59);
//    	panel.add(btnNewButton_1);
//    	
//    	JLabel lblNewLabel_1 = new JLabel("Infeccion Ciudad :");
//    	lblNewLabel_1.setBounds(10, 44, 146, 24);
//    	panel.add(lblNewLabel_1);
//    	
//    	JLabel lblNewLabel_2 = new JLabel("Nivel Infeccion");
//    	lblNewLabel_2.setBounds(10, 78, 99, 22);
//    	panel.add(lblNewLabel_2);
//    	
//    	JLabel lblNewLabel_3 = new JLabel("Estancia Campeon");
//    	lblNewLabel_3.setBounds(10, 110, 86, 13);
//    	panel.add(lblNewLabel_3);



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Boton) {
            JFrame menu_principal = (JFrame) SwingUtilities.getWindowAncestor(this);
            menu_principal.remove(this);
            menu_principal.getContentPane().add(new Panel_Menu_Principal());
            menu_principal.setVisible(true);
        }
    }
}