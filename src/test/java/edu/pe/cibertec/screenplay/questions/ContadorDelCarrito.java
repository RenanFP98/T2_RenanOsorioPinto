package edu.pe.cibertec.screenplay.questions;

import edu.pe.cibertec.screenplay.ui.CarritoPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ContadorDelCarrito {
    public static Question<String> valor() {
        return actor -> Text.of(CarritoPage.CART_TOTAL).answeredBy(actor);
    }
}