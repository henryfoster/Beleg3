package Pack1_Bruno;

public class knoten {

	String knotentext;
	int name;
	int x,y;

	public String getKnotentext() {
		return knotentext;
	}

	public void setKnotentext(String knotentext) {
		this.knotentext = knotentext;
	}
	public int getX() {
		return x ;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	knoten (int n){
		name = n;
	}
	
	public int getname(){
		return name;
	}
	
	public void setname(int n){
		name = n;
	}
}
