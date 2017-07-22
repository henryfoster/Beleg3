package Pack1;

import java.util.Random;

public class graph {
	
	public knoten[] knot;
	knoten[] tempknot;
	int knoten;
	String name;
	
	kante[] kante;
	kante[] tempkante;
	
	int[][] adj;
	int[][] tempadj;
	
	graph(int k, String n){
		name = n;
		
		
		knot = new knoten[k];
		adj = new int[knot.length][knot.length];
		for (int i = 0; i < adj.length ; i++ ){
			for (int o = 0; o < adj[0].length; o++){
				adj[i][o]= 0;
			}
		}
		System.out.println("knot.length: "+knot.length);
		for (int i = 0; i < knot.length; i++ ){
			knot[i] = new knoten ("Knoten"+i);
		}
		knoten = k;
		Random x = new Random();
		for (int i = 0; i < knot.length ; i++){
		 x.nextInt(knot.length);
		  
		 
		}
		
	}
	
	public void newrandomgraph(){
		knot = new knoten[randominteger()];
		kante = new kante[randominteger()];
	}
	
	
	public int randominteger(){
		int x = (int) (Math.random() * 10 % 15 )+1;
		return x;
	}
	
	public void printgraph(){
		
	}
	
	public void neuknoten(){
		tempknot = knot;
		knot = new knoten[tempknot.length+1];
		
		
	}
	
	public void neukante(){
		
		
	}
	
	public void printmatr(){
		
		
			for (int o = 0; o < adj[0].length; o++){
				System.out.print("__"+o);
			}
			System.out.println("");
		
		for (int i = 0; i < adj.length ; i++){
			for (int o = 0; o < adj[0].length; o++){
				System.out.printf("%3d",adj[i][o]);
			}
			System.out.println();
		}
	}
	
	public String getname(){
		return name;
	}
	
	public void setname(String n){
		name = n;
	}
}
