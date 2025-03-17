# viveLibre-app

- Las clases y la API han sido documentadas y generadas con swagger
- El proyecto sigue una estructura principal: - api: donde se encuentra la interfaz de la API implementada por la clase Controller
                                              - client: Donde se encontraría el restTemplate y el método para obtener el token
                                              - configuration: donde se encuentra la clase SecurityConfig para configuraciones de Spring Security
                                              - model: con las clases de Book y Author, estas clases llevan los getters and setters establecidos pero también tienen la anotación @Data de lombok, valen las dos, no he pulido esto por falta de tiempo.
                                              - service: con la interfaz que recoge los métodos de la capa de negocio y su clase de implementación.
                                              - test: No los he pulido más por falta de tiempo, pero testean las funcionalidades de la clase BookServiceImpl
                                              - Dockerfile: La aplicación ha sido envuelta en un contenedor de Docker y subida a DockerHub.
                                              - En el pom se encuentran las dependencias utilizadas y plugins como el de OpenApi
                                              
