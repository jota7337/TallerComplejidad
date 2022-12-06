package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Model {
	private SaltoLiebre saltoLiebre;
	private SolitarioChino solitario;

	public Model() {
		saltoLiebre = new SaltoLiebre();
		solitario = new SolitarioChino();

	}
	
	public String leerMatrizLiebre(String matrix[][]) {
		StringBuilder builder = new StringBuilder();
		for (int i = 1; i < (matrix.length - 1); i++) {
			for (int j = 1; j < (matrix.length - 1); j++) {
				builder.append("[" + matrix[i][j] + "]");

			}
			builder.append("\n");
		}
		return builder.toString();
	}
	
	public String leerMatriz(String matrix[][]) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < (matrix.length); i++) {
			for (int j = 0; j < (matrix.length); j++) {
				builder.append("[" + matrix[i][j] + "]");

			}
			builder.append("\n");
		}
		return builder.toString();
	}

	

	/**
	 * Calcula la calorias optimas segun un menu para un menu, usando programacion
	 * dinamica.
	 * 
	 * 
	 * @param calorias        contiene las calorias dependiendo del menu.
	 * @param caloriasMinimas calorias minimas que se deben tener en cuenta para la
	 *                        construccion de las calorias optimas.
	 * @return calorias optimas del menu degun un limite.
	 */
	public int dp(int calorias[], int caloriasMinimas) {
		Arrays.toString(calorias);
		int nums[][] = new int[calorias.length + 1][caloriasMinimas + 1];
		for (int i = 1; i < nums[0].length; i++)
			nums[0][i] = Integer.MAX_VALUE;
		for (int i = 1, compare; i < nums.length; i++) {
			for (int j = 1; j < nums[i].length; j++) {
				if (calorias[i - 1] <= j) {
					compare = nums[i - 1][j - calorias[i - 1]];
					if (compare < Integer.MAX_VALUE)
						compare += calorias[i - 1];
				} else {
					compare = calorias[i - 1];
				}
				nums[i][j] = compare >= j ? Math.min(nums[i - 1][j], compare) : Integer.MAX_VALUE;
			}
		}
		return nums[calorias.length][caloriasMinimas];
	}

	

	public SaltoLiebre getSaltoLiebre() {
		return saltoLiebre;
	}

	public void setSaltoLiebre(SaltoLiebre saltoLiebre) {
		this.saltoLiebre = saltoLiebre;
	}

	public SolitarioChino getSolitario() {
		return solitario;
	}

	public void setSolitario(SolitarioChino solitario) {
		this.solitario = solitario;
	}
	
	

}
