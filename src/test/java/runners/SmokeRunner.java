package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // features we use to provide the path of all the feature files
        features = "src/test/resources/features/",
        glue = "steps",

        // when you set dry run to true, it stops actual execution
        // it will quickly scan all the gherkin steps weather they are implemented or not
        // when we set dry to false, it starts execution again
        dryRun = false,
        // for run multiple tag put or
       // tags = "@sprint3 or @sprint1"
        tags = "@sprint3",

        // to remove irrelevant information from console, you need to set monochrome to true
        monochrome = true,
        // pretty keyword prints the step in the console to increase readability
        plugin = {"pretty"}

)



public class SmokeRunner {

}
