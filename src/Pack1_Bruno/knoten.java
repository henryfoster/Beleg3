package Pack1_Bruno;

public class knoten {

	String knotentext;
	int name;
	int x,y;

	/**
	 * Getter f�r Knotentext
	 * @return
	 */
	public String getKnotentext() {
		return knotentext;
	}

	/**
	 * Setter f�r Knotentext
	 * @param knotentext
	 */
	public void setKnotentext(String knotentext) {
		this.knotentext = knotentext;
	}
	
	/**
	 * Getter f�r X-Koordinate
	 * @return
	 */
	public int getX() {
		return x ;
	}

	/**
	 * Setter f�r X-Koordinate
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Getter f�r Y-Koordinate des Knoten
	 * @return 
	 */
	public int getY() {
		return y;
	}

	/**
	 * Setter f�r Y-Koordinate des Knoten
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Konstruktor f�r knoten
	 * @param n
	 */
	knoten (int n){
		name = n;
	}
	
	/**
	 * Getter f�r Knotenname
	 * @return
	 */
	public int getname(){
		return name;
	}
	
	/**
	 * Setter f�r Knotenname
	 * @param n
	 */
	public void setname(int n){
		name = n;
	}
}
