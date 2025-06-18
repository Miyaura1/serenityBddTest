package com.nttdata.testing.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.nttdata.testing.Pages.EditAccountInformationPage;
import com.nttdata.testing.Tasks.LoginTask;
import com.nttdata.testing.Tasks.NavigateTo;
import com.nttdata.testing.questions.LabelQuestion;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;

public class EditarNombresApellidosStepDefinition {

  @Given("el {actor} esta logueado con email {string} y contrasenia {string}")
  public void elUsuarioEstaLogueadoConEmailYContrasenia(Actor actor, String email, String contrasenia) {
    actor.attemptsTo(
        NavigateTo.theHomePage(),
        LoginTask.withData(email, contrasenia));
  }

  @And("se dirige a la pagina de configuracion de perfil")
  public void seDirigeALaPaginaDeConfiguracionDePerfil() {
    theActorInTheSpotlight().attemptsTo(NavigateTo.theEditAccountInformationPage());
  }

  @And("edita los campos nombres o apellidos con {string} y {string}")
  public void editaLosCamposNombresOApellidos(String nombreNuevo, String apellidoNuevo) {
    theActorInTheSpotlight().attemptsTo(
        Enter.theValue(nombreNuevo).into(EditAccountInformationPage.TXT_FIRST_NAME),
        Enter.theValue(apellidoNuevo).into(EditAccountInformationPage.TXT_LAST_NAME));
  }

  @When("hace clic en guardar configuraciones")
  public void haceClicEnGuardarConfiguraciones() {
    theActorInTheSpotlight().attemptsTo(
        MoveMouse.to(EditAccountInformationPage.BTN_SAVE_CHANGES),
        Click.on(EditAccountInformationPage.BTN_SAVE_CHANGES));
  }

  @Then("se muestra el mensaje de edicion exitosa")
  public void seMuestraElMensajeDeEdicionExitosa() {
    theActorInTheSpotlight().attemptsTo(
        WaitUntil.the(EditAccountInformationPage.LBL_SUCCESS_EDITION, isVisible()).forNoMoreThan(5).seconds());

    theActorInTheSpotlight().should(
      seeThat("Se muestra el mensaje de edicion exitosa",
        LabelQuestion.visibleEn(EditAccountInformationPage.LBL_SUCCESS_EDITION),
        equalTo("You saved the account information.")));
  }
}