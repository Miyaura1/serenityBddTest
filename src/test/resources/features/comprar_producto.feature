@ComprarProductos @Comprar @Test
Feature: Comprar un producto

  @ComprarProducto @HappyPath
  Scenario Outline: Comprar un producto de manera exitosa
    Given el usuario inicia sesion con email "<email>" y contrasenia "<contrasenia>"    
    And ingresa a la seccion Jackets de la seccion Men del navbar
    And selecciona el producto "<nombreProducto>"
    And selecciona la talla "<talla>" y color "<color>" con cantidad "<cantidad>" y agrega al carrito
    And se agrega el producto "<nombreProducto>" al carrito de manera exitosa
    And verifica el carrito con los productos agregados
    And procede a comprar
    And se muestra el formulario de compra
    And llena el formulario con los datos "<nombres>", "<apellidos>", "<direccion>", "<ciudad>", "<region>", "<codigoPostal>", "<pais>" y "<telefono>"
    When hace clic en Place Order
    Then se realiza la compra de manera exitosa

    Examples:
      | email               | contrasenia | nombres | apellidos | direccion      | ciudad   | region      | codigoPostal | pais | telefono  | nombreProducto   | talla | color | cantidad | item |
      | admin7788@gmail.com | #987654321M | Miyaura | Tello     | Los Sauces 123 | Trujillo | La Libertad | 13001        | Peru | 987654321 | Lando Gym Jacket | S     | Blue  | 1        | 1    |