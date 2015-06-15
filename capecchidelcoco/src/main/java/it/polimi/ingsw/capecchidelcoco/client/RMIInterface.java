package it.polimi.ingsw.capecchidelcoco.client;

import it.polimi.ingsw.capecchidelcoco.game.GamesHandler;
import it.polimi.ingsw.capecchidelcoco.game.GamesHandlerInterface;

import java.io.IOException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class RMIInterface implements NetworkInterface {

	private GamesHandlerInterface controller;
	private static final String valid[] = {"MOVE","MYCHARACTER","MAP","SHOWCARD","USECARD","HELP","PLAYERS"};

	public int connect(String name) throws IOException {
		/*String url = "rmi://localhost:1413/Server";
		try{
			RemoteGame me= (RemoteGame) Naming.lookup(url);
			System.out.println(me.getMap().replace(";","\n"));
		}
		catch (Exception e){
			e.printStackTrace();
			
		}*/
		String url = "Server";
        Registry registry;
		try {
			registry = LocateRegistry.getRegistry(1413);
		} catch (RemoteException e) {			
			e.printStackTrace();
			return -1;
		}
        try {
			controller = (GamesHandlerInterface) registry.lookup(url);
		} catch (AccessException e) {
			e.printStackTrace();
			return -1;
		} catch (RemoteException e) {
			e.printStackTrace();
			return -1;
		} catch (NotBoundException e) {
			e.printStackTrace();
			return -1;
		}
		try {
			System.out.println("1");
			return controller.connect(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return -1;
	}

	public boolean close() throws IOException {
		// TODO Auto-generated method stub
		return false;
	}

	public String sendCommand(String command, int myGame, String player)throws RemoteException {
		String splitted[] = command.split(" ");
		String result;
		for (int i = 0; i<valid.length; i++){
			if (splitted[0] == valid[i]){
				result = controller.sendAction(command, myGame, player);
				return result;
			}
		}
		return null;
	}

	public boolean isEnded() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public String updateBrodcast(int myGame, String player) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	
	


	
	
	

	
}
