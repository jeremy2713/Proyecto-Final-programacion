package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Factura;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DetallesFactura extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			DetallesFactura dialog = new DetallesFactura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DetallesFactura(Factura aux) {
		setTitle("Detalles de la Factura");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 11, 414, 206);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JTextPane textPane = new JTextPane();
			textPane.setEditable(false);
			textPane.setText("\"El mundo del componente\"\r\n\r\nCodigo de Factura: "+aux.getCodigo()+"\r\nNombre del Cliente: "+aux.getElcliente().getNombre()+"\r\nCedula del cliente: "+aux.getElcliente().getCedula()+"\r\nCantidad de Componentes: "+aux.getMiscomponentes().size()+"\r\nTotal de la Orden: "+aux.getPreciototal());
			textPane.setBounds(10, 11, 394, 184);
			panel.add(textPane);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
}
