package sports_miniWiki;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class GetTennisPlayerInfoTest {

	private GetTennisPlayerInfo player;
	
	@Before
	public void setUp() throws Exception {
		player = new GetTennisPlayerInfo();
	}
	
	@Test
	public void testPlayerNotNull() {
		assertNotNull("player cannot be null", player);
	}
	
	@Test
	public void testATPtop10PlayersNumber() {
		int numberOfPlayers = player.getTop10ATPplayers().size();
		assertEquals("Number of top 10 ATP players should be 10", 10, numberOfPlayers);
	}
	
	@Test
	public void testWTAtop10PlayersNumber() {
		int numberOfPlayers = player.getTop10WTAplayers().size();
		assertEquals("Number of top 10 WTA players should be 10", 10, numberOfPlayers);
	}
	
	@Test
	public void testPlayerName() {
		String name = player.getTop10ATPplayers().get(0).getName();
		assertEquals("Top1 ATP player should be Novak Djokovic", name, "Djokovic, Novak");
	}
	
	@Test
	public void testPlayerRanking() {
		String rank = player.getTop10ATPplayers().get(0).getRanking();
		assertEquals("Novak Djokovic's ranking should be first", rank, "1");
	}
	
	@Test
	public void testPlayerOtherAttributes() {
		String ranking_points = player.getTop10ATPplayers().get(0).getRanking_points();
		HashMap<String, String> tournament_round = player.getTop10ATPplayers().get(0).getTournament_round();
		
		assertNotNull("Ranking points cannot be null", ranking_points);
		assertNotNull("Tournament information cannot be null", tournament_round);
	}
}
