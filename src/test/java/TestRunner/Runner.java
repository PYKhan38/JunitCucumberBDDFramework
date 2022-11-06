package TestRunner;
//tags="@Sanity" Will run scenario which is tagged with Sanity. Does not matter if it has other tags as well.
//tags="@Sanity or @Regression"// Will run scenario tagged with sanity or regression.
//tags="@Sanity and @Regression"//Will run scenario which is tagged with sanity as well as regression
//tags="@sanity and not @regression"//will run scenario which is tagged with sanity but not regression

//Hooks
//--------

//Hooks are block of code that runs before and after each scenario

//1.Scenario hooks: runs before/after each scenario.

//@Before --->Steps to perform before start of testing of each scenario
//
//Setup code:
//	
//	To start a web drive
//	Setup of data base connection
//	setup of test data
//	setup of browser cookies
//	Navigation to a certain page

//@After----->Steps to perform after testing of each scenario

// Cleanup code/teardown code:

// To stop the webDriver
// to close Db connections
// To clear the test data
// To clear browser cookies
//To Log out from the application
//Printing reports or logs
//Taking the screeenshots of errors

//2.Step hooks: runs before/after each steps.abstract
//3.conditional hooks: we can associate hooks with tags for conditional execution.

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features ={"Features/LoginFeature.feature", "Features/Customers.feature"},

//to run all features just keep features folder "Features"


glue="StepDefinition",dryRun=false, monochrome=true, tags="@Sanity",

//		plugin= {"pretty","html:target/cucumber-reports/report.html"}

plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class Runner {
	

}
