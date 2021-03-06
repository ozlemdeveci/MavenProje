Feature: DashBoard Tab Functionality
  @dashboardTabs
  Scenario: Dashboards Tab verification
    When enter valid credentials
    And click on login button
    Then verify dashboard is displayed
    Then verify the following tabs on dashboard
          |Admin|PIM|Leave|Time|Recruitment|Performance|Dashboard|Directory|
