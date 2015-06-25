package test;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.FileNotFoundException;

import it.polimi.ingsw.capecchidelcoco.game.Game;
import it.polimi.ingsw.capecchidelcoco.player.AlienPlayer;
import it.polimi.ingsw.capecchidelcoco.player.Player;
import it.polimi.ingsw.capecchidelcoco.sector.*;

public class SectorTest {
	
	Sector s1 = new SecureSector(0, 0);
	Sector s2 = new DangerousSector(10, 0);
	Sector s3 = new HatchSector(0, 10);
	Sector s4 = new AlienSpawn(10, 10);
	Sector s5 = new NullSector(10, 20);
	Sector s6 = new HumanSpawn(10,10);
	@Test
	public void checkName() throws FileNotFoundException{
		assertEquals(s1.getName(),"A01");
		assertEquals(s2.getName(),"A11");
		assertEquals(s3.getName(),"K01");
		assertEquals(s4.getName(),"K11");
		assertEquals(s5.getName(),"   ");
		assertEquals(s6.getName(),"K11");

	}
	
	@Test
	public void checkXCoordinates(){
		assertEquals(Sector.GetCoordinate("A01").getX(),s1.getX());
		assertEquals(Sector.GetCoordinate("A11").getX(),s2.getX());
		assertEquals(Sector.GetCoordinate("K01").getX(),s3.getX());
		assertEquals(Sector.GetCoordinate("K11").getX(),s4.getX());
		assertEquals(Sector.GetCoordinate("U11").getX(),s5.getX());
	}
	
	@Test
	public void checkYCoordinates(){
		assertEquals(Sector.GetCoordinate("A01").getY(),s1.getY());
		assertEquals(Sector.GetCoordinate("A11").getY(),s2.getY());
		assertEquals(Sector.GetCoordinate("K01").getY(),s3.getY());
		assertEquals(Sector.GetCoordinate("K11").getY(),s4.getY());
		assertEquals(Sector.GetCoordinate("U11").getY(),s5.getY());
	}
	
	@Test
	public void checkUsable(){
		assertTrue(s1.isUsable());
		assertTrue(s2.isUsable());
		assertTrue(s3.isUsable());
		assertFalse(s4.isUsable());
		assertFalse(s5.isUsable());
		assertFalse(s6.isUsable());

	}
	
	@Test
	public void checkAddPlayer(){
		Game g = new Game(0);
		Player p1 = new AlienPlayer(g,0,"p1");
		s1.addPlayer(p1);
		assertTrue(s1.playerList().contains(p1));
	}
	
}
