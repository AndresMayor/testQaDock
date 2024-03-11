package co.com.carvajal.certificacion.gaia.interactions;

import net.serenitybdd.screenplay.Tasks;

public class Wait {

    public static WaitSecond seconds(Integer seconds) {

        return Tasks.instrumented(WaitSecond.class, seconds);
    }

    public static WaitMilisecond miliseconds(Integer miliseconds) {

        return Tasks.instrumented(WaitMilisecond.class, miliseconds);
    }

}
