Feature: Login MacroSitio
  As a user of the Macrositio
  I want to login in the Macrositio
  to see the Home Menu correctly

  Scenario: Successful login
    Given User open Home page
    When The user enters credentials
    Then User verify access
    And The user close MacroSitio

