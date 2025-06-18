@Editar @Test
Feature: Editar datos del perfil de usuario

  @EditarDatosDeUsuario @HappyPath
  Scenario Outline: Editar nombres o apellidos del usuario
    Given el usuario esta logueado con email "<email>" y contrasenia "<contrasenia>"
    And se dirige a la pagina de configuracion de perfil
    And edita los campos nombres o apellidos con "<nombreNuevo>" y "<apellidoNuevo>"
    When hace clic en guardar configuraciones
    Then se muestra el mensaje de edicion exitosa

    Examples: 
      | email               | contrasenia | nombreNuevo     | apellidoNuevo |
      | admin7788@gmail.com | #987654321M | Miyaura Editado | Tello Editado | 
