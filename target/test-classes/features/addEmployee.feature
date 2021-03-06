Feature: Add Employee Functionality

  Background:
    When enter valid credentials
    And click on login button
    Then verify dashboard is displayed
    When click on PIM
    And click on add employee button

  @addEmloyeeWithoutLogin
  Scenario: Add emloyee without login details
    Then enter firstname and lastname
    And click on save button
    Then verify employee is added succesfully

  @addEmployeeWithLogin
  Scenario: Add employee with login credentials and middle name
    Then enter firstname and lastname and middle name
    And click on login details checkbox
    Then enter login details
    And click on save button
    Then verify employee is added succesfully

  @parameter
  Scenario: add employee without login details but with middle name
    Then enter first name "Marta" and lastname "Mary" and middle name "Ostash"
    And click on save button
    Then verify that "Marta Mary Ostash" is added successfuly

    @exampleOutline
  Scenario Outline: Adding multiple employees without login details
    When enter "<Firstname>", "<MiddleName>" and "<lastname>"
    And click on save button
    Then verify "<Firstname>", "<MiddleName>" and "<lastname>" is added succesfully

    Examples:
      | Firstname | MiddleName | lastname |
      | oz        | kozi       | sozi     |
      | Smith     | John       | mike     |

      @dtWithHeader
  Scenario: adding multiple employees at one execution
    When add multiple employee and verify they are added successfully
      | FirstName | MiddleName | LastName |EmployeeID|
      | oz        | kozi       | sozi     |111000    |
      | Smith     | John       | mike     |111002    |

    @excelTask
  Scenario: Adding multiple employees from excel
    When add multiple employees from excel"AddEmployee" sheet and verify they are added

  @db @regression
  Scenario: Adding Employee and database validation
    And enter first name "Sean" and lastname "Married" and middle name "Oliva"
    And capture employeeId
    And click on save button
    Then collect employee data from hrms database
    And verify data from database and ui