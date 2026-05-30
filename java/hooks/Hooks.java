package hooks;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {

    @Before
    public void setup() {

        initializeBrowser();

        System.out.println("Browser Launched");
    }

    @After
    public void teardown(Scenario scenario) throws Exception {

        // Screenshot on Failure
        if (scenario.isFailed()) {

            TakesScreenshot ts = (TakesScreenshot) driver;

            File src = ts.getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(
                src,
                new File("screenshots/" + scenario.getName() + ".png")
            );
        }

        closeBrowser();

        System.out.println("Browser Closed");
    }
}