package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Aplicacion;
import img.ImagenFondoPrincipal;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;
	private Aplicacion app;

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
		mnComponentes.add(mntmListarComponente);
		
		JMenuItem mntmCrearCombo = new JMenuItem("Crear Combo");
		mnComponentes.add(mntmCrearCombo);
		
		JMenu mnFacturas = new JMenu("Facturas");
		menuBar.add(mnFacturas);
		
		JMenu mnPedido = new JMenu("Pedido");
		menuBar.add(mnPedido);
		
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
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
