package Grafo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Grafo implements Cloneable {

	public int[][] matriz;
	public int[] gradoNodos;
	public int cantAristas;
	public int cantNodos;
	
	private ArrayList<Nodo> nodos = new ArrayList<Nodo>();
	private ArrayList<AristaPonderada> aristas = new ArrayList<AristaPonderada>();;


	

	
	public Grafo(String path) throws FileNotFoundException 
	{
		File file = new File(path);
		Scanner scan = new Scanner(file);
		int peso;


		this.cantNodos = scan.nextInt();
		//this.cantAristas = scan.nextInt();
		inicializarMatriz();
		for (int i = 0; i < this.cantNodos; i++) {
			for(int j = 0; j < this.cantNodos; j++) {
				peso = scan.nextInt();
				matriz[i][j]=peso;
				
				if(peso==99 || peso==-1)
					matriz[i][j]=Integer.MAX_VALUE;
				else if(peso!=0){
					gradoNodos[i]++;
					aristas.add(new AristaPonderada(i,j,peso));
				}
			}
		}
		for (int i = 0; i < this.cantNodos; i++) {
			nodos.add(new Nodo(i,gradoNodos[i]));
		}
		scan.close();
	}

	private void inicializarMatriz()
	{ 
		int n = this.cantNodos;
		matriz = new int[n][n];
		
		for (int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					matriz[i][j] = -1;
		
		gradoNodos= new int[n];
		for (int i = 0; i < n; i++)
			gradoNodos[i]=0;
	}

	public void ponerArista(int fil, int col) 
	{
		this.matriz[fil][col] = 1;
	}
	
	public boolean hayArista(int fil, int col) 
	{
		return this.matriz[fil][col] != 0;
	}
	
	public void sacarArista(int fil, int col)
	{
		this.matriz[fil][col] = 0;
	}
	public  ArrayList<Nodo> getNodos()
	{
		return this.nodos;
	}
	public  ArrayList<AristaPonderada> getAristas()
	{
		return this.aristas;
	}
	
	public Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}

}
