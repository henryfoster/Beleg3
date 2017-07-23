package Pack1_Bruno;

public class knoten {

	String name;
	int x,y;
	
	public int getX() {
		return x;
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

	knoten (String n){
		name = n;
	}
	
	public String getname(){
		return name;
	}
	
	public void setname(String n){
		name = n;
	}
}
