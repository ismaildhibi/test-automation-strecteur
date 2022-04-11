package runner;

import base.Base;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = /*"src/test/java/features",*/
                {
                        "src/test/java/features/A/01-Feature.feature",

                },
        glue = "stepDefintions",
        plugin = {"pretty", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"}
)
public class TestRunner  {

}
