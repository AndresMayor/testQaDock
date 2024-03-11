package co.com.carvajal.certificacion.gaia.stepdefinitions;

import co.com.carvajal.certificacion.gaia.tasks.CloseThePage;
import co.com.carvajal.certificacion.gaia.tasks.Login;
import co.com.carvajal.certificacion.gaia.tasks.OpenThePage;
import co.com.carvajal.certificacion.gaia.questions.ValidateLogin;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class LoginStepDefinition {



    @Before
    public void starTheStage() {
        WebDriverManager.chromedriver().setup();
        setTheStage(new OnlineCast());

    }

    @Given("^(.*)User open Home page$")
    public void userOpenHomePage(String actor) {
        theActorCalled(actor).wasAbleTo(
                OpenThePage.macroSitie());

    }
    @When("^The user enters credentials$")
    public void the_user_enters_credentials() {
        theActorInTheSpotlight().wasAbleTo(
                Login.onThePage(
                       System.getProperty("username"),
                       System.getProperty("password")));

    }
    @Then("^User verify access$")
    public void user_verify_access() {

        theActorInTheSpotlight().should(
                seeThat(ValidateLogin.isCorrect())
        );
    }

    @And("^The user close MacroSitio$")
    public void user_close_page() {

        theActorInTheSpotlight().wasAbleTo(
                CloseThePage.macroSite());
    }

}
