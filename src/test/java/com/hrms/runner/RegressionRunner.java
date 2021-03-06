package com.hrms.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
                    glue = "com/hrms/stepdefinitions",
                    dryRun = false,
                    tags="@regression",
                    strict = false,
                    plugin = {"pretty",
                            "html:target/cucumber-default-reports",
                            "rerun:target/FailedTests.txt",
                            "json:target/cucumber.json"
                    }
)
public class RegressionRunner {
}
