package com.PracticeProject.library.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/PracticeProject/library/step_definitions",
        tags = "@all_accounts"
)
public class CukesRunner {

}
