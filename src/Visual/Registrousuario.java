package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Aplicacion;
import Logico.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Registrousuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtContrasena;
	private JTextField txtConfirmar;

	public Registrousuario() {
		setTitle("Registro usuario");
		setIconImage(new ImageIcon(getClass().getResource("/img/carritocompra.png")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(25, 84, 146, 26);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewUsername = new JLabel("New Username");
		lblNewUsername.setBounds(47, 48, 107, 20);
		contentPane.add(lblNewUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(285, 48, 69, 20);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmarPassword = new JLabel("Confirmar Password");
		lblConfirmarPassword.setBounds(249, 145, 146, 20);
		contentPane.add(lblConfirmarPassword);
		
		JLabel lblTipoDeUsuario = new JLabel("Tipo de usuario:");
		lblTipoDeUsuario.setBounds(35, 145, 123, 20);
		contentPane.add(lblTipoDeUsuario);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Administracion ", "Cliente"}));
		comboBox.setBounds(25, 181, 146, 26);
		contentPane.add(comboBox);
		
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtConfirmar.getText().equalsIgnoreCase("")&& !txtContrasena.getText().equalsIgnoreCase("")&& txtConfirmar.getText().equalsIgnoreCase(txtContrasena.getText()) && !txtUsuario.getText().equalsIgnoreCase("") && comboBox.getSelectedIndex()!=0 ) {
				User u1=new User(comboBox.getSelectedItem().toString(), txtUsuario.getText(), txtContrasena.getText());
				Aplicacion.getInstance().regUser(u1);
				
				JOptionPane.showMessageDialog(null, "Registro Exitoso", "Registro exitoso",
	                    JOptionPane.INFORMATION_MESSAGE);
				dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Revise la informacion", "Validacion",
		                    JOptionPane.ERROR_MESSAGE);
					
				}
			}
			});
		btnRegistrar.setBounds(173, 251, 115, 29);
		contentPane.add(btnRegistrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnCancelar.setBounds(303, 251, 115, 29);
		contentPane.add(btnCancelar);
		
		txtContrasena = new JTextField();
		txtContrasena.setBounds(249, 84, 146, 26);
		contentPane.add(txtContrasena);
		txtContrasena.setColumns(10);
		
		txtConfirmar = new JTextField();
		txtConfirmar.setBounds(249, 181, 156, 26);
		contentPane.add(txtConfirmar);
		txtConfirmar.setColumns(10);
	}
}
