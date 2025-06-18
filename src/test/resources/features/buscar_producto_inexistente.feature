@BuscarProductos @Buscar @Test
Feature: Buscar producto inexistente

  @BuscarProducto @Happypath
  Scenario Outline: Buscar un producto inexistente y validar que no existe
    Given el usuario esta logueado con email "<email>" y contrasenia "<contrasenia>", y en la pagina de inicio
    And ingresa el producto "<producto>" en la barra de busqueda
    When hace clic en el icono de buscar
    Then se muestra el mensaje de busqueda sin resultados

    Examples:
      | email               | contrasenia | producto |
      | admin7788@gmail.com | #987654321M | polera   |
