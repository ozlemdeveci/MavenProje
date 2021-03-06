Feature: Configure PIM - Optional Fields
  @PIM
  Scenario: unchecking unnecessary checkboxes
    When enter valid credentials
    And click on login button
    Then verify dashboard is displayed
    When click on PIM
    When click on configuration dropdown
    And click optional fields
    Then click on edit button
    And uncheck unnecesary checkboxes
    |Show  SSN field in Personal Details|
    |Show  SIN field in Personal Details|