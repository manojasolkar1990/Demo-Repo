#Author: manoj.asolkar@gmail.com
Feature: User Registration in MecuryFlight site

  Background: 
    Given I've a valid set of data and access to Registration Page
	 
	  #DataTable for UserDetails using raw()
  @Registration1
  Scenario: Single User Registration
    When Registration page Displayed
    Then I enter valid data on page
      | FirstName       | Aditya     |	
      | LastName        | Roy        |
      | Phone           | 7501451189 |
      | Email           | a@test.com |
      | UserName        | aditya     |
      | Password        | test123    |
      | ConfirmPassword | test123    |
    Then Click on Submit Button
     And Thank you for registering: should be displayed
    Then Click on Signoff
     And Close the Browser