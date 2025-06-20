package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.HomePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theHomePage() {
        return Task.where("{0} opens the Home page",
                Open.browserOn().the(HomePage.class));
    }
    public static Performable theEditAccountInformationPage() {
        return Task.where("{0} opens the Edit Account Information page",
                Open.url("https://magento.softwaretestingboard.com/customer/account/edit/"));
    }
}