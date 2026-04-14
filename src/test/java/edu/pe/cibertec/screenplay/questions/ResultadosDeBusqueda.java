package edu.pe.cibertec.screenplay.questions;

import edu.pe.cibertec.screenplay.ui.BusquedaPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.Collection;
import java.util.stream.Collectors;

public class ResultadosDeBusqueda implements Question<Collection<String>> {

    @Override
    public Collection<String> answeredBy(Actor actor) {
        return Text.ofEach(BusquedaPage.PRODUCT_RESULTS)
                .answeredBy(actor)
                .stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static ResultadosDeBusqueda nombres() {
        return new ResultadosDeBusqueda();
    }
}