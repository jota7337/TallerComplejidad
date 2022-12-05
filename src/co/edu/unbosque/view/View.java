package co.edu.unbosque.view;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class View {
	
	private int select;
	
	
	
	
	public View() {
	
		select=-1;
		
	}
	
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
	
	public String leerDatoString(String instruccion) {
		String respuesta = "";
		respuesta = JOptionPane.showInputDialog(instruccion);
		return respuesta;
	}
	
	public int leerDatoMenu() {
		int respuesta =0;
		try {
	
		String mensaje = JOptionPane.showInputDialog("Digite que ejercicio quiere hacer:"
				+"\n1. Nutricionista"
				+"\n2. Solitario continental"
				+"\n3. Salto liebre"
				
			
				+"\n0. Salir");
		respuesta = Integer.parseInt(mensaje);
	
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, "Digite de nuevo una opcion valida");
			respuesta=leerDatoMenu();
		
			
			
		}
		return respuesta;
		
	}
	public int getSelect() {
		return select;
	}

	public void setSelect(int select) {
		this.select = select;
	}
}
