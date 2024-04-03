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
@Search
Feature: MakerPlace Search functionality validation

@Smoke
Scenario Outline: Simple Search validation
    Given User is on the "<browser>" MakerPlace Home Page
    When User enters the "<searchTerm>" in the searchBar field
    And User clicks on search button
    Then User should land on Products Search Page and find "<searchTerm>"
Examples:
|	browser	|	searchTerm		|
|	chrome	|	stained glass	|
   
@Regression
Scenario Outline: MultiBrowser Search validation
    Given User is on the "<browser>" MakerPlace Home Page
    When User enters the "<searchTerm>" in the searchBar field
    And User clicks on search button
    Then User should land on Products Search Page and find "<searchTerm>"
Examples:
|	browser	|	searchTerm		|
|	chrome	|	stained glass	|
|	edge		|	stained glass	|
| firefox	|	stained glass	|

