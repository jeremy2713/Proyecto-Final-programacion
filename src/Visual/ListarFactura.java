package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Aplicacion;
import Logico.Factura;
import Logico.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ListarFactura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_nombre;
	private static ArrayList<Factura> facturacliente = new ArrayList<>();
	private static DefaultTableModel model;
	public static Object[] fila;
	private JTable table;
	private JButton btnBuscar;
	private JComboBox comboBox_cliente;
	private JTextField txtcedula;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			ListarFactura dialog = new ListarFactura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Create the dialog.
	 */
	public ListarFactura() {
		setTitle("Lista de Factura");
		setBounds(100, 100, 597, 387);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Buscar Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 561, 102);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(10, 22, 63, 19);
		panel.add(lblCliente);
		
		 btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				facturacliente.removeAll(facturacliente);
				String cedula = (String) txtcedula.getText();
				if(Aplicacion.getInstance().buscarClientePorCedula(cedula)==null) {
					JOptionPane.showMessageDialog(null, "No se encontro el cliente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
				}else {
				textField_nombre.setText(Aplicacion.getInstance().buscarClientePorCedula(cedula).getNombre());
				loadTable(cedula);
				}
			}
		});
		btnBuscar.setBounds(211, 20, 89, 23);
		panel.add(btnBuscar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 52, 63, 19);
		panel.add(lblNombre);
		
		textField_nombre = new JTextField();
		textField_nombre.setEditable(false);
		textField_nombre.setBounds(83, 52, 101, 19);
		panel.add(textField_nombre);
		textField_nombre.setColumns(10);
		
		txtcedula = new JTextField();
		txtcedula.setText("(Cedula)");
		txtcedula.setBounds(83, 21, 101, 20);
		panel.add(txtcedula);
		txtcedula.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Facturas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 124, 561, 180);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 541, 147);
		panel_1.add(scrollPane);
		
		model = new DefaultTableModel();
		String[] header = {"Codigo","Cantidad de Componentes","Precio Total"};
		model.setColumnIdentifiers(header);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                if(table.getSelectedRow()>=0){
					
				//	btnMirarFactura.setEnabled(true);
					
	
				}
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(model);	
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Detalles");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int fila = table.getSelectedRow();
						String codigo = (String)table.getValueAt(fila, 0);
						
						Factura f = Aplicacion.getInstance().buscarFacturaPorCodigo(codigo);
						DetallesFactura DF = new DetallesFactura(f);
						DF.setModal(true);
						DF.setLocationRelativeTo(null);
						DF.setVisible(true);
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
						facturacliente.removeAll(facturacliente);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public static void loadTable(String codigo) {
		model.setRowCount(0);
		facturacliente.addAll(Aplicacion.getInstance().buscarFacturasByCliente(codigo));
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i < facturacliente.size(); i++) {
			
			fila[0] = facturacliente.get(i).getCodigo();
			fila[1] = facturacliente.get(i).getMiscomponentes().size();
			fila[2] = facturacliente.get(i).getPreciototal();
			
			model.addRow(fila);
		}
		
		
	}
}
