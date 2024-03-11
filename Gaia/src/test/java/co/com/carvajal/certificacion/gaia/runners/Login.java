package co.com.carvajal.certificacion.gaia.runners;

import co.com.carvajal.certificacion.gaia.utils.BeforeSuite;
import co.com.carvajal.certificacion.gaia.utils.DataToFeature;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import java.io.IOException;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/login/login.feature",
                glue = "co.com.carvajal.certificacion.gaia.stepdefinitions",
                snippets = CAMELCASE,
                monochrome = true)
public class Login {

    private Login(){

    }

   @BeforeSuite
   public static void test() throws InvalidFormatException, IOException {
       DataToFeature.overrideFeatureFiles("src/test/resources/features/login/login.feature");
   }

}
