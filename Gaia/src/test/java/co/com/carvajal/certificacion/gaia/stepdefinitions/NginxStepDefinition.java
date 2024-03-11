package co.com.carvajal.certificacion.gaia.stepdefinitions;

//import co.com.carvajal.certificacion.gaia.tasks.CloseThePage;
import co.com.carvajal.certificacion.gaia.tasks.OpenThePage;
import co.com.carvajal.certificacion.gaia.questions.ValidateNginx;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class NginxStepDefinition {

    @Before
    public void starTheStage() {
        WebDriverManager.chromedriver().setup();
        setTheStage(new OnlineCast());

    }

    @Given("^(.*)Open Home page nginx$")
    public void openHomePage(String actor) {
        theActorCalled(actor).wasAbleTo(
                OpenThePage.nginx());

    }
  /*  @When("^The user enters credentials$")
    public void the_user_enters_credentials() {
        theActorInTheSpotlight().wasAbleTo(
                Login.onThePage(
                       System.getProperty("username"),
                       System.getProperty("password")));

    }*/
    @Then("^Verify state running nginx$")
    public void verifyStateRunningNginx() {

        theActorInTheSpotlight().should(
                seeThat(ValidateNginx.isCorrect())
        );
    }

   /* @And("^The user close MacroSitio$")
    public void user_close_page() {

        theActorInTheSpotlight().wasAbleTo(
                CloseThePage.macroSite());
    }*/

}
