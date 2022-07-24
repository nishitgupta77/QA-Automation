
##### Selenium Web Automation #####

- On a browser
- Given I want to go to the 'www.seleniumhq.org' Page
- When I go to 'www.google.com'
	- and I type 'Seleniumhq' in the searchbox
	- and I press 'ENTER' in the searchbox
	- and I click on 'Selenium HQ' link
- Then I´m on Selenium HQ Page

Outline of automating proposed scenarios on different levels of testing pyramid.

The testing pyramid is a concept that group software into three categories. This helps QA professionals to ensure quality, reduce the time it takes to find root cause of bug, and build more reliable suite.

From top to bottom, the main layer include:

UI/Exploratory tests
Integration tests
Unit tests
UI/ Exploratory tests generally lie at the top layer of the pyramid which are generally are more complex and have more dependencies than unit and integrations tests. Our automation suite has been implemented based on the top layer of the pyramid. Following are the pros and cons list:

Pros:

Tests from user perspective.
Verifies end to end workflow of the application.
Reduces number of errors found in production.
Cons:

Slow execution time as it performs end to end test on workflows.
Test flakiness as it requires maintenance and trouble shooting if change in workflows.
Technical Document:

Tech Stack, Libraries and Dependencies used:
Java JDK 15.0.2
Selenium Webdriver
Cucucmber 
Junit 
TestNg
Maven

Project Specification:

Selenium Webdriver has been used for automating the Steps proposed for the assignment which is an open source tool with multi browser support for automating browser based application.

Page Object Model design pattern approach has been used for storing objects and maintaining test in separate folder. It is useful in reducing code duplication and improves test case maintenance.

Cucumber has been used to implement testcases that supports behaviour driven development approach easily uderstandable by the stakeholders.

Folder structure:

src/test/java/pages: contains all the class files for page that includes all the page objects and methods specific for that page.
src/test/java/stepDefinition: contains TestRunner and TestStep that contains actual methods to implement tests
src/test/resources/Feature: contains test.Feature written in gherkin.
AutomationAssignment/Pom.xml: contains the maven dependencies.

To run the tests
Clone the project from the repository shared.
Download the maven dependencies.
Right click on the file src/test/java/stepDefinition/TestRunner.java to run as Junit.
