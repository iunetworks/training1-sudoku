package am.iunetworks.training.sudoku.bdd.steps;

import am.iunetworks.training.sudoku.bdd.context.WebClientContext;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import junit.framework.Assert;
import org.jbehave.core.annotations.*;

public class NavigationSteps {

    private WebClientContext ctx;

    public NavigationSteps(WebClientContext ctx){
        this.ctx = ctx;
    }

    @Given("user is on start page ($page)")
    @Alias("կայքի այցելուն գտնվում է առաջին էջում ($page)")
    public void navigateTo(@Named("page") String page) throws Exception {
        ctx.gotTo(page);
    }

}
