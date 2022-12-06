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

				modelo.getSolitario().crearTablero();
				int filaSolitario = vista.leerDato("Seleccione la fila donde desea colocar la ficha");
				int columnaSolitario = vista.leerDato("Seleccione la columna donde desea colocar la ficha");

				if ((filaSolitario == 0 || filaSolitario == 1 || filaSolitario == 5 || filaSolitario == 6)
						&& (columnaSolitario == 0 || columnaSolitario == 1 || columnaSolitario == 5
								|| columnaSolitario == 6)) {
					vista.mostrarmensaje("No puede ingresar una ficha en dicha casilla");

				} else {

					modelo.getSolitario()
							.imprimirTablero(modelo.getSolitario().posicionarFicha(filaSolitario, columnaSolitario));

				}

				break;

			case 3:

				int fila = vista.leerDato("Digite el tamaño de las filas");
				int columna = vista.leerDato("Digite el tamaño de las columnas");
				int x = vista.leerDato("Digite el X inicial");
				int y = vista.leerDato(" Digite el Y inicial");
				int xfinal = vista.leerDato("Digite el X final");
				int yfinal = vista.leerDato("Digite el y final");
				int caminop = vista.leerDato("Digite el p");
				int caminoq = vista.leerDato("Digite el q");

				if (fila < 0 || columna < 0 || x < 0 || y < 0 || xfinal < 0 || yfinal < 0 || caminop < 0
						|| caminoq < 0) {

					vista.mostrarmensaje("Debe ingresar un número valido para cada uno de los campos");
				} else {

					ArrayList<String[][]> siguienteMovimiento = modelo.getSaltoLiebre().Solucion(fila, columna, y, x,
							xfinal, yfinal, caminop, caminoq);

					for (int i = 0; i < siguienteMovimiento.size(); i++) {

						vista.mostrarmensaje("Movimiento Salto Liebre " + (i + 1) + "\n"
								+ modelo.leerMatriz(siguienteMovimiento.get(i)));

					}
				}

				break;

			case 0:

				break;
			default:

				break;
			}
		}

	}

}
