package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions
	(
		features=	"src/test/resources/login.feature",
		
		glue= {"stepdefinition", "hooks"},
		
		
		plugin= {"pretty", "html:target/cucumber-report.html",
				"json:target/cucumber.json"
				},
		
		monochrome=true,
		tags="@Smoke or @Regression")
			
   public class TestRunner extends AbstractTestNGCucumberTests
   {
		
   }