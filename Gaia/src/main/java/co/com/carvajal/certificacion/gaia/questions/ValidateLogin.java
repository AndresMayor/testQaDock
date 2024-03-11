package co.com.carvajal.certificacion.gaia.questions;

import co.com.carvajal.certificacion.gaia.userinterfaces.Home;
import co.com.carvajal.certificacion.gaia.utils.ConstantsNum;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidateLogin implements Question {

    private Boolean result;

    @Override
    public Object answeredBy(Actor actor) {

        actor.attemptsTo(WaitUntil.the(Home.WELCOME, isVisible()).forNoMoreThan(ConstantsNum.SIXTY_NUM).seconds());
        if (!Home.WELCOME.resolveFor(actor).isVisible()){
            result = false;
        } else if (Home.WELCOME.resolveFor(actor).isVisible()){
            result = true;
        }

        return result;
    }

    public static ValidateLogin isCorrect() { return new ValidateLogin(); }

}
