package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.screenplay.questions.ContadorDelCarrito;
import edu.pe.cibertec.screenplay.tasks.AgregarAlCarrito;
import edu.pe.cibertec.screenplay.ui.CarritoPage;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CarritoStepDefinitions {

    @When("the user adds the product {string} to the cart")
    public void agregarProductoAlCarrito(String producto) {
        OnStage.theActorInTheSpotlight().attemptsTo(AgregarAlCarrito.elProducto(producto));
    }

    @Then("the cart should show {string}")
    public void verificarContador(String cantidadEsperada) {
        // La espera ya se hizo en la Task, así que aquí el contador ya debería estar actualizado
        OnStage.theActorInTheSpotlight().should(
                seeThat(ContadorDelCarrito.valor(), Matchers.containsString(cantidadEsperada))
        );
    }

    @And("navigates to the cart")
    public void navegarAlCarrito() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                // Forzamos el clic con JavaScript para que el menú se abra sí o sí
                WaitUntil.the(CarritoPage.CART_BUTTON, WebElementStateMatchers.isClickable()),
                JavaScriptClick.on(CarritoPage.CART_BUTTON),

                // Esperamos a que el enlace interno sea visible antes de clickearlo
                WaitUntil.the(CarritoPage.VIEW_CART_LINK, WebElementStateMatchers.isVisible()),
                Click.on(CarritoPage.VIEW_CART_LINK)
        );
    }

    @Then("the user should see the product {string} in the cart list")
    public void verificarProductoEnLista(String nombreProducto) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(Text.of(CarritoPage.PRODUCT_IN_TABLE.of(nombreProducto)),
                        Matchers.equalTo(nombreProducto))
        );
    }
}