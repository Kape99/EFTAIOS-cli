package it.polimi.ingsw.capecchidelcoco.player;

import java.rmi.RemoteException;

import it.polimi.ingsw.capecchidelcoco.game.*;

public class HumanPlayer extends Player {

	public HumanPlayer(Game myGame, int num, String name){
		super(myGame, num, name);
		this.speed = 1;
		this.faction = "Human";
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
