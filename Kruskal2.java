package Algoritmo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

import Auxiliares.CustomComparatorAristas;
import Grafo.Arista;
import Grafo.AristaPonderada;
import Grafo.Grafo;
import Grafo.Nodo;

public class Kruskal2 {
	
	private Grafo grafo;
	private ArrayList<AristaPonderada> arbol;
    // make subset of each vertex
	
	public static ArrayList<AristaPonderada> kruskal(Grafo graph) {
		ArrayList<AristaPonderada> arbol= new ArrayList<AristaPonderada>();
		ArrayList<AristaPonderada> aristas= graph.getAristas();
		ArrayList<HashSet<Nodo>> subsets = new ArrayList<>();
		ArrayList<Nodo> nodos= graph.getNodos();
		Collections.sort(aristas,new CustomComparatorAristas());
		
		for (int i = 0; i < nodos.size(); i++) {
        HashSet<Nodo> set = new HashSet<>();
        set.add(nodos.get(i));
        subsets.add(set);
    }

    // sorting the edges based on the weight
    System.out.println("The input Graph with 10 vertex and following edges");
    System.out.println("The MST after running Kruskals Algorithm");
    System.out.println("Src --> Dst == Wt");
    // Union and Find algorithm to detect a cycle
    for (int i = 0; i < aristas.size(); i++) {
        AristaPonderada edg = aristas.get(i);
        Nodo srcNode = nodos.get(edg.getNodo1());
        Nodo destNode = nodos.get(edg.getNodo2());

        if (find(srcNode,subsets) != find(destNode,subsets)) {
            System.out.println(edg.getNodo1() + " --> " + edg.getNodo2() + " == " + edg.getPeso());
            union(find(srcNode,subsets), find(destNode,subsets),subsets);
            arbol.add(edg);
        }
    }
    return arbol;
}

	private static void union(int aSubset, int bSubset,ArrayList<HashSet<Nodo>> subsets) {
	    HashSet<Nodo> aSet = subsets.get(aSubset);
	    HashSet<Nodo> bSet = subsets.get(bSubset);
	    //adding all elements of subsetB in subsetA and deleting subsetB
	    Iterator<Nodo> iter = bSet.iterator();
	    while (iter.hasNext()) {
	        Nodo b = iter.next();
	        aSet.add(b);
	    }
	    subsets.remove(bSubset);
	
	}
	
	
	
	
	
	private static int find(Nodo node, ArrayList<HashSet<Nodo>> subsets) {
	    int number = -1;
	
	    for (int i = 0; i < subsets.size(); i++) {
	        HashSet<Nodo> set = subsets.get(i);
	        Iterator<Nodo> iterator = set.iterator();
	        while (iterator.hasNext()) {
	            Nodo setnode = iterator.next();
	            if (setnode.getNroNodo() == node.getNroNodo() ) {
	                number = i;
	                return number;
	            }
	
	        }
	    }
	    return number;
	}
}
