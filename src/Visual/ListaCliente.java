package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.ScrollPane;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Aplicacion;
import Logico.Cliente;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.Scrollable;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class ListaCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;
	private JButton btnEliminar;
	private String nombreCliente = "";
	private static Aplicacion miApp;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		try {
			ListaCliente dialog = new ListaCliente();
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
	public ListaCliente(Aplicacion app) {
		this.miApp = app;
		setResizable(false);
		setTitle("Listado de clientes");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			JPanel panel = new JPanel();
			panel.setBounds(10, 11, 424, 216);
			contentPanel.add(panel);
			panel.setLayout(null);
			
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(table.getSelectedRow()>=0){
							int index = table.getSelectedRow();
							btnEliminar.setEnabled(true);
							nombreCliente = (String) table.getValueAt(index, 0);
						}
					}
				});
				scrollPane.setBounds(10, 11, 404, 194);
				panel.add(scrollPane);
			
			String[] columns = {"Codigo","Nombre","Direccion","Credito"};
			table = new JTable();
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			model = new DefaultTableModel();
			model.setColumnIdentifiers(columns);
			table.setModel(model);
			scrollPane.setViewportView(table);
			loadClientes();	
		
		
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int fila = table.getSelectedRow();
					String codigo= (String)table.getValueAt(fila, 0);
					Cliente C1=Aplicacion.getInstance().buscarClientePorCodigo(codigo);
					Aplicacion.getInstance().getClientes().remove(C1);
					loadClientes();
				}
			});
			buttonPane.add(btnEliminar);
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
	
	public static void loadClientes(){
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i <Aplicacion.getInstance().getClientes().size(); i++) {
			fila[0] = Aplicacion.getInstance().getClientes().get(i).getCodigo();
			fila[1] = Aplicacion.getInstance().getClientes().get(i).getNombre();
			fila[2] = Aplicacion.getInstance().getClientes().get(i).getDireccion();
			fila[3] = Aplicacion.getInstance().getClientes().get(i).getCredito();
			model.addRow(fila);
		}
		
		
	}
}
