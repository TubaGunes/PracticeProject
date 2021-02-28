package com.PracticeProject.library.step_definitions;

import com.PracticeProject.library.pages.LandingPage;
import com.PracticeProject.library.pages.LoginPage;
import com.PracticeProject.library.pages.PageBase;
import com.PracticeProject.library.utilities.BrowserUtils;
import com.PracticeProject.library.utilities.ConfigurationReader;
import com.PracticeProject.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    LandingPage landingPage = new LandingPage();
   // PageBase pageBase = new PageBase();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {

        String url = ConfigurationReader.getProperty("qa2_url");
        Driver.getDriver().get(url);

    }


    @When("I login as a librarian")
    public void i_login_as_a_librarian() {

        String username = ConfigurationReader.getProperty("lib22_user");
        String password = ConfigurationReader.getProperty("lib22_pass");

        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.signInButton.click();


    }
    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {

         String expected ="dashboard";
         WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
         wait.until(ExpectedConditions.urlContains(expected));
         String actual = Driver.getDriver().getCurrentUrl();

        System.out.println("actual = "+actual);

        Assert.assertTrue(actual.contains(expected));

        Driver.closeDriver();


    }

    @Then("books should be displayed")
    public void booksShouldBeDisplayed() {
        String expected ="books";
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.urlContains(expected));
        String actual = Driver.getDriver().getCurrentUrl();

        System.out.println("actual = "+actual);

        Assert.assertTrue(actual.contains(expected));

    }

    @When("I login as a student")
    public void iLoginAsAStudent() {

        String username = ConfigurationReader.getProperty("student26_user");
        String password = ConfigurationReader.getProperty("student26_pass");

        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.signInButton.click();


    }

    @When("I enter username {string}")
    public void iEnterUsername(String username) {

        loginPage.usernameInput.sendKeys(username);


    }

    @And("I enter password {string}")
    public void iEnterPasswordBJRnAAyp(String password) {

        loginPage.passwordInput.sendKeys(password);
    }

    @And("click the sign in button")
    public void clickTheSignInButton() {

        loginPage.signInButton.click();

    }

    @And("there should be {int} users")
    public void thereShouldBeUsers(int number) {
        int expectedUserNumber = number;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        // wait.until(ExpectedConditions.visibilityOf(expectedUserNumber));


        String expected = String.valueOf(expectedUserNumber);
        String actual = landingPage.userCount.getText();

        Assert.assertEquals(actual, expected);
    }

        @When("I login using {string} and {string}")
        public void i_login_using_and(String username, String password){


            loginPage.usernameInput.sendKeys(username);
            loginPage.passwordInput.sendKeys(password);

            loginPage.signInButton.click();




    }


    @When("I login using {string}and {string}")
    public void iLoginUsingAnd(String username, String password) {

        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.signInButton.click();

    }

    @Then("account holder name should be {string}")
    public void accountHolderNameShouldBe(String expectedAccountUsername) {
        BrowserUtils.waitForVisibility(landingPage.accountUsername, 2);
        String actualAccountUsername  = landingPage.accountUsername.getText();


        Assert.assertEquals(expectedAccountUsername ,actualAccountUsername );
        Driver.closeDriver();

    }
}
