package am.iunetworks.training.sudoku.bdd.runners;

import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.spring.UsingSpring;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static java.util.Arrays.asList;


@RunWith(org.jbehave.core.junit.spring.SpringAnnotatedEmbedderRunner.class)
@UsingEmbedder(embedder = Embedder.class,
        generateViewAfterStories = true,
        ignoreFailureInStories = true,
        ignoreFailureInView = true
)
@Configure()
@UsingSpring(resources = {
		"jbehave/spring-config/spring-jbehave-config-hy.xml",
		"jbehave/spring-config/spring-jbehave-config.xml",
        "jbehave/spring-config/jbehave-step-classes.xml" })
public class ITestArmenianStories extends InjectableEmbedder {


	@Test 
	@Override
	public void run() throws Throwable {

		List<String> paths = new StoryFinder().findPaths(CodeLocations
				.codeLocationFromClass(this.getClass()).getFile(),
				asList("**/*story.hy.txt"), null);
		injectedEmbedder().runStoriesAsPaths(paths);
//		injectedEmbedder().configuration().;
	}

}
