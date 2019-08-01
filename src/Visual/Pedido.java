package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.portable.ApplicationException;

import Logico.Aplicacion;
import Logico.Cliente;
import Logico.Combo;
import Logico.Componente;
import Logico.Factura;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Pedido extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_nombre;
	private JTextField textField_credito;
	private JTextField textField_total;
	private JTextField textField_devuelta;
	private JTable table;
	private JTable table_1;
	public static Object[] fila;
	public static Object[] fila_1;
	private static DefaultTableModel model;
	private static DefaultTableModel model_1;
	private static ArrayList<Componente> Componentespedidos = new ArrayList<>();
	private JButton btnMover;
	private JButton btnRemover;
	private JTextField txtcedula;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Pedido dialog = new Pedido();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Pedido() {
		setResizable(false);
		setTitle("Realizar Pedidos");
		setBounds(100, 100, 766, 598);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 740, 480);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Informacion General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 720, 97);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(10, 29, 67, 21);
		panel_1.add(lblCliente);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 61, 67, 25);
		panel_1.add(lblNombre);
		
		textField_nombre = new JTextField();
		textField_nombre.setEditable(false);
		textField_nombre.setBounds(101, 60, 86, 20);
		panel_1.add(textField_nombre);
		textField_nombre.setColumns(10);
		
		JLabel lblCredito = new JLabel("Credito");
		lblCredito.setBounds(273, 61, 82, 18);
		panel_1.add(lblCredito);
		
		textField_credito = new JTextField();
		textField_credito.setEditable(false);
		textField_credito.setBounds(383, 61, 86, 20);
		panel_1.add(textField_credito);
		textField_credito.setColumns(10);
		
		txtcedula = new JTextField();
		txtcedula.setText("(Cedula)");
		txtcedula.setBounds(101, 29, 86, 20);
		panel_1.add(txtcedula);
		txtcedula.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		//		facturacliente.removeAll(facturacliente);
				String cedula = (String) txtcedula.getText();
				if(Aplicacion.getInstance().buscarClientePorCedula(cedula)==null) {
					JOptionPane.showMessageDialog(null, "No se encontro el cliente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
				}else {
				textField_nombre.setText(Aplicacion.getInstance().buscarClientePorCedula(cedula).getNombre());
				float credito = Aplicacion.getInstance().buscarClientePorCedula(cedula).getCredito();
				textField_credito.setText(Float.toString(credito));
				
				}
			}
		});
		btnBuscar.setBounds(266, 28, 89, 23);
		panel_1.add(btnBuscar);
		
		String[] header = {"Codigo","Nombre","Precio", "Cantidad"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(header);
		
		String[] header1 = {"Codigo","Nombre","Precio"};
		model_1 = new DefaultTableModel();
		model_1.setColumnIdentifiers(header1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 119, 317, 350);
		panel.add(panel_2);
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
		panel_3.setBounds(413, 119, 317, 350);
		panel.add(panel_3);
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
				if(C1.getCantidad_disponible()>0) {				
				C1.setCantidad_disponible(C1.getCantidad_disponible()-1);
				textField_total.setText(Float.toString(precioTotalComponentePedido()));
				textField_devuelta.setText(Float.toString(devuelta()));
		//		Aplicacion.getInstance().getComponentes().remove(C1);
				loadTable();
				loadTablePedidosRemover();
				}else {
				JOptionPane.showMessageDialog(null, "no hay suficiente");
				} 
				btnMover.setEnabled(false);
			}
		});
		btnMover.setEnabled(false);
		btnMover.setBounds(349, 150, 41, 23);
		panel.add(btnMover);
		
		 btnRemover = new JButton("<");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = table_1.getSelectedRow();
				String codigo = (String) table_1.getValueAt(fila, 0);
				Componente C1 = componentePedidosPorCodigo(codigo);
				C1.setCantidad_disponible(C1.getCantidad_disponible()+1);
				textField_total.setText(Float.toString(precioTotalComponentePedido()));
				textField_devuelta.setText(Float.toString(devuelta()));
				Componentespedidos.remove(C1);
				loadTable();
				loadTablePedidosRemover();
				btnRemover.setEnabled(false);
			}
		});
		btnRemover.setEnabled(false);
		btnRemover.setBounds(349, 257, 41, 23);
		panel.add(btnRemover);
		
		JButton btnTotal = new JButton("Total");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			float devolver=0;
				textField_total.setText(Float.toString(precioTotalComponentePedido()));
				devolver=devuelta();
				textField_devuelta.setText(Float.toString(devolver));

				if(devolver<0)
				{
						JOptionPane.showMessageDialog(null, "Advertencia\n"
				                + "credito insuficiente", "",
				                JOptionPane.INFORMATION_MESSAGE);
				}
	
			}
		});
		btnTotal.setBounds(10, 502, 89, 23);
		contentPanel.add(btnTotal);
		
		textField_total = new JTextField();
		textField_total.setEditable(false);
		textField_total.setBounds(111, 503, 86, 20);
		contentPanel.add(textField_total);
		textField_total.setColumns(10);
		
		JLabel lblDevuelta = new JLabel("Devuelta");
		lblDevuelta.setBounds(264, 504, 64, 19);
		contentPanel.add(lblDevuelta);
		
		textField_devuelta = new JTextField();
		textField_devuelta.setBounds(338, 503, 86, 20);
		contentPanel.add(textField_devuelta);
		textField_devuelta.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						float devolver=0;
						devolver=devuelta();
						
						if(devolver<0)
						{
							
							JOptionPane.showMessageDialog(null, "No se ha podido realizar su compra\n"
					                + "no posee credito suficiente para la compra", "",
					                JOptionPane.ERROR_MESSAGE);

						     	
						}
						
						else {
						Factura aux = null;
						String codigoFactura;
						codigoFactura= "F"+Integer.toString(Aplicacion.getInstance().getFacturas().size()+1);
						String cedula = txtcedula.getText();
						Cliente elCliente = Aplicacion.getInstance().buscarClientePorCedula(cedula);
						ArrayList<Componente> losComponentes = new ArrayList<>();
						losComponentes.addAll(Componentespedidos);
						Componentespedidos.removeAll(Componentespedidos);
						float total = Float.parseFloat(textField_total.getText());
						float devuelta = Float.parseFloat(textField_devuelta.getText());
						for(int i =0;i<Aplicacion.getInstance().getClientes().size();i++) {
							if(Aplicacion.getInstance().getClientes().get(i)==elCliente) 
								Aplicacion.getInstance().getClientes().get(i).setCredito(devuelta);
						
						}
						aux = new Factura(codigoFactura, total, losComponentes, elCliente);
						elCliente.agregarFactura(aux);
						Aplicacion.getInstance().agregarFactura(aux);
						JOptionPane.showMessageDialog(null, "Operacion exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						dispose();
						}
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
						Aplicacion.getInstance().getComponentes().addAll(Componentespedidos);
						Componentespedidos.removeAll(Componentespedidos);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	//	loadClientes();
		loadTable();
	}
	public static void loadTable() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for(int i=0;i<Aplicacion.getInstance().getComponentes().size();i++) {
			fila[0] = Aplicacion.getInstance().getComponentes().get(i).getBarcode();
			fila[1] = Aplicacion.getInstance().getComponentes().get(i).getClass().getSimpleName();
			fila[2] = Aplicacion.getInstance().getComponentes().get(i).getPrecio();
			fila[3] = Aplicacion.getInstance().getComponentes().get(i).getCantidad_disponible();
			model.addRow(fila);
			
		}
		
		
	}
	public static void loadTablePedidosRemover() {
		model_1.setRowCount(0);
		fila_1 = new Object[model_1.getColumnCount()];
		for(int i=0;i<10;i++) {
			fila_1[0] = Componentespedidos.get(i).getBarcode();
			fila_1[1] = Componentespedidos.get(i).getClass().getSimpleName();
			fila_1[2] = Componentespedidos.get(i).getPrecio();
		//	fila_1[3] = Componentespedidos.get(i).getCantidad_disponible();
			model_1.addRow(fila_1);
		
		}
	}
	public Componente componentePedidosPorCodigo(String codigo) {
		Componente aux = null;
		for(int i=0;i<Componentespedidos.size();i++) {
			if(Componentespedidos.get(i).getBarcode().equalsIgnoreCase(codigo)) {
				aux = Componentespedidos.get(i);
			}
			
		}
		
		
		return aux;
	}
	public float precioTotalComponentePedido() {
		float total=0;
		for(int i =0;i<Componentespedidos.size();i++) {
			total+= Componentespedidos.get(i).getPrecio();
		}
		return total;
		
	}
	public float devuelta() {
		float devuelta=0;
		devuelta =Float.parseFloat(textField_credito.getText())-precioTotalComponentePedido();
		return devuelta;
	}
	/*private void loadClientes() {
		for(int i =0;i<Aplicacion.getInstance().getClientes().size();i++) {
			comboBox_clientecodigo.addItem(new String(Aplicacion.getInstance().getClientes().get(i).getCodigo()));
		}
	}*/
}
