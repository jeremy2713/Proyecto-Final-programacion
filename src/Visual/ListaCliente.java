package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Aplicacion;
import Logico.Cliente;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;
	public String selecte;
	private JButton btnModificar = new JButton("Modificar");
	private JButton btnVerFacturas = new JButton("Ver Facturas");

	public ListaCliente() {
		setTitle("Listar Clientes");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{	
				table = new JTable();
				table.setBackground(SystemColor.info);
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int index = table.getSelectedRow();
						if(index >= 0) {
							btnVerFacturas.setEnabled(true);
							btnModificar.setEnabled(true);
							selecte = table.getValueAt(index, 0).toString();
						}
					}
				});
				model = new DefaultTableModel();
				String[] columnNames = {"Codigo","Nombre","Cedula", "Direccion","Limite de credito"};
				model.setColumnIdentifiers(columnNames);
				table.setModel(model);
				scrollPane.setViewportView(table);
				loadClientes();			
			}}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnVerFacturas.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Cliente client = Aplicacion.getInstance().buscarClientePorCodigo(selecte);
						ListaFactura listFact = new ListaFactura(client);
						listFact.setModal(true);
						listFact.setVisible(true);
					}
				});
				{
					
					btnModificar.setEnabled(false);
					buttonPane.add(btnModificar);
				}
				
				btnVerFacturas.setEnabled(false);
				btnVerFacturas.setActionCommand("OK");
				buttonPane.add(btnVerFacturas);
				getRootPane().setDefaultButton(btnVerFacturas);
			}
			{
				JButton btnCerrar = new JButton("Cerrar");
				btnCerrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCerrar.setActionCommand("Cancel");
				buttonPane.add(btnCerrar);
			}
		}
	}
	public static void loadClientes(){
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (Cliente cliente : Aplicacion.getInstance().getClientes()) {
			fila[0] = cliente.getCodigo();
			fila[1] = cliente.getNombre();
			fila[2] = cliente.getCedula();
			fila[3] = cliente.getDireccion();
			fila[4] = cliente.getCredito();
			model.addRow(fila);
			
		}
	}

}
