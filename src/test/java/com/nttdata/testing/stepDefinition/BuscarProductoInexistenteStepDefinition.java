package com.nttdata.testing.stepDefinition;

import com.nttdata.testing.Pages.HomePage;
import com.nttdata.testing.Tasks.LoginTask;
import com.nttdata.testing.Tasks.NavigateTo;
import com.nttdata.testing.questions.LabelQuestion;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import static org.hamcrest.Matchers.equalTo;


public class BuscarProductoInexistenteStepDefinition {
  @Given ("el {actor} esta logueado con email {string} y contrasenia {string}, y en la pagina de inicio")
  public void elUsuarioEstaLogueadoYEnLaPaginaDeInicio(Actor actor, String email, String contrasenia) {
    actor.attemptsTo(LoginTask.withData(email, contrasenia));
    theActorInTheSpotlight().attemptsTo(NavigateTo.theHomePage());
  }
  @And ("ingresa el producto {string} en la barra de busqueda")
  public void ingresaUnProductoEnLaBarraDeBusqueda(String producto) {
    theActorInTheSpotlight().attemptsTo(
      MoveMouse.to(HomePage.INPT_SEARCH_BAR),
      Enter.theValue(producto).into(HomePage.INPT_SEARCH_BAR)
    );
  }
  @When ("hace clic en el icono de buscar")
  public void haceClicEnElIconoDeBuscar() {
    theActorInTheSpotlight().attemptsTo( 
      Click.on(HomePage.BTN_SEARCH)
    );
  }
  @Then ("se muestra el mensaje de busqueda sin resultados")
  public void seMuestraElMensajeDeBusquedaSinResultados() {
    theActorInTheSpotlight().attemptsTo(
    
    );

    theActorInTheSpotlight().should(
      seeThat("Se muestra el mensaje de busqueda sin resultados", LabelQuestion.visibleEn(HomePage.LBL_NO_SEARCH_RESULTS), equalTo("Your search returned no results.")));
  }
}
