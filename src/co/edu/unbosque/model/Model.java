package co.edu.unbosque.model;

import java.util.ArrayList;

public class Model {
	private SaltoLiebre l;
	
	
	public Model() {
		l= new SaltoLiebre();
		
	}
	
	public ArrayList<String [][]> Solucion(int f, int c, int libreiniciof, int libreinicioc, int librefinalf, int librefinalc, int p, int q) {
		ArrayList<Liebre> lp =l.siguienteMovimiento(f, c, libreiniciof, libreinicioc, librefinalf, librefinalc, p, q);
		ArrayList<String [][]> camino= new ArrayList<String [][]>();
		for(int i= 0;i<lp.size();i++) {
			camino.add(l.rellenarMatriz(f+2, c+2, lp.get(i).getX(), lp.get(i).getY(), librefinalf, librefinalc));
			
			
			
		}
		
		return camino;
		
	}

}
