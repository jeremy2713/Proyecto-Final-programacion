package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Aplicacion;
import Logico.Componente;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class ManejoInventario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;
	private static ArrayList<Componente> misComponentes;
	private JScrollPane scrollPane;
	private JButton btnRestock;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			ManejoInventario dialog = new ManejoInventario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ManejoInventario() {
		setTitle("Manejo de inventario");
		setBounds(100, 100, 490, 353);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 11, 454, 259);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			 scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 54, 434, 194);
			panel.add(scrollPane);
			
			JLabel lblCantidad = new JLabel("Cantidad");
			lblCantidad.setBounds(10, 11, 86, 20);
			panel.add(lblCantidad);
			
			JSpinner spinner_cantidad = new JSpinner();
			spinner_cantidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spinner_cantidad.setBounds(122, 11, 49, 20);
			panel.add(spinner_cantidad);
		}
		
		table = new JTable();
		table.setBackground(SystemColor.info);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			//	int index = table.getSelectedRow();
				if(table.getSelectedRow()>=0){
					btnRestock.setEnabled(true);
					
	
				}
			}
		});
		model = new DefaultTableModel();
		String[] columnNames = {"Codigo","Tipo De Componente", "Marca", "Modelo", "Cantidad"};
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
		scrollPane.setViewportView(table);
		loadComponente();
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				 btnRestock = new JButton("Re-stock");
				 btnRestock.addActionListener(new ActionListener() {
				 	public void actionPerformed(ActionEvent e) {
						
						for(int i=0;i<Aplicacion.getInstance().getComponentes().size();i++) {
							if(Aplicacion.getInstance().getComponentes().get(i).getCantidad_disponible()<5) {
								Aplicacion.getInstance().getComponentes().get(i).setCantidad_disponible(Aplicacion.getInstance().getComponentes().get(i).getCantidad_disponible()+10);
							}			
						}
						
						JOptionPane.showMessageDialog(null, "Operación exitosa", "Información", JOptionPane.INFORMATION_MESSAGE);
				 	}
				 });
				 btnRestock.setEnabled(false);
				buttonPane.add(btnRestock);
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
	private static void loadComponente() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i = 0;i<Aplicacion.getInstance().getComponentes().size();i++) {
			fila[0] = Aplicacion.getInstance().getComponentes().get(i).getBarcode();
			fila[1] = Aplicacion.getInstance().getComponentes().get(i).getClass().getSimpleName();
			fila[4] = Aplicacion.getInstance().getComponentes().get(i).getCantidad_disponible();
			fila[2] = Aplicacion.getInstance().getComponentes().get(i).getMarca();
			fila[3] = Aplicacion.getInstance().getComponentes().get(i).getModelo();
					
			model.addRow(fila);
		}
	}
}
