package Pack1_E;

public class Main {

    public static void main(String[] args) {
        Graph_start g = new Graph_start (15);
        g.knotenneu (3);
        g.knotenneu (5);
        g.kanteneu  (3,5,21);
        g.knotenneu (4);
        g.kanteneu  (3,4,17);
        g.kanteneu  (4,5,13);
        g.knotenneu (8);
        g.kanteneu  (8,3,29);

        g.ausgabe();
        
        g.ausgabe2();
        System.out.println();
        g.knotenloeschen(4);
        
        System.out.println();
        System.out.println();
        g.ausgabe2();

       // g.knotenneu (5);ht
       // g.kanteneu  (8,5,20);
        //g.kanteneu  (8,3,29);
       // g.ausgabe();
        //		Fehler, weil Knoten fehlt
       // g.kanteneu  (7,8,29);
       // g.knotenneu (7);
       // g.kanteneu  (7,8,29);
        //g.ausgabe();
 
    }



}
