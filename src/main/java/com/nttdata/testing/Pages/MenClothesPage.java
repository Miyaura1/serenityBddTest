package com.nttdata.testing.Pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class MenClothesPage extends PageObject {

        public static Target itmProduct(String productName) {
                return Target.the("El producto elegido: " + productName)
                                .located(By.xpath(
                                                "//li[contains(@class, 'product-item') and .//a[contains(text(), '"
                                                                + productName + "')]]"));
        }

        public static Target optnTalla(String talla) {
                return Target.the("Opcion Talla de ropa" + talla)
                                .located(By.xpath("//div[@option-label='" + talla + "']"));
        }

        public static Target optnColor(String color) {
                return Target.the("Opcion Color de la prenda")
                                .located(By.xpath("//div[@option-label='" + color + "']"));
        }

        public static final Target OPTN_QTY = Target.the("Opcion de cantidad")
                        .located(By.id("qty"));

        public static final Target BTN_AGREGAR_CARRITO = Target.the("Boton Agregar producto al carrito")
                        .located(By.xpath("//button[span[text()='Add to Cart']]"));

        public static final Target BTN_CARRITO = Target.the("Items agregados al carrito")
            .located(By.xpath("//div[@data-block='minicart' and contains(@class, 'minicart-wrapper')]"));

        public static final Target LBL_ADDED_TO_CART = Target.the("Banner con mensaje de producto agregado al carrito")
                        .located(By.cssSelector("div[data-ui-id='message-success'] > div"));

        public static final Target ITM_JACKET = Target.the("Item Jacket")
                        .located(By.xpath(
                                        "//li[contains(@class, 'product-item') and .//a[contains(text(), 'Montana Wind Jacket')]]"));

        public static final Target BTN_CHECKOUT = Target.the("Boton Proceed to Checkout")
                        .located(By.xpath(
                                        "//div[contains(@class, 'block-minicart')]//button[contains(text(), 'Proceed to Checkout')]"));
}