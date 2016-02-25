package by.epam.cdp.framework.stories;

import java.util.Arrays;
import java.util.List;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import by.epam.cdp.framework.bddsteps.Steps;

public class StoryRunner extends JUnitStories {
	
	public StoryRunner() {
		super();
	}
	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new Steps());
	}

	protected List<String> storyPaths() {
		return Arrays.asList("by/epam/cdp/framework/stories/AddToCart.story");
	}

	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration().useStoryLoader(new LoadFromClasspath(this.getClass()))
				.useStoryControls(new StoryControls().doResetStateBeforeScenario(true))
				.useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE,
						Format.TXT, Format.HTML));
	}	
}