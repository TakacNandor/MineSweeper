package Mines;

import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		CreateGame game = new CreateGame();
		
		System.out.println("Wellcome in Minesweeper!");
		System.out.println("Number of columns: " );
		int rows = input.nextInt();
		game.setNumberOfRows(rows);
		System.out.println("Number of rows: " );
		int columns = input.nextInt();
		game.setNumberOfColumns(columns);
		System.out.println("Number of mines" );
		int mines = input.nextInt();
		game.setNumberOfMines(mines);
		
		game.showField(game.createField());

	}

}
