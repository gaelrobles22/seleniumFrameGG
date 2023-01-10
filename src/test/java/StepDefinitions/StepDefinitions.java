package StepDefinitions;

import Functions.SeleniumFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class StepDefinitions {

    WebDriver driver;
    public StepDefinitions(){
        driver = Hooks.driver;
    }
    Logger log = Logger.getLogger(StepDefinitions.class);

    @Given("^El cliente se encuentra en la pantalla de loggeo$")
    public void elClienteSeEncuentraEnLaPantallaDeLoggeo() throws IOException{
        pro.load(in);
        String url = pro.getProperty("MainAppUrlBase");
        log.info(("Navegar a: "+ url));
        driver.get(url);
    }
    @Given("^El cliente ingresa al sitio (.*)$")
    public void elClienteIngresaAlSitio(String url) throws IOException{
        log.info(("Navegar a: "+ url));
        driver.get(url);
    }

    @Then("^Cargo la informacion del DOM (.*)$")
    public void cargoLaInformacionDelDOM(String file) throws IOException {
        SeleniumFunctions.FileName = file;
        SeleniumFunctions.readJson();
        log.info("Inicializa el archivo: "+ file);



    }

    @And("^Hago un click en el elemento (.*)$")
    public void hagoUnClicEnElElementoEmail(String element) throws Exception{
        By SeleniumElement = SeleniumFunctions.getCompleteElements(element);
        driver.findElement(SeleniumElement).click();
        log.info("click en el elemento"+element);
    }

    @And("^Configuro el elemento (.*) con el texto (.*)$")
    public void configuroElElementoEmailConElTextoGaelroblesGmailCom(String element, String text)throws Exception {
        By SeleniumElement = SeleniumFunctions.getCompleteElements(element);
        driver.findElement(SeleniumElement).sendKeys(text);
    }
}
