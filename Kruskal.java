package Algoritmo;

import java.util.ArrayList;
import java.util.Collections;

import Auxiliares.CustomComparatorAristas;
import Grafo.AristaPonderada;
import Grafo.Grafo;

public class Kruskal {
	private Grafo grafo;
	private ArrayList<AristaPonderada> arbol;
	
	public static ArrayList<AristaPonderada> kruskal(Grafo graph) {
		ArrayList<AristaPonderada> arbol= new ArrayList<AristaPonderada>();
		ArrayList<AristaPonderada> aristas= graph.getAristas();
		Collections.sort(aristas,new CustomComparatorAristas());
		boolean visited[] = new boolean[graph.cantNodos];
		
		
        for (int i = 0; i < graph.cantNodos; i++) {
            visited[i] = false;
        }
		for(AristaPonderada ar: aristas) {
			if(!visited[ar.getNodo1()] || !visited[ar.getNodo2()] || !hayCiclo(arbol,ar)) {
				arbol.add(ar);
				visited[ar.getNodo1()] = true;
				visited[ar.getNodo2()] = true;
			}
				
		}
		
		return arbol;
		
	}
	private static boolean hayCiclo( ArrayList<AristaPonderada> arbol,AristaPonderada ar ) {
		ArrayList<AristaPonderada> aux1= new ArrayList<AristaPonderada>();
		ArrayList<AristaPonderada> aux2= new ArrayList<AristaPonderada>();
		for(AristaPonderada kru: arbol) {
			if(ar.getNodo1()==kru.getNodo1())
				aux1.add(kru);
			if(ar.getNodo2()==kru.getNodo2())
				aux2.add(kru);
		}
		for(AristaPonderada a1: aux1) {
			for(AristaPonderada a2: aux2) {
				if(a1.getNodo2()==a2.getNodo1())
					return true;
			}
		}
		return false;
	}
	
	
	
}
