package com.hrms.testbase;

import com.hrms.pages.*;

public class PageInitializer extends BaseClass{

    public static LoginPage loginPage;

    public static DashboardPage dashboardPage;

    public static AddEmployeePage addEmployeePage;

    public static PersonalDetailsPage personalDetailsPage;

    public static EmployeeListPage employeeListPage;

    public static PIMConfigurationPage pimConfigurationPage;

    public static void initializePageObjects(){

        loginPage=new LoginPage();
        dashboardPage =new DashboardPage();
        addEmployeePage=new AddEmployeePage();
        personalDetailsPage=new PersonalDetailsPage();
        employeeListPage=new EmployeeListPage();
        pimConfigurationPage=new PIMConfigurationPage();
    }
}
