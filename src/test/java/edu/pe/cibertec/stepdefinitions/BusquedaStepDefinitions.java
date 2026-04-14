package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.screenplay.questions.ResultadosDeBusqueda;
import edu.pe.cibertec.screenplay.tasks.BuscarProducto;
import edu.pe.cibertec.screenplay.ui.BusquedaPage;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Text;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class BusquedaStepDefinitions {

    @Given("the user is on the OpenCart home page")
    public void userIsOnHomePage() {
        OnStage.theActorCalled("Renán").wasAbleTo(Open.url("https://naveenautomationlabs.com/opencart/"));
    }

    @When("the user searches for the product {string}")
    public void searchesForProduct(String producto) {
        OnStage.theActorInTheSpotlight().attemptsTo(BuscarProducto.conNombre(producto));
    }

    @Then("the user should see at least one result with the name {string}")
    public void verifyAtLeastOneResult(String expectedName) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ResultadosDeBusqueda.nombres(), Matchers.hasItem(Matchers.containsString(expectedName)))
        );
    }

    @Then("the user should see the search message {string}")
    public void verifySearchMessage(String expectedMessage) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(Text.of(BusquedaPage.NO_RESULTS_MESSAGE), Matchers.containsString(expectedMessage))
        );
    }
}