package com.nttdata.testing.Pages;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;

public class EditAccountInformationPage extends PageObject {

  public static final Target TXT_FIRST_NAME = Target.the("Campo de texto para editar el nombre")
      .located(By.id("firstname"));

  public static final Target TXT_LAST_NAME = Target.the("Campo de texto para editar el apellido")
      .located(By.id("lastname"));

  public static final Target BTN_SAVE_CHANGES = Target.the("Boton para guardar los cambios")
      .located(By.xpath("//button[@title='Save']"));

  public static final Target LBL_SUCCESS_EDITION = Target.the("Mensaje de edicion exitosa")
      .located(By.cssSelector("div[data-ui-id='message-success'] > div"));
}
