package co.edu.unbosque.model;
import java.util.Scanner;

public class SolitarioChino {

//	private String[][] tableroInicial = new String[7][7];
//	private String[][] tablero = new String[7][7];
	Scanner sc = new Scanner(System.in);
	
	int movimientosMaximos=37;

	public SolitarioChino() {

		funcionar();
		

	}

	public void funcionar() {

		crearTablero();
		System.out.println("Seleccione la fila donde desea colocar la ficha");
		int fila = sc.nextInt();

		System.out.println("Seleccione la columna donde desea colocar la ficha");
		int columna = sc.nextInt();

		if ((fila == 0 || fila == 1 || fila == 5 || fila == 6)
				&& (columna == 0 || columna == 1 || columna == 5 || columna == 6)) {
			System.out.println("No puede ingresar una ficha en dicha casilla");
			funcionar();

		} else {

			imprimirTablero(posicionarFicha(fila, columna));
			
		}

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

		System.out.println("El tablero inicial es: ");
		imprimirTablero(tablero);

		return tablero;
	}

	public String[][] posicionarFicha(int fila, int columna) {
		String[][] tablero = new String[7][7];
		tablero = crearTablero();

		tablero[fila][columna] = " F ";
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

}
