@CustomerLogin
Feature: Login to Customer Profile , Update the Profile and Verify changes.

Scenario Outline: Customer to login in application and update the profile
Given User Navigate to Application "<reqUrl>"
	Then User should Login Successfully
	And User verify Name "<username>" after Login
	Then Navigate to My Profile Section
	Then User update the City name "<city>" and phone "<phone>"
	Then User Verify the changes are saved succesfully "<city>" "<phone>"
	
Examples:
|reqUrl|username|city|phone|
|userUrl|Demo User|Victoria|988899|

Scenario Outline: Check if the user is able to access the section that they are not allowed in.
Given User Navigate to supplier site
	Then Enter Credentials and Login "<username>" "<password>"
	And User verify error Message
Examples:
|username|password|
|username|password|