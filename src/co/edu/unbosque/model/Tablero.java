package co.edu.unbosque.model;

import java.util.ArrayList;

public class Tablero {
	
	private Liebre[][] campoliebre;
	private ArrayList<Liebre> camino;
	public Liebre[][] getCampoliebre() {
		return campoliebre;
	}
	public void setCampoliebre(Liebre[][] campoliebre) {
		this.campoliebre = campoliebre;
	}
	public ArrayList<Liebre> getCamino() {
		return camino;
	}
	public void setCamino(ArrayList<Liebre> camino) {
		this.camino = camino;
	}
	public Tablero(Liebre[][] campoliebre) {
		super();
		this.campoliebre = campoliebre;
		this.camino = camino;
	}
	private boolean limitartableto(int x, int y) {
		
		return (x > 0 &&x< (campoliebre.length - 1)) &(y>0&&y<(campoliebre[0].length-1));
	}
	
	public Liebre posicionLiebre(int x ,int y) {
		if (limitartableto(x,y)) {
			return campoliebre[x][y];
		}
		return null;
	}
	
	public void mejorCamino (ArrayList<Liebre> camino1) {
		if (camino!= null && camino.isEmpty() ) {
			camino=camino1;
		}
	
		
	}

	

}
