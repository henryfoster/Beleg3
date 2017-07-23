package Pack1_Bruno;

public class Graphteststart {

    public static void main(String[] args) {
      
    	new GUI();
        
    	Graphstart g = new Graphstart (15);
    	Graphstart h = new Graphstart (5);
    	 h.knotenneu (3);
         h.knotenneu (5);
         h.kanteneu  (3,5,21);
         h.knotenneu (4);
         h.kanteneu  (3,4,17);
    	g.knotenneu (3);
        g.knotenneu (5);
        g.kanteneu  (3,5,21);
        g.knotenneu (4);
        g.kanteneu  (3,4,17);
        g.kanteneu  (4,5,13);
        g.knotenneu (8);
        g.kanteneu  (8,3,29);

        g.ausgabe();
        h.ausgabe();

        g.knotenneu (5);
        g.kanteneu  (8,5,20);
        g.knotenneu (7);
        g.kanteneu  (8,3,29);
        g.ausgabe();
//		Fehler, weil Knoten fehlt
        
        g.kanteneu  (7,8,29);
        g.knotenneu (7);
        g.kanteneu  (7,8,29);
        g.ausgabe();
 
    }
    
    
}


