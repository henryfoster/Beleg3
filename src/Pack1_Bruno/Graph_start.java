Package Pack1;

public class Graph_start
{
  private int knzahl = 0;
  int [][] kante;  // Kantenmatrix
  int [] knoten;  // Knotenvektor

  Graph_start(int kn) {  // kn maximale Knotenzahl
	  kante = new int [kn][kn];
	  knoten = new int [kn];
	  for (int i=0; i < knzahl; i++)     // Initialisieren: alle Kanten-
	      for (int j=0; j < knzahl; j++)
	          kante [i][j] = 0;
  }

  public void knotenneu (int Kn) {
//Pruefen, ob Knoten schon existiert fehlt noch!
	knoten[knzahl] = Kn;
	knzahl ++;
  }

  private int knotennr (int kn) {
	int i;
	for (i=0; i<knzahl; i++)
		if (knoten[i] == kn) return i;
	return -1;
  }

  public void kanteneu(int K1, int K2, int wert) {
	int n1,n2;
//Pruefen, ob beide Knoten schon existieren !
	n1=knotennr(K1);
	n2=knotennr(K2);
		kante[n1][n2] = wert;
		kante[n2][n1] = wert;
  }

  public void ausgabe() {
	  	System.out.println( "\n Knotenliste\n" );
	  	for (int i=0; i < knzahl; i++)
	  	  	System.out.print( "  " + knoten[i] );

	  	System.out.println( "\n\n Kantenliste\n" );
	  	for (int i=0; i < knzahl; i++) {    // Initialisieren: alle Kanten
		    for (int j=0; j < knzahl; j++) {
		    	if (kante [i][j] != 0)
	//	    	System.out.print("  Kante "+knoten[i]+" -> "+knoten[j]);
                        System.out.print(" Kante " +knoten[i]+ " -> " +knoten[j]
                                + " ("+  kante [i][j]+")   ");
                    }
		    System.out.println();
		}
  }
// weiter Methoden noch zu realisieren
   public void knotenloeschen (int Kn) {
   }
   public void kanteloeschen (int K1, int K2) {
   }
   public void dateischreiben () {
   }
   public void dateilesen () {
   }

// fakultativ Breitensuche, Tiefensuche oder Wegsuche
}
