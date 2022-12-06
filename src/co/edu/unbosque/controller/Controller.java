package co.edu.unbosque.controller;

import java.util.ArrayList;

import co.edu.unbosque.model.Liebre;
import co.edu.unbosque.model.Model;
import co.edu.unbosque.model.SaltoLiebre;
import co.edu.unbosque.view.View;

public class Controller {
	private View vista;
	private Model modelo;
	private  SaltoLiebre liebre;

	
	public Controller() {
		
		vista= new View();
		liebre=new SaltoLiebre();
		
		funcionar();
	}
	public void funcionar() {

		

	
		while(vista.getSelect()!=0) {
			int numeroMenu = vista.leerDatoMenu();
			vista.setSelect(numeroMenu);
			
			switch(vista.getSelect()) {
			case 1:
				
	
				String siguienteMovimiento = liebre.siguienteMovimiento(4, 4, 1, 1, 3, 2, 4, 4);
				
				System.out.println(""+ siguienteMovimiento);
				
		         
		
				break;  
			case 2:
			
			
				break;  
				
			case 3:
				
				
				break;  
		
	
			case 0:
			 
				break;
			default:

				break;
			}
		}
		
		
	}
}
