package Pack1_Bruno;

import java.util.Random;

public class graph {
	
	public knoten[] knot;
	knoten[] tempknot;
	int knoten, kanten, counter;
	String name;
	
	int[][] adj;
	int[][] tempadj;

/**
 * Knoten Array wird erzeugt mit vorgegebener Anzahl von Knoten	erzeugt
 * danach wird ein Adjazenzmatrix erzeugt und mit Nullen gefüllt
 * danach wird die Matrix mit einer vorgegebenen Anzahl von Werten befüllt 
 * @param knzahl
 * @param kazahl
 * @param n
 */
	graph(int knzahl, int kazahl, String n){
		counter = 0;
		name = n;
		knoten = knzahl;
		kanten = kazahl;
		knot = new knoten[knzahl];
		adj = new int[knot.length][knot.length];
		
		for (int i = 0; i < adj.length ; i++ ){
			for (int o = 0; o < adj[0].length; o++){
				adj[i][o]= 0;
			}
		}
		
		for (int i = 0; i < knot.length; i++ ){
			knot[i] = new knoten (i);
		}
		
		Random x = new Random();
		
		for (int i = 0; i < knot.length; i++){
			
			for (int o = 0; o < knot.length; o++){
				if (i==o){
					adj[i][o]= 0;
				}else if(adj[o][i] != 0) {
					adj[i][o]= 0;
				}else if (x.nextInt(2) == 1){
					if (counter < kazahl){
					adj[i][o]= x.nextInt(20)+1;
					counter++;
					}
				}
			}
		}
	}
	
	graph(String n){
		counter = 0;
		name = n;
		int knzahl = randomint(4,8);
		int kazahl = randomint(4,12);
		knoten = knzahl;
		kanten = kazahl;
		knot = new knoten[knzahl];
		adj = new int[knot.length][knot.length];
		
		for (int i = 0; i < adj.length ; i++ ){
			for (int o = 0; o < adj[0].length; o++){
				adj[i][o]= 0;
			}
		}
		
		for (int i = 0; i < knot.length; i++ ){
			knot[i] = new knoten (i);
		}
		
		Random x = new Random();
		
		for (int i = 0; i < knot.length; i++){
			
			for (int o = 0; o < knot.length; o++){
				if (i==o){
					adj[i][o]= 0;
				}else if(adj[o][i] != 0) {
					adj[i][o]= 0;
				}else if (x.nextInt(2) == 1){
					if (counter < kazahl){
					adj[i][o]= x.nextInt(20)+1;
					counter++;
					}
				}
			}
		}
	}
	
	int randomint(int k, int min){
		int i;
		
		Random x = new Random();
		i = x.nextInt(k)+8;
		return i;
	}
	
	/**
	 * Knoten-Array und Adjazenzmatrix werden in jeweils in eine 2. Array geschrieben, jedoch ohne Zeile und Spalte k
	 * danach werden neue Arrays für Knoten und Adjazenzmatrix erstellt und mit den Werten der korrigierten Arrays gefüllt
	 * @param k
	 */
	public void deleteknoten(int k){
		tempknot = new knoten[knot.length-1];
		int hanspeter = 0;
		int hanspeter2 = 0;
		
		for (int i = 0; i< tempknot.length; i++){
			if (i == k){
				hanspeter = 1;
			}
			tempknot[i] = knot[i + hanspeter];
		}
		
		hanspeter = 0;
		
		knot = new knoten[tempknot.length];
		
		for (int i = 0; i < knot.length; i++){
			knot[i] = tempknot[i];
		}
		
		tempadj = new int [adj.length-1][adj.length-1];
		
		for (int i = 0; i < tempadj.length; i++ ){
			if (i == k){
				hanspeter = 1;
			}
			for (int o = 0; o < tempadj.length; o++){
				if (o == k){
					hanspeter2 = 1;
				}
				tempadj[i][o] = adj[i+hanspeter][o + hanspeter2];
			}
		}
		
		hanspeter = 0;
		hanspeter2 = 0;
		
		adj = new int[tempadj.length][tempadj.length];
		
		for (int i = 0; i < tempadj.length; i++ ){
			for (int o = 0; o < tempadj.length; o++){
				adj[i][o] = tempadj[i][o];
			}
		}
	}
	
	/**
	 * temporäres Knotenarray dass um 1 größer ist als das vorhandene Knotenarray
	 * neues Knotenarray wird erstellt welches identisch mit dem temporären Knotenarray ist
	 */
	
	public void neuknoten(){
		tempknot = knot;
		knot = new knoten[tempknot.length+1];

		for (int i = 0; i < tempknot.length; i++){
			knot[i] = tempknot[i];
		}
		
		knot[knot.length-1] = new knoten(knot.length);
		
		tempadj = adj;
		adj = new int[tempadj.length+1][tempadj.length+1];
		for (int i = 0; i < adj.length ; i++ ){
			for (int o = 0; o < adj[0].length; o++){
				adj[i][o]= 0;
			}
		}
		
		for (int i = 0; i < tempadj.length; i++){
			for (int o = 0; o < tempadj.length; o++){
				adj[i][o] = tempadj[i][o];
			}
		}
	}
	
	/**
	 * neuer Wert wird in der Adjazenzmatrix eingefügt
	 * @param K1
	 * @param K2
	 * @param wert //Kantenwert
	 */
	 public void kanteneu(int K1, int K2, int wert) {  //Von: K2 nach K1
			if ( adj[K2][K1] != 0){		
			}else{
			adj[K2][K1] = wert;
			}			
		  }
	/**
	 * ausgewählte Kante wird in der Adjazenzmatrix 0 gesetzt
	 * @param K1
	 * @param K2
	 */
	 public void kanteloeschen (int K1, int K2) {
		 adj[K2][K1] = 0;
	 }
		  
	/**
	 * Getter für Name des Graphen
	 * @return
	 */
	public String getname(){
		return name;
	}
	
	/**
	 * Setter für Name des Graphen
	 * @param n
	 */
	public void setname(String n){
		name = n;
	}
}
