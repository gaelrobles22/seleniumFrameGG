package StepDefinitions;

import Functions.CreateDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class Hooks {
    public static WebDriver driver;
    Logger log = Logger.getLogger(Hooks.class);
    Scenario scenario = null;

    //Initialiting driver
    @Before
    public void initDriver(Scenario scenario) throws IOException{
        log.info("#####");
        log.info("[ Configuration ] - Initializing control settings");
        log.info("#####");
        driver = CreateDriver.initConfig();
        this.scenario = scenario;
        log.info("#####");
        log.info("[ Scenario ] - "+ scenario.getName());
        log.info("#####");
    }

    //Close driver
    @After
    public void embedScreenshot(Scenario scenario) throws IOException{
        log.info("#####");
        log.info("[ Driver Status ] - Clean and close the controller instance");
        log.info("#####");
        driver.quit();
    }

}
