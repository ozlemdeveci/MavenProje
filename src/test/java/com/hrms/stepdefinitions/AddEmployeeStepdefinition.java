package com.hrms.stepdefinitions;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtils;
import com.hrms.utils.GlobalVariables;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AddEmployeeStepdefinition extends CommonMethods {
    @When("click on PIM")
    public void click_on_PIM() {
        dashboardPage.clickOnPIM();
    }

    @When("click on add employee button")
    public void click_on_add_employee_button() {
        dashboardPage.clickOnAddEmloyeeBtn();
    }

    @Then("enter firstname and lastname")
    public void enter_firstname_and_lastname() {
        addEmployeePage.enterFirstAndLastName("ali","veli");
    }

    @Then("click on save button")
    public void click_on_save_button() {
        addEmployeePage.clickOnSaveBtn();
    }
    @Then("verify employee is added succesfully")
    public void verify_employee_is_added_succesfully() {
        String actualProfilename=personalDetailsPage.getUserProfileName();
        Assert.assertEquals("Verify profile name","Ali pot",actualProfilename);

    }
    @Then("enter firstname and lastname and middle name")
    public void enter_firstname_and_lastname_and_middle_name() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("click on login details checkbox")
    public void click_on_login_details_checkbox() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("enter login details")
    public void enter_login_details() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("enter first name {string} and lastname {string} and middle name {string}")
    public void enter_first_name_and_lastname_and_middle_name(String firstname, String lastname, String middlename) {
        addEmployeePage.enterFirstAndLastName(firstname,middlename,lastname);
    }

    @Then("verify that {string} is added successfuly")
    public void verify_that_is_added_successfuly(String fullname) {
        String actualnameProfile=personalDetailsPage.getUserProfileName();
        Assert.assertEquals("Verify profile name",actualnameProfile,fullname);
    }
    @When("enter {string}, {string} and {string}")
    public void enter_and(String firstName, String middlename, String lastname) {
        addEmployeePage.enterFirstAndLastName(firstName,middlename,lastname);
    }

    @Then("verify {string}, {string} and {string} is added succesfully")
    public void verify_and_is_added_succesfully(String firstName, String middlename, String lastname) {
        String fullname=firstName+" "+middlename+" "+lastname;
        String actualnameProfile=personalDetailsPage.getUserProfileName();
        Assert.assertEquals("Verify profile name",actualnameProfile,fullname);
    }

    @When("add multiple employee and verify they are added successfully")
    public void addMultipleEmployeeAndVerifyTheyAreAddedSuccessfully(DataTable employees) {
        List<Map<String,String>> employeeNames=employees.asMaps();
        for(Map<String,String> empName:employeeNames){
           String firstname= empName.get("FirstName");
           String middleName=empName.get("MiddleName");
           String lastname=empName.get("LastName");
           String emloyeeId=empName.get("EmployeeID");

           addEmployeePage.enterFirstAndLastName(firstname,middleName,lastname);
           addEmployeePage.enterEmployeeId(emloyeeId);
            addEmployeePage.clickOnSaveBtn();

            String expectedFullname=personalDetailsPage.getUserProfileName();
            String fullname=firstname+" "+middleName+" "+lastname;
            Assert.assertEquals("Verifying profile name"+expectedFullname,fullname);
            dashboardPage.clickOnAddEmloyeeBtn();
        }

    }
    @When("add multiple employees from excel\"AddEmployee\" sheet and verify they are added")
    public void add_multiple_employees_from_excel_AddEmployee_sheet_and_verify_they_are_added(String sheetName) {
       List<Map<String ,String>> excelDate= ExcelUtils.excelIntoListMap(Constants.TESTDATA_FILEPATH,sheetName);

    }
    @And("capture employeeId")
    public void captureEmployeeId() {
        GlobalVariables.emp_id=addEmployeePage.empIDTextbox.getAttribute("value");
    }

    @And("verify data from database and ui")
    public void verifyDataFromDatabaseAndUi() {

    }
}
