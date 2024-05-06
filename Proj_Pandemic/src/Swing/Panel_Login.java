package Swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Button;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import Func_Partida.bbdd;

import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Panel_Login extends JPanel implements ActionListener{
	
	private JPasswordField passwordField;
	private JTextField textField;
	
	JButton Boton;

	Panel_Login(){
		setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(132, 128, 285, 40);
		add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(132, 60, 285, 40);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("USER:");
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lblNewLabel.setBounds(64, 61, 112, 40);
		add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lblPassword.setBounds(10, 129, 127, 40);
		add(lblPassword);
		
		Boton = new JButton("Acceptar");
		Boton.setBounds(114, 210, 169, 48);
		add(Boton);
		Boton.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == Boton) {
			String user = textField.getText();
	        char[] passwordChars = passwordField.getPassword();
	        String password = new String(passwordChars);
	        if (compr(user,password)) {
				JFrame MenuPrincipal = (JFrame) SwingUtilities.getWindowAncestor(this);
				MenuPrincipal.getContentPane().removeAll();
				MenuPrincipal.getContentPane().add(new Panel_Menu_Principal());
				MenuPrincipal.revalidate();
				MenuPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
	        } else {
				JFrame MenuPrincipal = (JFrame) SwingUtilities.getWindowAncestor(this);
				MenuPrincipal.getContentPane().removeAll();
				MenuPrincipal.getContentPane().add(new Panel_Login());
				MenuPrincipal.revalidate();
//				MenuPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
	        }
	        

		}
	}
	
	public boolean compr (String NICKNAME, String PASSWORD) {
		String [] Select = new String [10];
		Connection con = bbdd.conectarBaseDatos();
		String[] listaElementosSeleccionados = { "COUNT(*)" };
		Select = bbdd.select(con, "SELECT COUNT(*) FROM JUGADOR WHERE NICKNAME = '"+ NICKNAME +"' and PASSWORD = '"+PASSWORD+"'", listaElementosSeleccionados);
		if (Select[0].equals("1")) {
		    return true;
		} else {
		    return false;
		}
	}
}
