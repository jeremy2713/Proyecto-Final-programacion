package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import img.ImagenFondoPrincipal;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImagenFondoPrincipal p = new ImagenFondoPrincipal("/img/Fondo.jpeg");
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
		
		JMenu mnComponentes = new JMenu("Componentes");
		menuBar.add(mnComponentes);
		
		JMenuItem mntmRegistrarComponente = new JMenuItem("Registrar Componente");
		mnComponentes.add(mntmRegistrarComponente);
		
		JMenuItem mntmListarComponente = new JMenuItem("Listar Componente");
		mnComponentes.add(mntmListarComponente);
		
		JMenuItem mntmCrearCombo = new JMenuItem("Crear Combo");
		mnComponentes.add(mntmCrearCombo);
		
		JMenu mnFacturas = new JMenu("Facturas");
		menuBar.add(mnFacturas);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
