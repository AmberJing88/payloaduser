# payloaduser
This project is a REST API for payload register, exposed username, password and ip-address. The api validate the password and ip-address with spcific restrainctions.
This project is built in java mavon with spring boot framework. 

## Project Description:
The project includes src and dependecies. In src section, the codes are in main and test sections. 
## In main:
 1.	$UserPayload.java$: This class represents the payload that your API will accept. It contains fields for the username, password, and IP address. Annotations such as @NotNull, @Size, and @Pattern are used for validation.
 2.	$UserController.java$: This class is your API controller. It handles incoming HTTP requests, validates the payload using the UserPayload class, interacts with the IP-API.com Geolocation API, and generates a response containing a UUID and a welcome message.
 3.	$GeolocationService.java$: (Optional) This service class abstracts the interaction with the IP-API.com Geolocation API. It's responsible for making the API request and processing the response.
 4.	$SwaggerConfig.java$: This configuration class sets up Swagger (OpenAPI) documentation for your API. It uses the Springfox library to generate API documentation that can be accessed through the Swagger UI.
 5.	$PayloadUserApplication.java$: This is the main class of your Spring Boot application. It contains the main method to start your application. It also serves as the entry point for Spring Boot's auto-configuration.
## In test:
1. $UserControllerTest.java$: This JUnit test class tests the UserController class. It simulates requests to the API endpoints and verifies the responses, making sure that your API behaves as expected.
2. $UserPayloadTest.java$: This JUnit test class tests the UserPayload class by validating the payload's properties against defined constraints.
3. $PayloadUserApplicationTests.java$: This JUnit test class tests the main application class by checking whether the Spring context loads successfully. It ensures that the application's basic configuration is correct.

## Dependency
All dependencies are listed in file $pom.xml$.


