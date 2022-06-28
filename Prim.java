package Algoritmo;

import Grafo.Grafo;
import Grafo.Nodo;

import java.util.ArrayList;
import java.util.Collections;

import Auxiliares.CustomComparator;
import Grafo.AristaPonderada;

public class Prim {
	private Grafo grafo;
	private ArrayList<AristaPonderada> arbol;
	
	public static ArrayList<AristaPonderada> prim(Grafo graph) {
		ArrayList<AristaPonderada> arbol= new ArrayList<AristaPonderada>();
		
		
        // visitado [] marca si el nodo (vértice) ha sido visitado
        int v= minNodo(graph);
		boolean visited[] = new boolean[graph.cantNodos];
        // visitado [] El valor del elemento predeterminado es 0, lo que significa que no ha sido visitado
        for (int i = 0; i < graph.cantNodos; i++) {
            visited[i] = false;
        }

        // Marcar el nodo actual como visitado
        visited[v] = true;
        // h1 y h2 registran los subíndices de los dos vértices
        int h1 = -1;
        int h2 = -1;
        int minWeight = Integer.MAX_VALUE; // Inicializar minWeight a un número grande, que será reemplazado más adelante en el proceso transversal
        for (int k = 1; k < graph.cantNodos; k++) {// Debido a que hay vértices graph.verxs, después de que finaliza el algoritmo de Plim, hay bordes graph.verxs-1
            // Esto es para determinar cada subgrafo generado, qué nodo es el más cercano
            for (int i = 0; i < graph.cantNodos; i++) {// i nodo representa el nodo que se ha visitado
                for (int j = 0; j < graph.cantNodos; j++) {// j nodo significa un nodo que no ha sido visitado
                    if (visited[i] == true && visited[j] == false && graph.matriz[i][j] < minWeight) {
                        // Reemplazar minWeight (encuentra el borde con el menor peso entre el nodo que se ha visitado y el nodo que no se ha visitado)
                        minWeight = graph.matriz[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            arbol.add(new AristaPonderada(h1,h2,minWeight));
            visited[h2] = true;
            // minWeight se restablece al valor máximo de 10000
            minWeight = Integer.MAX_VALUE;
        }
        return arbol;
    }

	private static int minNodo(Grafo graph) {
		int menorPesoNodo=0;
        int menValor=Integer.MAX_VALUE;
        int valor;
		for (int i = 0; i < graph.cantNodos; i++) {
			for (int j = 0; j < graph.cantNodos; j++) {
				valor=graph.matriz[i][j];
				if(valor<menValor) {
					menValor=valor;
					menorPesoNodo=i;
				}
	        }

        }
		return menorPesoNodo;
	}
	
}

