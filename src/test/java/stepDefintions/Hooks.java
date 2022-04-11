package stepDefintions;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

public class Hooks extends Base {
    @Before
    public void setUpDriver() throws IOException, InterruptedException {

        lunchBrowser();
    }

    @After
    public void before_or_after(Scenario scenario) {

        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot of error");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        driver.close();
        driver.quit();

    }
}
