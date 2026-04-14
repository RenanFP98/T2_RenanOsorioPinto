package edu.pe.cibertec.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegistroPage {
    public static final Target FIRST_NAME = Target.the("campo nombre").located(By.id("input-firstname"));
    public static final Target LAST_NAME = Target.the("campo apellido").located(By.id("input-lastname"));
    public static final Target EMAIL = Target.the("campo email").located(By.id("input-email"));
    public static final Target TELEPHONE = Target.the("campo teléfono").located(By.id("input-telephone"));
    public static final Target PASSWORD = Target.the("campo password").located(By.id("input-password"));
    public static final Target CONFIRM_PASSWORD = Target.the("campo confirmar password").located(By.id("input-confirm"));
    public static final Target PRIVACY_POLICY = Target.the("check política privacidad").located(By.name("agree"));
    public static final Target CONTINUE_BUTTON = Target.the("botón continuar").locatedBy("//input[@value='Continue']");
    public static final Target SUCCESS_MESSAGE = Target.the("mensaje éxito").located(By.tagName("h1"));
}