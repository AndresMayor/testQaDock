package co.com.carvajal.certificacion.gaia.tasks;

import co.com.carvajal.certificacion.gaia.userinterfaces.Nginx;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;


public class OpenThePage implements Task {

    private Nginx nginx;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(nginx));
    }

    public static OpenThePage nginx(){ return Tasks.instrumented(OpenThePage.class);
    }
}
