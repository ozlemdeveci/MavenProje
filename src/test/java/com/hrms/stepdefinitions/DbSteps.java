package com.hrms.stepdefinitions;

import com.hrms.utils.DbUtils;
import com.hrms.utils.GlobalVariables;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class DbSteps {

    @Then("collect employee data from hrms database")
    public void collectEmployeeDataFromHrmsDatabase() {
        String query="select emp_firstname, emp_middle_name,emp_lastname "+
                "from hs_hr_employees where employee_id="+ GlobalVariables.emp_id;

        GlobalVariables.dbList=DbUtils.getDbDataIntoList(query);
    }

}
