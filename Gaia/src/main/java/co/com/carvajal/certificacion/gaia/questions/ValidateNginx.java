package co.com.carvajal.certificacion.gaia.questions;

import co.com.carvajal.certificacion.gaia.userinterfaces.Nginx;
import co.com.carvajal.certificacion.gaia.utils.ConstantsNum;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidateNginx implements Question {

    private Boolean result;

    @Override
    public Object answeredBy(Actor actor) {


        if (!Nginx.WELCOME.resolveFor(actor).isVisible()){
            result = false;
        } else if (Nginx.WELCOME.resolveFor(actor).isVisible()){
            result = true;
        }

        return result;
    }

    public static ValidateNginx isCorrect() { return new ValidateNginx(); }

}
