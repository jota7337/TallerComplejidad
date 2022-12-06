package co.edu.unbosque.model;


import java.util.ArrayList;
import java.util.Arrays;


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

	/**
	 * Calcula la calorias optimas segun un menu para un menu, usando
	 * programacion dinamica.
	 * 
	 * 
	 * @param calorias contiene las calorias dependiendo del menu.
	 * @param caloriasMinimas calorias minimas que se deben tener en cuenta
	 * 		  para la construccion de las calorias optimas.
	 * @return calorias optimas del menu degun un limite.
	 */
	public int dp(int calorias [], int caloriasMinimas){
		Arrays.toString(calorias);
		int nums [][] = new int [calorias.length +1][caloriasMinimas +1];
		for(int i = 1; i < nums[0].length; i++)
			nums[0][i] = Integer.MAX_VALUE;
		for(int i = 1, compare; i < nums.length; i++) {
			for(int j = 1; j < nums[i].length; j++) {
				if(calorias[i - 1] <= j) {
					compare = nums[i - 1][j - calorias[i - 1]];
					if(compare < Integer.MAX_VALUE)
						compare += calorias[i - 1];
				}else {
					compare = calorias[i - 1];
				}
				nums[i][j] = compare >= j? Math.min(nums[i - 1][j], compare) : Integer.MAX_VALUE;
			}
		}
		return nums[calorias.length][caloriasMinimas];
	}
	
}
