package it.polimi.ingsw.capecchidelcoco.client;

import it.polimi.ingsw.capecchidelcoco.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;



public class Client{
	
	
	private static Scanner in = new Scanner(System.in);

	



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Timer timer;
	
	private static String name;
	
	private static int game;
	
	private static int counter = 0;

	private static NetworkInterface ni;
	
	public static void main (String[] args) throws IOException{
		timer = new Timer(true);
		String input = "";
		while (!("1").equals(input) && !("2").equals(input) ){
			System.out.println("Choose your network interface:");
			System.out.println("1 - RMI");
			System.out.println(" - Socket to be implemented");
			input = readLine("\n");
			if (!input.equals("1"))
				System.out.println("Not a valid input");
		}
		
		ni = NetworkInterfaceFactory.getInterface(input);
		System.out.println("Chose a name");
		input = readLine("\n");
		game = ni.connect(input);
		while (game ==-1){
			System.out.println("name alrady use , try again");
			input = readLine("\n");
			game = ni.connect(input);
		}
		long delay =1000;
		
		timer.schedule(new TimerTask(){
			 @Override
			  public void run() {
			   try {
				update(ni);
			} catch (IOException e) {
			}
			  }
			
		}, delay, delay);
		
		name = input;
		System.out.println("Connection to the room... Waiting for other player");
		
		System.out.println(ni.sendCommand("HELP", game, name).replace(";", "\n"));
		
		
		boolean finish = false;
		String toPrint;
		
		while(true){
			input = readLine("\n");
			toPrint =ni.sendCommand(input, game, name);
			if (toPrint.contains("%")){
				;
				do {
					System.out.println(toPrint.replace(";", "\n").replace("ANY%",""));
					input = readLine("\n");
				}while (!ni.sendSector(input, game, name));
				System.out.println("Turn ended");
			}else{
				System.out.println(toPrint.replace(";", "\n"));
			
			}
			
		}
		
	}
			
	/**
	 * @param ni
	 * @throws IOException
	 */
	public static void update(NetworkInterface ni) throws IOException{
		for (String s:ni.updateBrodcast(game, name, counter)){
			if (s.startsWith(name))
				System.out.println("#"+s.replace(name+":", "you:").replace(";", "\n"));
			else System.out.println("#"+s.replace(";", "\n"));
			counter++;
		}
	}
		
	
	
	/**
	 * @param format
	 * @param args
	 * @return
	 * @throws IOException
	 */
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