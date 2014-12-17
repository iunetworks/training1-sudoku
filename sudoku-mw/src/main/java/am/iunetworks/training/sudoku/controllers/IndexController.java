package am.iunetworks.training.sudoku.controllers;

import am.iunetworks.training.sudoku.dao.GameDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller("/")
public class IndexController {

    @Autowired
    GameDao gameDao;

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("index.html")
    public ModelAndView index(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        return new ModelAndView("index");
    }
/**
    @RequestMapping("new.json")
    public void loadARandomGame(HttpServletResponse response) {
        String randomGame = gameDao.getRandomGame();
        logger.trace("Sending random game {}", randomGame);
        response.setContentType("text/plain");
        response.setContentLength(randomGame.length());
        try {
            response.getWriter().write(randomGame);
        } catch (IOException e) {
            logger.trace("Error sending game", e);
        }
    }
*/
}
