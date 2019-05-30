package com.dds.testrunners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Test\\com\\dds\\features",
		glue = "com.dds.tests",
		plugin = { "usage"},
		monochrome = true
		)

public class MainTest {

}
