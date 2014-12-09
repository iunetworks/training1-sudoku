package am.iunetworks.training.sudoku.dao;

/**
 * Created by Gurgen on 18.11.2014.
 */
public class GameDaoImpl implements GameDao {

    @Override
    public String getRandomGame() {
        return "123456789"+
               "000000000"+
               "000000000"+
               "000000000"+
               "000000000"+
               "000000000"+
               "000000000"+
               "000000000"+
               "000000000"
                ;
    }
}
