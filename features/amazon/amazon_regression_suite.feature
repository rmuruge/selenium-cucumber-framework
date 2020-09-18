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

@amazon-full-regression
Feature: Validate URL redirection
  Final Projeoct - Test Class I 

#  @smoke
#  Scenario: Title of your scenario
#    Given I want to write a step with precondition
#    And some other precondition
#    When I complete action
#    And some other action
#    And yet another action
#    Then I validate the outcomes
#    And check more outcomes

#  @amz-test1
	@amz-smoke1-url
  Scenario Outline: Validate URL Redirection
    When User enters incorrect site url  '<badurl>'
#    When I check for the <value> in step
    Then Site redirects to the correct site url '<url>'
    Then User searches a product '<product>'
#    And User closes browser

    Examples: 
      | badurl  						| url 										| product  	|
      | http://amzn.in/ 		| https://www.amazon.in/	| mobile 		|
#      | http://amaazon.in/ 	| https://www.amazon.in/	| mobile    |
	@amz-smoke2-url
  Scenario Outline: Validate URL Redirection
    Given User opens the site url '<url>'
    When User hovers over '<link>'
    And User performs action '<actionon>' on '<page>'
    Then Verify navigation to '<page>' is successful

    Examples: 
      | url  											| link 										| actionon  											|	page				|
      | https://www.amazon.in/ 		| Accounts & Lists				| Click > Create Wishlist					| Your Lists 	|

   
  @amz-smoke3-login
  Scenario Outline: Test Login correct credentials 
    Given User opens the site url '<url>'
    When User hovers over '<link>'
    And User performs action '<actionon>' on '<page>'
    And User enters email '<username>' and clicks on Continue
    And User enters password '<password>' and clicks on 'Login' button
    Then User sees greeting message Hi '<message>' on the top navigation 

    Examples: 
      | url  											| link 										| actionon  			|	page 			| username							| password 	|message		|
      | https://www.amazon.in/ 		| Accounts & Lists				| Click > Sign In | Sign In		|	raj2k_m@yahoo.com 		| dummy			|Rajkumar		|


  @amz-smoke4-login
  Scenario Outline: Test Login incorrect credentials 
    Given User opens the site url '<url>'
    When User hovers over '<link>'
    And User performs action '<actionon>' on '<page>'
    And User enters email '<username>' and clicks on Continue
    And User enters bad password '<password>' and clicks on 'Login' button
    Then User sees error message '<message>'

    Examples: 
      | url  											| link 										| actionon  				|	page 		| username							| password 			|message		|
      | https://www.amazon.in/ 		| Accounts & Lists				| Click > Sign In | Sign In		|	mailforme@yahoo.com 		| fakepassword	|Your password is incorrect		|
 
 
  @amz-smoke5-mobile-search
  Scenario Outline: Search Mobile
    Given User opens the site url '<url>'
    And User performs search action '<product>'
    Then Application lists results for the searched '<product>' and validates

    Examples: 
      | url  											| product 						|
      | https://www.amazon.in/ 		| iphone 11 64GB			| 
 
 
  @amz-smoke6-mobile-tocart
  Scenario Outline: Search Mobile and Add to Cart
    Given User opens the site url '<url>'
    And User performs search action '<product>'
    And Application lists results for the searched '<product>' and validates
    Then User selects a <searchindex> product from the search results
    Then User changes delivery location <pincode> and validates
    Then User clicks on add to cart button and validates

    


    Examples: 
      | url  											| product 						| searchindex 	|	pincode 		|
      | https://www.amazon.in/ 		| iphone 11 64GB			| 1						| 600088			|
 

 @amz-smoke6-video-and-ratings
  Scenario Outline: Search Mobile, play videos and check review
    Given User opens the site url '<url>'
    And User performs search action '<product>'
    And Application lists results for the searched '<product>' and validates
    Then User selects a <searchindex> product from the search results
    Then User plays the video demo and closes the popup
		Then User hovers over user reviews and selects <rating>

    Examples: 
      | url  											| product 						| searchindex 	|	rating 		|
      | https://www.amazon.in/ 		| iphone 11 64GB			| 1						| "5 star"		|
 