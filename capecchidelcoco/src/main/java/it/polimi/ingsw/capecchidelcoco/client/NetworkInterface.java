package it.polimi.ingsw.capecchidelcoco.client;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;


public interface NetworkInterface {
	
	
	int connect(String Name) throws IOException;
	
	boolean close() throws IOException;
	
	String sendCommand(String command, int myGame, String player) throws RemoteException;

	List<String> updateBrodcast(int game, String player, int counter) throws IOException;

	boolean sendSector(String sector, int game, String name) throws RemoteException ;
}
