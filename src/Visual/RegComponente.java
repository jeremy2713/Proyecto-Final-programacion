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

public class RegComponente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_tipoderam;
	private JTextField textField_conectoralmicro;
	private JTextField textField_conectordiscoduro;
	private JTextField textField_velocidad;
	private JTextField textField_tipodeconexion;
	private JTextField textField_almacenamiento;
	private JTextField textField_tipodeconector;
	private JTextField textField_cantidaddememoria;
	private JTextField textField_tipodememoria;
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
	private JTextField textField_marca;
	private JTextField textField_modelo;
	private JTextField textField_precio;
	private JTextField textField_cantidad;
	private JButton btnReinventar;
	private JComboBox comboBox_cantidaddememoria;
	private JComboBox comboBox_tipodememoria;
	private JComboBox comboBox_velocidad;
	private JComboBox comboBox_tipodeconexion;
	private JComboBox comboBox_almacenamiento;
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
		setBounds(100, 100, 904, 733);
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
		panel_TarjetaMadre.setBounds(10, 355, 507, 94);
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
		
		textField_tipoderam = new JTextField();
		textField_tipoderam.setBounds(130, 24, 92, 20);
		panel_TarjetaMadre.add(textField_tipoderam);
		textField_tipoderam.setColumns(10);
		
		textField_conectoralmicro = new JTextField();
		textField_conectoralmicro.setBounds(130, 55, 92, 20);
		panel_TarjetaMadre.add(textField_conectoralmicro);
		textField_conectoralmicro.setColumns(10);
		
		textField_conectordiscoduro = new JTextField();
		textField_conectordiscoduro.setBounds(379, 24, 118, 20);
		panel_TarjetaMadre.add(textField_conectordiscoduro);
		textField_conectordiscoduro.setColumns(10);
		
		comboBox_tipoderam = new JComboBox();
		comboBox_tipoderam.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "DDR", "DDR-2", "DDR-3", "DDR-4"}));
		comboBox_tipoderam.setBounds(242, 55, 28, 20);
		panel_TarjetaMadre.add(comboBox_tipoderam);
		
		comboBox_conectoralmicro = new JComboBox();
		comboBox_conectoralmicro.setBounds(294, 55, 28, 20);
		panel_TarjetaMadre.add(comboBox_conectoralmicro);
		
		comboBox_conectordiscoduro = new JComboBox();
		comboBox_conectordiscoduro.setBounds(334, 55, 28, 20);
		panel_TarjetaMadre.add(comboBox_conectordiscoduro);
		
		 panel_Micro = new JPanel();
		panel_Micro.setBorder(new TitledBorder(null, "Microprocesador", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Micro.setBounds(10, 449, 507, 94);
		contentPanel.add(panel_Micro);
		panel_Micro.setLayout(null);
		
		JLabel lblVelocidad = new JLabel("Velocidad");
		lblVelocidad.setBounds(10, 24, 110, 20);
		panel_Micro.add(lblVelocidad);
		
		textField_velocidad = new JTextField();
		textField_velocidad.setBounds(130, 24, 92, 20);
		panel_Micro.add(textField_velocidad);
		textField_velocidad.setColumns(10);
		
		JLabel lblTipoDeConexion = new JLabel("Tipo de conexion");
		lblTipoDeConexion.setBounds(10, 55, 110, 20);
		panel_Micro.add(lblTipoDeConexion);
		
		textField_tipodeconexion = new JTextField();
		textField_tipodeconexion.setBounds(130, 55, 92, 20);
		panel_Micro.add(textField_tipodeconexion);
		textField_tipodeconexion.setColumns(10);
		
		comboBox_velocidad = new JComboBox();
		comboBox_velocidad.setBounds(253, 24, 92, 20);
		panel_Micro.add(comboBox_velocidad);
		
		comboBox_tipodeconexion = new JComboBox();
		comboBox_tipodeconexion.setBounds(253, 55, 92, 20);
		panel_Micro.add(comboBox_tipodeconexion);
		
		 panel_Discoduro = new JPanel();
		panel_Discoduro.setBorder(new TitledBorder(null, "Discoduro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Discoduro.setBounds(10, 554, 507, 94);
		contentPanel.add(panel_Discoduro);
		panel_Discoduro.setLayout(null);
		
		JLabel lblAlmacenamiento = new JLabel("Almacenamiento");
		lblAlmacenamiento.setBounds(10, 24, 110, 20);
		panel_Discoduro.add(lblAlmacenamiento);
		
		textField_almacenamiento = new JTextField();
		textField_almacenamiento.setBounds(130, 24, 92, 20);
		panel_Discoduro.add(textField_almacenamiento);
		textField_almacenamiento.setColumns(10);
		
		JLabel lblTipoDeConector = new JLabel("Tipo de conector");
		lblTipoDeConector.setBounds(10, 55, 110, 20);
		panel_Discoduro.add(lblTipoDeConector);
		
		textField_tipodeconector = new JTextField();
		textField_tipodeconector.setBounds(130, 55, 92, 20);
		panel_Discoduro.add(textField_tipodeconector);
		textField_tipodeconector.setColumns(10);
		
		comboBox_almacenamiento = new JComboBox();
		comboBox_almacenamiento.setBounds(254, 24, 92, 20);
		panel_Discoduro.add(comboBox_almacenamiento);
		
		comboBox_tipodeconector = new JComboBox();
		comboBox_tipodeconector.setBounds(254, 55, 92, 20);
		panel_Discoduro.add(comboBox_tipodeconector);
		
		 panel_MemoriaRam = new JPanel();
		panel_MemoriaRam.setBorder(new TitledBorder(null, "MemoriaRam", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_MemoriaRam.setBounds(10, 250, 507, 94);
		contentPanel.add(panel_MemoriaRam);
		panel_MemoriaRam.setLayout(null);
		
		JLabel lblCantidaddememoria = new JLabel("Cantidad de Memoria");
		lblCantidaddememoria.setBounds(10, 24, 150, 20);
		panel_MemoriaRam.add(lblCantidaddememoria);
		
		textField_cantidaddememoria = new JTextField();
		textField_cantidaddememoria.setBounds(140, 24, 82, 20);
		panel_MemoriaRam.add(textField_cantidaddememoria);
		textField_cantidaddememoria.setColumns(10);
		
		JLabel lblTipoDeMemoria = new JLabel("Tipo de memoria");
		lblTipoDeMemoria.setBounds(10, 55, 110, 20);
		panel_MemoriaRam.add(lblTipoDeMemoria);
		
		textField_tipodememoria = new JTextField();
		textField_tipodememoria.setBounds(130, 55, 92, 20);
		panel_MemoriaRam.add(textField_tipodememoria);
		textField_tipodememoria.setColumns(10);
		
		comboBox_cantidaddememoria = new JComboBox();
		comboBox_cantidaddememoria.setBounds(260, 24, 82, 20);
		panel_MemoriaRam.add(comboBox_cantidaddememoria);
		
		comboBox_tipodememoria = new JComboBox();
		comboBox_tipodememoria.setBounds(260, 55, 82, 20);
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
		
		textField_marca = new JTextField();
		textField_marca.setBounds(83, 57, 86, 20);
		panel_1.add(textField_marca);
		textField_marca.setColumns(10);
		
		textField_modelo = new JTextField();
		textField_modelo.setBounds(83, 89, 86, 20);
		panel_1.add(textField_modelo);
		textField_modelo.setColumns(10);
		
		textField_precio = new JTextField();
		textField_precio.setBounds(335, 25, 86, 20);
		panel_1.add(textField_precio);
		textField_precio.setColumns(10);
		
		textField_cantidad = new JTextField();
		textField_cantidad.setBounds(335, 57, 86, 20);
		panel_1.add(textField_cantidad);
		textField_cantidad.setColumns(10);
		
		comboBox_marca = new JComboBox();
		comboBox_marca.setBounds(184, 57, 28, 20);
		panel_1.add(comboBox_marca);
		
		spinner_cantidad = new JSpinner();
		spinner_cantidad.setBounds(431, 57, 29, 20);
		panel_1.add(spinner_cantidad);
		
		spinner_precio = new JSpinner();
		spinner_precio.setBounds(431, 25, 29, 20);
		panel_1.add(spinner_precio);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Componente aux = null;
						float precio = Float.parseFloat(textField_precio.getText());
						int cantidad = Integer.parseInt(textField_cantidad.getText());
						String modelo = textField_modelo.getText();
						String marca = textField_marca.getText();
						String barcode = "COM-"+(Aplicacion.getInstance().getComponentes().size()+1);								
							
						if (rdbtnTarjetaMadre.isSelected()) {
							String tipoderam = textField_tipoderam.getText();
							String conectoralmicro = textField_conectoralmicro.getText();
							String conectordiscoduro = textField_conectordiscoduro.getText();
							aux = new Tarjetamadre(precio, cantidad, barcode, marca, modelo, conectoralmicro, tipoderam, conectordiscoduro);
						
						}
						if (rdbtnMemoriaram.isSelected()) {
							String tipodememoria = textField_tipodememoria.getText();
							int cantidadmemoria = Integer.parseInt(textField_cantidaddememoria.getText());
							aux = new Memoriaram(precio, cantidad, barcode, marca, modelo, cantidadmemoria, tipodememoria);
							
						}
						if (rdbtnDiscoDuro.isSelected()) {
							String tipodeconector = textField_tipodeconector.getText();
							float almacenamiento = Float.parseFloat(textField_almacenamiento.getText());
							aux = new Discoduro(precio, cantidad, barcode, marca, modelo, almacenamiento, tipodeconector);
							
						}
						if (rdbtnMicroprocesador.isSelected()) {
							String tipodeconexion = textField_tipodeconexion.getText();
							float velocidad = Float.parseFloat(textField_velocidad.getText());
							aux = new Microprocesadores(precio, cantidad, barcode, marca, modelo, tipodeconexion, velocidad);
							
						}
						Aplicacion.getInstance().agregarComponente(aux);
						
						JOptionPane.showMessageDialog(null, "Operación exitosa", "Información", JOptionPane.INFORMATION_MESSAGE);
						clean();
				
						
					}
				});
				
				btnReinventar = new JButton("Re-inventar");
				btnReinventar.addActionListener(new ActionListener() {
					@SuppressWarnings("null")
					public void actionPerformed(ActionEvent e) {
						int cont=0;
						Componente aux = null;
						
						for(int i=0;i<Aplicacion.getInstance().getComponentes().size();i++) {
							if(Aplicacion.getInstance().getComponentes().get(i).getCantidad_disponible()<5) {
								Aplicacion.getInstance().getComponentes().get(i).setCantidad_disponible(Aplicacion.getInstance().getComponentes().get(i).getCantidad_disponible()+10);
							}			
						}
						
						/*
						 * aux.getCantidad_disponible()<5
						while(cont==0 || cont==1) {
							String barcode = "COM-"+(Aplicacion.getInstance().getComponentes().size()+1);
							aux = new Tarjetamadre(1000, 1, barcode, "Dell", "Model33", "micro-usb", "DDR-3", "SATA-2");
							Aplicacion.getInstance().agregarComponente(aux);
							cont++;
						}
						while(cont==2 || cont==3) {
							String barcode = "COM-"+(Aplicacion.getInstance().getComponentes().size()+1);
							aux = new Memoriaram(1000, 1, barcode, "MLLSE", "PC3L-128", 16, "DDR-3");
							Aplicacion.getInstance().agregarComponente(aux);
							cont++;
							
						}
						while(cont==4 || cont==5) {
							String barcode = "COM-"+(Aplicacion.getInstance().getComponentes().size()+1);
							aux = new Discoduro(1000, 1, barcode, "TEYADI", "Model3786", 500, "USB");
							Aplicacion.getInstance().agregarComponente(aux);
							cont++;
							
						}
						while(cont==6 || cont==7) {
							String barcode = "COM-"+(Aplicacion.getInstance().getComponentes().size()+1);
							aux= new Microprocesadores(1000, 1, barcode, "OEM", "Model471", "micro-usb", 2660);
							Aplicacion.getInstance().agregarComponente(aux);
							cont++;
							
						}
							*/
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
		textField_almacenamiento.setText("");
		textField_barcode.setText("COM-"+(Aplicacion.getInstance().getComponentes().size()+1));
		textField_cantidad.setText("");
		textField_cantidaddememoria.setText("");
		textField_conectoralmicro.setText("");
		textField_conectordiscoduro.setText("");
		textField_marca.setText("");
		textField_modelo.setText("");
		textField_precio.setText("");
		textField_tipodeconector.setText("");
		textField_tipodeconexion.setText("");
		textField_tipodememoria.setText("");
		textField_tipoderam.setText("");
		textField_velocidad.setText("");		
	}
}
