package it.polimi.ingsw.capecchidelcoco.client;

import it.polimi.ingsw.capecchidelcoco.player.RemotePlayer;
import it.polimi.ingsw.capecchidelcoco.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;



public class Client{
	
	
	
	protected Client(){
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Server mycs;
	
	
	
	
	private static String name;
	
	private static int game;

	public static void main (String[] args) throws IOException{
		
		String input = "";
		while (!input.equals("1") && !input.equals("2")) {
			System.out.println("Choose your network interface:");
			System.out.println("1 - RMI");
			System.out.println(" - Socket to be implemented");
			input = readLine("\n");
			if (!input.equals("1"))
				System.out.println("Not a valid input");
		}
		

		
		NetworkInterface ni = NetworkInterfaceFactory.getInterface(input);
		
		System.out.println("Chose a name");
		input = readLine("\n");
		game = ni.connect(input);
		while (game !=-1){
			System.out.println("name alrady use , try again");
			input = readLine("\n");
		}
		name = input;
		System.out.println("Connection to the room... Waiting for other player");
		
		//System.out.println("You are " + ni.sendCommand("MYCHARACTER", game, name));
		boolean finish = false;
		String toPrint;
	
		
	}
			
		
	
	/*	public static void main(String[] args) throws NotBoundException,
		IOException, InterruptedException {

	String read1 = "";
	while (!read1.equals("1") && !read1.equals("2")) {
		System.out.println("Choose your network interface:");
		System.out.println("1 - Socket");
		System.out.println("2 - RMI");
		read1 = readLine("\n");
		if (!read1.equals("1") && !read1.equals("2"))
			System.out.println("You typed the wrong command!");
	}

	NetworkInterface ni = NetworkInterfaceFactory.getInterface(read1);
	System.out.println("Connection to the room... Waiting for other player");
	String player = ni.connect();

	System.out.println("You are " + player);
	boolean finish = false;
	String toPrint;

	// while the game is online
	while (!finish) {
		
		// if it is not ended
		if (!ni.isEnded().equals("true")) {

			// print the map
			System.out.println(ni.getMap().replace(";", "\n"));
			
			// ask the user for a move
			String read = readLine("\nPress Q to exit or insert x,y to move\nMove: ");
			if (read.equals("Q")) {
				
				// if the move is quit, exit
				finish = true;
			} else {
				
				// parse the move
				String[] result=read.split(",");
				
				// make the move
				toPrint = ni.move(Integer.parseInt(result[0]), Integer.parseInt(result[1]), player);
				
				// analyze if win/lose/draw/nothing
				finish = analyze(toPrint);
			} 
		} else {
			
			// if ended check who won.
			finish=true;
			System.out.println("THE WINNER IS "+ni.getWinner());
		}
	}

}*/

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



	public void run() {
		// TODO Auto-generated method stub
		
	}

	

}