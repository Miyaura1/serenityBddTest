package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.CheckoutPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class FillCheckoutForm implements Task {

  private String firstName;
  private String lastName;
  private String address;
  private String city;
  private String region;
  private String postalCode;
  private String country;
  private String phone;

  public FillCheckoutForm(String firstName, String lastName, String address, String city, String region, String postalCode, String country, String phone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.city = city;
    this.region = region;
    this.postalCode = postalCode;
    this.country = country;
    this.phone = phone;

  }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(firstName).into(CheckoutPage.TXT_FIRST_NAME),
                Enter.theValue(lastName).into(CheckoutPage.TXT_LAST_NAME),
                Enter.theValue(address).into(CheckoutPage.TXT_ADDRESS),
                SelectFromOptions.byVisibleText(country).from(CheckoutPage.SLCT_COUNTRY),
                // SelectFromOptions.byVisibleText(region).from(CheckoutPage.SLCT_REGION), //solo para US
                Enter.theValue(region).into(CheckoutPage.TXT_REGION),
                Enter.theValue(city).into(CheckoutPage.TXT_CITY),
                Enter.theValue(postalCode).into(CheckoutPage.TXT_POSTAL_CODE),
                Enter.theValue(phone).into(CheckoutPage.TXT_PHONE),
                Click.on(CheckoutPage.RD_SHIPPING_METHOD),
                Click.on(CheckoutPage.BTN_CONTINUE),
                Click.on(CheckoutPage.CHK_ADDRESS)
                // ScrollToBottom.now()
        );
    }

  public static Performable withData(String firstName, String lastName, String address, String city, String region, String postalCode, String country, String phone) {
    return new FillCheckoutForm(firstName, lastName, address, city, region, postalCode, country, phone);
  }
}
