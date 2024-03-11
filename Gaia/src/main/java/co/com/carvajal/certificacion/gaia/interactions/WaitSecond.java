package co.com.carvajal.certificacion.gaia.interactions;

import net.serenitybdd.core.time.InternalSystemClock;
import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class WaitSecond implements Interaction, IsSilent {

    private Integer seconds;

    public WaitSecond(Integer seconds) {

        this.seconds = seconds;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        new InternalSystemClock().pauseFor(seconds * 1000);
    }

    public static WaitSecond forContinue(Integer seconds) {

        return Tasks.instrumented(WaitSecond.class, seconds);
    }

}
