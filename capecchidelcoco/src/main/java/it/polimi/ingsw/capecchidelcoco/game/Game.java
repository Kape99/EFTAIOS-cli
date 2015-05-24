package it.polimi.ingsw.capecchidelcoco.game;

import it.polimi.ingsw.capecchidelcoco.board.Board;
import it.polimi.ingsw.capecchidelcoco.deck.*;
import it.polimi.ingsw.capecchidelcoco.deck.card.SectorCard;
import it.polimi.ingsw.capecchidelcoco.player.*;

import java.util.List;
import java.util.ArrayList;



public class Game {

	public static final String[] characterNameList = {"Piero Ceccarella", "Ennio Maria Dominoni", "Vittorio Martana", "Julia Niguloti",
		"Maria Galmbani", "Silvano Porpora", "Paolo Landon", "Tuccio Brendon"};
	public static final String[] characterRoleList = {"First Alien", "Captain", "Second Alien", "Pilot",
		"Third Alien", "Psychologist", "Fourth Alien", "Soldier"};
			
	
	private List<Player> players;
	private Board board;
	public SectorDeck sectorDeck;
	private ObjectDeck objectDeck;
	private HatchDeck hatchDeck;
	private Player currentPlayer;
	

	private boolean started = false;
	private boolean ended = false;
	private int numberOfTurns = 0;

	
	private boolean aliensWin = false;
	private List<Player> winnerPlayers;
	
	private boolean turnsEnabled = true;

	public static final int MAX_PLAYERS = 8;
	private static final int MAX_TURNS = 39;

		
		public	Game(Board board) {
			players = new ArrayList<Player>();
			sectorDeck = new SectorDeck();
			this.setBoard(board);
			winnerPlayers = new ArrayList<Player>();
		}

		public List<Player> getPlayers() {
			return players;
		}
		
		public List<Player> getPlayersOfType(String faction) {
			List<Player> result = new ArrayList<Player>();
			for(Player p: players) {
				if(p.getFaction() == faction)
					result.add(p);
			}
			return result;
		}

		public int getNumberOfPlayers() {
			return players.size();
		}

		private int getNumberOfAliveHumanPlayers() {
			int n = 0;
			for (Player p : players) {
				if (p instanceof HumanPlayer && p.isAlive())
					n++;
			}
			return n;
		}

		/**
		 * @return the map
		 */
		public Board getMap() {
			return getBoard();
		}

		

		public void start() throws GamePlayException {
			if (getBoard() == null) {
				throw new GamePlayException("No valid map to start the game!");
			}
			
			currentPlayer = players.get(0);
			started = true;
		}

		/**
		 * Has the game started?
		 * 
		 * @return true if the game has started
		 */
		public boolean isStarted() {
			return started;
		}

		/**
		 * @return the ended
		 */
		public boolean isEnded() {
			return ended;
		}

		void nextTurn() {
			if (isEnded())
				return;
			numberOfTurns++;

			if (numberOfTurns > MAX_TURNS && getNumberOfAliveHumanPlayers() > 0
					|| numberOfTurns <= MAX_TURNS
					&& getNumberOfAliveHumanPlayers() == 0) {

				aliensWin = true;
				currentPlayer = null;
				ended = true;

				return;
			}
			int currentPlayerIndex = players.indexOf(currentPlayer);
			do {
				currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
				currentPlayer = players.get(currentPlayerIndex);
			} while (!currentPlayer.isAlive());
		}

		

		/**
		 * @return the winnerPlayer
		 */
		public List<Player> getWinnerPlayers() {
			return winnerPlayers;
		}

		/**
		 * @return the currentPlayer
		 */
		public Player getCurrentPlayer() {
			return currentPlayer;
		}

	
	

		/**
		 * Add a player to gamePlay
		 * 
		 * @param player
		 * @throws GamePlayException
		 */
		void addPlayer(Player p) throws GamePlayException {
			if (started) {
				throw new GamePlayException("Cannot add players during the match!");
			}
			if(players.size() == MAX_PLAYERS) {
				throw new GamePlayException("Cannot add another player: max number of players (" + MAX_PLAYERS + ") reached.");
			}
			players.add(p);
		}

		
		SectorCard pickDangerousSectorCard() {
			return sectorDeck.draw();
		}

		
		void escaped(HumanPlayer human) {

			winnerPlayers.add(human);
		}

			
		boolean isTurnOf(Player p) {
			return p.equals(currentPlayer);
		}
		
		/**
		 * @return turns enabled
		 */
		public boolean areTurnsEnabled() {
			return turnsEnabled;
		}

		/**
		 * @param turnsEnabled are turns enabled?
		 */
		public void setTurnsEnabled(boolean turnsEnabled) {
			this.turnsEnabled = turnsEnabled;
		}

		public ObjectDeck getObjectDeck() {
			return objectDeck;
		}

		public void setObjectDeck(ObjectDeck objectDeck) {
			this.objectDeck = objectDeck;
		}

		/**
		 * @return the hatchDeck
		 */
		public HatchDeck getHatchDeck() {
			return hatchDeck;
		}

		/**
		 * @param hatchDeck the hatchDeck to set
		 */
		public void setHatchDeck(HatchDeck hatchDeck) {
			this.hatchDeck = hatchDeck;
		}

		/**
		 * @return the board
		 */
		public Board getBoard() {
			return board;
		}

		/**
		 * @param board the board to set
		 */
		public void setBoard(Board board) {
			this.board = board;
		}

		public static class GamePlayException extends Exception {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public GamePlayException() {
				super();
			}

			public GamePlayException(String message) {
				super(message);
			}

			public GamePlayException(String message, Throwable cause) {
				super(message, cause);
			}

			public GamePlayException(Throwable cause) {
				super(cause);
			}
		}

		

	

	


}
