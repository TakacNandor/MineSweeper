package Mines;

import java.util.Random;

import javax.net.ssl.SSLEngineResult.Status;

public class CreateGame {

	private int numberOfRows;
	private int numberOfColumns;
	private int numberOfMines;
	private Tile[][] gameField;
	

	public CreateGame(int numberOfRows, int numberOfColumns, int mines) {
		this.numberOfRows = numberOfRows;
		this.numberOfColumns = numberOfColumns;
		this.numberOfMines = mines;
	}

	public CreateGame() {

	}

	public Tile[][] createField() {

		gameField = new Tile[getNumberOfColumns()][getNumberOfRows()];
		fillMines(gameField);
		fillClue(gameField);
		for (int i = 0; i < getNumberOfColumns(); i++) {
			for (int j = 0; j < getNumberOfRows(); j++) {
				gameField[i][j].setTileStatus(TileStatus.CLOSED);
			}
		}
		return gameField;
	}

	private void fillMines(Tile[][] gameField) {
		Random random = new Random();
		while (numberOfMines != 0) {

			int column = random.nextInt(getNumberOfColumns());
			int row = random.nextInt(getNumberOfRows());

			if (gameField[column][row] == null) {
				gameField[column][row] = new Mine();
				numberOfMines--;
			}
		}
	}

	private void fillClue(Tile[][] gameField) {

		for (int i = 0; i < getNumberOfColumns(); i++) {
			for (int j = 0; j < getNumberOfRows(); j++) {
				if (!(gameField[i][j] instanceof Mine)) {
					gameField[i][j] = minesAround(i, j);
				}
			}
		}
	}

	public void showOpenedField(Tile[][] gameField) {
		System.out.print("  ");
		for (int columnNum = 0; columnNum < getNumberOfColumns(); columnNum++) {
			System.out.print(" " + columnNum);

		}
		System.out.println();
		for (int row = 0; row < getNumberOfColumns(); row++) {
			System.out.print((char)(row+'A'));

			for (int column = 0; column < getNumberOfRows(); column++) {
				System.out.print(" " + gameField[column][row].toString());
			}
			System.out.println();
		}
	}

	public void showField(Tile[][] gameField) {
		System.out.print("  ");
		for (int columnNum = 0; columnNum < getNumberOfColumns(); columnNum++) {
			System.out.print(" " + columnNum);
		}
		System.out.println();
		for (int row = 0; row < getNumberOfColumns(); row++) {
			System.out.print((char)(row+'A'));
			for (int column = 0; column < getNumberOfRows(); column++) {
				
				switch (gameField[column][row].getTileStatus()) {
				case CLOSED:
					System.out.print(" -");
					break;
				case OPEN:
					System.out.print(" "+gameField[column][row].toString());
					break;
				case MARKED:
					System.out.print(" M");
					break;

				default:
					break;
				}
				
			}
			System.out.println();
		}
	}

	public Clue minesAround(int column, int row) {
		int minesAround = 0;
		
		for (int i = -1; i <= 1; i++) {
			if (column + i >= 0 && column + i < getNumberOfColumns())
			for (int j = -1; j <= 1; j++) {
				if (row + j >= 0 && row + j < getNumberOfRows()) {
					if (gameField[column + i][row + j] instanceof Mine) {
						minesAround++;
					}
				}
			}
		}
		return new Clue(minesAround);
	}

	public int getNumberOfRows() {
		return numberOfRows;
	}

	public void setNumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}

	public int getNumberOfColumns() {
		return numberOfColumns;
	}

	public void setNumberOfColumns(int numberOfCollumns) {
		this.numberOfColumns = numberOfCollumns;
	}

	public int getNumberOfMines() {
		return numberOfMines;
	}

	public void setNumberOfMines(int numberOfMines) {
		this.numberOfMines = numberOfMines;
	}

}
