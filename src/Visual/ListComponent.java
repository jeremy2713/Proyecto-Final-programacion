package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Aplicacion;
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
	private JButton btnEliminar;

	public ListComponent(ArrayList<Componente> componentes) {
		setIconImage(new ImageIcon(getClass().getResource("/img/carritocompra.png")).getImage());

		setTitle("Lista de Componentes");
		misComponentes = componentes;
		setBounds(100, 100, 575, 313);
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
					//	int index = table.getSelectedRow();
						if(table.getSelectedRow()>=0){
							btnEliminar.setEnabled(true);
			
						}
					}
				});
				model = new DefaultTableModel();
				String[] columnNames = {"Codigo","Tipo De Componente", "Marca", "Modelo", "Cantidad"};
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
				{
					 btnEliminar = new JButton("Eliminar");
					btnEliminar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int fila = table.getSelectedRow();
							String codigo= (String)table.getValueAt(fila, 0);
							Componente C1 = Aplicacion.getInstance().buscarComponentePorCodigo(codigo);
							Aplicacion.getInstance().getComponentes().remove(C1);
							loadComponente();
							btnEliminar.setEnabled(false);
						}
					});
					btnEliminar.setEnabled(false);
					buttonPane.add(btnEliminar);
				}
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
			fila[4] = componente.getCantidad_disponible();
			fila[2] = componente.getMarca();
			fila[3] = componente.getModelo();
					
			model.addRow(fila);
		}
	}

}
