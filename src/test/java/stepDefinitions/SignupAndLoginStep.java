package stepDefinitions;

import base.Base;
import com.microsoft.playwright.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignupPage;
import static org.junit.Assert.assertEquals;

public class SignupAndLoginStep extends Base {

    SignupPage signupPage;

    // Use the page from the Hooks class
    public SignupAndLoginStep() {
        this.signupPage = new SignupPage(Hooks.getPage());

    }
    @Given("I am on the homepage")
    public void i_am_on_the_homepage() {
      //  String host = "http://your-homepage-url.com"; // Replace with your actual homepage URL
        signupPage.navigateUrl(host);
    }


    @Given("I click on the Signup Menu")
    public void clickOnTheSignupMenu() {
        delay(2);
        signupPage.clickSignUpMenu();
    }



    @When("I should see the {string} title on the signup page")
    public void shouldSeeTheTitleOnTheSignupPage(String expectedTitle) {

        // Get the text content of the title element
        String actualTitle = signupPage.getSignUpTitleElement(); // or actualTitleLocator.innerText();

        // Assert the actual title against the expected title
        assertEquals(expectedTitle, actualTitle);
    }

    @Then("I fill userName {string}")
    public void iFillUserName(String userName) {
        signupPage.enterUserName(userName);
    }

    @And("I fill email {string}")
    public void iFillEmail(String email) {
        signupPage.enterEmail(email);
    }

    @And("I fill password {string}")
    public void iFillPassword(String password) {
        signupPage.enterPassword(password);
    }
    @Then("I click on the Sign Up button")
    public void iClickOnTheSignUpButton() {
        signupPage.clickSignUpButton();
    }


    @Given("I click on the SignIn Menu")
    public void iClickOnTheSignInMenu() {
        signupPage.clickSignInMenu();
    }

    @Then("I click on the Sign In button")
    public void iClickOnTheSignInButton() {
        signupPage.clickSignInBtn();
    }


}
