package com.hrms.stepdefinitions;

import com.hrms.utils.CommonMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class PIMConfigurationStepDefination extends CommonMethods {

    @When("click on configuration dropdown")
    public void click_on_configuration_dropdown() {
       pimConfigurationPage.clickOnConfigDropDown();
    }

    @When("click optional fields")
    public void click_optional_fields() {
      pimConfigurationPage.clickOnOptionalFields();
    }

    @Then("click on edit button")
    public void click_on_edit_button() {
        pimConfigurationPage.clickOnEditBtn();
    }

    @Then("uncheck unnecesary checkboxes")
    public void uncheck_unnecesary_checkboxes(DataTable checkBoxOptions) {
        List<String> expectedCheckBoxOptions=checkBoxOptions.asList();
        for(int i=0; i<expectedCheckBoxOptions.size(); i++){
            clickRadioOrCheckBoxByText(pimConfigurationPage.checkBoxes,expectedCheckBoxOptions.get(i));
        }
    }

}
