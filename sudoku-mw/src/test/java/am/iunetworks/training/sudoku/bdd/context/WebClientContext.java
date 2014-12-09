package am.iunetworks.training.sudoku.bdd.context;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;

import java.io.IOException;

public class WebClientContext {

    String hostUrlBase ;

    private WebDriver driver;

    public WebClientContext() {
        hostUrlBase = System.getProperty("app.host", "http://localhost:8080");
    }

    public void initPhantomJsDriver(boolean withJavaScriptSupport) {
        driver = new PhantomJSDriver();
    }

    public void gotTo(String page) {
        String url = hostUrlBase+page;
        if (!url.equals(driver.getCurrentUrl())) {
            driver.get(url);
        }
    }

    public boolean containsText(String text) {
        return getByXpath("//*[contains(text(),'" + text + "')]") != null;
    }

    public boolean containsLink(String text, String url) {
        return getByXpath("//a[@href='"+url+"' and contains(text(),'"+text+"')]") != null;
    }


    public WebElement getByXpath(String xpath) {
        WebElement element = null;
        try {
             element = driver.findElement(By.xpath(xpath));
        }
        catch (NoSuchElementException e) {
            System.out.println("Didn't found element for: " + xpath);
        }
        return element;
    }
}
