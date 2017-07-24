package Pack1_E;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Graph_start {
	private int knzahl = 0;
	  int [][] kantenMatrix;					//Adiazenzmatrix
	  int [] knoten;  							// Knotenarray
	  int KantenAnzahl1 = 0;
	  Graph_start(int kn) {  					// kn maximale Knotenzahl
		  kantenMatrix = new int [kn][kn];
		  knoten = new int [kn];
		  for (int i=0; i < knzahl; i++)     	// Initialisieren: alle Kanten mit 0
		      for (int j=0; j < knzahl; j++)
		          kantenMatrix [i][j] = 0;
	  }

	  public void knotenneu (int Kn) {
		  boolean vorhanden = false;
		  for(int i = 0; i < knoten.length;i++){	//Prüft ob der Knoten nicht schon vorhanden ist
			if(Kn == 0){
				System.out.println("Knoten darf nicht 0 sein");
				vorhanden = true;
				break;
			}else if(Kn == knoten[i] ){
				System.out.println("Knoten "+ Kn + " schon vorhanden!");
				vorhanden = true;
			}
			  
		}
		if(!vorhanden){
			try{
				for(int i = 0; i < knoten.length; i++){
					if(knoten[i] == 0){
						knoten[i] = Kn;
						knzahl ++;
						break;
					}
				}
			}catch(ArrayIndexOutOfBoundsException e){
				System.out.println("Nicht genug Platz");
			}
			
		}
		
	  }

	  private int knotennr (int kn) {
		int i;
		for (i=0; i<knzahl; i++)
			if (knoten[i] == kn) return i;
		return -1;
	  }

	  public void kanteneu(int K1, int K2, int wert) {  //Von: K1 nach K2
		int n1,n2;
		boolean k1 = false;
		boolean k2 = false;
		n1=knotennr(K1);
		n2=knotennr(K2);
		for(int i = 0;i < knoten.length; i++){
			if(knoten[i] == K1){
				k1 = true;
			}
		}
		for(int i = 0;i < knoten.length; i++){
			if(knoten[i] == K2){
				k2 = true;
			}
		}
		
		if(k1 && k2){
			kantenMatrix[n1][n2] = wert;
			KantenAnzahl1++;
		}else{
			System.out.println("zum erzeugen der Kante fehlt ein Knoten");
		}
		
			
		
			
	  }
	  
	  public void ausgabe2(){  //Matrix ausgabe
		  System.out.print("     ");
		  for(int k = 0; k<knoten.length; k++){
			  
			  System.out.printf("%5d",knoten[k]);
		  }
		  
		  
		  for(int i = 0; i < knoten.length; i++){
			  System.out.println();
			  System.out.printf("%5d",knoten[i]);
			  for(int j = 0; j<knoten.length; j++){
				  System.out.printf("%5d", kantenMatrix[i][j]);
			  }
		  }
		  
	  }

	  public void ausgabe() {
		  	System.out.println( "\n Knotenliste\n" );
		  	for (int i=0; i < knzahl; i++)
		  	  	System.out.print( "  " + knoten[i] );

		  	System.out.println( "\n\n Kantenliste\n" );
		  	for (int i=0; i < knzahl; i++) {    				// Initialisieren: alle Kanten
			    for (int j=0; j < knzahl; j++) {
			    	if (kantenMatrix [i][j] != 0)	
	                        System.out.print(" Kante " +knoten[i]+ " -> " +knoten[j]
	                                + " ("+  kantenMatrix [i][j]+")   ");
	                    }
			    System.out.println();
			}
	  }
	  
	  // weiter Methoden 
	  
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
			   
			   kantenMatrix[i][index] = 0;
			   kantenMatrix[index][i] = 0;
			   //System.out.println(i);
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
					kantenMatrix[zeile][spalte]  = 0; 
				   
			   }
		   }
	   }
	  
	   
	   public  void schreiber(){
			FileWriter writer;
			File datei = new File("daten.txt");
			try {
				writer = new FileWriter(datei);
				
				writer.write(knzahl + " ");
				writer.write(KantenAnzahl1 + ";");
				for(int i = 0; i < knzahl; i++){
					writer.write(knoten[i] + " ");
				}
				writer.write(";");
				for(int i = 0;i<kantenMatrix.length;i++){
					for(int j = 0; j < kantenMatrix[i].length; j++){
						if(kantenMatrix[i][j] != 0){
							writer.write(knoten[i] + " ");
							writer.write(knoten[j] + " ");
							writer.write(kantenMatrix[i][j] + ",");
						}
					}
				}
				
				
				
				writer.flush();
				writer.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
	   public static void DateiLeser(){   
	        BufferedReader br = null;
	        String[] kantenzahl;
 
	        try {
	        	
	        	br = new BufferedReader(new FileReader(new File("daten.txt")));
	            String line = null;
	            
	            
	            while(!((line = br.readLine()) != null && !line.isEmpty())) {
	               
	            	String[] parts = line.split(";");
	                String[] kanten = parts[2].split(",");
	                
	                String[] knoten = parts[1].split("\\s+");
	                String[] flags = parts[0].split("\\s+");
	               
	                int knotenmenge = Integer.parseInt(flags[0]);
	                int kantenmenge = Integer.parseInt(flags[1]);
	                int[] knotenArray = new int[knotenmenge];
	                for(int i = 0; i < knotenmenge; i++){
	                	knotenArray[i] = Integer.parseInt(knoten[i]);
	                	
	                }
	                Graph_start g = new Graph_start (15);
	                
	                
	                
	                
	                int[][] KantenMatrix = new int[kantenmenge][3];
	                for(int i = 0; i < kantenmenge; i++){
	                	for(int j = 0; j < 3; j++){
	                		kantenzahl = kanten[i].split("\\s+");
		                	KantenMatrix[i][j] = Integer.parseInt(kantenzahl[j]);
	
	                	}
	                	
	                }

	                for(int i = 0; i < knotenmenge; i++){
	                	g.knotenneu (knotenArray[i]);
	                }
	                for(int i = 0; i < KantenMatrix.length; i++){
	                	g.kanteneu(KantenMatrix[i][0],KantenMatrix[i][1],KantenMatrix[i][2]);
	                }
	                g.ausgabe2();
	                System.out.println("Fertig eingelesen");
   
	            }
	        } catch(FileNotFoundException e) {
	            e.printStackTrace();
	        } catch(IOException e) {
	            e.printStackTrace();
	            
	        } 
	        catch(NullPointerException e) {
	            System.out.println("file empty");
	        }
	        catch(ArrayIndexOutOfBoundsException e) {
	            
	        	e.printStackTrace();
	            
	        }
	        
	        finally {
	            if(br != null) {
	                try {
	                    br.close();
	                } catch(IOException e) {
	                    e.printStackTrace();
	                    
	                }
	            }
	        }
	        
	    }

	// fakultativ Breitensuche, Tiefensuche oder Wegsuchehgtcdcg
}
