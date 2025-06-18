package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavigateToJacketsFromMenu implements Task {

    public static NavigateToJacketsFromMenu navigate() {
        return Tasks.instrumented(NavigateToJacketsFromMenu.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            MoveMouse.to(HomePage.MENU_MEN),
            WaitUntil.the(HomePage.ITM_TOPS, isVisible()).forNoMoreThan(5).seconds(),
            MoveMouse.to(HomePage.ITM_TOPS),
            WaitUntil.the(HomePage.ITM_JACKETS, isVisible()).forNoMoreThan(5).seconds(),
            Click.on(HomePage.ITM_JACKETS)
        );
    }
}
