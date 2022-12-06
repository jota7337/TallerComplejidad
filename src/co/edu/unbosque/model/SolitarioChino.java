package co.edu.unbosque.model;

public class SolitarioChino {

//	private String[][] tableroInicial = new String[7][7];
//	private String[][] tablero = new String[7][7];
	
	private int movimientosMaximos=37;

	public SolitarioChino() {}
	
	
	public void valido(int i, int j, int movimiento, int[] tablero, boolean e) {
		
		
		
		
	}
	
	
	
	

	public void solucion(String[][] tablero) {
		
	}

	public String[][] crearTablero() {
		String[][] tablero = new String[7][7];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {

				tablero[i][j] = "CAS";
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
		tablero[fila][columna] = " F ";
		return tablero;
	}


}
