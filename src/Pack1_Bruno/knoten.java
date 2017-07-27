package Pack1_Bruno;

public class knoten {

	String knotentext;
	int name;
	int x,y;

	/**
	 * Getter für Knotentext
	 * @return
	 */
	public String getKnotentext() {
		return knotentext;
	}

	/**
	 * Setter für Knotentext
	 * @param knotentext
	 */
	public void setKnotentext(String knotentext) {
		this.knotentext = knotentext;
	}
	
	/**
	 * Getter für X-Koordinate
	 * @return
	 */
	public int getX() {
		return x ;
	}

	/**
	 * Setter für X-Koordinate
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Getter für Y-Koordinate des Knoten
	 * @return 
	 */
	public int getY() {
		return y;
	}

	/**
	 * Setter für Y-Koordinate des Knoten
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Konstruktor für knoten
	 * @param n
	 */
	knoten (int n){
		name = n;
	}
	
	/**
	 * Getter für Knotenname
	 * @return
	 */
	public int getname(){
		return name;
	}
	
	/**
	 * Setter für Knotenname
	 * @param n
	 */
	public void setname(int n){
		name = n;
	}
}
