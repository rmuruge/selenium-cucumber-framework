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
Feature: Test adding a items to cart from menu items

  @regression
  Scenario Outline: Add to cart from different dropdown links
    Given The user opens the site
    When The user hover over '<menu>' item
    Then The user clicks '<link>' link
    And The user selects '<index>' item
    And The user click '<button>' button
    And The user for action '<button>' sees '<message>' message

   Examples: 
   	| menu 					| link  				| index  	| button 				|	message								|
   	| HOME & KITCHEN|Curtains      	| 1				| ADD TO CART		|	Product added to cart |
