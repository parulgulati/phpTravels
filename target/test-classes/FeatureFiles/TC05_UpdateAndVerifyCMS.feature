@CMSUpdate
Feature: Login to Admin Profile ,make changes in CMS Pages and verify on website.

Scenario Outline: Login As Admin , make changes on CMS Page
Given User Navigate to Application "<reqUrl>"
	Then Enter Credentials and Login "<username>" "<password>"
	Then Navigate to CMS Pages
	Then Edit Contact CMS Information "<contactTitle>"
	And Add SEO information "<keywords>" "<description>"
	Then Save the CMS
	 
Examples:
|reqUrl|username|password|contactTitle|keywords|description|
|cmsUrl|cmsUsername|cmsPassword|Contact Us-PHPTravels2|php travels hotels flights boats|We have everything for vacation at one stop| 
@CMSUpdate
Scenario Outline: Verify the CMS changes from User Profile
Given User Navigate to Application "<reqUrl>"
	Then User should Login Successfully
	Then Verify CMS Updates "<pagetitle>" 
	
Examples:
|reqUrl|pagetitle|
|userUrl|Contact Us-PHPTravels2|
