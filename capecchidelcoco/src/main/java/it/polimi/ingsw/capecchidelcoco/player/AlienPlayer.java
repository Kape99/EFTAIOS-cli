package it.polimi.ingsw.capecchidelcoco.player;

import it.polimi.ingsw.capecchidelcoco.game.Game;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Set;

public class AlienPlayer extends Player implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Set<Player> killed = null;
	
	public AlienPlayer(Game myGame, int num, String name){
		super(myGame, num, name);
		this.speed = 2;
		this.faction = "Alien";
		
	}
	
	
	public int returnSpeed(){
		if (killed.isEmpty()){
			return 2;
		}
		return 3;
	}

	@Override
	public String action() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String move() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMap() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String connect() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String isEnded() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWinner() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String attack() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showCard() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String useCard() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String discardCard() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String makeNoise() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
