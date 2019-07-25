package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registrousuario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrousuario frame = new Registrousuario();
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
	public Registrousuario() {
		setTitle("Registro usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(25, 102, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(272, 102, 146, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewUsername = new JLabel("New Username");
		lblNewUsername.setBounds(25, 48, 107, 20);
		contentPane.add(lblNewUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(284, 48, 69, 20);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmarPassword = new JLabel("Confirmar Password");
		lblConfirmarPassword.setBounds(272, 145, 146, 20);
		contentPane.add(lblConfirmarPassword);
		
		textField_2 = new JTextField();
		textField_2.setBounds(272, 181, 146, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
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
	}

}
