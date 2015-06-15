package it.polimi.ingsw.capecchidelcoco.game;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GamesHandlerInterface extends Remote{

	public int connect(String name) throws RemoteException; 
	public Boolean isEnded() throws RemoteException;

	public String sendAction(String action, int game, String name) throws RemoteException ;

}
