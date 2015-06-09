package it.polimi.ingsw.capecchidelcoco.game;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteGame extends Remote {
	
	public String action() throws RemoteException;

	public String move(String sector,String player) throws RemoteException ;
	
	public String getMap() throws RemoteException;
	
	public int connect(String name) throws RemoteException;
	
	public String isEnded() throws RemoteException;
	
	public String getWinner() throws RemoteException;
	
	public String attack(String name) throws RemoteException;
	
	public String showCard(String name) throws RemoteException;
	
	public String useCard(String card, String name) throws RemoteException;
	
	public String discardCard(String card, String name) throws RemoteException;
	
	public String makeNoise(String sector, String name)throws RemoteException;

}
