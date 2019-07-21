package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Aplicacion;
import Logico.Cliente;
import Logico.Registrarusuario;
import img.ImagenFondoPrincipal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
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
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
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
		
		
		
		
		JButton btnAcceder = new JButton("acceder");
		btnAcceder.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
		Registrarusuario registro=null;
				String username  = txtusuario.getText();
				String contrasena = txtpass.getText();
				registro = new Registrarusuario(contrasena, username);
				
		
				if (txtusuario.getText().equalsIgnoreCase("jeremy") && txtpass.getText().equalsIgnoreCase("admin")){
                    JOptionPane.showMessageDialog(null, "Bienvenido\n"
                    + "Has ingresado satisfactoriamente al sistema",   "Mensaje de bienvenida",
                    JOptionPane.INFORMATION_MESSAGE);


                    Principal principal1 = new Principal();

                    principal1.setVisible(true);


            }else {
      
                     	
            	JOptionPane.showMessageDialog(null, "Acceso denegado", "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
            }
				
				
				
				
			
			}
		});
		btnAcceder.setBounds(235, 187, 115, 29);
		border.add(btnAcceder);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Registrousuario registrousuario = new Registrousuario();
				registrousuario.setLocationRelativeTo(null);
				registrousuario.setVisible(true);
				
				
				
			}
		});
		btnRegistrarse.setBounds(83, 187, 115, 29);
		border.add(btnRegistrarse);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(138, 109, 146, 26);
		border.add(txtpass);
	}
}
