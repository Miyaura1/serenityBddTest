package com.nttdata.testing.stepDefinition;

import net.serenitybdd.screenplay.actions.Enter;

import com.nttdata.testing.Pages.MenClothesPage;
import com.nttdata.testing.Pages.CheckoutPage;
import com.nttdata.testing.Tasks.FillCheckoutForm;
import com.nttdata.testing.Tasks.LoginTask;
import com.nttdata.testing.Tasks.NavigateTo;
import com.nttdata.testing.Tasks.NavigateToJacketsFromMenu;
import com.nttdata.testing.questions.LabelQuestion;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ComprarProductoStepDefinition {

    @Given("el {actor} inicia sesion con email {string} y contrasenia {string}")
    public void elUsuarioIniciaSesion(Actor actor, String email, String contrasenia) {
        actor.attemptsTo(NavigateTo.theHomePage());
        theActorInTheSpotlight().attemptsTo(LoginTask.withData(email, contrasenia));
    }

    @And("ingresa a la seccion Jackets de la seccion Men del navbar")
    public void ingresaALaSeccionJacketsDeLaSeccionMenDelNavbar() {
        theActorInTheSpotlight().attemptsTo(NavigateToJacketsFromMenu.navigate());
    }

    @And("selecciona el producto {string}")
    public void seleccionaUnProducto(String nombreProducto) {
        theActorInTheSpotlight().attemptsTo(
                MoveMouse.to(MenClothesPage.itmProduct(nombreProducto)),
                Click.on(MenClothesPage.itmProduct(nombreProducto)));
    }

    @And("selecciona la talla {string} y color {string} con cantidad {string} y agrega al carrito")
    public void seleccionaLaTallaYColorYAgregaAlCarrito(String talla, String color, String cantidad) {
        theActorInTheSpotlight().attemptsTo(
                Click.on(MenClothesPage.optnTalla(talla)),
                Click.on(MenClothesPage.optnColor(color)),
                Enter.theValue(cantidad).into(MenClothesPage.OPTN_QTY),
                MoveMouse.to(MenClothesPage.BTN_AGREGAR_CARRITO),
                Click.on(MenClothesPage.BTN_AGREGAR_CARRITO));
    }

    @And("se agrega el producto {string} al carrito de manera exitosa")
    public void seAgregaElItemAlCarritoDeManeraExitosa(String nombreProducto) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(MenClothesPage.LBL_ADDED_TO_CART, isVisible()).forNoMoreThan(5).seconds());
        theActorInTheSpotlight().should(
                seeThat("Se muestra el mensaje de producto agregado al carrito",
                        LabelQuestion.visibleEn(MenClothesPage.LBL_ADDED_TO_CART),
                        equalTo("You added " + nombreProducto + " to your shopping cart.")));
    }

    @And("verifica el carrito con los productos agregados")
    public void estaEnElCarrito() {
        theActorInTheSpotlight().attemptsTo(Click.on(MenClothesPage.BTN_CARRITO));
    }

    @And("procede a comprar")
    public void procedeAComprar() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(MenClothesPage.BTN_CHECKOUT));
    }

    @And("se muestra el formulario de compra")
    public void seMuestraElFormularioDeCompra() {
        theActorInTheSpotlight().should(
                seeThat("El formulario muestra el título de Shipping Address",
                        LabelQuestion.visibleEn(CheckoutPage.LBL_CHECKOUT_FORM),
                        equalTo("Shipping Address")));
    }

    @And("llena el formulario con los datos {string}, {string}, {string}, {string}, {string}, {string}, {string} y {string}")
    public void llenaLosDatosDelFormularioDeCompra(String nombres, String apellidos, String direccion, String ciudad,
            String region, String codigoPostal, String pais, String telefono) {
        theActorInTheSpotlight().attemptsTo(
                FillCheckoutForm.withData(nombres, apellidos, direccion, ciudad, region, codigoPostal, pais, telefono));
    }

    @When("hace clic en Place Order")
    public void haceClicEnPlaceOrder() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(CheckoutPage.BTN_PLACE_ORDER));
    }

    @Then("se realiza la compra de manera exitosa")
    public void seRealizaLaCompraDeManeraExitosa() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CheckoutPage.LBL_SUCCESS_PURCHASE, isVisible()).forNoMoreThan(10).seconds());
        theActorInTheSpotlight().should(
                seeThat("Se muestra el mensaje de compra exitosa",
                        LabelQuestion.visibleEn(CheckoutPage.LBL_SUCCESS_PURCHASE),
                        equalTo("Thank you for your purchase!")));
    }

}
