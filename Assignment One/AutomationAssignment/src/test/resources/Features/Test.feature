Feature: As a user
         Should be able to search
         On Google search
         
 Scenario: Check that user is able to navigate to SeleniumHq using Google search
 
 Given I want to go to the 'www.seleniumhq.org' Page
 When I go to "https://www.google.com/"
 And I type "Seleniumhq" in the searchbox
 And I press ENTER in the searchbox
 And I click on Selenium link
 Then I am on Selenium HQ Page