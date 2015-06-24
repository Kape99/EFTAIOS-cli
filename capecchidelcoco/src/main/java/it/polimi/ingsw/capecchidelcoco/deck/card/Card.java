package it.polimi.ingsw.capecchidelcoco.deck.card;

import it.polimi.ingsw.capecchidelcoco.game.Game;
import it.polimi.ingsw.capecchidelcoco.player.Player;

/**
 * @author lucacapecchi
 * Define all Cards structure
 */
public abstract class Card {

	//Object cards
	public static final int N_ATTACK_CARDS = 2;
	public static final int N_TELEPORT_CARDS = 2;
	public static final int N_ADRENALINE_CARDS = 2;
	public static final int N_SEDATIVE_CARDS = 3;
	public static final int N_LIGHT_CARDS = 2;
	public static final int N_DEFENSE_CARDS = 1;
	
	//Sector cards
	public static final int N_SILENCE_CARDS = 5;
	public static final int N_NOISE_THIS_SECTOR_CARDS = 6;
	public static final int N_NOISE_THIS_SECTOR_OBJ_CARDS = 4;
	public static final int N_NOISE_ANY_SECTOR_CARDS = 6;
	public static final int N_NOISE_ANY_SECTOR_OBJ_CARDS = 4;
	
	//Hatch cards
	public static final int N_GREEN_CARDS = 3; 
	public static final int N_RED_CARDS = 3; 
	

	/**
	 * Define the action that a card have to do when needed
	 * @param game - the game where the card have to do the action
	 * @param pl - the player who use the card
	 * @return the result of the action made
	 */
	public abstract String doAction(Game game, Player pl);

	
	
}
