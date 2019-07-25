package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Aplicacion;
import Logico.Cliente;
import Logico.User;
import img.ImagenFondoPrincipal;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel border;
	private JTextField txtusuario;
	private JPasswordField txtpass;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream tienda;
				FileOutputStream tienda2;
				ObjectInputStream tiendaLectura;
				ObjectOutputStream tiendaEscritura;
				try {
					tienda= new FileInputStream ("tienda.dat");
					tiendaLectura = new ObjectInputStream(tienda);
					Aplicacion temp = (Aplicacion)tiendaLectura.readObject();
					Aplicacion.setInstance(temp);
					tienda.close();
					tiendaLectura.close();
				} catch (FileNotFoundException e) {
					try {
						tienda2 = new  FileOutputStream("tienda.dat");
						tiendaEscritura = new ObjectOutputStream(tienda2);
						User aux = new User("Administrador", "Admin", "Admin");
						Aplicacion.getInstance().regUser(aux);
						tiendaEscritura.writeObject(Aplicacion.getInstance());
						tienda2.close();
						tiendaEscritura.close();
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				} catch (IOException e) {
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 441, 314);
		border = new JPanel();
		border.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(border);
		border.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Username");
		lblUsuario.setBounds(38, 57, 74, 20);
		border.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(43, 112, 69, 20);
		border.add(lblPassword);
		
		txtusuario = new JTextField();
		txtusuario.setBounds(138, 54, 146, 26);
		border.add(txtusuario);
		txtusuario.setColumns(10);
		
		
		
		
		JButton btnAcceder = new JButton("Acceder");
		btnAcceder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					
					
					
				}
			});
		
		btnAcceder.setBounds(87, 180, 115, 29);
		border.add(btnAcceder);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		btnSalir.setBounds(229, 180, 115, 29);
		border.add(btnSalir);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(138, 109, 146, 26);
		border.add(txtpass);
			
	}
}
	

