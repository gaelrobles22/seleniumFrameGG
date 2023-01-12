package Functions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class WebDriveFactory {

    private static Properties prop = new Properties();
    private static InputStream in = CreateDriver.class.getResourceAsStream("../test.properties");
    private static String resourceFolder;
    private static Logger log = Logger.getLogger(WebDriveFactory.class);
    private static WebDriveFactory instance = null;

    private WebDriveFactory(){

    }

    public static WebDriveFactory getInstance(){
        if(instance == null){
            instance = new WebDriveFactory();

        }
        return instance;
    }
    public static WebDriver createNewWebDriver(String browser, String os)throws IOException {
        WebDriver driver;
        prop.load(in);
        resourceFolder = prop.getProperty("resourceFolder");


        //Selecting FirefoxDriver
        if("FIREFOX".equalsIgnoreCase(browser)){
            if("WINDOWS".equalsIgnoreCase(os)){
                System.setProperty("webdriver.gecko.driver", resourceFolder + os + "/geckodriver.exe");
            }
            else{
                System.setProperty("webdriver.gecko.driver", resourceFolder + os + "/geckodriver");
            }
            driver = new FirefoxDriver();
        }
        //Selecting ChromeDriver
        else if("CHROME".equalsIgnoreCase(browser)){
            if("WINDOWS".equalsIgnoreCase(os)){
                System.setProperty("webdriver.chrome.driver", resourceFolder + os + "/chromedriver.exe");
            }
            else{
                System.setProperty("webdriver.chrome.driver", resourceFolder + os + "/chromedriver");
            }
            driver = new ChromeDriver();
        }


        //Selecting Internet Explorer
        else if ("INTERNET EXPLORER".equalsIgnoreCase(browser)) {
            System.setProperty("webdriver.ie.driver", resourceFolder + os + "/IEDriverServer.exe");
            driver = new InternetExplorerDriver();

            //if not selected anyone or invalid name
        }else{
            log.error("The Driver is not selected property, invalid name" + browser + ", "+ os);
            return null;
        }

        driver.manage().window().maximize();
        return driver;


    }



}
