package edu.pe.cibertec.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static final Target EMAIL = Target.the("campo email").located(By.id("input-email"));
    public static final Target PASSWORD = Target.the("campo password").located(By.id("input-password"));
    public static final Target LOGIN_BUTTON = Target.the("botón login").located(By.xpath("//input[@value='Login']"));
    public static final Target HEADER_NAME = Target.the("nombre en header").located(By.xpath("//h2[contains(text(),'My Account')]"));
    public static final Target ALERT_MESSAGE = Target.the("mensaje alerta").located(By.cssSelector(".alert-danger"));
}