package com.conversor.interfaz;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.conversor.mundo.*;


import java.util.Map;
import java.util.HashMap;

/***
 * 
 * @author Cristhian Poveda
 *
 *Esta clase contiene el panel que se encuentra dentro del Frame.
 *
 *
 */


public class ConversorMoneda extends JPanel {
	private JTextField txtInt;
	private JTextField txtOut;
	private JButton btnLimpiar;
	private JButton btnConvertir;
	private JComboBox listaI;
	private JComboBox listaO;
	
	NumberFormatException exep = new NumberFormatException();
	Main main=new Main();
	
	
	/**
	 * Create the panel.
	 */
	public ConversorMoneda() {
		setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64), 1, true), "Conversor de Monedas", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Ingrese Cantidad");
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Resultado:  ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNewLabel_1);
		
		txtInt = new JTextField();
		add(txtInt);
		txtInt.setColumns(10);
		
		txtOut = new JTextField();
		txtOut.setEditable(false);
		add(txtOut);
		txtOut.setColumns(10);
		
		listaI = new JComboBox();
		listaI.setModel(new DefaultComboBoxModel(new String[] {"Peso Colombiano", "Dólar", "Euro", "Libra Esterlina", "Yen Japonés", "Won sul-coreano"}));
		add(listaI);
		
		listaO = new JComboBox();
		listaO.setModel(new DefaultComboBoxModel(new String[] {"Peso Colombiano", "Dólar", "Euro", "Libra Esterlina", "Yen Japonés", "Won sul-coreano"}));
		add(listaO);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOut.setText("");
				txtInt.setText("");
			}
		});
		add(btnLimpiar);
		
		btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obtenerDatos();		
			}
		});
		add(btnConvertir);
	}

	public JButton getBtnNewButton() {
		return btnLimpiar;
	}
	public JButton getBtnNewButton_1() {
		return btnConvertir;
	}
	
	//
	public void obtenerDatos() {
		Double dato =0.0;
        String monedaI = (String) listaI.getSelectedItem();
		String monedaO = (String) listaO.getSelectedItem();
        try {
        	dato = Double.parseDouble((txtInt.getText()));
        	
        	if ( dato==0.0) {
                JOptionPane.showMessageDialog(this, "Ingresar una Cantidad Valida", "Error", JOptionPane.ERROR_MESSAGE);
                throw new NumberFormatException("Unknown currency: ");
              
            }
        	} catch (NumberFormatException e) {
        	JOptionPane.showMessageDialog(this, "La entrada no es válida", "Error", JOptionPane.ERROR_MESSAGE);
        	}
        
		Double result = main.convertir(dato,monedaI,monedaO );
		txtOut.setText(result.toString());
    }
	//
	public JComboBox getListaI() {
		return listaI;
	}
	public JComboBox getListaO() {
		return listaO;
	}
}
