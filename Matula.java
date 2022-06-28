package Algoritmo;

import java.util.ArrayList;
import java.util.Collections;

import Auxiliares.Colores;
import Auxiliares.CustomComparator;
import Grafo.Grafo;
import Grafo.Nodo;

public class Matula {
	
	private Grafo grafo;
	
	public static int Matula(Grafo grafo) {
		
		ArrayList<Nodo> nodos= grafo.getNodos();
		Collections.sort(nodos,new CustomComparator());
		int colores=1;
		int[] coloreoNodos= new int[nodos.size()];
		
		for(int i=0; i<nodos.size();i++)
			coloreoNodos[i]=0;
		coloreoNodos[0]=1;
		int ultimoColor=1;
		
		for(int i=1;i<nodos.size();i++) {
			coloreoNodos[i]=1;
			for(int j=0;j<i;j++) {
				if(grafo.matriz[nodos.get(i).getNroNodo()][nodos.get(j).getNroNodo()]> 0 && grafo.matriz[nodos.get(i).getNroNodo()][nodos.get(j).getNroNodo()]!= Integer.MAX_VALUE ) {		
					if(coloreoNodos[j]==coloreoNodos[i]) {
						coloreoNodos[i]++;
					}
				}
			}

			if(ultimoColor < coloreoNodos[i]) {
				colores++;
				ultimoColor=coloreoNodos[i];
			}
				
		}
		//asignar colores a los nodos
		for(int i=0;i<nodos.size();i++) {
			nodos.get(i).setColor(Colores.values()[coloreoNodos[i]]);
		}
		
		return colores;
		
	}
	

}
