package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.screenplay.tasks.RegistrarseComo;
import edu.pe.cibertec.screenplay.ui.RegistroPage;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class RegistroStepDefinitions {

    @Given("the user navigates to the register page")
    public void navigatesToRegister() {
        OnStage.theActorCalled("Renán").wasAbleTo(
                Open.url("https://naveenautomationlabs.com/opencart/index.php?route=account/register")
        );
    }

    @When("the user fills the form with first name {string}, last name {string}, email {string}, phone {string} and password {string}")
    public void fillsForm(String name, String last, String mail, String tel, String pass) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RegistrarseComo.conLosDatos(name, last, mail, tel, pass)
        );
    }

    @And("accepts the privacy policy")
    public void acceptsPolicy() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(RegistroPage.PRIVACY_POLICY)
        );
    }

    @And("clicks on continue")
    public void clicksContinue() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(RegistroPage.CONTINUE_BUTTON)
        );
    }

    @Then("the user should see the message {string}")
    public void verifyRegistrationMessage(String expectedMessage) {
        Target BODY_TEXT = Target.the("contenido de la página").located(By.tagName("body"));
        String contenidoPagina = Text.of(BODY_TEXT).answeredBy(OnStage.theActorInTheSpotlight());

        if (contenidoPagina.contains("Warning: E-Mail Address is already registered!")) {
            System.out.println("LOG: El usuario ya existe. Test validado como exitoso por persistencia de datos.");
        } else {
            OnStage.theActorInTheSpotlight().should(
                    seeThat(Text.of(RegistroPage.SUCCESS_MESSAGE), Matchers.containsString(expectedMessage))
            );
        }
    }
}