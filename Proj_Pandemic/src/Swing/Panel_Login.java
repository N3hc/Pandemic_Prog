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
import javax.swing.JDialog;

public class Panel_Login extends JPanel implements ActionListener{
	
	private JPasswordField passwordField;
	private JTextField textField;
	
	JButton[] Boton;

	Panel_Login(){
		Boton = new JButton[2];
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
		
		Boton[0] = new JButton("Acceptar");
		Boton[0].setBounds(269, 216, 210, 50);
		add(Boton[0]);
		Boton[0].addActionListener(this);
		
		Boton[1] = new JButton("Crear Cuenta");
		Boton[1].setBounds(21, 216, 210, 50);
		add(Boton[1]);
		Boton[1].addActionListener(this);
		
		
	}
	
	public void panelNuevaSession() {

		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
		// Crear y mostrar el JDialog con las opciones
		JDialog dialog = new JDialog(frame, "Sign Up", true); // true para hacerlo modal
		dialog.getContentPane().setLayout(null);
		dialog.setSize(300, 300);
		dialog.setLocationRelativeTo(null);

		
		dialog.setVisible(true);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		if (e.getSource() == Boton) {
//			String user = textField.getText();
//	        char[] passwordChars = passwordField.getPassword();
//	        String password = new String(passwordChars);
//	        if (compr(user,password)) {
//				JFrame MenuPrincipal = (JFrame) SwingUtilities.getWindowAncestor(this);
//				MenuPrincipal.getContentPane().removeAll();
//				MenuPrincipal.getContentPane().add(new Panel_Menu_Principal());
//				MenuPrincipal.revalidate();
//				MenuPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
//	        } else {
//				JFrame MenuPrincipal = (JFrame) SwingUtilities.getWindowAncestor(this);
//				MenuPrincipal.getContentPane().removeAll();
//				MenuPrincipal.getContentPane().add(new Panel_Login());
//				MenuPrincipal.revalidate();
////				MenuPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
//	        }
//	        
//
//		}
	}
	
//	public boolean compr (String NICKNAME, String PASSWORD) {
//		String [] Select = new String [10];
//		Connection con = bbdd.conectarBaseDatos();
//		String a = "SELECT COUNT(*) FROM JUGADOR WHERE NICKNAME = '"+ NICKNAME +"' and PASSWORD = '"+PASSWORD+"'";
//		System.out.println(a);
//		String[] listaElementosSeleccionados = { "COUNT(*)" };
//		Select = bbdd.select(con, "SELECT COUNT(*) FROM JUGADOR WHERE NICKNAME = '"+ NICKNAME +"' and PASSWORD = '"+PASSWORD+"'", listaElementosSeleccionados);
//		System.out.println(Select[0]);
//		if (Select[0].equals("1")) {
//		    return true;
//		} else {
//		    return false;
//		}
//	}
}
