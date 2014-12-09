package am.iunetworks.training.sudoku.controllers;

import org.junit.Before;
import org.junit.Test;

import java.net.URL;
import java.net.URLConnection;

/**
 * Created by gurgen.nersesyan on 11/25/2014.
 */
public class ITestIndexController {

    @Before
    public void setup(){
    }

    @Test
    public void testIndexPage() throws Exception {
//        Thread.sleep(100000);

        URL url = new URL("http://localhost:8080/index.html");
        URLConnection conn = url.openConnection();
        System.err.print(conn.getContentLength());
    }
}
