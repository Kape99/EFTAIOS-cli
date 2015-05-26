package it.polimi.ingsw.capecchidelcoco.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;



public class Client {
	
	public static void main(String[] args) throws NotBoundException,IOException, InterruptedException {

		
		
		NetworkInterface ni = new NetworkInterface();
		System.out.println("Connection to the room... Waiting for other player");
		String player = ni.connect();
		
		System.out.println("You are " + player);
		boolean finish = false;
		// while the game is online
		while (!finish) {
			
			// if it is not ended
			if (!ni.isEnded().equals("true")) {
		
				// print the map
				System.out.println(ni.getMap().replace(";", "\n"));
				
				// ask the user for a move
				String read = readLine("\nPress Q to exit or insert Sector: ");
				if (read.equals("Q")) {
					
					// if the move is quit, exit
					finish = true;
				} else {
					
				} 
			} else {
				
				// if ended check who won.
				finish=true;
				System.out.println("THE WINNER IS "+ni.getWinner());
			}
		}
		
		while (!finish) {
			
			// if it is not ended
			if (!ni.isEnded().equals("true")) {

				// print the map
				System.out.println(ni.getMap().replace(";", "\n"));
				
				
			}	
		}

	}

	

	private static String readLine(String format, Object... args)
			throws IOException {
		if (System.console() != null) {
			return System.console().readLine(format, args);
		}
		System.out.print(String.format(format, args));

		BufferedReader br = null;
		InputStreamReader isr = null;
		String read = null;

		isr = new InputStreamReader(System.in);
		br = new BufferedReader(isr);
		read = br.readLine();

		return read;
	}
	


}
