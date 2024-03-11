package co.com.carvajal.certificacion.gaia.interactions;

import net.serenitybdd.core.time.InternalSystemClock;
import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class WaitMilisecond implements Interaction, IsSilent {

    private Integer miliseconds;

    public WaitMilisecond(Integer miliseconds) {

        this.miliseconds = miliseconds;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        new InternalSystemClock().pauseFor(miliseconds);
    }

    public static WaitMilisecond forContinue(Integer miliseconds) {
        return Tasks.instrumented(WaitMilisecond.class, miliseconds);
    }

}
