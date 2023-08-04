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
import javax.swing.DefaultComboBoxModel;
import ConversorGeneral.MiConversor.Moneda1;
import ConversorGeneral.MiConversor.Moneda2;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.DrbgParameters.Capability;
import java.text.DecimalFormat;

public class MiConversor {

	private JFrame frmConversor;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JButton btnConvertir;
	private JTextField tf_cantidad1;
	private JLabel lblResultado;

	public enum Moneda1{
		Pesos(1),
		Dolar(4171.78),
		Euro(4570.38),
		Libra(5325.52),
		Yen(29.27),
		Yuan(588.24);

	    private double valor;
	    Moneda1(double valor) {
	        this.valor = valor;
	    }
	}
	public enum Moneda2{
		Pesos(1),
		Dolar(4171.78),
		Euro(4570.38),
		Libra(5325.52),
		Yen(29.27),
		Yuan(588.24);

	    private double valor;
	    Moneda2(double valor) {
	        this.valor = valor;
	    }
	}	
		
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
		
		tf_cantidad1 = new JTextField();
		tf_cantidad1.setBounds(149, 108, 86, 20);
		frmConversor.getContentPane().add(tf_cantidad1);
		tf_cantidad1.setColumns(10);
			
		btnConvertir = new JButton("Convertir");
		btnConvertir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Convertir();
			}
		});
		btnConvertir.setBounds(149, 139, 86, 20);
		frmConversor.getContentPane().add(btnConvertir);
		
		JLabel lblTitulo = new JLabel("Seleccione las divisas a convertir");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitulo.setBounds(94, 20, 195, 16);
		frmConversor.getContentPane().add(lblTitulo);
		
		JLabel lblFlecha = new JLabel(">>>");
		lblFlecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFlecha.setBounds(169, 62, 46, 14);
		frmConversor.getContentPane().add(lblFlecha);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantidad.setBounds(156, 90, 71, 14);
		frmConversor.getContentPane().add(lblCantidad);
			
		lblResultado = new JLabel("Resultado");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResultado.setBounds(71, 170, 242, 14);
		frmConversor.getContentPane().add(lblResultado);	
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setModel(new DefaultComboBoxModel(Moneda1.values()));
		comboBox_1.setBounds(70, 58, 86, 22);
		frmConversor.getContentPane().add(comboBox_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBackground(new Color(255, 255, 255));
		comboBox_2.setModel(new DefaultComboBoxModel(Moneda2.values()));
		comboBox_2.setBounds(226, 58, 86, 22);
		frmConversor.getContentPane().add(comboBox_2);		 
		
	}
	
	// crear la funcion que convierta el valor a la divisa deseada
	private void Convertir() {

		Moneda1 moneda1 = (Moneda1) comboBox_1.getSelectedItem();
		Moneda2 moneda2 = (Moneda2) comboBox_2.getSelectedItem();		
		String cantidad_text = tf_cantidad1.getText();
		double cantidad_double = 0;
		
        try {
        	cantidad_double = Double.parseDouble(cantidad_text);
            System.out.println("El número double es: " + cantidad_text);
        } catch (NumberFormatException e) {
            System.err.println("El formato del número no es válido.");
        }
		
        if (cantidad_double != 0) {
        	
			double resultado = cantidad_double * moneda1.valor / moneda2.valor; 	        
	        DecimalFormat df = new DecimalFormat("#.######");
	        String valorRedondeado = df.format(resultado);	        
	        lblResultado.setText(valorRedondeado);
	        
        }else {
        	lblResultado.setText("Introduzca un número mayor a cero");
        }
		
	} 
	
}

