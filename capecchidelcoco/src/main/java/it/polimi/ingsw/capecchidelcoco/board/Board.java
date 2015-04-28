package it.polimi.ingsw.capecchidelcoco.board;

import it.polimi.ingsw.capecchidelcoco.sector.Sector;

public class Board {
	
	
	//possibile lettura da file
	
	static Sector[][] sectors;
	static int table [][] = {
		
		
	};
	
	public Board (){
		sectors = new Sector[BoardConstant.ROWS][BoardConstant.COLS];
		for (int row = 0; row < BoardConstant.ROWS; row++ ){
			for (int col = 0; col < BoardConstant.COLS; col++ ){
				sectors[row][col] = new Sector(row, col, table[row][col]);
			}
		}
			
		
	}

}
