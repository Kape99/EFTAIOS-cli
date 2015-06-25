package it.polimi.ingsw.capecchidelcoco.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import it.polimi.ingsw.capecchidelcoco.client.Client;
import it.polimi.ingsw.capecchidelcoco.game.*;

public class Server implements ServerInterface {
	
	private static Server server = null;
	
	
	private Server() throws NotBoundException, IOException{
		Registry registry = null;
		try{
			GamesHandlerInterface game = new  GamesHandler();
			GamesHandlerInterface stub = (GamesHandlerInterface) UnicastRemoteObject.exportObject(game, 0);	
			registry = LocateRegistry.createRegistry(1413);
			registry.bind("Server", stub);
			System.out.println("Running");
		} catch(Exception ex){
		}
		boolean finish = false;
		while (!finish) {
			String read = readLine("Press Q to exit\n");
			if (read.equals("Q")) {
				finish = true;
			}
		if (registry != null)
			registry.unbind("Server");
		System.exit(0);	
		}
	}
	 
	
	public static Server getServer() throws IOException, NotBoundException {
		if (server==null){
			server= new Server();
		}
		
		return server;
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


	@Override
	public void register(Client c) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void broadcast(String s) throws RemoteException {
		// TODO Auto-generated method stub
		
	}



}


