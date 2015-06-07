package it.polimi.ingsw.capecchidelcoco.client;

import java.rmi.*;

public interface ClientInterface extends Remote {

	void receive (String s) throws RemoteException;
	
}
