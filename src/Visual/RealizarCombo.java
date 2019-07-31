package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
import com.sun.org.apache.xml.internal.security.encryption.AgreementMethod;

import Logico.Aplicacion;
import Logico.Cliente;
import Logico.Combo;
import Logico.Componente;
import Logico.Discoduro;
import Logico.Factura;
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
	private JTextField txttotal;
	private JTable table;
	private JTable table_1;
	public static Object[] fila;
	public static Object[] fila_1;
	private static DefaultTableModel model;
	private static DefaultTableModel model_1;
	private static ArrayList<Componente> Componentespedidos = new ArrayList<>();
	private static ArrayList<Combo>miscombos= new ArrayList<>();
	private JButton btnMover;
	private JButton btnRemover;
	private JTextField txtdescuento;
	private JTextField txtdevuelta;



	public RealizarCombo() {
		setTitle("Crear Combo");
		setLocationRelativeTo(null);
		setBounds(100, 100, 747, 679);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panelInformacionGeneral = new JPanel();
		panelInformacionGeneral.setBorder(new TitledBorder(null, "Informacion General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInformacionGeneral.setBounds(6, 69, 706, 149);
		contentPanel.add(panelInformacionGeneral);
		panelInformacionGeneral.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(12, 31, 68, 14);
		panelInformacionGeneral.add(lblNombre);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(12, 61, 68, 21);
		panelInformacionGeneral.add(lblCedula);
		
		JLabel txtcredito = new JLabel("Credito:");
		txtcredito.setBounds(305, 31, 78, 14);
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
		txtCredito.setBounds(368, 28, 86, 20);
		panelInformacionGeneral.add(txtCredito);
		txtCredito.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setBounds(84, 95, 190, 20);
		panelInformacionGeneral.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txttotal = new JTextField();
		txttotal.setBounds(595, 58, 91, 26);
		panelInformacionGeneral.add(txttotal);
		txttotal.setColumns(10);
		
		
		JButton btnTotal = new JButton("Total ");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				txttotal.setText(Float.toString(precioTotalComponentePedido()));
			
				
			}
		});
		btnTotal.setBounds(465, 57, 115, 29);
		panelInformacionGeneral.add(btnTotal);
		
		txtdescuento = new JTextField();
		txtdescuento.setBounds(595, 100, 88, 26);
		panelInformacionGeneral.add(txtdescuento);
		txtdescuento.setColumns(10);
		
		JButton btnNewButton = new JButton("total con descuento");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
                       if(Componentespedidos.size()>3)
{
				txtdescuento.setText(Float.toString(precioTotalCombo()));
				txtdevuelta.setText(Float.toString(devuelta()));
}

else {
	
	JOptionPane.showMessageDialog(null, "Se necesita mas de 3 componentes para crear el combo", "Advertencia", JOptionPane.INFORMATION_MESSAGE);

	
}	
				}
			
		});
		
		btnNewButton.setBounds(411, 99, 169, 29);
		panelInformacionGeneral.add(btnNewButton);
		
		JLabel lblDevuelta = new JLabel("Devuelta");
		lblDevuelta.setBounds(298, 66, 69, 20);
		panelInformacionGeneral.add(lblDevuelta);
		
		txtdevuelta = new JTextField();
		txtdevuelta.setEditable(false);
		txtdevuelta.setBounds(368, 58, 86, 26);
		panelInformacionGeneral.add(txtdevuelta);
		txtdevuelta.setColumns(10);
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
		

		String[] header = {"Codigo","Nombre","Precio", "Cantidad"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(header);
		
		String[] header1 = {"Codigo","Nombre","Precio"};
		model_1 = new DefaultTableModel();
		model_1.setColumnIdentifiers(header1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(16, 234, 317, 350);
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
		panel_3.setBounds(395, 234, 317, 350);
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
				if(C1.getCantidad_disponible()>0) {				
					C1.setCantidad_disponible(C1.getCantidad_disponible()-1);
				}
					
					else {
						JOptionPane.showMessageDialog(null, "\n"
				                + "Este componente no esta disponible", "",
				                JOptionPane.INFORMATION_MESSAGE);
						
					}
					//txttotal.setText(Float.toString(precioTotalComponentePedido()));
					 if(Componentespedidos.size()>3)
		                {
						//txtdescuento.setText(Float.toString(0));
						//txtdevuelta.setText(Float.toString(0));
						//txttotal.setText(Float.toString(0));
						txttotal.setText(Float.toString(precioTotalComponentePedido()));
						txtdevuelta.setText(Float.toString(devuelta()));
						txttotal.setText(Float.toString(precioTotalComponentePedido()));
	
		                }
			//	Aplicacion.getInstance().getComponentes().remove(C1);
				
				loadTable();
				loadTablePedidosRemover();
				}
				 
		});
		btnMover.setBounds(348, 311, 41, 23);
		contentPanel.add(btnMover);
		
		 btnRemover = new JButton("<");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = table_1.getSelectedRow();
				String codigo = (String) table_1.getValueAt(fila, 0);
				Componente C1 = componentePedidosPorCodigo(codigo);
				C1.setCantidad_disponible(C1.getCantidad_disponible()+1);
				Componentespedidos.remove(C1);
				 if(Componentespedidos.size()<4)
	                {
					txtdescuento.setText(Float.toString(0));
					txtdevuelta.setText(Float.toString(0));
					txttotal.setText(Float.toString(0));
	                }                
				loadTable();
				loadTablePedidosRemover();
				
