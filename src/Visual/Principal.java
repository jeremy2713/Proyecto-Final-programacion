package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Aplicacion;
import Logico.Cliente;
import Logico.Factura;
import img.ImagenFondoPrincipal;


import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBoxMenuItem;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;
	private Aplicacion app;
	private Factura factura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImagenFondoPrincipal p = new ImagenFondoPrincipal("/img/Fondo.jpeg");// Ruta de la imagen de fondo
					Principal frame = new Principal();
					frame.setVisible(true);
					frame.getContentPane().add(p);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {

		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream tienda2;
				ObjectOutputStream tiendaEscritura;
				try {
					tienda2 = new  FileOutputStream("tienda.dat");
					tiendaEscritura = new ObjectOutputStream(tienda2);
					tiendaEscritura.writeObject(Aplicacion.getInstance());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

		File datos = new File("Electronica.dat");
		if(datos.exists()) {
			FileInputStream entradaFichero;
			 try {
	                entradaFichero = new FileInputStream(datos);
	                ObjectInputStream entrada = new ObjectInputStream(entradaFichero);
	                Aplicacion.setInstance((Aplicacion)entrada.readObject());
	                entradaFichero.close();
	            } catch (FileNotFoundException e) {
	                e.printStackTrace();
	            } catch (ClassNotFoundException e) {
	                e.printStackTrace();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
			
		}
		addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent arg0) {
                FileOutputStream f;
                try {
                    f = new FileOutputStream("Electronica.dat");
                    ObjectOutputStream guardar = new ObjectOutputStream(f);
                    guardar.writeObject(Aplicacion.getInstance());
                    f.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setBounds(100, 100, 450, 300);
		dim = super.getToolkit().getScreenSize();
		super.setSize(dim.width,(dim.height - 50));
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmRegistrarCliente = new JMenuItem("Registrar Cliente");
		mntmRegistrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegCliente Regc = new RegCliente(null);
				Regc.setModal(true);
				Regc.setLocationRelativeTo(null);
				Regc.setVisible(true);
			}
		});
		mnClientes.add(mntmRegistrarCliente);
		
		JMenuItem mntmListaDeCliente = new JMenuItem("Lista De Cliente");
		mntmListaDeCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaCliente Listc = new ListaCliente();
				Listc.setModal(true);
				Listc.setLocationRelativeTo(null);
				Listc.setVisible(true);
			}
		});
		mnClientes.add(mntmListaDeCliente);
		
		JMenu mnComponentes = new JMenu("Componentes");
		menuBar.add(mnComponentes);
		
		JMenuItem mntmRegistrarComponente = new JMenuItem("Registrar Componente");
		mntmRegistrarComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegComponente Regcom = new RegComponente();
				Regcom.setModal(true);
				Regcom.setLocationRelativeTo(null);
				Regcom.setVisible(true);
			}
		});
		mnComponentes.add(mntmRegistrarComponente);
		
		JMenuItem mntmListarComponente = new JMenuItem("Listar Componente");
		mntmListarComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListComponent listcompo = new ListComponent(Aplicacion.getInstance().getComponentes());
				listcompo.setModal(true);
				listcompo.setVisible(true);
			}
		});
		mnComponentes.add(mntmListarComponente);
		
		JMenu mnFacturas = new JMenu("Facturas");
		menuBar.add(mnFacturas);
		
		JMenuItem mntmRealizarFacturas = new JMenuItem("Realizar Facturas");
		mnFacturas.add(mntmRealizarFacturas);
		
		JMenu mnPedido = new JMenu("Pedido");
		menuBar.add(mnPedido);
		
		JMenu mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);
		
		JMenuItem mntmRegistrar = new JMenuItem("Registrar");
		mntmRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Registrousuario registrousuario = new Registrousuario();
			  //  registrousuario.setModal(true);
				registrousuario.setLocationRelativeTo(null);
				registrousuario.setVisible(true);
				
			}
		});
		mnUsuario.add(mntmRegistrar);

		JMenuItem mntmHacerPedido = new JMenuItem("Hacer Pedido");
		mntmHacerPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pedido Pedido = new Pedido();
				Pedido.setModal(true);
				Pedido.setLocationRelativeTo(null);
				Pedido.setVisible(true);
			}
		});
		mnPedido.add(mntmHacerPedido);
		
		JMenuItem mntmComprarCombo = new JMenuItem("Comprar Combo");
		mntmComprarCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RealizarCombo combo = new RealizarCombo();
				combo.setModal(true);
				combo.setVisible(true);
			

			}
		});
		mnPedido.add(mntmComprarCombo);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
