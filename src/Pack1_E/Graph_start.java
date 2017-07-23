package Pack1_E;

public class Graph_start {
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

	  public void kanteneu(int K1, int K2, int wert) {  //Von: K1 nach K2
		int n1,n2;
		//Pruefen, ob beide Knoten schon existieren !
		n1=knotennr(K1);
		n2=knotennr(K2);
			kante[n1][n2] = wert;
			//kante[n2][n1] = wert;
	  }
	  
	  public void ausgabe2(){  //Matrix ausgabe
		  System.out.print("     ");
		  for(int k = 0; k<knzahl; k++){
			  
			  System.out.printf("%5d",knoten[k]);
		  }
		  
		  
		  for(int i = 0; i < knzahl; i++){
			  System.out.println();
			  System.out.printf("%5d",knoten[i]);
			  for(int j = 0; j<knzahl; j++){
				  System.out.printf("%5d", kante[i][j]);
			  }
		  }
		  
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
	  
	  public int indexSuche(int kn){
		  for(int i = 0; i < knzahl; i++){
			  if(kn == knoten[i]){
				  return i;
			  }
		  }
		  return -1;
		  
	  }
	  
	   public void knotenloeschen (int Kn) {
		   int index = indexSuche(Kn);
		   knoten[index] = 0;
		   for(int i = 0; i < knzahl; i++ ){
			   
			   kante[i][index] = 0;
			   kante[index][i] = 0;
			   System.out.println(i);
		   }
		   
	   }
	   
	   public void kanteloeschen (int K1, int K2) {
		   int zeile = 0; 
		   int spalte = 0;
		   for(int i = 0, k = 0; i < knzahl;i++, k++){
			   if(knoten[i] == K1){
				   zeile = i;
			   }
			   if(knoten[k] == K2){
				   spalte = k;
			   }
		   }
		   
		   for(int i = 0; i < knzahl; i++){
			   for(int j= 0; j < knzahl;j++){				
					kante[zeile][spalte]  = 0; 
				   
			   }
		   }
	   }
	   public void dateischreiben () {
	   }
	   public void dateilesen () {
	   }

	// fakultativ Breitensuche, Tiefensuche oder Wegsuche
}
