package Algoritmo;
// A Java program that finds the shortest path using Dijkstra's algorithm.  
// The program uses the adjacency matrix for the representation of a graph   
  
// import statements  
import java.util.*;

import Grafo.Grafo;
import Grafo.Nodo;

import java.io.*;  
import java.lang.*;  
  
public class Dijkstra   
{  
	private int totalVertex;
	private Grafo grafo;


	public Dijkstra(Grafo grafo) {
		super();
		this.totalVertex = grafo.cantNodos;
		this.grafo = grafo;
	}

	int minimumDistance(int distance[], Boolean spSet[])  {  

		int m = Integer.MAX_VALUE, m_index = -1;  	  
		for (Nodo e : grafo.getNodos() )  {  
		if (spSet[e.getNroNodo()] == false && distance[e.getNroNodo()] <= m )   {
			m = distance[e.getNroNodo()];  
			m_index = e.getNroNodo();  
		}  
	}  
	return m_index;  
	  
	}    

	void dijkstra(int s) {  
		int distance[] = new int[totalVertex];  
		Boolean spSet[] = new Boolean[totalVertex]; 
		// Parent array to store shortest path tree
		int[] parents = new int[totalVertex];
		parents[s] = -1;
	    
		for (int j = 0; j < totalVertex; j++){  
		distance[j] = Integer.MAX_VALUE;
		spSet[j] = false;  
		}  
		
		distance[s] = 0;  


		for (int cnt = 0; cnt < totalVertex - 1; cnt++)   
		{  
			int ux = minimumDistance(distance, spSet);  
			spSet[ux] = true;  

			for (Nodo e : grafo.getNodos() ) { 
				if (!spSet[e.getNroNodo()] && grafo.matriz[ux][e.getNroNodo()] != -1 && distance[ux] != Integer.MAX_VALUE && distance[ux] + grafo.matriz[ux][e.getNroNodo()] < distance[e.getNroNodo()])  {  			
						distance[e.getNroNodo()] = distance[ux] + grafo.matriz[ux][e.getNroNodo()];
						parents[e.getNroNodo()] = ux;	
				}
			}
		}
		printSolution(distance,s, parents);
	}

	void printPath(int parent[], int j)
	{
	    // Base Case : If j is source
	    if (parent[j] == -1)
	        return;
	   
	    printPath(parent, parent[j]);
	    System.out.print((j+1) + " ");;
	}
	void printSolution(int dist[], int n, int parent[])
	{
	    int src = n;
	    System.out.print("Vertex\t Distance\tPath");
	    for (int i = 0; i < totalVertex; i++) {
	    	if(dist[i]!=Integer.MAX_VALUE) {
		    	System.out.print("\n"+ (src+1) + "->" + (i+1) +"\t\t "+ dist[i]+"\t\t" + (src+1) +" ");
		        printPath(parent, i);
	    	}
	    }
	}
}  
