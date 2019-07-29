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
import Logico.Combocomponente;
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
	public static Object[] fila;
	public static Object[] fila1;
	private static DefaultTableModel model1;
	private JTable table;




	public RealizarCombo() {
		setTitle("Comprar Combo");
		setLocationRelativeTo(null);
		setBounds(100, 100, 644, 567);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panelInformacionGeneral = new JPanel();
		panelInformacionGeneral.setBorder(new TitledBorder(null, "Informacion General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInformacionGeneral.setBounds(10, 65, 524, 142);
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
		
		JPanel panelCombos = new JPanel();
		panelCombos.setBorder(new TitledBorder(null, "Combos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCombos.setBounds(10, 218, 545, 67);
		contentPanel.add(panelCombos);
		panelCombos.setLayout(null);
		
		Combocomponente aux=null;/////////////////llenar los combos/////////////
		Componente auxcom=null;
	//	auxcom=new Componente(Aplicacion.getInstance().getComponentes().get(1));
		//Se quiere crear un combo1 numero1, copiando la primera fila del arraylist de componentes. Esta copia no es correcta.
		aux= new Combocomponente(1,auxcom);
		//Aplicacion.getInstance().agregarCombo1(aux);
	/*	aux= new Combocomponente(1,Aplicacion.getInstance().getComponentes().get(2));
		Aplicacion.getInstance().agregarCombo1(aux);
		aux= new Combocomponente(1,Aplicacion.getInstance().getComponentes().get(3));
		Aplicacion.getInstance().agregarCombo1(aux);*/
		
		
		
		
		
		
		
		
		
		JRadioButton radiogamer = new JRadioButton("Combo Gamer");
		radiogamer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model1.setRowCount(0);

				for(int i =0;i<Aplicacion.getInstance().getCombos1().size();i++) {
					if(Aplicacion.getInstance().getCombos1().get(i).getCodigoCombo()==1) {
					
						fila[0] = Aplicacion.getInstance().getCombos1().get(i).getComponente().getBarcode();
						fila[1] = Aplicacion.getInstance().getCombos1().get(i).getComponente().getClass().getSimpleName();
						fila[2] = Aplicacion.getInstance().getCombos1().get(i).getComponente().getPrecio();
						model1.addRow(fila);
				}
					
				
			}
			
			
			}
		});
		radiogamer.setBounds(6, 27, 130, 23);
		panelCombos.add(radiogamer);
		
		JRadioButton radioestudiante = new JRadioButton("Combo Estudiante");
		radioestudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Aplicacion.getInstance().getCombos().equals( radioestudiante)) {	
					
					model1.setRowCount(0);
					fila = new Object[model1.getColumnCount()];
					fila[0] = Aplicacion.getInstance().getCombos().get(2).getDiscoDuro();
					fila[1] = Aplicacion.getInstance().getCombos().get(2).getMemoriaRAM();
					fila[2] = Aplicacion.getInstance().getCombos().get(2).getCpu();	
				}	
			}
			
		});
		
		
		radioestudiante.setBounds(179, 27, 130, 23);
		panelCombos.add(radioestudiante);
		
		JRadioButton radiobasico = new JRadioButton("Combo Basico");
		radiobasico.setBounds(373, 27, 109, 23);
		panelCombos.add(radiobasico);
		
		String[] header = {"Codigo","Nombre","Precio"};
		model1 = new DefaultTableModel();
		model1.setColumnIdentifiers(header);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 301, 516, 133);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//if(table.getSelectedRow()>=0){
					
					
				
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(model1);	
		scrollPane.setViewportView(table);
		
		
		
		
		
		
		
		
		
		
		JButton btnTotal = new JButton("Total ");
		btnTotal.setBounds(10, 450, 115, 29);
		contentPanel.add(btnTotal);
		
		textField = new JTextField();
		textField.setBounds(140, 450, 91, 26);
		contentPanel.add(textField);
		textField.setColumns(10);
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
	//loadTable();
	}



	
	
	
	
	
	private void loadClientes() {
		comboBoxcliente.removeAllItems();
		for(int i =0;i<Aplicacion.getInstance().getClientes().size();i++) {
			comboBoxcliente.addItem(new String(Aplicacion.getInstance().getClientes().get(i).getCodigo()));
		}
		comboBoxcliente.insertItemAt(new String("<Seleccione>"), 0);
		
		comboBoxcliente.setSelectedIndex(0);
		
		
	}
	
	
	
	/*public static void loadTable() {
		model1.setRowCount(0);
		fila = new Object[model1.getColumnCount()];
			fila[0] = Aplicacion.getInstance().getCombos().;
			fila[1] = Aplicacion.getInstance().getComponentes().get(i).getClass().getSimpleName();
			fila[2] = Aplicacion.getInstance().getComponentes().get(i).getPrecio();
			model1.addRow(fila);
			
		}*/
	}
	
	
	
	
	
	
	
	




	
	
	
	
	
	
	

