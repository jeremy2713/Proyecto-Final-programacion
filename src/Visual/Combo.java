package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Aplicacion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class Combo extends JFrame {

	private JPanel contentPane;
	private JTextField txtnombre;
	private JTextField txtcredito;
	private static DefaultTableModel model;
	private static DefaultTableModel model1;
	private JComboBox comboBoxcodigocliente;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Combo frame = new Combo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Combo() {
		setTitle("Comprar Combo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informacion general", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(15, 16, 619, 132);
		contentPane.add(panel);
		panel.setLayout(null);
		
	JComboBox comboBoxcodigocliente = new JComboBox();
	comboBoxcodigocliente.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

	for(int i =0;i<Aplicacion.getInstance().getClientes().size();i++) {
		
	if(Aplicacion.getInstance().getClientes().get(i).getCodigo().equals(comboBoxcodigocliente.getSelectedItem())) {
	txtcredito.setText(Float.toString(Aplicacion.getInstance().getClientes().get(i).getCredito()));
	txtnombre.setText(Aplicacion.getInstance().getClientes().get(i).getNombre());
	
				}
			
	}
		}
	});
		comboBoxcodigocliente.setBounds(83, 35, 76, 23);
		panel.add(comboBoxcodigocliente);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(15, 72, 69, 20);
		panel.add(lblNombre);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(83, 69, 91, 26);
		panel.add(txtnombre);
		txtnombre.setColumns(10);
		
		JLabel lblCredito = new JLabel("Credito");
		lblCredito.setBounds(244, 56, 69, 20);
		panel.add(lblCredito);
		
		txtcredito = new JTextField();
		txtcredito.setBounds(314, 53, 97, 26);
		panel.add(txtcredito);
		txtcredito.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(15, 36, 55, 20);
		panel.add(lblCliente);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Combos Disponibles", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(15, 160, 619, 67);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton rdbtnComboGamer = new JRadioButton("Combo Gamer");
		rdbtnComboGamer.setBounds(11, 26, 155, 29);
		panel_1.add(rdbtnComboGamer);
		
		JRadioButton rdbtnComboEstudiante = new JRadioButton("Combo estudiante");
		rdbtnComboEstudiante.setBounds(188, 26, 167, 29);
		panel_1.add(rdbtnComboEstudiante);
		
		JRadioButton rdbtnComboBasico = new JRadioButton("Combo Basico");
		rdbtnComboBasico.setBounds(414, 26, 155, 29);
		panel_1.add(rdbtnComboBasico);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(86, 242, 467, 145);
		contentPane.add(scrollPane);
		
		JButton btnComprarCombo = new JButton("Comprar Combo");
		btnComprarCombo.setBounds(527, 471, 164, 29);
		contentPane.add(btnComprarCombo);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(388, 471, 115, 29);
		contentPane.add(btnCancelar);
		
		
		JButton btnTotal = new JButton("Total ");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				JOptionPane.showMessageDialog(null, "Gracias  por comprar un combo:\n"
	                    + "A su cuenta se le aplico un 30% de descuento", "",
	                    JOptionPane.INFORMATION_MESSAGE);
									
			}
		});
		btnTotal.setBounds(15, 414, 115, 29);
		contentPane.add(btnTotal);
		
		textField = new JTextField();
		textField.setBounds(140, 415, 115, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(140, 472, 115, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDevuelta = new JLabel("Devuelta");
		lblDevuelta.setBounds(61, 475, 69, 20);
		contentPane.add(lblDevuelta);
		
		
		
			
		/*String[] header = {"Codigo","Nombre","Precio"};
		model = new DefaultTableModel();
		model1.setColumnIdentifiers(header);*/
	}
	
	
	
	private void obtenerclientes() {
		comboBoxcodigocliente.removeAllItems();
		for(int i =0;i<Aplicacion.getInstance().getClientes().size();i++) {
			comboBoxcodigocliente.addItem(new String(Aplicacion.getInstance().getClientes().get(i).getCodigo()));
		}
		comboBoxcodigocliente.insertItemAt(new String("<Seleccione>"), 0);
		comboBoxcodigocliente.setSelectedIndex(0);
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

