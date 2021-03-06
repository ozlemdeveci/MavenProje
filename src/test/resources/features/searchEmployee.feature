@searchEmployee
  Feature: Search and Employee

    Background:
      When enter valid credentials
      And click on login button
      And click on PIM
      And click on employee list button

    @regression
    Scenario: search employee job tittles
      When search for job titles
      Then all job title from database