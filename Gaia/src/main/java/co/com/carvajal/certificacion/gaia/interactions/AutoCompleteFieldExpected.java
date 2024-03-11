package co.com.carvajal.certificacion.gaia.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;

public class AutoCompleteFieldExpected {


    public static void compareAutoCompleteField(Actor actor, Target nameElement, String expectedInformationElement) {
        WebElementFacade inputField = nameElement.resolveFor(actor);
        String actualInformationElement = inputField.getValue().replaceAll("\\s", "");


        if (!expectedInformationElement.replaceAll("\\s", "").equalsIgnoreCase(actualInformationElement)) {
            String errorMessage = "El texto ingresado no es el esperado. Elemento: " + nameElement.getName();
            throw new AssertionError(errorMessage);
        }
    }
}
