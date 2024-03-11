package co.com.carvajal.certificacion.gaia.tasks;

import co.com.carvajal.certificacion.gaia.userinterfaces.Login;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;


public class OpenThePage implements Task {

    private Login loginMacroSitie;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(loginMacroSitie));
    }

    public static OpenThePage macroSitie(){ return Tasks.instrumented(OpenThePage.class);
    }
}
