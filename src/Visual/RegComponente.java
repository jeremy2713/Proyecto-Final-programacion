package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Logico.Aplicacion;
import Logico.Componente;
import Logico.Discoduro;
import Logico.Memoriaram;
import Logico.Microprocesadores;
import Logico.Tarjetamadre;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class RegComponente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtmhz;
	private JTextField txtgb;
	private JTextField txtgb_1;
	private JRadioButton rdbtnTarjetaMadre;
	private JRadioButton rdbtnMicroprocesador;
	private JRadioButton rdbtnMemoriaram;
	private JRadioButton rdbtnDiscoDuro;
	JPanel panel_TarjetaMadre;
	JPanel panel_Micro;
	JPanel panel_Discoduro;
	JPanel panel_MemoriaRam;
	private JPanel panel_1;
	private JLabel lblBarcode;
	private JLabel lblMarca;
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblCantidad;
	private JTextField textField_barcode;
	private JTextField txtKlk;
	private JButton btnReinventar;
	private JComboBox comboBox_tipodememoria;
	private JComboBox comboBox_tipodeconexion;
	private JComboBox comboBox_tipodeconector;
	private JComboBox comboBox_tipoderam;
	private JComboBox comboBox_conectoralmicro;
	private JComboBox comboBox_conectordiscoduro;
	private JComboBox comboBox_marca;
	private JSpinner spinner_cantidad;
	private JSpinner spinner_precio;
	

	public RegComponente() {
		setResizable(false);
		setTitle("Registrar Componente");
		setBounds(100, 100, 528, 412);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Tipo de Componente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 150, 507, 89);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		 rdbtnTarjetaMadre = new JRadioButton("Tarjeta Madre");
		 rdbtnTarjetaMadre.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		rdbtnTarjetaMadre.setSelected(true);
		 		rdbtnDiscoDuro.setSelected(false);
		 		rdbtnMemoriaram.setSelected(false);
		 		rdbtnMicroprocesador.setSelected(false);
		 		panel_TarjetaMadre.setVisible(true);
		 		panel_Discoduro.setVisible(false);
		 		panel_Micro.setVisible(false);
		 		panel_MemoriaRam.setVisible(false);
		 		
		 	}
		 });
		 rdbtnTarjetaMadre.setSelected(true);
		rdbtnTarjetaMadre.setBounds(6, 22, 109, 23);
		panel.add(rdbtnTarjetaMadre);
		
		 rdbtnMicroprocesador = new JRadioButton("Microprocesador");
		 rdbtnMicroprocesador.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		rdbtnTarjetaMadre.setSelected(false);
			 		rdbtnDiscoDuro.setSelected(false);
			 		rdbtnMemoriaram.setSelected(false);
			 		rdbtnMicroprocesador.setSelected(true);
			 		panel_TarjetaMadre.setVisible(false);
			 		panel_Discoduro.setVisible(false);
			 		panel_Micro.setVisible(true);
			 		panel_MemoriaRam.setVisible(false);
			 	}
			 });
		rdbtnMicroprocesador.setBounds(6, 59, 130, 23);
		panel.add(rdbtnMicroprocesador);
		
		 rdbtnMemoriaram = new JRadioButton("MemoriaRam");
		 rdbtnMemoriaram.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		rdbtnTarjetaMadre.setSelected(false);
			 		rdbtnDiscoDuro.setSelected(false);
			 		rdbtnMemoriaram.setSelected(true);
			 		rdbtnMicroprocesador.setSelected(false);
			 		panel_TarjetaMadre.setVisible(false);
			 		panel_Discoduro.setVisible(false);
			 		panel_Micro.setVisible(false);
			 		panel_MemoriaRam.setVisible(true);
			 	}
			 });
		rdbtnMemoriaram.setBounds(271, 22, 109, 23);
		panel.add(rdbtnMemoriaram);
		
		 rdbtnDiscoDuro = new JRadioButton("Disco Duro");
		 rdbtnDiscoDuro.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		rdbtnTarjetaMadre.setSelected(false);
			 		rdbtnDiscoDuro.setSelected(true);
			 		rdbtnMemoriaram.setSelected(false);
			 		rdbtnMicroprocesador.setSelected(false);
			 		panel_TarjetaMadre.setVisible(false);
			 		panel_Discoduro.setVisible(true);
			 		panel_Micro.setVisible(false);
			 		panel_MemoriaRam.setVisible(false);
			 	}
			 });
		rdbtnDiscoDuro.setBounds(271, 59, 109, 23);
		panel.add(rdbtnDiscoDuro);
		
		 panel_TarjetaMadre = new JPanel();
		panel_TarjetaMadre.setBorder(new TitledBorder(null, "Tarjeta Madre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_TarjetaMadre.setBounds(10, 250, 507, 94);
		contentPanel.add(panel_TarjetaMadre);
		panel_TarjetaMadre.setLayout(null);
		
		JLabel lblTipoDeRam = new JLabel("Tipo de Ram");
		lblTipoDeRam.setBounds(10, 24, 110, 20);
		panel_TarjetaMadre.add(lblTipoDeRam);
		
		JLabel lblConectoralmicro = new JLabel("Conector al micro");
		lblConectoralmicro.setBounds(10, 55, 110, 20);
		panel_TarjetaMadre.add(lblConectoralmicro);
		
		JLabel lblConectorAlDisco = new JLabel("Conector al Disco Duro");
		lblConectorAlDisco.setBounds(232, 26, 130, 17);
		panel_TarjetaMadre.add(lblConectorAlDisco);
		
		comboBox_tipoderam = new JComboBox();
		comboBox_tipoderam.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "DDR", "DDR-2", "DDR-3", "DDR-4"}));
		comboBox_tipoderam.setBounds(130, 24, 92, 20);
		panel_TarjetaMadre.add(comboBox_tipoderam);
		
		comboBox_conectoralmicro = new JComboBox();
		comboBox_conectoralmicro.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "TypeA", "TypeB", "TypeC"}));
		comboBox_conectoralmicro.setBounds(130, 55, 92, 20);
		panel_TarjetaMadre.add(comboBox_conectoralmicro);
		
		comboBox_conectordiscoduro = new JComboBox();
		comboBox_conectordiscoduro.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "IDE", "SATA", "SATA-2", "SATA-3"}));
		comboBox_conectordiscoduro.setBounds(372, 24, 92, 20);
		panel_TarjetaMadre.add(comboBox_conectordiscoduro);
		
		 panel_Micro = new JPanel();
		panel_Micro.setBorder(new TitledBorder(null, "Microprocesador", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Micro.setBounds(10, 250, 507, 94);
		contentPanel.add(panel_Micro);
		panel_Micro.setLayout(null);
		
		JLabel lblVelocidad = new JLabel("Velocidad");
		lblVelocidad.setBounds(10, 24, 110, 20);
		panel_Micro.add(lblVelocidad);
		
		txtmhz = new JTextField();
		txtmhz.setText("(Mhz)");
		txtmhz.setBounds(140, 24, 82, 20);
		panel_Micro.add(txtmhz);
		txtmhz.setColumns(10);
		
		JLabel lblTipoDeConexion = new JLabel("Tipo de conexion");
		lblTipoDeConexion.setBounds(10, 55, 110, 20);
		panel_Micro.add(lblTipoDeConexion);
		
		comboBox_tipodeconexion = new JComboBox();
		comboBox_tipodeconexion.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "TypeA", "TypeB", "TypeC"}));
		comboBox_tipodeconexion.setBounds(130, 55, 92, 20);
		panel_Micro.add(comboBox_tipodeconexion);
		
		 panel_MemoriaRam = new JPanel();
		panel_MemoriaRam.setBorder(new TitledBorder(null, "MemoriaRam", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_MemoriaRam.setBounds(10, 250, 507, 94);
		contentPanel.add(panel_MemoriaRam);
		panel_MemoriaRam.setLayout(null);
		
		JLabel lblCantidaddememoria = new JLabel("Cantidad de Memoria");
		lblCantidaddememoria.setBounds(10, 24, 150, 20);
		panel_MemoriaRam.add(lblCantidaddememoria);
		
		txtgb_1 = new JTextField();
		txtgb_1.setText("(Gb)");
		txtgb_1.setBounds(140, 24, 82, 20);
		panel_MemoriaRam.add(txtgb_1);
		txtgb_1.setColumns(10);
		
		JLabel lblTipoDeMemoria = new JLabel("Tipo de memoria");
		lblTipoDeMemoria.setBounds(10, 55, 110, 20);
		panel_MemoriaRam.add(lblTipoDeMemoria);
		
		comboBox_tipodememoria = new JComboBox();
		comboBox_tipodememoria.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "DDR", "DDR-2", "DDR-3", "DDR-4"}));
		comboBox_tipodememoria.setBounds(130, 55, 92, 20);
		panel_MemoriaRam.add(comboBox_tipodememoria);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Informacion General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 507, 128);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		lblBarcode = new JLabel("Barcode");
		lblBarcode.setBounds(10, 25, 63, 21);
		panel_1.add(lblBarcode);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 57, 63, 21);
		panel_1.add(lblMarca);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 89, 63, 21);
		panel_1.add(lblModelo);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(262, 28, 63, 21);
		panel_1.add(lblPrecio);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(262, 60, 63, 21);
		panel_1.add(lblCantidad);
		
		textField_barcode = new JTextField();
		textField_barcode.setEditable(false);
		textField_barcode.setText("COM-"+(Aplicacion.getInstance().getComponentes().size()+1));		
		textField_barcode.setBounds(83, 25, 86, 20);
		panel_1.add(textField_barcode);
		textField_barcode.setColumns(10);
		
		txtKlk = new JTextField();
		txtKlk.setText("\r\n");
		txtKlk.setBounds(83, 89, 86, 20);
		panel_1.add(txtKlk);
		txtKlk.setColumns(10);
		
		comboBox_marca = new JComboBox();
		comboBox_marca.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Dell"}));
		comboBox_marca.setBounds(83, 57, 108, 20);
		panel_1.add(comboBox_marca);
		
		spinner_cantidad = new JSpinner();
		spinner_cantidad.setModel(new SpinnerNumberModel(1, 1, 20, 1));
		spinner_cantidad.setBounds(335, 57, 87, 20);
		panel_1.add(spinner_cantidad);
		
		spinner_precio = new JSpinner();
		spinner_precio.setModel(new SpinnerNumberModel(new Integer(6000), new Integer(0), null, new Integer(1)));
		spinner_precio.setBounds(335, 25, 87, 20);
		panel_1.add(spinner_precio);
		
		 panel_Discoduro = new JPanel();
		 panel_Discoduro.setBounds(10, 250, 507, 94);
		 contentPanel.add(panel_Discoduro);
		 panel_Discoduro.setBorder(new TitledBorder(null, "Discoduro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		 panel_Discoduro.setLayout(null);
		 
		 JLabel lblAlmacenamiento = new JLabel("Almacenamiento");
		 lblAlmacenamiento.setBounds(10, 24, 110, 20);
		 panel_Discoduro.add(lblAlmacenamiento);
		 
		 txtgb = new JTextField();
		 txtgb.setText("(Gb)");
		 txtgb.setBounds(140, 24, 82, 20);
		 panel_Discoduro.add(txtgb);
		 txtgb.setColumns(10);
		 
		 JLabel lblTipoDeConector = new JLabel("Tipo de conector");
		 lblTipoDeConector.setBounds(10, 55, 110, 20);
		 panel_Discoduro.add(lblTipoDeConector);
		 
		 comboBox_tipodeconector = new JComboBox();
		 comboBox_tipodeconector.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "IDE", "SATA", "SATA-2", "SATA-3"}));
		 comboBox_tipodeconector.setBounds(130, 55, 92, 20);
		 panel_Discoduro.add(comboBox_tipodeconector);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Componente aux = null;
						float precio = Float.parseFloat(spinner_precio.getValue().toString());
						int cantidad = Integer.parseInt(spinner_cantidad.getValue().toString());
						String modelo = txtKlk.getText();
						String marca = comboBox_marca.getSelectedItem().toString();
						String barcode = "COM-"+(Aplicacion.getInstance().getComponentes().size()+1);								
							
						if (rdbtnTarjetaMadre.isSelected()) {
							String tipoderam = comboBox_tipoderam.getSelectedItem().toString();
							String conectoralmicro = comboBox_conectoralmicro.getSelectedItem().toString();
							String conectordiscoduro = comboBox_conectordiscoduro.getSelectedItem().toString();
							aux = new Tarjetamadre(precio, cantidad, barcode, marca, modelo, conectoralmicro, tipoderam, conectordiscoduro);
						
						}
						if (rdbtnMemoriaram.isSelected()) {
							String tipodememoria = comboBox_tipodememoria.getSelectedItem().toString();
							int cantidadmemoria = Integer.parseInt(txtgb_1.getText());
							aux = new Memoriaram(precio, cantidad, barcode, marca, modelo, cantidadmemoria, tipodememoria);
							
						}
						if (rdbtnDiscoDuro.isSelected()) {
							String tipodeconector = comboBox_tipodeconector.getSelectedItem().toString();
							float almacenamiento = Float.parseFloat(txtgb.getText());
							aux = new Discoduro(precio, cantidad, barcode, marca, modelo, almacenamiento, tipodeconector);
							
						}
						if (rdbtnMicroprocesador.isSelected()) {
							String tipodeconexion = comboBox_tipodeconexion.getSelectedItem().toString(); 
							float velocidad = Float.parseFloat(txtmhz.getText());
							aux = new Microprocesadores(precio, cantidad, barcode, marca, modelo, tipodeconexion, velocidad);
							
						}
						Aplicacion.getInstance().agregarComponente(aux);
						
						JOptionPane.showMessageDialog(null, "Operación exitosa", "Información", JOptionPane.INFORMATION_MESSAGE);
						clean();
				
						
					}
				});
				
				btnReinventar = new JButton("Re-inventar");
				btnReinventar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						for(int i=0;i<Aplicacion.getInstance().getComponentes().size();i++) {
							if(Aplicacion.getInstance().getComponentes().get(i).getCantidad_disponible()<5) {
								Aplicacion.getInstance().getComponentes().get(i).setCantidad_disponible(Aplicacion.getInstance().getComponentes().get(i).getCantidad_disponible()+10);
							}			
						}
						
						JOptionPane.showMessageDialog(null, "Operación exitosa", "Información", JOptionPane.INFORMATION_MESSAGE);
						clean();
					}
				});
				buttonPane.add(btnReinventar);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
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
	private void clean() {
		txtgb.setText("");
		textField_barcode.setText("COM-"+(Aplicacion.getInstance().getComponentes().size()+1));
	//	textField_cantidad.setText("");
		txtgb_1.setText("");
	//	textField_conectoralmicro.setText("");
	//	textField_conectordiscoduro.setText("");
	//	textField_marca.setText("");
		txtKlk.setText("");
	//	textField_precio.setText("");
	//	textField_tipodeconector.setText("");
	//	textField_tipodeconexion.setText("");
	//	textField_tipodememoria.setText("");
	//	textField_tipoderam.setText("");
		txtmhz.setText("");	
		comboBox_conectoralmicro.setSelectedIndex(0);
		comboBox_conectordiscoduro.setSelectedIndex(0);
		comboBox_marca.setSelectedIndex(0);
		comboBox_tipodeconector.setSelectedIndex(0);
		comboBox_tipodeconexion.setSelectedIndex(0);
		comboBox_tipoderam.setSelectedIndex(0);
		comboBox_tipodememoria.setSelectedIndex(0);
		spinner_cantidad.setValue(new Integer("1"));
	}
}
