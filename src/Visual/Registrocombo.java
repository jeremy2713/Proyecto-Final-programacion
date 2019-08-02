package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;

public class Registrocombo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Registrocombo dialog = new Registrocombo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Registrocombo() {
		setBounds(100, 100, 744, 493);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 16, 692, 105);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(330, 16, 79, 29);
		panel.add(btnBuscar);
		{
			textField = new JTextField();
			textField.setBounds(169, 17, 146, 26);
			panel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblBusquedaComponentes = new JLabel("Componentes");
			lblBusquedaComponentes.setBounds(51, 20, 103, 20);
			panel.add(lblBusquedaComponentes);
		}
		
		JList list = new JList();
		list.setBounds(60, 138, 232, 231);
		contentPanel.add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(391, 138, 237, 231);
		contentPanel.add(list_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
