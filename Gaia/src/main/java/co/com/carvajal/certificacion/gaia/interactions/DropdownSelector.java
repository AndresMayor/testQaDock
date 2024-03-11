package co.com.carvajal.certificacion.gaia.interactions;

import co.com.carvajal.certificacion.gaia.utils.ConstantsNum;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static co.com.carvajal.certificacion.gaia.userinterfaces.CreatedUpdateCompany.OVERLAY_ELEMENT;
import static co.com.carvajal.certificacion.gaia.userinterfaces.Login.USERNAME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class DropdownSelector {


    public static void selectDropdownElement(Actor actor, Target elementSelect, Target elementOptions, String userOption) {

        WaitUntil.the(OVERLAY_ELEMENT, isNotVisible()).forNoMoreThan(ConstantsNum.SIXTY_NUM).seconds();

        if (elementSelect != null) {
            WaitUntil.the(elementSelect, isClickable());
            actor.attemptsTo(
                    Click.on(elementSelect)
            );


            String selectClass = elementSelect.resolveFor(actor).getAttribute("class");


            if (selectClass.contains("p-autocomplete")) {
                WaitUntil.the(elementOptions, isVisible()).forNoMoreThan(ConstantsNum.SIXTY_NUM).seconds();
                actor.attemptsTo(
                        Enter.theValue(userOption).into(elementSelect)
                );
            }
        }




        if (elementOptions.resolveFor(actor).isVisible()) {

            List<WebElementFacade> dropdownElements = elementOptions.resolveAllFor(actor);
            for (WebElementFacade element : dropdownElements) {
                if (element.getText().toLowerCase().replaceAll("\\s", "").contains(userOption.toLowerCase().replaceAll("\\s", ""))) {
                    WaitUntil.the(elementOptions, isClickable()).forNoMoreThan(ConstantsNum.TWO_NUM).seconds();
                    element.click();
                    break;
                }
            }
        }
    }
}