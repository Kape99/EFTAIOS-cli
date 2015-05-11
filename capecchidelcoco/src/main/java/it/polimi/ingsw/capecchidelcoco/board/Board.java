package it.polimi.ingsw.capecchidelcoco.board;

import it.polimi.ingsw.capecchidelcoco.sector.Sector;

import java.io.*;
import java.util.*;


public class Board {
	
	
	//possibile lettura da file
	
	private  Sector[][] sectors;
	static int table [][];
	
	
	public Board () throws FileNotFoundException{
		
			Scanner input = new Scanner(new File("src/galileo.txt"));
			sectors = new Sector[BoardConstant.ROWS][BoardConstant.COLS];
			for (int row = 0; row < BoardConstant.ROWS; row++ ){
				for (int col = 0; col < BoardConstant.COLS; col++ ){
					if(input.hasNextInt())
			        {
						sectors[row][col] = new Sector(row, col, input.nextInt());
			        }
				}
			}
			input.close();
		
			
		
			
		
	}
	
	public static void main (String[] args){
		

			try {
				new Board();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	


}


