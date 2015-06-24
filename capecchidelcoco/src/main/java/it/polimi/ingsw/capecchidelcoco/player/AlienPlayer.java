package it.polimi.ingsw.capecchidelcoco.player;

import it.polimi.ingsw.capecchidelcoco.game.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lucacapecchi
 *
 * this class define the method needed for an alien Player
 * 
 */
public class AlienPlayer extends Player{

	
	List<Player> killed = null;
	
	/**
	 * Constructor of the class
	 * @param myGame - is the game in witch the player is playing
	 * @param num - is the counter that remember the order on witch the player are joined
	 * @param name - is the name of the user related to this player
	 */
	public AlienPlayer(Game myGame, int num, String name){
		super(myGame, num, name);
		killed = new ArrayList<Player>();
		this.speed = 2;
		this.faction = "Alien";
		this.currentPosition = myGame.getBoard().findSpawn(faction);
		currentPosition.addPlayer(this);
		listOfMove.add(currentPosition);
	}
	
	
	/**
	 * Set the speed of an alien after an attack,
	 * if in the attack he killed someone he can move faster
	 * 
	 */
	public void updateSpeed(){
		if (!killed.isEmpty()){
			speed = 3;
		}
	}
	
	

	public String attack() {
		if (!hasMoved){
			return "You must move before attack;";
		}
		if (hadAttacked){
			return "You alrady attack this turn;";
		}
		ArrayList<Player> tmp = new ArrayList<Player>();
		String ret = "Attacking location;";
		tmp.addAll(currentPosition.playerList());
		tmp.remove(this);
		hadAttacked = true;
		myGame.addNews("'"+name+"' attacking on:"+currentPosition.getName());
		if (tmp.isEmpty())
			return "None here;";
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


}
