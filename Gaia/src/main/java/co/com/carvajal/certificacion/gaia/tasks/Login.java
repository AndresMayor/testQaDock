package co.com.carvajal.certificacion.gaia.tasks;

import co.com.carvajal.certificacion.gaia.interactions.Wait;
import co.com.carvajal.certificacion.gaia.utils.ConstantsNum;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.ScrollToTarget;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.apache.poi.ss.formula.functions.T;

import static co.com.carvajal.certificacion.gaia.userinterfaces.Login.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login implements Task {

    private String username;
    private String password;



    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        stepsLogin(actor);
        if(LOGIN_BLOKED.resolveFor(actor).isVisible()){
           actor.attemptsTo(Click.on(CONTINUE));
           stepsLogin(actor);
        }

    }

    public  <T extends Actor>  void stepsLogin (T actor){

        actor.attemptsTo(
                Click.on(USERNAME),
                WaitUntil.the(USERNAME, isVisible()).forNoMoreThan(ConstantsNum.SIXTY_NUM).seconds(),
                Enter.theValue(username).into(USERNAME),
                WaitUntil.the(PASSWORD, isVisible()).forNoMoreThan(ConstantsNum.SIXTY_NUM).seconds(),
                Click.on(PASSWORD),
                Enter.theValue(password).into(PASSWORD),
                Scroll.to(LOGIN).andAlignToBottom(),
                Click.on(LOGIN)
        );
    }


    public static Login onThePage(String username, String password) {
        return Tasks.instrumented(Login.class, username, password);
    }





}
