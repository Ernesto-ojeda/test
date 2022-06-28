package Grafo;
import Auxiliares.Colores;
public class Nodo {

	private int nroNodo;
	private int grado = 0;
	private Colores color;
	
	public Nodo(int nroNodo, int grado) {
		this.nroNodo=nroNodo;
		this.grado=grado;
		color=Colores.NOT_DEFINED;
	}
	public int getNroNodo() 
	{
		return nroNodo;
	}

	public void setNroNodo(int nroNodo) 
	{
		this.nroNodo = nroNodo;
	}

	public int getGrado() 
	{
		return grado;
	}

	public void setGrado(int grado) 
	{
		this.grado = grado;
	}
	public void setColor(Colores color) 
	{
		this.color = color;
	}


	public Nodo(int nodo) 
	{
		this.setNroNodo(nodo);
	}
	
	public void incrementarGrado() 
	{
		this.grado++;
	}

	public String toString() {
		return (this.nroNodo+1) + ", ";
	}

}
