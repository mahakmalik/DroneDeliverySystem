package com.dds.testrunners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\com\\dds\\features",
		glue = "com.dds.tests"
		)

public class MainTest {

}