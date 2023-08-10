package com.firstdemo.runner;

import  io.cucumber.testng.CucumberOptions;
import  io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions( tags = "@registration",
        features="src/test/java/com/firstdemo/features",
        glue="com/firstdemo/stepdefination",
        plugin = {  "pretty","html:target/cucumber-reports/RunnerTest-report.html",
        "json:target/cucumber-reports/RunnerTest.json"}
)
public class runnertest extends AbstractTestNGCucumberTests  { }
