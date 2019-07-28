package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Componente;
import Logico.Factura;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ListComponent extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;
	private static ArrayList<Componente> misComponentes;

	public ListComponent(ArrayList<Componente> componentes) {
		misComponentes = componentes;
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
					}
				});
				model = new DefaultTableModel();
				String[] columnNames = {"Codigo","Tipo De Componente", "Cantidad Pedida", "Marca", "Modelo"};
				model.setColumnIdentifiers(columnNames);
				table.setModel(model);
				scrollPane.setViewportView(table);
				loadComponente();			
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
				btnCerrar.setActionCommand("Cancel");
				buttonPane.add(btnCerrar);
			}
		}
	}
	private static void loadComponente() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (Componente componente : misComponentes) {
			fila[0] = componente.getBarcode();
			fila[1] = componente.getClass().getSimpleName();
			fila[2] = componente.getCantidad_disponible();
			fila[3] = componente.getMarca();
			fila[4] = componente.getModelo();
					
			model.addRow(fila);
		}
	}

}
