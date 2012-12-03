package node;
import java.io.*;
import java.util.*;

public class Node {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This is a node");
		

		class Arc {
		  Noeud n; // destination de cet arc
		  Arc s;   // suite de la liste d'adjacences

		  public Arc(Noeud n, Arc s) {
		    this.n = n;
		    this.s = s;
		  }

		  // insertion itérative dans une liste d'adjacences, en maintenant l'ordre sur les noeuds
		  public Arc insertionIterative(Noeud n, Arc l) {
		    Arc l1 = null, l2 = l;
		    while ( l2 != null && l2.n.num < n.num ) {
		      l1 = l2;
		      l2 = l2.s;
		    }
		    if ( l2 == null || l2.n.num > n.num ) { // pour éviter la duplication
		      if ( l1 == null )
		        return new Arc(n, l2); // insertion en tête
		      else
		        l1.s = new Arc(n, l2); // insertion entre l1 et l2
		    }
		    return l;
		  }

		  // retourne une description de cet arc et des suivants
		  public String toString() {
		    String s = "" + n.num;
		    for ( Arc l = this.s; l != null; l = l.s )
		      s = s + ' ' + l.n.num;
		    return s;
		  }

		} // end class Arc

		class Noeud {
		  int num;  // indice dans le graphe
		  int x, y; // position
		  Arc adj;  // liste des noeuds adjacents
		  int val;  // une valeur, utilisable comme marqueur

		  // constructeur avec la position (x,y)
		  public Noeud(int x, int y) {
		    num = -1;
		    this.x = x;
		    this.y = y;
		    adj = null;
		    val = 0;
		  }

		  // retourne la distance de ce noeud au point de coordonnées (x,y)
		  public int dist(int x, int y) {
		    return Math.max(Math.abs(this.x-x), Math.abs(this.y-y));
		  }

		  // opération classique d'ajout d'un arc de ce noeud vers le noeud n
		  public void ajouterArc(Noeud n) {
		    adj = Arc.insertionIterative(n, adj);
		  }

		  // retourne une description de ce noeud
		  public String toString() {
		    return "noeud " + num + "  coord = (" + x + ',' + y + ")   adj = " + adj;
		  }

		} // end class Noeud

		class Graphe {
		  Noeud[] noeuds;

		  // constructeur avec taille du tableau
		  public Graphe(int n) {
		    noeuds = new Noeud[n];
		  }

		  // retourne le nombre de places disponibles dans le tableau
		  public int disponible() {
		    int n = 0;
		    for ( int i = 0; i < noeuds.length; i++ )
		      if ( noeuds[i] == null )
		        n++;
		    return n;
		  }

		  // ajoute le noeud n, à la première place disponible dans le tableau
		  public void ajouterNoeud(Noeud n) {
		    for ( int i = 0; i < noeuds.length; i++ )
		      if ( noeuds[i] == null ) {
		        noeuds[i] = n;
		        n.num = i;      // important
		        return;
		      }
		    throw new Error("plus de place");
		  }

		  static final int DIST = 10;
		  // retourne le premier noeud assez proche du point de coordonnées (x,y)
		  public Noeud chercherNoeud(int x, int y) {
		    for ( int i = 0; i < noeuds.length; i++ )
		      if ( noeuds[i] != null && noeuds[i].dist(x, y) < DIST )
		        return noeuds[i];
		    return null;
		  }

		} // end class Graphe

	}

}
