package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Aplicacion;
import Logico.Cliente;
import Logico.User;
import img.Fondologin;
import img.ImagenFondoPrincipal;
import sun.security.jca.GetInstance;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel border;
	private JTextField txtusuario;
	private JPasswordField txtpass;
	private Image fondo;
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
					tienda= new FileInputStream ("Electronica.dat");
					tiendaLectura = new ObjectInputStream(tienda);
					Aplicacion temp = (Aplicacion)tiendaLectura.readObject();
					Aplicacion.setInstance(temp);
					tienda.close();
					
				} catch (FileNotFoundException e) {
					try {
						tienda2 = new  FileOutputStream("Electronica.dat");
						tiendaEscritura = new ObjectOutputStream(tienda2);
						User aux = new User("Administrador", "admin", "admin");
						Aplicacion.getInstance().regUser(aux);
						tiendaEscritura.writeObject(Aplicacion.getInstance());
						tienda2.close();
						System.out.println("FUnciona");
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
		
		Fondologin L = new Fondologin("/img/imagenlogin.jpg");
		setIconImage(new ImageIcon(getClass().getResource("/img/carritocompra.png")).getImage());

		
		
		setTitle("Login");

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 389, 489);
		border = new JPanel();
		border.setForeground(new Color(255, 255, 255));
		border.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(border);
		border.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblUsuario = new JLabel("Username");
		lblUsuario.setBounds(27, 166, 74, 20);
		border.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(32, 248, 69, 20);
		border.add(lblPassword);
		
		txtusuario = new JTextField();
		txtusuario.setBounds(111, 163, 199, 26);
		border.add(txtusuario);
		txtusuario.setColumns(10);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(111, 245, 199, 26);
		border.add(txtpass);
		txtpass.setColumns(10);
		
		
		
		JButton btnAcceder = new JButton("Acceder");
		btnAcceder.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
					
					
					if(Aplicacion.getInstance().confirmLogin(txtusuario.getText(),txtpass.getText())){
						ImagenFondoPrincipal p = new ImagenFondoPrincipal("/img/Fondo.jpeg");// Ruta de la imagen de fondo
						Principal frame = new Principal();
						dispose();
						frame.setVisible(true);
						frame.getContentPane().add(p);
					}
					
					else {
						
						JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
			                    + "Por favor ingrese un usuario y/o contraseña correctos", "Acceso denegado",
			                    JOptionPane.ERROR_MESSAGE);
						
						
					}
				}
			});
		
		btnAcceder.setBounds(34, 350, 115, 29);
		border.add(btnAcceder);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		btnSalir.setBounds(194, 350, 115, 29);
		border.add(btnSalir);
		
		
			
	}
}
	

