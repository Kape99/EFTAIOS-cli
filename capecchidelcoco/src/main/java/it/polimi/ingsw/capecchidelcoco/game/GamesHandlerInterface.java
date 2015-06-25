package it.polimi.ingsw.capecchidelcoco.game;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author lucacapecchi
 * Interface that define the methods that a player can use
 */
public interface GamesHandlerInterface extends Remote{

	/**
	 * Connect the player
	 * @param name - name given by the player
	 * @return the result of connection
	 * @throws RemoteException
	 */
	public int connect(String name) throws RemoteException;
	
	public Boolean isEnded() throws RemoteException;

	/**
	 * Send the action a player want perform 
	 * @param action - the command the player is asking
	 * @param game - the game the player is playing
	 * @param name - name of the player
	 * @return the result of the asked action
	 * @throws RemoteException
	 */
	public String sendAction(String action, int game, String name) throws RemoteException ;
	
	/**
	 * Update the player with all the message he is missing
	 * @param game - the game the player is playing
	 * @param name - name of the player
	 * @param counter - the last message he have
	 * @return the message he is missing
	 * @throws RemoteException
	 */
	public List<String> brodcast (int game, String name, int counter) throws RemoteException;

	/**
	 * send a sector when asked to do it
	 * @param sector - name of the sector
	 * @param game - the game the player is playing
	 * @param name - name of the player
	 * @return if the user send a correct sector
	 * @throws RemoteException
	 */
	public Boolean sendSector(String sector, int game, String name) throws RemoteException;
}
