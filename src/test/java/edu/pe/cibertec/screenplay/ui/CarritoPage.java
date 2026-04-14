package edu.pe.cibertec.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CarritoPage {

    // Botón azul de "Add to Cart" que aparece en el primer resultado de búsqueda
    public static final Target ADD_TO_CART_BTN = Target.the("botón agregar al carrito")
            .locatedBy("(//button[contains(@onclick, 'cart.add')])[1]");

    // El botón negro de la esquina superior derecha que muestra el total
    public static final Target CART_TOTAL = Target.the("total del carrito")
            .located(By.id("cart-total"));

    // Botón negro del carrito para abrir el mini-menú
    public static final Target CART_BUTTON = Target.the("botón negro del carrito")
            .located(By.id("cart-total"));

    // Enlace "View Cart" dentro del mini-menú del carrito
    public static final Target VIEW_CART_LINK = Target.the("enlace ver carrito")
            .locatedBy("//strong[contains(text(),'View Cart')]");

    // Selector dinámico para verificar que el nombre del producto esté en la tabla del carrito
    public static final Target PRODUCT_IN_TABLE = Target.the("producto en la tabla")
            .locatedBy("//div[@class='table-responsive']//a[text()='{0}']");
}