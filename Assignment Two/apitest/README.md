##### Go Rest API #####

Test cases covered in the API automation suite:

API automation suite is used to perform CRUD operations using different HTTP methods: GET, POST, DELETE.

CREATE USER:
1. Send Post request to add new user.
2. Verify correct HTTP response status code is returned when sending POST request.(201)
3. Verify correct User Id is received when sending POST request.
4. Send GET request with same User Id to verify correct User detail is fetched.

CREATE USER WITH SAME EMAIL:
1. Send Post request to add new user.
2. Verify correct HTTP response status code is returned when sending POST request.
3. Send Post request to add new user with same email.
3. Verify User is not able to create user with same email Id.
4. Verify User is recieved with message "has already been taken".

CREATE USER WITH INVALID EMAIL:
1. Send Post request to add new user with incorrect Email.
2. Verify correct HTTP response status code is returned when sending POST request.(422)
3. Verify User is recieved with message "his invalid".

CREATE POST:
1. Send Post request to add new user.
2. Verify correct User Id is received when sending POST request.
3. Send Post request to add new post.
4. Verify that new post has been added.

CREATE COMMENT:
1. Send Post request to add new user.
2. Verify correct User Id is received when sending POST request.
3. Send Post request to add new post.
4. Verify that new post has been added.
5. Send Post request to add new Comment.
6. Verify that new comment is added.

CREATE TODO:
1. Send Post request to add new user.
2. Verify correct User Id is received when sending POST request.
3. Send Post request to add new Todo.
4. Verify that new todo has been added.

Outline of automating proposed scenarios on different levels of testing pyramid.

API layer of an application is most crucial part of software component. It provides interface between the different modules of the application which helps to test the integration of different components/modules of the application.

API testing lies in the middle layer which is the integration testing after the unit testing is performed for each component of the application.

From top to bottom, the main layer include:

UI/Exploratory tests
Integration tests
Unit tests
Pros:

Finding bugs at the early stages of software development.
Faster execution, API testing is generally fast in execution as compared to UI testing.
Language independence
Does not simulate real users interacting with elements of your webpage.
Cons:

Does not simulate real users interacting with elements of your webpage.
Does not give idea how user friendly the application is.
Technical Document:

Tech Stack, Libraries and Dependencies used:

Java JDK 15.0.2
RestAssured Libraries
GSON, JackSon libraries for POJO classes implementation
TestNG
Maven

Project Specification:

RestAssured has been used for the implementation of automation suite which is an open-source java library for testing RESTful Web API.

Folder structure:

Files: contains payload to Add requests payload used in tests.

Pojo: contains the Plain Old Java Object classes to create request JSON payload and methods to fetch from response JSON payload.

Tests: contains all the tests to perform CRUD operations on the API.

Utils: contains the BaseSpec that includes RequestSpecificationBuilder and RespnseSpecifcationBuilder methods.

testng.xml: to run the test cases.

Pom.xml: contains the maven dependencies.

To run the tests

Clone the project from the repository shared.
Download the maven dependencies.
Run the testng.xml file using TestNg.

