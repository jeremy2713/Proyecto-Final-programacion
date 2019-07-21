package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Cliente;
import Logico.Factura;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListaFactura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static Cliente miCliente;
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;
	public String selecte;
	private JButton btnVerDetalles = new JButton("Ver Detalles");
	
	public ListaFactura(Cliente cliente) {
		setTitle("Facturas Cliente");
		setResizable(false);
		setLocationRelativeTo(null);
		miCliente = cliente;
		setBounds(100, 100, 450, 300);
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
							btnVerDetalles.setEnabled(true);
							selecte = table.getValueAt(index, 0).toString();
						}
					}
				});
				model = new DefaultTableModel();
				String[] columnNames = {"Codigo","Monto Total"};
				model.setColumnIdentifiers(columnNames);
				table.setModel(model);
				scrollPane.setViewportView(table);
				loadFacturas();			
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCerrar = new JButton("Cerrar");
				btnCerrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				{
					
					btnVerDetalles.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
						}				
					});
					btnVerDetalles.setEnabled(false);
					buttonPane.add(btnVerDetalles);
				}
				btnCerrar.setActionCommand("Cancel");
				buttonPane.add(btnCerrar);
			}
		}
	}
	private static void loadFacturas() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (Factura factura : miCliente.getFacturas()) {
			fila[0] = factura.getCodigo();
			fila[1] = factura.getPreciototal();
			model.addRow(fila);
		}
	}

}
