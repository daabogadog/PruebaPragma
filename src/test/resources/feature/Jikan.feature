#language: es
Característica: Registro login y compra de arituclos automation pratice

 Antecedentes: 
  Dado Un usuario ingresa a la pagina de Jikan                                       
  |https://jikan.moe/|Chrome |
  #|https://jikan.moe/|Firefox|
  
 @Busqueda
 Esquema del escenario: Busqueda de anime
  Cuando El usuario ingresa el anime a buscar <Anime>
  Y Presiona el boton de buscar
  Y Valida el resultado de la busqueda
  Ejemplos:
  |Anime       |
  |"Naruto"    |
  |"Pokemon"   |
  |"Death note"|

  @ValidarLinks
  Esquema del escenario: Validar Links
   Entonces Valida es status de los link prensentes en la pagina
  Ejemplos:
  ||
  ||