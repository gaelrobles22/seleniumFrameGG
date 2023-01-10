Feature: Login con usuario y contrasena
  Descripcion opcional de la funcion
  @test
  Scenario: Cliente se loggea en la pagina principal ingresando su contrasena correcta.
    Given El cliente se encuentra en la pantalla de loggeo
    Then Cargo la informacion del DOM tienda_registro.json
    And Hago un click en el elemento Email
    And Configuro el elemento Email con el texto gaelrobles22@gmail.com

  @test
  Scenario: Cliente se loggea en la pagina principal ingresando su contrasena correcta
    Given El cliente ingresa al sitio http://automationpractice.com/index.php

