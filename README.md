#Automatizacion Web con Serenity BDD, Screenplay Pattern, Java

## Tecnologías usadas

- Java 17
- Maven 3.9.10

## Tareas automatizadas
- Buscar un producto.
- Comprar un producto.
- Editar los datos de usuario.

## Como ejecutar el proyecto

Pagina a automatizar: https://magento.softwaretestingboard.com/

Para limpiar el target ejecutar en la terminal el comando: mvn clean
Para ejecutar desde la terminal: mvn clean verify
Para que se creen los reportes desde la ultima ejecucion: mvn serenity:aggregate
Para ejecutar y hacer reportes: mvn clean verify serenity:aggregate
