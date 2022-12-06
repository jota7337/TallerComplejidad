package co.edu.unbosque.model;

import java.util.ArrayList;

public class SaltoLiebre {

	private String[][] campo;

	public String[][] rellenarMatriz(int f, int c, int ic, int iff, int fc, int ff) {

		campo = new String[f][c];

		for (int i = 0; i < campo.length; i++) {
			for (int j = 0; j < campo.length; j++) {

				campo[i][j] = "0";

			}

			campo[ic][iff] = "liebre";
			campo[fc][ff] = "Destino";

		}

		return campo;
	}

	public boolean casillalibre(Liebre c) {

		if (c != null && !c.isLiebrepasado()) {
			return true;
		}
		return false;
	}

	public void ramaYpoda(Tablero tablero, Liebre actual, ArrayList<Liebre> camino, int p, int q, int antes,
			String direcion) {

		if (actual.isTermino()) {
			tablero.mejorCamino((ArrayList<Liebre>) camino.clone());

		} else {
			if (p != 0 && direcion.equals("q")) {
				p--;
				int[][] descripcion = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
				caminoPosibles(tablero, actual, camino, p, q, antes, direcion, descripcion);

			}

			if (q != 0 && direcion.equals("p")) {
				q--;
				if (antes == 0 || antes == 2) {

					int[][] descripcion = { { 0, 1 }, { 0, -1 } };
					caminoPosibles(tablero, actual, camino, p, q, antes, direcion, descripcion);
				} else {

					int[][] descripcion = { { -1, 0 }, { 1, 0 } };
					caminoPosibles(tablero, actual, camino, p, q, antes, direcion, descripcion);

				}
			}

		}

	}

	public void caminoPosibles(Tablero tablero, Liebre actual, ArrayList<Liebre> camino, int p, int q, int antes,
			String saber, int[][] salto) {
		Liebre z;
		int x;
		int y;

		for (int i = 0; i < salto.length; i++) {
			x = actual.getX() + salto[i][0];
			y = actual.getY() + salto[i][1];
			z = tablero.posicionLiebre(x, y);

			if (casillalibre(actual)) {
				System.out.println("entra al if");
				camino.add(z);
				actual.setLiebrepasado(true);
                 ramaYpoda(tablero, actual, camino, p, q, antes, saber);    
				actual.setLiebrepasado(false);
				camino.remove(z);

			}

		}
	}

	public String siguienteMovimiento(int f, int c, int iff, int ic, int ff, int fc, int p, int q) {
		Liebre[][] campo = new Liebre[f + 2][c + 2];

		for (int i = 1; i < (campo.length - 1); i++) {
			for (int j = 1; j < (campo.length - 1); j++) {

				campo[i][j] = new Liebre(i,j);

			}

		}

		campo[ff][fc].setTermino(true);
		
		ArrayList<Liebre> camino =new ArrayList<>();
		int  pCamino =p;
		int qCaminos=q;
		int anterior = 0;
		Tablero trayectoria=new Tablero(campo);
		camino.add(campo[iff][ic]);
		ramaYpoda(trayectoria, campo[iff][ic], camino, pCamino, qCaminos, anterior, "q");
		return trayectoria.mostrarCaminos();
		
	}
}
