package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Logico.Aplicacion;
import Logico.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class RegCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtCodigo;
	private JTextField txtDireccion;
	private JTextField txtCedula;
	private JSpinner spnCredito;

	public RegCliente() {
		setResizable(false);
		setTitle("Registrar Cliente");
		setBounds(100, 100, 447, 232);
		getContentPane().setLayout(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Informacion del cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(panel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("Nombre");
		label.setBounds(10, 64, 58, 24);
		panel.add(label);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(78, 66, 232, 20);
		panel.add(txtNombre);
		
		JLabel label_1 = new JLabel("Codigo");
		label_1.setBounds(10, 29, 58, 24);
		panel.add(label_1);
		
		txtCodigo = new JTextField();
		txtCodigo.setText("C-1");
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(78, 31, 58, 20);
		panel.add(txtCodigo);
		
		JLabel label_2 = new JLabel("Direccion");
		label_2.setBounds(10, 124, 58, 24);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Credito");
		label_3.setBounds(259, 94, 51, 24);
		panel.add(label_3);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(78, 126, 305, 20);
		panel.add(txtDireccion);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(10, 99, 46, 14);
		panel.add(lblCedula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(78, 97, 171, 20);
		panel.add(txtCedula);
		txtCedula.setColumns(10);
		
		spnCredito = new JSpinner();
		spnCredito.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
		spnCredito.setBounds(327, 96, 79, 20);
		panel.add(spnCredito);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Cliente i = null;
						String nombre = txtNombre.getText();
						String direccion = txtDireccion.getText();
						String cedula = txtCedula.getText();
						String codigo = txtCodigo.getText();
						float credito = Float.parseFloat(spnCredito.getValue().toString());
						i = new Cliente(codigo, nombre, cedula, credito, direccion);
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
		txtNombre.setText("");
		txtDireccion.setText("");
		txtCedula.setText("");
		spnCredito.setValue(0);
		txtCodigo.setText("C-"+(Aplicacion.getInstance().getClientes().size()+1));	
		
	}
}
