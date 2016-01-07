package Mines;

public class Clue extends Tile {
private int minesAround = 0;

public int getMinesAround() {
	return minesAround;
}

public void setMinesAround(int minesAround) {
	this.minesAround = minesAround;
}

public Clue(int minesAround) {
	super();
	this.minesAround = minesAround;
}

public Clue() {
	// TODO Auto-generated constructor stub
}



@Override
public String toString() {
	return  ""+getMinesAround();
}


}
