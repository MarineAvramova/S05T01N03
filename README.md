Exercise Rest API connected to another Rest API
Access the page ->https://start.spring.io/, and generate a Spring boot project with the following characteristics:
Dependencies:
Spring Boot DevTools
Spring Web
Using RestTemplate or WebClient, you will need to connect to the API you made in level 2, to call and test all the requests that this API allows.
Note, that in this level 3 task, you have no reference to any database, nor do you need to use JPA, as your repository will access the level 2 API.
You don't need to create a View, is planned as a Rest API,  will need to create all the layers up to the controller like any other application:

- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.controllers

- cat.itacademy.barcelonactiva.surnames.nom.s05.t01.n03.model.domain

- cat.itacademy.barcelonactiva.surnames.name.s05.t01.n03.model.dto

- cat.itacademy.barcelonactiva.surnames.nom.s05.t01.n03.model.services

- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.model.repository

 

The controller class must be able to handle the following requests:

http://localhost:9002/flor/clientFlorsAdd

http://localhost:9002/flor/clientFlorsUpdate

http://localhost:9002/flor/clientFlorsDelete/{id}

http://localhost:9002/flor/clientFlorsGetOne/{id}

http://localhost:9002/flor/clientFlorsAll

 

As you can see, in the application.properties file, you must configure that the port to use is 9002.

To test level 3, you'll need to have the level 2 API running. You won't have any problems, since the level 3 API works with port 9002 and the level 2 API with port 9001.

  important

You should include swagger so that any developer can get a quick idea of the resources available in the API.

*Tutorials and video*:
https://www.bezkoder.com/spring-boot-swagger-3/
https://www.bezkoder.com/swagger-3-annotations/
https://www.bezkoder.com/spring-boot-webflux-rest-api/
https://www.bezkoder.com/spring-boot-controlleradvice-exceptionhandler/
https://docs.spring.io/spring-boot/docs/2.1.13.RELEASE/reference/html/boot-features-webclient.html
https://www.youtube.com/watch?v=eyN9H_EA7tI
Spring-5 WebClient - Logging and Exception Handling | Java Techie - https://www.youtube.com/watch?v=wikyb_DyMYk
 What is Spring Webflux and when to use it? - https://www.youtube.com/watch?v=M3jNn3HMeWg
 Spring Boot DTO Example Tutorial | Data Transfer Object Pattern | Line By Line Coding  - https://www.youtube.com/watch?v=THv-TI1ZNMk&t=1094s
 How to use ResponseEntity in Spring REST API ?  - https://www.youtube.com/watch?v=JmMXQaSYl4Y&t=204s
 Complete Crud Operation With Spring Boot and Mysql  - https://www.youtube.com/watch?v=bWYgGaTl8B4&t=2237s
 Difference between RestClient, RestTemplate, WebClient - https://www.youtube.com/watch?v=ECAhXdFrBaE


