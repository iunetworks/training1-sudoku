package am.iunetworks.training.sudoku.bdd.runners;

import static java.util.Arrays.asList;
import java.util.List;

import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.spring.UsingSpring;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.junit.Test;
import org.junit.runner.RunWith;



@RunWith(org.jbehave.core.junit.spring.SpringAnnotatedEmbedderRunner.class)
@UsingEmbedder(embedder = Embedder.class,
        generateViewAfterStories = true,
        ignoreFailureInStories = true,
        ignoreFailureInView = true
)
@Configure()
@UsingSpring(resources = {
		"jbehave/spring-config/spring-jbehave-config.xml",
		"jbehave/spring-config/spring-jbehave-config-en.xml",
        "jbehave/spring-config/jbehave-step-classes.xml" })
public class ITestEnglishStories extends InjectableEmbedder {


	@Test 
	@Override
	public void run() throws Throwable {

		List<String> paths = new StoryFinder().findPaths(CodeLocations
				.codeLocationFromClass(this.getClass()).getFile(),
				asList("**/*story.en.txt"), null);
		injectedEmbedder().runStoriesAsPaths(paths);
//		injectedEmbedder().configuration().;
	}

}
