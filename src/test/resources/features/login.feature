@featureLeveltag
Feature: Login Functionality
  @testRunner
  Scenario: Login with valid credentials
#we commend navigate and quit browser after create hooks class
#    Given navigate to HRMS login page
    When enter valid credentials
    And click on login button
    Then verify dashboard is displayed
#    And quit the browser

  @smoke @regression
  Scenario: Login with Invalid credentials
#    Given navigate to HRMS login page
    When enter invalid credentials
    And click on login button
    Then verify error msj
#    And quit the browser

#  FOR ppl who missed the HW:
#  HW:come up with login scenarios with:
#  1.Empty user name , verify the error message
#  2.Empty user password , verify the error message

  Scenario: empty username and password
#    Given navigate to HRMS login page
    When enter username
    And click on login button
    Then see the empty username error msj
    And enter password
    And click on login button
    Then see the empty password error msj




