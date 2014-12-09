package am.iunetworks.training.sudoku.bdd.steps;

import am.iunetworks.training.sudoku.bdd.context.WebClientContext;
import org.jbehave.core.annotations.*;

public class BeforeAndAfterSteps {

    private WebClientContext ctx;

    public BeforeAndAfterSteps(WebClientContext ctx){
        this.ctx = ctx;
    }

    @BeforeStories
    public void beforeAllStories(){
        ctx.initPhantomJsDriver(true);
    }

    @BeforeStory
    public void beforeEachStory(){
        // add code here if needed
    }

    @BeforeScenario
    public void beforeScenario(){
        // add code here if needed
    }


    @AfterStory
    public void afterEachStory(){
        // add code here if needed
    }

    @AfterScenario
    public void afterScenario(){
        // add code here if needed
    }

    @AfterStories
    public void afterAllStories(){
        // add code here if needed
    }
}