if(comboBoxcliente.equals("<seleccione>"))
						
						{
	txtdescuento.setText(Float.toString(0));
	txtdevuelta.setText(Float.toString(0));
	txttotal.setText(Float.toString(0));
					
						}
				

				
			
			}
		});
		btnRemover.setBounds(348, 411, 41, 23);
		contentPanel.add(btnRemover);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Comprar combo");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						if(devuelta()<0)
						{
							
							JOptionPane.showMessageDialog(null, "No se ha podido realizar su compra\n"
					                + "no posee credito suficiente para la compra", "",
					                JOptionPane.ERROR_MESSAGE);

						     	
						}
						if(Float.parseFloat(txtcredito.getText())<0)
						{
							

						}
						
						else
						{
							Factura aux = null;
							int pos = comboBoxcliente.getSelectedIndex();
							String codigoFactura;
							codigoFactura= "F"+Integer.toString(Aplicacion.getInstance().getFacturas().size()+1);
							String codigo = (String) comboBoxcliente.getItemAt(pos);
							Cliente elCliente = Aplicacion.getInstance().buscarClientePorCodigo(codigo);
							ArrayList<Combo>miscombos = new ArrayList<>();
						//miscombos.addAll(Componentespedidos);
							Componentespedidos.removeAll(Componentespedidos);
							float total = Float.parseFloat(txttotal.getText());
							float devuelta = Float.parseFloat(txtdevuelta.getText());
							for(int i =0;i<Aplicacion.getInstance().getClientes().size();i++) {
								if(Aplicacion.getInstance().getClientes().get(i)==elCliente) 
									Aplicacion.getInstance().getClientes().get(i).setCredito(devuelta);
							
							}
							aux = new Factura(codigoFactura, precioTotalCombo(), null, elCliente);
							elCliente.agregarFactura(aux);
							Aplicacion.getInstance().agregarFactura(aux);
							JOptionPane.showMessageDialog(null, "Operaci�n exitosa", "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
							dispose();
							 }
						
					}
							
					});
					
					
	
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						//Aplicacion.getInstance().getComponentes().addAll(Componentespedidos);
						//Componentespedidos.removeAll(Componentespedidos);
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
			fila[3] = Aplicacion.getInstance().getComponentes().get(i).getCantidad_disponible();
			model.addRow(fila);
			
		}}
	
	

	public static void loadTablePedidosRemover() {
		model_1.setRowCount(0);
		fila_1 = new Object[model_1.getColumnCount()];
		for(int i=0;i<10;i++) {
			fila_1[0] = Componentespedidos.get(i).getBarcode();
			fila_1[1] = Componentespedidos.get(i).getClass().getSimpleName();
			fila_1[2] = Componentespedidos.get(i).getPrecio();
			model_1.addRow(fila_1);
	
		}
	}
	
	
	
	public float precioTotalCombo() {
		
		float totalcondescuento=0;		
		totalcondescuento=(float) (precioTotalComponentePedido()-precioTotalComponentePedido()*0.30);
		return totalcondescuento;
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
		devuelta =Float.parseFloat(txtCredito.getText())-precioTotalCombo();
		return devuelta;
}
}

	
	
	
	
	
	
	
	




	
	
	
	
	
	
	

