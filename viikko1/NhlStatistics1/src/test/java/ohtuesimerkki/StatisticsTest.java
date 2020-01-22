
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }  
    
    @Test
    public void pelaajaHakuPalauttaaOikeanPelaajan() {
        assertEquals("Kurri", stats.search("Kurri").getName());
    }
    
    @Test
    public void pelaajaHakuPalauttaaNullJosPelaajaaEiLöydy() {
        assertEquals(null, stats.search("Jagr"));
    }
    
    @Test
    public void joukkueHakuPalauttaaOikeanMääränPelaajia() {
        assertEquals(3, stats.team("EDM").size());
    }
    
    @Test
    public void joukkueHakuPalauttaaOikeanPelaajanJoukkueessa() {
        List<Player> pit = stats.team("PIT");
        Player player = pit.get(0);
        
        assertEquals("Lemieux", player.getName());
    }
    
    @Test
    public void parasPisteMiesHakuPalauttaaOikeanPelaajan() {
        List<Player> topScorers = stats.topScorers(1);
        Player player = topScorers.get(0);
        
        assertEquals("Gretzky", player.getName());
    }
}