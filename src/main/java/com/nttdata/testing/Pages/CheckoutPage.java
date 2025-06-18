package com.nttdata.testing.Pages;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.core.annotations.findby.By;

public class CheckoutPage {
    public static final Target LBL_CHECKOUT_FORM = Target.the("etiqueta de Shipping Address en el formulario de compra")
            .located(By.xpath("//div[@class='step-title' and contains(text(), 'Shipping Address')]"));

    public static final Target TXT_FIRST_NAME = Target.the("Campo de texto primer nombre")
            .located(By.xpath("//input[@name='firstname']"));

    public static final Target TXT_LAST_NAME = Target.the("Campo de texto segundo nombre")
            .located(By.xpath("//input[@name='lastname']"));

    public static final Target TXT_ADDRESS = Target.the("Campo de texto direccion")
            .located(By.xpath("//input[@name='street[0]']"));

    public static final Target TXT_CITY = Target.the("Campo de texto ciudad")
            .located(By.xpath("//input[@name='city']"));

    public static final Target SLCT_REGION = Target.the("Campo selector de region")
            .located(By.xpath("//select[@name='region_id']"));

    public static final Target TXT_REGION = Target.the("Campo de texto de region")
            .located(By.xpath("//input[@name='region']"));

    public static final Target TXT_POSTAL_CODE = Target.the("Campo de texto codigo postal")
            .located(By.xpath("//input[@name='postcode']"));

    public static final Target SLCT_COUNTRY = Target.the("Campos selector de pais")
            .located(By.xpath("//select[@name='country_id']"));

    public static final Target TXT_PHONE = Target.the("Campo de texto telefono")
            .located(By.xpath("//input[@name='telephone']"));

    public static final Target RD_SHIPPING_METHOD = Target.the("Campos selector de metodo de envio")
            .located(By.xpath(
                    "//table[contains(@class, 'table-checkout-shipping-method')]//td[contains(text(), 'Fixed')]"));

    public static final Target BTN_CONTINUE = Target.the("Boton continuar compra")
            .located(By.xpath("//button[@data-role='opc-continue']"));

    public static final Target CHK_ADDRESS = Target.the("Casilla de verificaion de direccion")
            .located(By.xpath(
                    "//input[@name='billing-address-same-as-shipping']"));

    public static final Target BTN_PLACE_ORDER = Target.the("Boton Place Order")
            .located(By.xpath("//button[.//span[contains(text(), 'Place Order')]]"));

    public static final Target LBL_SUCCESS_PURCHASE = Target.the("mensaje de compra exitosa")
            .located(By.xpath("//h1[@class='page-title']//span[contains(text(), 'Thank you for your purchase')]"));

}
