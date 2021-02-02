@BookAHotel
Feature: Login to Customer Profile , book a hotel and verify the booking is complete.

Scenario Outline: Login As User , search for a desired hotel and confirm the booking
Given User Navigate to Application "<reqUrl>"
	Then User should Login Successfully
	Then Navigate to Home
	Then Search for Hotel with Dates "<place>" "<checkin>" "<checkout>"
	And User Filter out from hotels "<rating>" "<amenities>" "<propType>" "<priceFilter>" 
	Then Select a Hotel and choose a room and confirm booking 
	 
Examples:
|reqUrl|place|checkin|checkout|rating|amenities|propType|priceFilter|
|userUrl|Dubai|20/02/2021|24/02/2021|3|Disabled Facilities|Hotel|Low to High|

Scenario Outline: Verify the confirmed booking
Given Navigate to MyAccount
	Then Verify Hotel Booking "<place>"
	Then Close Browser
	
Examples:
|place|
|Dubai|