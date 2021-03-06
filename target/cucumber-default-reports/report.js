$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/login.feature");
formatter.feature({
  "name": "Login Functionality",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@featureLeveltag"
    }
  ]
});
formatter.scenario({
  "name": "Login with Invalid credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@featureLeveltag"
    },
    {
      "name": "@smoke"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "enter invalid credentials",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepdefinitions.LoginStepDefinition.enter_invalid_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on login button",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.stepdefinitions.LoginStepDefinition.click_on_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify error msj",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepdefinitions.LoginStepDefinition.verify_error_msj()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png", "Login with Invalid credentials");
formatter.after({
  "status": "passed"
});
});