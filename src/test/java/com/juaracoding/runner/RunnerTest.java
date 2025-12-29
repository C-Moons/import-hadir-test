package com.juaracoding.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/features/ImportAbsen.feature", "src/test/resources/features/ImportStatusAktif.feature", "src/test/resources/features/ImportStrukturUser.feature", "src/test/resources/features/ImportCuti.feature"}, glue = {
                "com.juaracoding.definition",
                "com.juaracoding.hook",
}, plugin = { "pretty", "html:test-output", "json:target/cucumber/cucumber.json",
                "html:target/cucumber-html-report",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class RunnerTest extends AbstractTestNGCucumberTests {

}
