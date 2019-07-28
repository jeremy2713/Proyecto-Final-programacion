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
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class RealizarCombo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtBuscar;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtCedula;
	private JTextField txtCredito;
	private JTextField txtDireccion;

	public RealizarCombo() {
		setTitle("Comprar Combo");
		setLocationRelativeTo(null);
		setBounds(100, 100, 550, 498);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panelInformacionGeneral = new JPanel();
		panelInformacionGeneral.setBorder(new TitledBorder(null, "Informacion General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInformacionGeneral.setBounds(10, 65, 514, 142);
		contentPanel.add(panelInformacionGeneral);
		panelInformacionGeneral.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(12, 22, 46, 14);
		panelInformacionGeneral.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(12, 48, 46, 14);
		panelInformacionGeneral.add(lblNombre);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(12, 74, 46, 14);
		panelInformacionGeneral.add(lblCedula);
		
		JLabel lblCredito = new JLabel("Credito:");
		lblCredito.setBounds(184, 22, 46, 14);
		panelInformacionGeneral.add(lblCredito);
		
		JLabel lblDireccion = new JLabel("Direccion: ");
		lblDireccion.setBounds(12, 102, 68, 14);
		panelInformacionGeneral.add(lblDireccion);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(72, 19, 86, 20);
		panelInformacionGeneral.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(72, 45, 244, 20);
		panelInformacionGeneral.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCedula = new JTextField();
		txtCedula.setEditable(false);
		txtCedula.setBounds(72, 71, 190, 20);
		panelInformacionGeneral.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtCredito = new JTextField();
		txtCredito.setEditable(false);
		txtCredito.setBounds(240, 19, 86, 20);
		panelInformacionGeneral.add(txtCredito);
		txtCredito.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setBounds(72, 99, 318, 20);
		panelInformacionGeneral.add(txtDireccion);
		txtDireccion.setColumns(10);
		{
			JPanel panelBuscar = new JPanel();
			panelBuscar.setBounds(10, 11, 514, 42);
			contentPanel.add(panelBuscar);
			panelBuscar.setLayout(null);
			
			JLabel lblBuscar = new JLabel("Buscar Por Codigo: ");
			lblBuscar.setBounds(10, 17, 94, 14);
			panelBuscar.add(lblBuscar);
			
			txtBuscar = new JTextField();
			txtBuscar.setBounds(114, 14, 296, 20);
			panelBuscar.add(txtBuscar);
			txtBuscar.setColumns(10);
			
			JButton btnBuscar = new JButton("");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Cliente client = Aplicacion.getInstance().buscarClientePorCodigo(txtBuscar.getText());
					if(client == null) {
						JOptionPane.showMessageDialog(null, "El cliente no se encuentra, digite nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else {
						loadCliente(client);
					}
					
				}
			});
			btnBuscar.setIcon(new ImageIcon(RealizarCombo.class.getResource("/img/magnifier(1).png")));
			btnBuscar.setBounds(420, 13, 47, 23);
			panelBuscar.add(btnBuscar);
		}
		
		JPanel panelCombos = new JPanel();
		panelCombos.setBorder(new TitledBorder(null, "Combos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCombos.setBounds(10, 218, 514, 67);
		contentPanel.add(panelCombos);
		panelCombos.setLayout(null);
		
		JRadioButton rdbtnComboGamer = new JRadioButton("Combo Gamer");
		rdbtnComboGamer.setBounds(6, 27, 109, 23);
		panelCombos.add(rdbtnComboGamer);
		
		JRadioButton rdbtnComboEstudiante = new JRadioButton("Combo Estudiante");
		rdbtnComboEstudiante.setBounds(160, 27, 130, 23);
		panelCombos.add(rdbtnComboEstudiante);
		
		JRadioButton rdbtnComboBasico = new JRadioButton("Combo Basico");
		rdbtnComboBasico.setBounds(333, 27, 109, 23);
		panelCombos.add(rdbtnComboBasico);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
	private void loadCliente(Cliente cliente) {
		txtCodigo.setText(cliente.getCodigo());
		txtNombre.setText(cliente.getNombre());
		txtCedula.setText(cliente.getCedula());
		txtDireccion.setText(cliente.getDireccion());
		txtCredito.setText(Float.toString(cliente.getCredito()));
		
	}
}
