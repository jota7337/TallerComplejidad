package co.edu.unbosque.controller;

import co.edu.unbosque.view.view;

public class controller {
	private view vista;
	
	
	public controller() {
		vista= new view();
		
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
		
	
			case 0:
			 
				break;
			default:

				break;
			}
		}
		
		
	}
}
