@WeatherCheck
Feature: Validate the Weather Details From Web and API for NDTV Weather Page
@WeatherCheck
  Scenario Outline: Fetching the Weather details from NDTV WeatherPage UI for a city
    Given User Navigate to Application 
	Then Navigate to the Weather page 
	And User search the desired City name "<city>" in the Search box
	And User click on the searched city on Map with City name as "<city>"
	And User Store the WeatherInfo to Properties file

Examples:
|city|
|Pune|
@WeatherCheck
  Scenario Outline: Fetching the Weather details from OpenWeatherMap API for a City
    Given User hit the OpenWeatherMap API "<city>" 
	When User calls weather details API with GET HTTP request 
	And Validate the Status code 
 Examples:
|city|
|Pune|   

 Scenario: Validate Weather information from  NDTV Weather WEb Page and OpenWeatherMap API
    And User Validates the data coming From Web and API
   



