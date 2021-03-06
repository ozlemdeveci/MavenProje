$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/apiWorkflow.feature");
formatter.feature({
  "name": "Syntax HRMS API Workflow",
  "description": "  Description:This feature file tests Syntax HRMS API WrokFlow",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@apiWorkflow"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "a JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.Api.generateTokenSteps.a_JWT_is_generated()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Creating an Employee",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@apiWorkflow"
    },
    {
      "name": "@createJson"
    }
  ]
});
formatter.step({
  "name": "a request is prepared to create an employee",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.Api.apiTestingFinalSteps.a_request_is_prepared_to_create_an_employee()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "a POST call is made to create an Employee",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.Api.apiTestingFinalSteps.a_POST_call_is_made_to_create_an_Employee()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the status code for creating an employee is 201",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.Api.apiTestingFinalSteps.the_status_code_for_creating_an_employee_is(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the employee is created contains key \"Message\" and value \"Entry Created\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.Api.apiTestingFinalSteps.the_employee_is_created_contains_key_and_value(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the employeeID \"Employee[0].employee_id\" is stored in the global variable to be used for other calls",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.Api.apiTestingFinalSteps.the_employeeID_is_stored_in_the_global_variable_to_be_used_for_other_calls(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
});