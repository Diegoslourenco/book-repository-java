# Book Repository

Application built to organize a book repository in order to practice and apply the concepts of a CRUD using Spring Boot and the MVC architectural pattern.

## Dependencies: 

- [Spring Boot 2.4.5](https://spring.io/projects/spring-boot)
- [Thymeleaf 3.0.11](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#expression-utility-objects)
- MySQL
- [Bootstrap 3.3.7](https://blog.getbootstrap.com/2016/07/25/bootstrap-3-3-7-released/)
- [bootstrap-datepicker](https://github.com/uxsolutions/bootstrap-datepicker)
- [jQuery 3.6.0](https://jquery.com/download/)
- jQuery [maskMoney](https://github.com/plentz/jquery-maskmoney)
- jQuery [sortElements](https://github.com/padolsey-archive/jquery.fn/tree/master/sortElements)

## Application Architecture

```
 ┌───────┐        ┌──────────┐      ┌──────────┐
 │   ☁️     <──>      ☕      <──>      💾    │
 │  Web  │  HTTP  │  Spring  │      │ Database │
 └───────┘        │  Service │      └──────────┘
                  └──────────┘
```

## Internal Architecture
The internal architecture:

  * `Controller` classes provide REST endpoints and deal with HTTP requests and responses from/to the view
  * `Service` 	classes contains the business rules, receive the request from a controller and talk to repository to acess data to return a response to controller
  * `Repository` classes interface with the DAO internally that interface with the database and take care of writing and reading data to/from persistent storage



```
                      ┌───────────────────── Spring Service ──────────────────────┐
                      │                                                           │
             Request  │                                                           │
 ┌────────┐   ─────────> ┌────────────┐       ┌─────────┐       ┌────────────┐    │   ┌──────────┐
 │  View  │  <────────── │ Controller │ <───> │ Service │ <───> │ Repository │ <────> │ Database │
 └────────┘  Response │  └────────────┘       └─────────┘       └────────────┘    │   └──────────┘
                      │                                                           │
                      └───────────────────────────────────────────────────────────┘
  ```  
