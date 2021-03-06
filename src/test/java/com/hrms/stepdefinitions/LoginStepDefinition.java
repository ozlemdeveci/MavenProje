package com.hrms.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.hrms.testbase.BaseClass.*;
import static com.hrms.testbase.PageInitializer.dashboardPage;
import static com.hrms.testbase.PageInitializer.loginPage;

public class LoginStepDefinition {
    @Given("navigate to HRMS login page")
    public void navigate_to_hrms_login_page() {
        setUp();
    }

    @When("enter valid credentials")
    public void enter_valid_credentials() {
        loginPage.login("Admin","Hum@nhrm123");
    }

    @When("click on login button")
    public void click_on_login_button() {
        loginPage.clickLoginBtn();
    }

    @Then("verify dashboard is displayed")
    public void verify_dashboard_is_displayed() {
        Assert.assertTrue(dashboardPage.welcomeMessage.isDisplayed());
    }
    @Then("quit the browser")
    public void quit_the_browser() {
        tearDown();
    }
    @When("enter invalid credentials")
    public void enter_invalid_credentials() {
        loginPage.login("Admin","yanlispass");
    }

    @Then("verify error msj")
    public void verify_error_msj() {
        Assert.assertEquals("Verifying error msj","Invalid credentials",loginPage.getErrorMessageText());
    }
    @When("enter username")
    public void enter_username() {
        loginPage.login("","");
    }

    @Then("see the empty username error msj")
    public void see_the_empty_username_error_msj() {
     Assert.assertEquals("verify empty username","Username cannot be empty",loginPage.getErrorMessageText());
    }

    @Then("enter password")
    public void enter_password(){
      loginPage.login("admin","");
    }

    @Then("see the empty password error msj")
    public void see_the_empty_password_error_msj() {
      Assert.assertEquals("empty password box","Password cannot be empty",loginPage.getErrorMessageText());
    }

}
