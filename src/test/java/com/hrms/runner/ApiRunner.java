package com.hrms.runner;
//@Runwith these coming junit????
//featuress=need to give a path for our feature file
//glue dada mutlaka package isminden baslamk gerek, need to give step definitions
//dryRun=true  this is just finding unimplemented method
//dryRun=false running all step
//tags adding tag for running spesific scenario
//tags={"@smoke","@whatever"} tagg ekleyebiliriz
//strict=true  when set is true , will fail the execution when undefined step is
//"pretty",    //will print executed steps inside console
//html type of report
//target/cucumber-default-reports  report path
//"rerun:target/FailedTests.txt"     //generate fail test case
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
                    glue ="com/hrms/Api",
                    dryRun = true,
                    tags = {"@createJson"},
                    strict = false,  //when fail in one step thats gonna be continue to execution
                    plugin = {"html:target/cucumber-default-reports",
                            "json:target/cucumber.json" //generates json report
                            ,
                            "pretty", //will print executed steps inside console
                            "rerun:target/FailedTests.txt" //generate fail test case
                    }
                    )
public class ApiRunner {

}
