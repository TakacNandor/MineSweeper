package Mines;

public class Clue extends Tile {
	private final int minesAround;

	public Clue(int minesAround) {
		this.minesAround = minesAround;
	}

	public int getMinesAround() {
		return minesAround;
	}

	@Override
	public String toString() {
		return "" + getMinesAround();
	}

}
