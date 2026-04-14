package edu.pe.cibertec.screenplay.tasks;

import edu.pe.cibertec.screenplay.ui.BusquedaPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BuscarProducto implements Task {
    private final String producto;

    public BuscarProducto(String producto) {
        this.producto = producto;
    }

    public static BuscarProducto conNombre(String producto) {
        return instrumented(BuscarProducto.class, producto);
    }

    @Override
    @Step("{0} busca el producto #producto")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(producto).into(BusquedaPage.SEARCH_INPUT).thenHit(Keys.ENTER)
        );
    }
}