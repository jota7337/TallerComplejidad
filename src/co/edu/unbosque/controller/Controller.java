package co.edu.unbosque.controller;

import java.util.ArrayList;

import co.edu.unbosque.model.Liebre;
import co.edu.unbosque.model.Model;
import co.edu.unbosque.model.SaltoLiebre;
import co.edu.unbosque.view.View;

public class Controller {
	private View vista;
	private Model modelo;
	private SaltoLiebre liebre;

	public Controller() {

		vista = new View();
		modelo = new Model();
		liebre = new SaltoLiebre();

		funcionar();
	}

	public void funcionar() {

		while (vista.getSelect() != 0) {
			int numeroMenu = vista.leerDatoMenu();
			vista.setSelect(numeroMenu);

			switch (vista.getSelect()) {
			case 1:

				break;
			case 2:

				break;

			case 3:
				
				int fila=vista.leerDato("Digite el tamaño de las filas");
				int columna=vista.leerDato("Digite el tamaño de las columnas");
				int x=vista.leerDato("Digite el X inicial");
				int y=vista.leerDato(" Digite el Y inicial");
				int xfinal=vista.leerDato("Digite el X final");
				int yfinal=vista.leerDato("Digite el y final");
				int caminop=vista.leerDato("Digite el p");
				int caminoq=vista.leerDato("Digite el q");
				
				ArrayList<String[][]> siguienteMovimiento = modelo.Solucion(fila, columna, y, x, xfinal, yfinal, caminop, caminoq);

				for (int i = 0; i < siguienteMovimiento.size(); i++) {
					

				vista.mostrarmensaje("Movimiento Salto Liebre "+(i+1)+"\n"+leerMatriz(siguienteMovimiento.get(i)));

				}

				break;

			case 0:

				break;
			default:

				break;
			}
		}

	}

	public String leerMatriz(String matrix[][]) {
		StringBuilder builder = new StringBuilder();
		for (int i = 1; i < (matrix.length - 1); i++) {
			for (int j = 1; j < (matrix.length - 1); j++) {
				builder.append("[" + matrix[i][j] + "]");

			}
			builder.append("\n");
		}
		return builder.toString();
	}
}
