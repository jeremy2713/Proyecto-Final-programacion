package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Logico.Aplicacion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_nombre;
	private JTextField textField_codigo;
	private JTextField textField_direccion;
	private JTextField textField_credito;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		try {
			RegCliente dialog = new RegCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Create the dialog.
	 * @param nombreCliente 
	 * @param app 
	 */
	public RegCliente(String nombreCliente) {
		setResizable(false);
		setTitle("Registrar Cliente");
		setBounds(100, 100, 450, 275);
		getContentPane().setLayout(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel_informacion_del_cliente = new JPanel();
		panel_informacion_del_cliente.setBorder(new TitledBorder(null, "Informacion del cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_informacion_del_cliente.setBounds(10, 11, 414, 206);
		contentPanel.add(panel_informacion_del_cliente);
		panel_informacion_del_cliente.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 29, 109, 24);
		panel_informacion_del_cliente.add(lblNombre);
		
		textField_nombre = new JTextField();
		textField_nombre.setBounds(169, 31, 141, 20);
		panel_informacion_del_cliente.add(textField_nombre);
		textField_nombre.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 64, 109, 24);
		panel_informacion_del_cliente.add(lblCodigo);
	
		textField_codigo = new JTextField();
		textField_codigo.setEditable(false);
		textField_codigo.setText("C-"+(Aplicacion.getInstance().getClientes().size()+1));
		textField_codigo.setBounds(169, 66, 141, 20);
		panel_informacion_del_cliente.add(textField_codigo);
		textField_codigo.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(10, 99, 109, 24);
		panel_informacion_del_cliente.add(lblDireccion);
		
		JLabel lblCredito = new JLabel("Credito");
		lblCredito.setBounds(10, 134, 109, 24);
		panel_informacion_del_cliente.add(lblCredito);
		
		textField_direccion = new JTextField();
		textField_direccion.setBounds(169, 101, 141, 20);
		panel_informacion_del_cliente.add(textField_direccion);
		textField_direccion.setColumns(10);
		
		textField_credito = new JTextField();
		textField_credito.setBounds(169, 136, 141, 20);
		panel_informacion_del_cliente.add(textField_credito);
		textField_credito.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Logico.Cliente i = null;
						String nombre = textField_nombre.getText();
						String direccion = textField_direccion.getText();
						String codigo = textField_codigo.getText();
						float credito = Float.parseFloat(textField_credito.getText());
						i = new Logico.Cliente(nombre, codigo, credito, direccion);
						Aplicacion.getInstance().agregarCliente(i);
						JOptionPane.showMessageDialog(null, "Cliente Registrado", "Información", JOptionPane.INFORMATION_MESSAGE);
						Clean();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private void Clean() {
		textField_credito.setText("");
		textField_direccion.setText("");
		textField_nombre.setText("");
		textField_codigo.setText("C-"+(Aplicacion.getInstance().getClientes().size()+1));	
		
	}
}
