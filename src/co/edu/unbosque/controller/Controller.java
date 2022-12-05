package co.edu.unbosque.controller;

import co.edu.unbosque.model.Model;
import co.edu.unbosque.view.View;

public class Controller {
	private View vista;
	private Model modelo;
	
	
	public Controller() {
		
		vista= new View();
		
		funcionar();
	}
	public void funcionar() {

		

	
		while(vista.getSelect()!=0) {
			int numeroMenu = vista.leerDatoMenu();
			vista.setSelect(numeroMenu);
			
			switch(vista.getSelect()) {
			case 1:
				
	
				
				
				
		         
		
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
