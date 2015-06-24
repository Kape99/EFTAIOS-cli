package test;

import static org.junit.Assert.*;
import it.polimi.ingsw.capecchidelcoco.game.Game;
import it.polimi.ingsw.capecchidelcoco.player.*;

import org.junit.Test;

public class PlayerTest {
	
	Game game = new Game(0);
	
	@Test
	public void checkMovement(){
		Player p1 = new HumanPlayer(game, 0, "p1");
		assertEquals(p1.move("K06"),"Invalid destination, you can move here:;K08 K09 L09 M08 M09 ;");
		assertEquals(p1.move("K08"),"You are in K08;");
		assertEquals(p1.move("K09"),"You alrady moved this turn;");
		assertEquals(p1.move("k09"),"Wrong Sector name;");
	}
	
	@Test
	public void checkAttack(){
		Player p1 = new AlienPlayer(game, 0, "p1");
		Player p2 = new HumanPlayer(game, 1, "p2");
		assertEquals("dind't move yet, he can't attack",p1.attack(), "You must move before attack;");
		//moving the 2 player to the same location
		p1.move("J06");
		assertEquals(p1.attack(), "None here;");
		p1.reset();
		p1.move("I08");
		p2.move("K09");
		p2.reset();
		p2.move("J08");
		p2.reset();
		p2.move("I08");
		assertEquals("he is human, he can't attack",p2.attack(), "Humans can't attack;");
		assertEquals(p1.attack(), "Attacking location;");
		assertEquals("can't attack twice",p1.attack(), "You alrady attack this turn;");
		assertFalse("was in the same sector of p1 while attacking",p2.isAlive());
	}

}
