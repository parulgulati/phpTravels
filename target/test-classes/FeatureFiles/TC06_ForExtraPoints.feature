@ExtraPoints
Feature: Login to User Profile , Verify Language Translate is working fine.

#Positive Scenario
Scenario Outline: Verify if the Spanish Language Translate is Correct for My Account
Given User Navigate to Application "<reqUrl>"
	Then User should Login Successfully
	Then Switch Language "<language>"
	And Verify Language Translate "<uname>" "<booking>" "<myprofile>"
	Then Switch Language "<defaultlanguage>"
	
	
Examples:
|reqUrl|booking|myprofile|language|uname|defaultlanguage|
|userUrl|Reservas|Mi perfil|Spanish|Hola Demo User|English|

#Negative Scenario - German is not getting updated on website
Scenario Outline: Verify if the German Language Translate is Correct for My Account

	When Switch Language "<language>"
	And Verify Language Translate "<uname>" "<booking>" "<myprofile>"
	Then Switch Language "<defaultlanguage>"
	Then Close Browser
Examples:
|reqUrl|booking|myprofile|language|uname|defaultlanguage|
|userUrl|Buchungen|Mein Profil|German|Hallo Demo User|English|