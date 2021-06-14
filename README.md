# Radiologics-Coding-Challenge

Repository housing completion of a challenge into the creation of a Spring Boot implementation of a RESTful API. The implementation has a OAuth2 login, a simple HTML front end, the ability to make REST calls (Create, Query, Edit), and an H2 based database backend.

https://spring.io/guides/tutorials/spring-boot-oauth2/ was used to help implement the oauth2 login.


Simply run the code as a spring boot app and then go to localhost:8080 to view the authentication page. Once you log in, you will be able to view the prepopulated data. In addition, making REST calls can be done from within the command line (or services such as postman). Viewing the data can be done by calling localhost:8080/api/subjects, and viewing a single user can be done by calling localhost:8080/api/subject{subject id}. POST and PUT actions can be done through postman or the like in order to add or edit information in the database.
