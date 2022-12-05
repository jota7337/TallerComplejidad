package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class view {
	
	
	public  int leerDato(String mensaje) {
		int respuesta=0;
		try {
			
		
		String instruccion=JOptionPane.showInputDialog(mensaje);
		respuesta=Integer.parseInt(instruccion);
	
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Digite un numero");
			respuesta =leerDato(mensaje);
			
		}
		return respuesta;
	}
	public double leerdo(String mensaje) {
		double respuesta=0;
		try {
		
		String instruccion=JOptionPane.showInputDialog(mensaje);
		respuesta=Double.parseDouble(instruccion);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Digite un numero");
			respuesta =leerdo(mensaje);}
		return respuesta;
	}
	
	public void mostrarmensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public String leerDato2(String instruccion) {
		String respuesta = "";
		respuesta = JOptionPane.showInputDialog(instruccion);
		return respuesta;
	}

}
