package am.iunetworks.training.sudoku.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitApplication implements ServletContextListener {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("Sudoku application started");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
