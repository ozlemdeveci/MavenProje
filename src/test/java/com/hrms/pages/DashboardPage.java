package com.hrms.pages;

import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static com.hrms.utils.CommonMethods.jsClick;

public class DashboardPage{
    @FindBy(id = "welcome")
    public WebElement welcomeMessage;
    @FindBy(linkText = "PIM")
    public WebElement PIMButton;
    @FindBy(id = "menu_pim_addEmployee")
    public WebElement addEmployeeBtn;
    @FindBy (id = "menu_pim_viewEmployeeList")
    public WebElement employeeList;

    @FindBy(xpath = "//div[@class='menu']/ul/li")
    public List<WebElement> dashTabs;

    public List<String>getDashTabs(){
        List<String> dashTabsText=new ArrayList<>();
        for(WebElement dashTab:dashTabs){
            dashTabsText.add(dashTab.getText());
        }
        return dashTabsText;
    }

    public void clickOnPIM(){
        jsClick(PIMButton);
    }
    public void clickOnAddEmloyeeBtn(){
        jsClick(addEmployeeBtn);
    }
    public DashboardPage() {
        PageFactory.initElements(CommonMethods.driver, this);
    }
}
