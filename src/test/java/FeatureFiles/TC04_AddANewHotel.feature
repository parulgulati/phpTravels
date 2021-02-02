@AddANewHotel
Feature: Login to Admin Profile , Add a New Hotel to the website with correct filters

Scenario Outline: Login As Admin User , Add a new Hotel
Given User Navigate to Application "<reqUrl>"
	Then Enter Credentials and Login "<username>" "<password>"
	And User verify Profile after Login
	Then Open Hotels Section
	Then Add a new hotel with all the details "<hotelname>" "<hoteldesc>" "<place>"
	Then Add facilities to hotel "<facilitiesToOmit1>" "<facilitiesToOmit2>"
	Then Add Contact for hotel "<hotelemail>" "<hotelwebsite>" "<hotelphone>"
	Then Add Translate Languages for hotel Info "<language1>" "<language2>" "<hotelname>" "<metatitle>"
	Then Save the Hotel Details

Examples:
|reqUrl|username|password|hotelname|hoteldesc|place|facilitiesToOmit1|facilitiesToOmit2|hotelemail|hotelwebsite|hotelphone|language1|language2|metatitile|
|cmsUrl|cmsUsername|cmsPassword|Monks palace|It is an absolute dream|Hilversum|Laundry Service|Bar Lounge|help@monkpalace.com|www.monkpalace.com|99999|Turkish|Farsi|MonkPalaceHilversum|

Scenario Outline: Login As Demo User , verify newly added Hotel 
Given User Navigate to Application "<reqUrl>"
	Then User should Login Successfully
	Then Navigate to Home
	Then Search for Hotel "<place>" "<checkin>" "<checkout>"
	Then Verify Omitted Facilities "<facilitiesOmit1>" "<facilitiesOmit2>"
	Then Switch Language "<language>"
	Then Verify Language Translation "<name>" 
	Then Switch Language "<defaultlanguage>"
	
Examples:
|reqUrl|place|checkin|checkout|facilitiesOmit1|facilitiesOmit2|language|name|defaultlanguage|
|userUrl|Monks palace|20/02/2021|24/02/2021|Laundry Service|Bar Lounge|Turkish|Ev|English|
	