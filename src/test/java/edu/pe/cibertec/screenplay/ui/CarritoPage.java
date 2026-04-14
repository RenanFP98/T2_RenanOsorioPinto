package edu.pe.cibertec.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CarritoPage {

    public static final Target ADD_TO_CART_BTN = Target.the("botón agregar al carrito")
            .locatedBy("(//button[contains(@onclick, 'cart.add')])[1]");

    public static final Target CART_TOTAL = Target.the("total del carrito")
            .located(By.id("cart-total"));

    public static final Target CART_BUTTON = Target.the("botón negro del carrito")
            .located(By.id("cart-total"));

    public static final Target VIEW_CART_LINK = Target.the("enlace ver carrito")
            .locatedBy("//strong[contains(text(),'View Cart')]");

    public static final Target PRODUCT_IN_TABLE = Target.the("producto en la tabla")
            .locatedBy("//div[@class='table-responsive']//a[text()='{0}']");
}