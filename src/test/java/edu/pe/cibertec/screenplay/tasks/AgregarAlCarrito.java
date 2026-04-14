package edu.pe.cibertec.screenplay.tasks;

import edu.pe.cibertec.screenplay.ui.BusquedaPage;
import edu.pe.cibertec.screenplay.ui.CarritoPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AgregarAlCarrito implements Task {
    private final String producto;

    public AgregarAlCarrito(String producto) {
        this.producto = producto;
    }

    public static AgregarAlCarrito elProducto(String producto) {
        return instrumented(AgregarAlCarrito.class, producto);
    }

    @Override
    @Step("{0} busca y agrega al carrito el producto #producto")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(producto).into(BusquedaPage.SEARCH_INPUT).thenHit(Keys.ENTER),
                WaitUntil.the(CarritoPage.ADD_TO_CART_BTN, WebElementStateMatchers.isClickable()).forNoMoreThan(10).seconds(),
                Click.on(CarritoPage.ADD_TO_CART_BTN),
                // ESPERA CORREGIDA: Espera a que aparezca el banner verde de éxito
                WaitUntil.the(Target.the("alerta de éxito").locatedBy(".alert-success"),
                        WebElementStateMatchers.isVisible()).forNoMoreThan(5).seconds()
        );
    }
}