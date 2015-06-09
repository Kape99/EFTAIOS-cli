package it.polimi.ingsw.capecchidelcoco.game;

import it.polimi.ingsw.capecchidelcoco.board.Board;
import it.polimi.ingsw.capecchidelcoco.client.Client;
import it.polimi.ingsw.capecchidelcoco.deck.*;
import it.polimi.ingsw.capecchidelcoco.deck.card.SectorCard;
import it.polimi.ingsw.capecchidelcoco.player.*;

import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.ArrayList;



public class Game implements RemoteGame {
	
	private int id;

	public static final String[] characterNameList = {"Piero Ceccarella", "Ennio Maria Dominoni", "Vittorio Martana", "Julia Niguloti",
		"Maria Galmbani", "Silvano Porpora", "Paolo Landon", "Tuccio Brendon"};
	public static final String[] characterRoleList = {"First Alien", "Captain", "Second Alien", "Pilot",
		"Third Alien", "Psychologist", "Fourth Alien", "Soldier"};
	private String[] name;		
	
	private List<Player> players;
	private Board board;
	private SectorDeck sectorDeck;
	private ObjectDeck objectDeck;
	private HatchDeck hatchDeck;
	private Player currentPlayer;
	

	private boolean started = false;
	private boolean ended = false;
	private int numberOfTurns = 0;
	private int maxNumberOfTurns;

	
	private boolean aliensWin = false;
	private List<Player> winnerPlayers;


	public static final int MAX_PLAYERS = 8;
	private static final int MAX_TURNS = 39;

		
		public	Game() {
			players = new ArrayList<Player>();
			//setSectorDeck(new SectorDeck());
			try {
				board = new Board();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//winnerPlayers = new ArrayList<Player>();
			//hatchDeck = new HatchDeck();
		}
		
		public synchronized boolean addPlayer(Client cl){
			return true;
			
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

	
		public boolean isFull(){
			return (players.size() == MAX_PLAYERS);
		}

		

		public void start(){
		
			
			currentPlayer = players.get(0);
			started = true;
			maxNumberOfTurns = MAX_TURNS*players.size() ;
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
	

		void nextTurn() {
			if (ended)
				return;
			numberOfTurns++;

			if (numberOfTurns > maxNumberOfTurns && getNumberOfAliveHumanPlayers() > 0
					|| numberOfTurns <= maxNumberOfTurns
					&& getNumberOfAliveHumanPlayers() == 0) {

				aliensWin = true;
				currentPlayer = null;
				ended = true;

				return;
			}
			int currentPlayerIndex = players.indexOf(currentPlayer);
			currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
			currentPlayer = players.get(currentPlayerIndex);
			if (!currentPlayer.isAlive())
				nextTurn();
			
		}

		

		/**
		 * @return the winnerPlayer
		 */
		public List<Player> getWinnerPlayers() {
			return winnerPlayers;
		}
		
		public void addWinner(Player pl){
			this.winnerPlayers.add(pl);
		}

		/**
		 * @return the currentPlayer
		 */
		public Player getCurrentPlayer() {
			return currentPlayer;
		}

	
	

		/**
		 * Add a player to game
		 * 
		 * @param player
		 * @throws GamePlayException
		 */
		void addPlayer(Player p){
			players.add(p);
		}

		
		SectorCard pickDangerousSectorCard() {
			return getSectorDeck().draw();
		}

		
		void escaped(HumanPlayer human) {

			winnerPlayers.add(human);
		}

			
		boolean isTurnOf(Player p) {
			return p.equals(currentPlayer);
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

		/**
		 * @return the sectorDeck
		 */
		public SectorDeck getSectorDeck() {
			return sectorDeck;
		}

		/**
		 * @param sectorDeck the sectorDeck to set
		 */
		public void setSectorDeck(SectorDeck sectorDeck) {
			this.sectorDeck = sectorDeck;
		}

		public void addClient(Client c) {
			// TODO Auto-generated method stub
			
		}

		public String action() throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}

		public String move(String sector, String player) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}

		public String getMap() throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}

		public int connect(String name) throws RemoteException {
			//TODO restiduire -1 se il nome esiste
			return this.id;
		}

		public String isEnded() throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}

		public String getWinner() throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}

		public String attack() throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}

		public String showCard() throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}

		public String useCard(String card) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}

		public String discardCard(String card) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}

		public String makeNoise(String sector) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}


	

	


}
