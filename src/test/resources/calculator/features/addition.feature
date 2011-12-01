Feature: Addition
  As a math idiot
  I want to be told the sum of two numbers
  In order to avoid silly mistakes

  Scenario: Add two numbers
    Given I have entered 2 into the calculator
    And I have entered 5 into the calculator
    When I press Add
    Then the result should be 7 on the screen