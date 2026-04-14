package edu.pe.cibertec.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BusquedaPage {
    // Campo de texto de la barra de búsqueda superior
    public static final Target SEARCH_INPUT = Target.the("campo de búsqueda")
            .located(By.name("search"));

    // Lupa o botón de búsqueda
    public static final Target SEARCH_BUTTON = Target.the("botón de búsqueda")
            .located(By.cssSelector(".btn-default.btn-lg"));

    // Nombres de los productos que aparecen en los resultados (H4 > A)
    public static final Target PRODUCT_RESULTS = Target.the("nombres de productos en resultados")
            .located(By.cssSelector("h4 a"));

    // Mensaje que sale cuando no hay resultados
    public static final Target NO_RESULTS_MESSAGE = Target.the("mensaje sin resultados")
            .located(By.xpath("//p[contains(text(),'There is no product')]"));
}