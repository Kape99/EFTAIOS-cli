package it.polimi.ingsw.capecchidelcoco.client;

import it.polimi.ingsw.capecchidelcoco.game.GamesHandlerInterface;

import java.io.IOException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class RMIInterface implements NetworkInterface {
	
	private static final Logger logger = Logger.getLogger(RMIInterface.class.getName());


	private GamesHandlerInterface controller;
	private static final String valid[] = {"MOVE","INFO","MAP","HELP","ATTACK","END","MOVEMENTS","TURN","ADDNOTE","NOTES"};

	public int connect(String name) throws IOException {
	
		String url = "Server";
        Registry registry;
		try {
			System.out.println("5");
			registry = LocateRegistry.getRegistry(1413);
			System.out.println("4");
		} catch (RemoteException e) {			
			logger.log(Level.SEVERE, "Fallito getRegistry "+e);
			return -1;
		}
        try {
			System.out.println("3");

			controller = (GamesHandlerInterface) registry.lookup(url);
			System.out.println("2");

		} catch (AccessException e) {
			logger.log(Level.SEVERE, "Fallito AccesException "+e);
			return -1;
		} catch (RemoteException e) {
			logger.log(Level.SEVERE, "Fallito RemoteException "+e);
			return -1;
		} catch (NotBoundException e) {
			logger.log(Level.SEVERE, "Fallito NotBoundException "+e);
			return -1;
		}
		try {
			System.out.println("1");
			return controller.connect(name);

		} catch (RemoteException e) {
		}
		System.out.println("0");
		return -1;
	}

	@Override
	public boolean close() throws IOException {
		return false;
	}

	@Override
	public String sendCommand(String command, int game, String player)throws RemoteException {
		String[] splitted = command.split(" ");
		String result;
		for (int i = 0; i<valid.length; i++){
			if (splitted[0].equals(valid[i])){
				result = controller.sendAction(command, game, player);
				return result;
			}
		}
		return "Wrong Command";
	}

	

	@Override
	public List<String> updateBrodcast(int game, String name, int counter) throws IOException {
		return controller.brodcast(game, name, counter);
	}

	@Override
	public boolean sendSector(String sector, int game, String name)
			throws RemoteException {
		
		return controller.sendSector(sector, game, name);
	}

	
	


	
	
	

	
}
