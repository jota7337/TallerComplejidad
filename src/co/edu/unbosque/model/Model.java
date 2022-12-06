package co.edu.unbosque.model;

import java.util.Arrays;

public class Model {
	private SaltoLiebre saltoLiebre;
	private SolitarioChino solitario;
	private Nutricionista nutricionista;

	public Model() {
		saltoLiebre = new SaltoLiebre();
		solitario = new SolitarioChino();
		nutricionista = new Nutricionista();

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

	public Nutricionista getNutricionista() {
		return nutricionista;
	}

	public void setNutricionista(Nutricionista nutricionista) {
		this.nutricionista = nutricionista;
	}
	
	
}
