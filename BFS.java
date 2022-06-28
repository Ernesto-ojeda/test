package Algoritmo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import Grafo.Arista;
import Grafo.Grafo;
public class BFS 
{

	private Grafo grafo;
	private int cantNodos;

	private int nodoInicial;
	private ArrayList<Arista> arbol;
	private boolean[] nodoVisitado;

	public BFS(Grafo grafo, int nodoInicial) 
	{
		this.grafo = grafo;
		this.cantNodos = grafo.cantNodos;

		this.nodoInicial = nodoInicial;
		this.arbol = new ArrayList<Arista>();
		this.nodoVisitado = new boolean[this.cantNodos];
	}

	public Set<Integer> ejecutar() throws IOException 
	{
		Queue<Integer> cola = new LinkedList<Integer>(); //Creo una cola que se iguala a una LinkedList.
		cola.offer(this.nodoInicial); //Agrego el nodo inicial.
		int nodo; //Variable auxiliar nodo.
		while(!cola.isEmpty()) { //Mientras la cola no este vacia.
			nodo = cola.peek(); //Asigno nodo al primero de la cola.
			for (int i = 0; i < this.cantNodos; i++)  //For hasta cantidad de nodos.
			{
				if (nodo != i && !this.nodoVisitado[i])  //Si el i es distinto que nodo y el i no fue visitado.
				{
					if (this.grafo.hayArista(nodo, i)) //Si hay arista entre nodo e i
					{
						this.arbol.add(new Arista(nodo, i)); //Agrego al arbol la arista.
						cola.offer(i); //Pongo en la cola el i.
						this.nodoVisitado[i] = true; //Marco el i como visitado.
					}
				}
			}
			nodo = cola.poll(); //Asigno nodo a lo que saco de la cola.
			this.nodoVisitado[nodo] = true;//El nodo fue visitado.
		}
		//this.escribirSolucionEnConsola();
		return nodosLlegados();
	}
	
	public Set<Integer> nodosLlegados()
	{
		Set<Integer> n = new LinkedHashSet<Integer>();
		for (Arista rama : arbol)
		{
			n.add((rama.getNodo1()+1));
			n.add((rama.getNodo2()+1));
		}
		return n;
	}
	public void escribirSolucionEnConsola() 
	{
		System.out.println("BFS: B√∫squeda en Anchura:");
		System.out.println("Cantidad de Ramas del √?rbol: " + this.arbol.size());
		System.out.println("Nodo Inicial del Recorrido (Ra√≠z del √?rbol): " + this.nodoInicial);
		System.out.println("Lista de Ramas:");
		for (Arista rama : arbol)
			System.out.println((rama.getNodo1()+1) + " " + (rama.getNodo2()+1));
	}
	private int maximoEnVector(int v[])
	{
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < v.length; i++)
			if(max<v[i])
				max = v[i];
		return max;
	}
}
