package it.polimi.ingsw.capecchidelcoco.player;

import it.polimi.ingsw.capecchidelcoco.game.Game;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AlienPlayer extends Player implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Player> killed = null;
	
	public AlienPlayer(Game myGame, int num, String name){
		super(myGame, num, name);
		killed = new ArrayList<Player>();
		this.speed = 2;
		this.faction = "Alien";
		//this.currentPosition = myGame.getBoard().findSpawn(faction);
		this.currentPosition = myGame.getBoard().getSector(2, 1);
		currentPosition.addPlayer(this);
	}
	
	
	public void updateSpeed(){
		if (!killed.isEmpty()){
			speed = 3;
		}
	}

	

	

	@Override
	public String attack() {
		if (!hasMoved){
			return "You must move before attack";
		}
		if (hadAttacked){
			return "you alrady attack this turn";
		}
		ArrayList<Player> tmp = new ArrayList<Player>();
		String ret = "";
		tmp.addAll(currentPosition.playerList());
		tmp.remove(this);
		hadAttacked = true;
		for (Player p:tmp){
			p.attacked();
			if (!p.isAlive()){
				killed.add(p);
				myGame.addNews("'"+name+"' killed: '"+p.getName()+"', he was: "+ p.getCharacter()+" <"+p.getRole()+"> faction:"+p.getFaction());
			}
		}
		updateSpeed();
			
		return ret;
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
