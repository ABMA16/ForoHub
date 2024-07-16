# Challenge Literalura
This is a java challenge proposed to the back-end formation students in the Oracle Next Education (ONE) program.
This consist in the creation of a community forum where a pre-registered user can create, modify, read and delete comments from an specific topic or in this case course.

## :checkered_flag: Objective
The objective of this project is to create a back end program able to control a web forum hosted in a local server, where a community can add commets of certain topics. The front-end design is currently out of scope but intermediate/advanced functionalities will be added for a fully operative forum.

## :hammer: Functionalities:
`Functionality 1`: Create, modify, read, search and delete a topic. \
`Functionality 2`: Create, modify, read, search and delete a course. \
`Functionality 3`: Create, modify, search and delete an answer.  \
`Functionality 4`: Filter topics marked as resolved or open. \
`Functionality 5`: Filter courses marked as active or inactive. \
`Functionality 6`: User authentication through JWT tokens. \
`Functionality 7`: Documentation using Swagger.

## :computer: Technologies
Java 17 \
IntellJ V21 \
MySQL Workbench 8 \
Insomnia API platform

## :books: Dependencies
Lombok \
Spring Web \
Spring Boot DevTools \
Spring Data JPA \
Flyway Migration \
MySQL Driver \
Validation \
Spring Security \
Java JWT

## :bulb: How to use?
Before usign this program we have to make sure that we already have our credentials added in the database as a registration page has not been implemented yet.
Once we have our credentials, we can choose running our HTTP methods or request from insomnia if we already know the required structure for our request, if not, we recommend to use the Swagger documentation page, this way you would only need to add "/swagger-ui/index.htm" to the server URL you are using to run the program.
Swagger is a powerful tool were are able to see all our HTTP methods declared in our controllers making easier to use a backend app without a front end program ready.
Once the program is running and we have our credentials on hand, we must go to the authentication-controller method to log in (get our JWT token) and add our token to the "Authorize" bar in the right upper corner of our window, this way our token will be used for every request we do.
