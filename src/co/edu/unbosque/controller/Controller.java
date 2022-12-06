package co.edu.unbosque.controller;

import java.util.ArrayList;

import co.edu.unbosque.model.Liebre;
import co.edu.unbosque.model.Model;
import co.edu.unbosque.model.SaltoLiebre;
import co.edu.unbosque.view.View;

public class Controller {
	private View vista;
	private Model modelo;

	public Controller() {

		vista = new View();
		modelo = new Model();

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

				vista.mostrarmensaje("Tablero Inicial\n" + modelo.leerMatriz(modelo.getSolitario().crearTablero()));
				modelo.getSolitario().crearTablero();
				int filaSolitario = vista.leerDato("Seleccione la fila donde desea colocar el espacio vacio");
				int columnaSolitario = vista.leerDato("Seleccione la columna donde desea el espacio vacio");

				if (filaSolitario < 0 || columnaSolitario < 0 || filaSolitario > 6 || columnaSolitario > 6) {
					
					vista.mostrarmensaje("El espacio vacio debe encontrarse en las dimensiones del tablero");
					
				} else {

					if ((filaSolitario == 0 || filaSolitario == 1 || filaSolitario == 5 || filaSolitario == 6)
							&& (columnaSolitario == 0 || columnaSolitario == 1 || columnaSolitario == 5
									|| columnaSolitario == 6)) {
						vista.mostrarmensaje("No puede ingresar un espacio en blanco en dicha casilla\n" + "Tenga en cuenta las caracteristicas del tablero");

					} else {

						vista.mostrarmensaje(modelo
								.leerMatriz(modelo.getSolitario().posicionarFicha(filaSolitario, columnaSolitario)));

					}
				}

				break;

			case 3:

				int fila = vista.leerDato("Digite el número de las filas");
				int columna = vista.leerDato("Digite el número de las columnas");
				int x = vista.leerDato("Digite el X inicial");
				int y = vista.leerDato(" Digite el Y inicial");
				int xfinal = vista.leerDato("Digite el X final");
				int yfinal = vista.leerDato("Digite el y final");
				int caminop = vista.leerDato("Digite el p");
				int caminoq = vista.leerDato("Digite el q");

				if (xfinal > fila || yfinal > columna || x > fila || y > fila) {
					vista.mostrarmensaje(
							"Ni el origne ni el destino pueden tener valores mayores a la dimensión del tablero");
				} else {
					if (fila < 0 || columna < 0 || x < 0 || y < 0 || xfinal < 0 || yfinal < 0 || caminop < 0
							|| caminoq < 0) {

						vista.mostrarmensaje("Debe ingresar un número valido para cada uno de los campos");
					} else {

						ArrayList<String[][]> siguienteMovimiento = modelo.getSaltoLiebre().Solucion(fila, columna, y,
								x, xfinal, yfinal, caminop, caminoq);

						for (int i = 0; i < siguienteMovimiento.size(); i++) {

							vista.mostrarmensaje("Movimiento Salto Liebre " + (i + 1) + "\n"
									+ modelo.leerMatrizLiebre(siguienteMovimiento.get(i)));

						}
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
