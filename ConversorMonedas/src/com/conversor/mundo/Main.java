package com.conversor.mundo;
import java.awt.EventQueue;

import com.conversor.interfaz.*;

import java.util.Map;
import java.util.HashMap;

public class Main {
	
	//Arreglos tipo "Diccionario"
	private static final Map<String, Double> dePesosColombianos = new HashMap<>();
    private static final Map<String, Double> deDolares = new HashMap<>();
    private static final Map<String, Double> deEuros = new HashMap<>();
    private static final Map<String, Double> deLibrasEsterlinas = new HashMap<>();
    private static final Map<String, Double> deYenesJaponeses = new HashMap<>();
    private static final Map<String, Double> deWonsSurcoreanos = new HashMap<>();
	
    //Metodo para asignar datos a los arreglos
    static {
    	dePesosColombianos.put("Dólar",0.00025);
		dePesosColombianos.put("Euro", 0.00023);
		dePesosColombianos.put("Libra Esterlina", 0.00020);
		dePesosColombianos.put("Yen Japonés", 0.036);
		dePesosColombianos.put("Won sul-coreano", 0.33);
		
		
		deDolares.put("Peso Colombiano", 3900.0);
		deDolares.put("Euro", 0.91);
		deDolares.put("Libra Esterlina", 0.85);
		deDolares.put("Yen Japonés", 131.97);
		deDolares.put("Won sul-coreano", 122.00);

		
		deEuros.put("Peso Colombiano", 4210.0);
		deEuros.put("Dólar", 1.05);
		deEuros.put("Libra Esterlina", 0.90);
		deEuros.put("Yen Japonés", 139.64);
		deEuros.put("Won sul-coreano", 128.60);

		
		deLibrasEsterlinas.put("Peso Colombiano", 5000.0);
		deLibrasEsterlinas.put("Dólar", 1.15);
		deLibrasEsterlinas.put("Euro", 1.00);
		deLibrasEsterlinas.put("Yen Japonés", 152.95);
		deLibrasEsterlinas.put("Won sul-coreano", 144.00);

		
		deYenesJaponeses.put("Peso Colombiano", 27.78);
		deYenesJaponeses.put("Dólar", 0.0076);
		deYenesJaponeses.put("Euro", 0.0071);
		deYenesJaponeses.put("Libra Esterlina", 0.0062);
		deYenesJaponeses.put("Won sul-coreano", 0.057);

		
		deWonsSurcoreanos.put("Peso Colombiano", 30.30);
		deWonsSurcoreanos.put("Dólar", 0.0082);
		deWonsSurcoreanos.put("Euro", 0.0077);
		deWonsSurcoreanos.put("Libra Esterlina", 0.0066);
		deWonsSurcoreanos.put("Yen Japonés", 0.063);
    }
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalPanel frame = new PrincipalPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	public double convertir(double dato, String monedaI, String monedaO) {
		double tasaConversion =0.0;
		double resultado =0.0;
		if (monedaI.equals(monedaO)) {
			return dato;
		}
		switch (monedaI) {
		
		//De Peso Colombiano
		
        case "Peso Colombiano":
        	tasaConversion = dePesosColombianos.get(monedaO);
            resultado = dato * tasaConversion;
            return resultado;
        	
        //De Dolar
		
        case "Dólar":
        	tasaConversion = deDolares.get(monedaO);
            resultado = dato * tasaConversion;
            return resultado;
         
        //De Euro   
        	
        case "Euro":
        	tasaConversion = deEuros.get(monedaO);
            resultado = dato * tasaConversion;
            return resultado;

        //De Libra Esterlina
        case "Libra Esterlina":
        	tasaConversion = deLibrasEsterlinas.get(monedaO);
            resultado = dato * tasaConversion;
            return resultado;
        //De Yen
        case "Yen Japonés":
        	tasaConversion = deYenesJaponeses.get(monedaO);
            resultado = dato * tasaConversion;
            return resultado;
        //De Won
        case"Won sul-coreano":
        	tasaConversion = deWonsSurcoreanos.get(monedaO);
            resultado = dato * tasaConversion;
            return resultado;
        default:
            throw new IllegalArgumentException("Unknown currency: " + monedaI);
    }  	
}
}