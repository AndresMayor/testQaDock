package co.com.carvajal.certificacion.gaia.userinterfaces;


import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;


@DefaultUrl("http://localhost")
public class Nginx  extends PageObject{

    public static final Target WELCOME = Target.the("welcomeNginx").located(By.xpath("//body//h1"));

    public WebDriver getThisWebDriver() {
        return this.getDriver();
    }
}
