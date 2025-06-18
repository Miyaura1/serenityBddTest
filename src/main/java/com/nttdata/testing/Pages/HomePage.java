package com.nttdata.testing.Pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://magento.softwaretestingboard.com/")
public class HomePage extends PageObject {

        // SIGN UP
        public static final Target BTN_SIGN_UP = Target.the("Boton para hacer el registro")
                        .located(By.xpath("//a[text()='Create an Account']"));

        public static final Target BTN_SIGN_IN = Target.the("Boton para hacer el inicio se sesion")
                        .located(By.xpath("//a[normalize-space(text())='Sign In']"));

        // NAVIGATION BAR
        public static final Target MENU_MEN = Target.the("Menú principal 'Men'")
                        .located(By.xpath("//nav//a[normalize-space()='Men']"));

        public static final Target ITM_TOPS = Target.the("Submenú 'Tops'")
                        .located(By.id("ui-id-17"));

        // ITEMS LIST
        public static final Target ITM_JACKETS = Target.the("Enlace 'Jackets'")
                        .located(By.id("ui-id-19"));

        // SEARCH BAR
        public static final Target INPT_SEARCH_BAR = Target.the("Barra de busqueda")
                        .located(By.id("search"));

        public static final Target BTN_SEARCH = Target.the("Boton de busqueda")
                        .located(By.xpath("//button[contains(@class, 'search') and span[text()='Search']]"));

        // NO SEARCH RESULTS MESSAGE
        public static final Target LBL_NO_SEARCH_RESULTS = Target.the("Mensaje de busqueda sin resultados")
                        .located(By.xpath("//div[contains(@class, 'message') and contains(@class, 'notice')]/div"));

}
