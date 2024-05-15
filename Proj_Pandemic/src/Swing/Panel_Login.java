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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;

public class Panel_Login extends JPanel implements ActionListener{
	
	private JPasswordField passwordField;
	private JTextField textField;
	private static String user;
	
	JButton[] Boton;
	//Getter y Setter
	
	/**
	 * Getters
	 * @return
	 */
	public static String getUser() {
		return user;
	}
	/**
	 * Setters
	 * @return
	 */
	public void setUser(String nombre) {
		user = nombre;
	}
	/**
	 * Panel de texto con los objetros pertinentes
	 */
	public Panel_Login(){
		Boton = new JButton[3];
		setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(132, 128, 285, 40);
		add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(132, 60, 285, 40);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 61, 112, 40);
		add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Contraseña:");
		lblPassword.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lblPassword.setBounds(10, 129, 127, 40);
		add(lblPassword);
		
		Boton[0] = new JButton("Iniciar Session");
		Boton[0].setBounds(269, 216, 210, 50);
		add(Boton[0]);
		Boton[0].addActionListener(this);
		
		Boton[1] = new JButton("Crear Cuenta");
		Boton[1].setBounds(21, 216, 210, 50);
		add(Boton[1]);
		Boton[1].addActionListener(this);
		
		setVisible(true);
	}
	
	
	@Override
	/**
	 * Action listener con las acciones correspondientes al momento de apretar el boton
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == Boton[0]) {
			setUser(textField.getText());
			System.out.println(getUser());
	        char[] passwordChars = passwordField.getPassword();
	        String password = new String(passwordChars);
	        if (IniciarSession(getUser(),password)) {
	    		JOptionPane.showMessageDialog(this, "Has Iniciado Sesión CORRECTAMENTE", "Login",
	    				JOptionPane.INFORMATION_MESSAGE);
				JFrame MenuPrincipal = (JFrame) SwingUtilities.getWindowAncestor(this);
				MenuPrincipal.getContentPane().removeAll();
				MenuPrincipal.getContentPane().add(new Panel_Menu_Principal());
				MenuPrincipal.getContentPane().validate();
				MenuPrincipal.getContentPane().repaint();
				MenuPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
	        } else if(comprobarCuenta(getUser())) {
	    		JOptionPane.showMessageDialog(this, "Contraseña INCORRECTA", "Login",
	    				JOptionPane.INFORMATION_MESSAGE);
				JFrame PanelLogin = (JFrame) SwingUtilities.getWindowAncestor(this);
				PanelLogin.getContentPane().removeAll();
				PanelLogin.getContentPane().add(new Panel_Login());
				PanelLogin.getContentPane().validate();
				PanelLogin.getContentPane().repaint();
	        }else {
	    		JOptionPane.showMessageDialog(this, "Usuario inexistente", "Login",
	    				JOptionPane.INFORMATION_MESSAGE);
				JFrame PanelLogin = (JFrame) SwingUtilities.getWindowAncestor(this);
				PanelLogin.getContentPane().removeAll();
				PanelLogin.getContentPane().add(new Panel_Login());
				PanelLogin.getContentPane().validate();
				PanelLogin.getContentPane().repaint();
	        }
		}
		if (e.getSource() == Boton[1]) {
			user = textField.getText();
	        char[] passwordChars = passwordField.getPassword();
	        String password = new String(passwordChars);
			if(CrearCuenta(user,password)) {
	    		JOptionPane.showMessageDialog(this, "Se ha creado la cuenta CORRECTAMENTE", "Login",
	    				JOptionPane.INFORMATION_MESSAGE);
	    		Connection con = bbdd.conectarBaseDatos();
	    		bbdd.insert(con, "INSERT INTO JUGADOR (\"NICKNAME\", \"PASSWORD\")\n" + "VALUES ('" + user+"',"+
	    				"'"+ password + "')");
	    	
			}else {
	    		JOptionPane.showMessageDialog(this, "Usuario ya existente", "Login",
	    				JOptionPane.INFORMATION_MESSAGE);	
			}
		}

	}
	/**
	 * Funcion de iniciar session en la cual mira si ese usuario con esa contraseña existe
	 * @param NICKNAME
	 * @param PASSWORD
	 * @return
	 */
	public boolean IniciarSession (String NICKNAME, String PASSWORD) {
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
	/**
	 * Funcion para comprobar si la cuenta existe
	 * @param NICKNAME
	 * @return
	 */
	public boolean comprobarCuenta (String NICKNAME) {
		String [] Select = new String [10];
		Connection con = bbdd.conectarBaseDatos();
		String[] listaElementosSeleccionados = { "COUNT(*)" };
		Select = bbdd.select(con, "SELECT COUNT(*) FROM jugador WHERE NICKNAME = '" + NICKNAME +"'", listaElementosSeleccionados);
		if (Select[0].equals("1")) {
		    return true;
		} else {
		    return false;
		}
	}
	/**
	 * Funcion para crear una cuenta inexistente en la base de datos
	 * @param NICKNAME
	 * @param PASSWORD
	 * @return
	 */
	public boolean CrearCuenta(String NICKNAME, String PASSWORD){
		String [] Select = new String [10];
		Connection con = bbdd.conectarBaseDatos();
		String[] listaElementosSeleccionados = { "COUNT(*)" };
		Select = bbdd.select(con, "SELECT COUNT(*) FROM JUGADOR WHERE NICKNAME = '"+ NICKNAME +"' and PASSWORD = '"+PASSWORD+"'", listaElementosSeleccionados);
		if (Select[0].equals("1")) {
		    return false;
		} else {
		    return true;
		}
	}

}
