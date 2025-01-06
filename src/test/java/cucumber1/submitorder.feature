#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Title of your feature
  I want to use this template for my feature file
	
	Background:
	Given I landed on Ecommerce Website
	
  @tag2
  Scenario Outline: Submit Order
    Given I logged in to the website with email <email> and password <password>
    When I added product <productName> to cart 
    And I proceeded to the checkout with product <productName> and submitted the order
    Then I verify the order id in the order confirmation page 
    Examples: 
      | email                | password     |   productName      |
      | adarshp@mail.com     | Password@123 |ADIDAS ORIGINAL     |
   
