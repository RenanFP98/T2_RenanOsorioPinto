package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.screenplay.tasks.IniciarSesionComo;
import edu.pe.cibertec.screenplay.ui.LoginPage;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.questions.Text;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class LoginStepDefinitions {

    @CastMember(name = "Renán")
    Actor actor;

    @Given("the user navigates to the login page")
    public void navigatesToLogin() {
        actor.wasAbleTo(Open.url("https://naveenautomationlabs.com/opencart/index.php?route=account/login"));
    }

    @When("the user enters email {string} and password {string}")
    public void entersCredentials(String email, String password) {
        actor.attemptsTo(IniciarSesionComo.conCredenciales(email, password));
    }

    @And("clicks on the login button")
    public void clicksLogin() {
    }

    @Then("the user should see the name {string} in the page header")
    public void verifyHeaderName(String expectedName) {
        actor.should(seeThat(Text.of(LoginPage.HEADER_NAME), Matchers.containsString("My Account")));
    }

    @Then("the user should see the login warning {string}")
    public void verifyLoginWarning(String expectedMessage) {
        actor.should(seeThat(Text.of(LoginPage.ALERT_MESSAGE), Matchers.containsString(expectedMessage)));
    }
}