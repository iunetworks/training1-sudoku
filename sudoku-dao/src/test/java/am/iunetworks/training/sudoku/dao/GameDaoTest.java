package am.iunetworks.training.sudoku.dao;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameDaoTest {


    GameDao dao;

    @Before
    public void setup(){
        dao = new GameDaoImpl();
    }

    @Test
    public void testGetRandomGame() {
        String game = dao.getRandomGame();
        assertEquals("Game must by 81 chars length string", 81, game.length());
        assertTrue("Game must contain digits only", game.matches("^\\d{81}$"));
    }
}
