package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.sun.org.apache.xml.internal.security.encryption.AgreementMethod;

import Logico.Aplicacion;
import Logico.Cliente;
import Logico.Combo;
import Logico.Componente;
import Logico.Discoduro;
import Logico.Memoriaram;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RealizarCombo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtCedula;
	private JTextField txtCredito;
	private JTextField txtDireccion;
	private JComboBox comboBoxcliente;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	public static Object[] fila;
	public static Object[] fila_1;
	private static DefaultTableModel model;
	private static DefaultTableModel model_1;
	private static ArrayList<Componente> Componentespedidos = new ArrayList<>();
	private JButton btnMover;
	private JButton btnRemover;



	public RealizarCombo() {
		setTitle("Comprar Combo");
		setLocationRelativeTo(null);
		setBounds(100, 100, 762, 692);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panelInformacionGeneral = new JPanel();
		panelInformacionGeneral.setBorder(new TitledBorder(null, "Informacion General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInformacionGeneral.setBounds(10, 100, 701, 142);
		contentPanel.add(panelInformacionGeneral);
		panelInformacionGeneral.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(12, 31, 68, 14);
		panelInformacionGeneral.add(lblNombre);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(12, 61, 68, 21);
		panelInformacionGeneral.add(lblCedula);
		
		JLabel txtcredito = new JLabel("Credito:");
		txtcredito.setBounds(305, 65, 78, 14);
		panelInformacionGeneral.add(txtcredito);
		
		JLabel lblDireccion = new JLabel("Direccion: ");
		lblDireccion.setBounds(12, 98, 86, 14);
		panelInformacionGeneral.add(lblDireccion);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(84, 26, 190, 20);
		panelInformacionGeneral.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCedula = new JTextField();
		txtCedula.setEditable(false);
		txtCedula.setBounds(84, 62, 190, 20);
		panelInformacionGeneral.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtCredito = new JTextField();
		txtCredito.setEditable(false);
		txtCredito.setBounds(363, 61, 86, 20);
		panelInformacionGeneral.add(txtCredito);
		txtCredito.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setBounds(84, 95, 190, 20);
		panelInformacionGeneral.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(524, 58, 91, 26);
		panelInformacionGeneral.add(textField);
		textField.setColumns(10);
		
		
		JButton btnTotal = new JButton("Total ");
		btnTotal.setBounds(485, 91, 115, 29);
		panelInformacionGeneral.add(btnTotal);
		{
			JPanel panelBuscar = new JPanel();
			panelBuscar.setBounds(10, 11, 514, 42);
			contentPanel.add(panelBuscar);
			panelBuscar.setLayout(null);
			
			JLabel lblCliente = new JLabel("Cliente");
			lblCliente.setBounds(15, 13, 69, 20);
			panelBuscar.add(lblCliente);
			
		    comboBoxcliente = new JComboBox();
			comboBoxcliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
            for(int i =0;i<Aplicacion.getInstance().getClientes().size();i++) {
	        if(Aplicacion.getInstance().getClientes().get(i).getCodigo().equals(comboBoxcliente.getSelectedItem())) {
	        txtCredito.setText(Float.toString(Aplicacion.getInstance().getClientes().get(i).getCredito()));
			txtNombre.setText(Aplicacion.getInstance().getClientes().get(i).getNombre());
			txtDireccion.setText(Aplicacion.getInstance().getClientes().get(i).getDireccion());
			txtCedula.setText(Aplicacion.getInstance().getClientes().get(i).getCedula());
			txtCredito.setText(Float.toString(Aplicacion.getInstance().getClientes().get(i).getCredito()));
	        }
			else {
				  txtCredito.setText("");
					txtNombre.setText("");
					txtDireccion.setText("");
					txtCedula.setText("");
					txtCredito.setText("");
				
			}
			
									
								}
							}
						});
	
					
	
		
			comboBoxcliente.setBounds(70, 10, 124, 23);
			panelBuscar.add(comboBoxcliente);
		}
		

		String[] header = {"Codigo","Nombre","Precio"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(header);
		
		String[] header1 = {"Codigo","Nombre","Precio"};
		model_1 = new DefaultTableModel();
		model_1.setColumnIdentifiers(header1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(6, 223, 317, 350);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 297, 328);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getSelectedRow()>=0){
					
					btnMover.setEnabled(true);
					
	
				}
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(model);	
		scrollPane.setViewportView(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(394, 223, 317, 350);
		contentPanel.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 297, 328);
		panel_3.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table_1.getSelectedRow()>=0) {
					
					btnRemover.setEnabled(true);
					
				}
				
				
			}
		});
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//table.edi
		table_1.setModel(model_1);
		scrollPane_1.setViewportView(table_1);
		
		 btnMover = new JButton(">");
		btnMover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = table.getSelectedRow();
				String codigo= (String)table.getValueAt(fila, 0);
				Componente C1 = Aplicacion.getInstance().buscarComponentePorCodigo(codigo);
				Componentespedidos.add(C1);
				Aplicacion.getInstance().getComponentes().remove(C1);
				loadTable();
				 
			}
		});
		btnMover.setBounds(338, 279, 41, 23);
		contentPanel.add(btnMover);
		
		 btnRemover = new JButton("<");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = table_1.getSelectedRow();
				String codigo = (String) table_1.getValueAt(fila, 0);
				
				loadTable();
				
			
			}
		});
		btnRemover.setBounds(338, 412, 41, 23);
		contentPanel.add(btnRemover);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Comprar combo\r\n");
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
		
	loadClientes();
	loadTable();
	}


	private void loadClientes() {
		comboBoxcliente.removeAllItems();
		for(int i =0;i<Aplicacion.getInstance().getClientes().size();i++) {
			comboBoxcliente.addItem(new String(Aplicacion.getInstance().getClientes().get(i).getCodigo()));
		}
		comboBoxcliente.insertItemAt(new String("<Seleccione>"), 0);
		
		comboBoxcliente.setSelectedIndex(0);
		
		
	}
	
	public static void loadTable() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for(int i=0;i<Aplicacion.getInstance().getComponentes().size();i++) {
			fila[0] = Aplicacion.getInstance().getComponentes().get(i).getBarcode();
			fila[1] = Aplicacion.getInstance().getComponentes().get(i).getClass().getSimpleName();
			fila[2] = Aplicacion.getInstance().getComponentes().get(i).getPrecio();
			model.addRow(fila);
			
		}}
	}
	
	
	
	
	
	
	
	




	
	
	
	
	
	
	

