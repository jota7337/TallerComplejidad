package co.edu.unbosque.model;

public class SolitarioChino {

//	private String[][] tableroInicial = new String[7][7];
//	private String[][] tablero = new String[7][7];

	private int m =37;
	private int n=7;
	

	
	private int movimientosMaximos=37;

	public SolitarioChino() {}
	
	

	
	
	
	

	public void solucion(String[][] tablero) {
		
	}

	public String[][] crearTablero() {
		String[][] tablero = new String[7][7];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {

				tablero[i][j] = "ocupado";
			}
		}

		for (int k = 0; k < 2; k++) {
			tablero[0][k] = "   ";
			tablero[1][k] = "   ";
			tablero[5][k] = "   ";
			tablero[6][k] = "   ";
		}

		for (int p = 5; p < tablero.length; p++) {
			tablero[0][p] = "   ";
			tablero[1][p] = "   ";
			tablero[5][p] = "   ";
			tablero[6][p] = "   ";
		}

		return tablero;
	}

	public String[][] posicionarFicha(int fila, int columna) {
		String[][] tablero = new String[7][7];
		tablero = crearTablero();


		tablero[fila][columna] = "libre";
		return tablero;
	}
	
	

	public void imprimirTablero(String[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {

				System.out.print(tablero[i][j] + " | ");
			}
			System.out.println();
		}

	}
	public String[][] posicionarFicha2(int fila, int columna) {
		String[][] tablero = new String[7][7];
		tablero = crearTablero2();


		tablero[fila][columna] = "ocupado";
		return tablero;
	}

	public String[][] crearTablero2() {
		String[][] tablero = new String[7][7];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {

				tablero[i][j] = "libre";
			}
		}

		for (int k = 0; k < 2; k++) {
			tablero[0][k] = "   ";
			tablero[1][k] = "   ";
			tablero[5][k] = "   ";
			tablero[6][k] = "   ";
		}

		for (int p = 5; p < tablero.length; p++) {
			tablero[0][p] = "   ";
			tablero[1][p] = "   ";
			tablero[5][p] = "   ";
			tablero[6][p] = "   ";
		}

		return tablero;
	}
	
	
	public void imprimirTablero2(String[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {

				System.out.print(tablero[i][j] + " | ");
			}
			System.out.println();
		}

	}
	public Solucion continental (int k,int y,String[][]t,boolean encontrado,Solucion sol ) {
		int i;
		int j;
		t=posicionarFicha(k, y);
		if (fin(k,y,t)){
			encontrado=true;
			
		}
		else {
			for ( i = 1; i < n; i++) {
				for ( j = 1; j < n; j++) {
                    if (valido(i,j,1,t,encontrado)) {
                    	
                    	sol.getS()[k].getOrigen().setX(i);
                    	sol.getS()[k].getOrigen().setY(j);
                    	sol.getS()[k].getDestine().setX(i);
                    	sol.getS()[k].getDestine().setY(j-2);
                    	sol.getS()[k].getComida().setX(i);
                      	sol.getS()[k].getComida().setY(j-1);
                   
                      return	continental(k, y,t, encontrado, sol);
                    }
                    
                     if (valido(i,j,2,t,encontrado)) {
                    	
                    	sol.getS()[k].getOrigen().setX(i);
                    	sol.getS()[k].getOrigen().setY(j);
                    	sol.getS()[k].getDestine().setX(i-2);
                    	sol.getS()[k].getDestine().setX(j);
                    	sol.getS()[k].getComida().setX(i-1);
                      	sol.getS()[k].getComida().setX(j);
                  
                     return 	continental(k,y, t, encontrado, sol);
                    }
                     
                     if (valido(i,j,3,t,encontrado)) {
                     	
                     	sol.getS()[k].getOrigen().setX(i);
                     	sol.getS()[k].getOrigen().setY(j);
                     	sol.getS()[k].getDestine().setX(i);
                     	sol.getS()[k].getDestine().setX(j+2);
                     	sol.getS()[k].getComida().setX(i);
                       	sol.getS()[k].getComida().setX(j+1);
                       
                      return 	continental(k,y, t, encontrado, sol);
                     }
                     
                     if (valido(i,j,4,t,encontrado)) {
                     	
                     	sol.getS()[k].getOrigen().setX(i);
                     	sol.getS()[k].getOrigen().setY(j);
                     	sol.getS()[k].getDestine().setX(i+2);
                     	sol.getS()[k].getDestine().setX(j);
                     	sol.getS()[k].getComida().setX(i+1);
                       	sol.getS()[k].getComida().setX(j);
                    
                       	return continental(k,y, t, encontrado, sol);
                     }
					
				}
				}
		
		}
		return sol;
		
		
	}
	
	


	private boolean valido(int i, int j, int mov, String[][] t, boolean encontrado) {
		if (mov==1) {
			
			return (j-1>0)&&(t[i][j].equals("ocupado")&&t[i][j-1].equals("ocupado")
					&&(j-2>0)&&(t[i][j-2].equals("libre"))&& !encontrado);
		}	else if (mov==2) {
			
			return (i-1>0)&&(t[i-2][j].equals("ocupado")&&t[i][j-1].equals("ocupado")
					&&(i-2>0)&&(t[i-2][j].equals("libre"))&& !encontrado);
		}
		
        else if (mov==3) {
			
			return (j+1<8)&&(t[i][j+1].equals("ocupado")&&t[i][j].equals("ocupado")
					&&(j+2<8)&&(t[i][j+2].equals("libre"))&& !encontrado);
		}
		
      else if (mov==4) {
			
			return (i+1<8)&&(t[i+1][j].equals("ocupado")&&t[i][j].equals("ocupado")
					&&(i+2<8)&&(t[i+2][j].equals("libre"))&& !encontrado);
		}
		
		return false;
		
	
	}

	public boolean fin(int k ,int y, String[][] tablero) {
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!tablero[i][j].equals("libre")) {
					return false;
					
				}else {
					if (!tablero[k][y].equals("ocupada")) {
						return false ;
					}
				}
				
			}
		}
		return true;
	}
	
	


}
