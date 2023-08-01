package ConversorGeneral;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MiConversor {

	private JFrame frmConversor;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiConversor window = new MiConversor();
					window.frmConversor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MiConversor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConversor = new JFrame();
		frmConversor.setTitle("Conversor");
		frmConversor.setBounds(100, 100, 400, 250);
		frmConversor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConversor.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(149, 105, 86, 20);
		frmConversor.getContentPane().add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(226, 66, 86, 22);
		frmConversor.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Convertir");
		btnNewButton.setBounds(149, 133, 86, 20);
		frmConversor.getContentPane().add(btnNewButton);
		
		JLabel titulo = new JLabel("Seleccione las divisas a convertir");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		titulo.setBounds(94, 20, 195, 16);
		frmConversor.getContentPane().add(titulo);
		
		JLabel lblNewLabel_1 = new JLabel("----->");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(169, 70, 46, 14);
		frmConversor.getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(70, 66, 86, 22);
		frmConversor.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("Resultado");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(156, 172, 71, 14);
		frmConversor.getContentPane().add(lblNewLabel);
	}
}

