package am.iunetworks.training.sudoku.bdd.steps;

import am.iunetworks.training.sudoku.bdd.context.WebClientContext;
import junit.framework.Assert;
import org.jbehave.core.annotations.*;

public class AssertionsSteps {

    private WebClientContext ctx;

    public AssertionsSteps(WebClientContext ctx){
        this.ctx = ctx;
    }

    @Then("text \"$text\" must be visible.")
    @Alias("հետևյալ տեքստը՝  \"$text\" պետք է լինի տեսանելի")
    public void verifyTextInPage(String text) throws Exception {
        Assert.assertTrue("Text not found in page", ctx.containsText(text));
    }

    @Then("կայքում պետք է լինի հղում $text տեքստով և $linkUrl հասցեով")
    public void verifyLink(String text, String linkUrl) {
        Assert.assertTrue("Link not found in page", ctx.containsLink(text, linkUrl));
    }

    @Then("a sudoku game board should be available")
    @Pending
    public void verifyThereIsSudokuGameOnPage(){

    }

}
