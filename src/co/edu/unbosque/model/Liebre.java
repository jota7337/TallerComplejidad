package co.edu.unbosque.model;

public class Liebre {
	
	private int x;
	private boolean termino;
	private int y;
	private boolean liebrepasado;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public boolean isTermino() {
		return termino;
	}
	public void setTermino(boolean termino) {
		this.termino = termino;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isLiebrepasado() {
		return liebrepasado;
	}
	public void setLiebrepasado(boolean liebrepasado) {
		this.liebrepasado = liebrepasado;
	}
	
	@Override
	public String toString() {
		return "Liebre [x=" + x + ", y=" + y + "]";
	}
	public Liebre(int x, int y) {
	
		this.x = x;
		this.y = y;
		this.liebrepasado=false;
		this.termino=false;
		
	}


}
