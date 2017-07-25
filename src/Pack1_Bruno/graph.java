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
 * 	
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
	
	/**
	 * 
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
	
	 public void kanteneu(int K1, int K2, int wert) {  //Von: K1 nach K2
			if ( adj[K2][K1] != 0){		
			}else{
			adj[K2][K1] = wert;
			}			
		  }
	
	 public void kanteloeschen (int K1, int K2) {
		 adj[K2][K1] = 0;
	 }
		  
	
	public String getname(){
		return name;
	}
	
	public void setname(String n){
		name = n;
	}
}
