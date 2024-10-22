package pages;

import base.Base;
import com.microsoft.playwright.*;

public class SignupPage extends Base {

    // Locators
    private final Locator signUpMenu;
    private final Locator signUpTitleElement;

    private final Locator userNameInput;
    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator signUpButton;
    private final Locator signInMenu;
    private final Locator signInButton;
    public SignupPage(Page page) {
        this.page = page;

        // Initialize locators using Playwright's Locator API
        signUpMenu = page.locator("a[href='/register']");
        signUpTitleElement = page.locator("h1.text-xs-center");
        userNameInput = page.locator("input[formcontrolname='username']");
        emailInput = page.locator("input[formcontrolname='email']");
        passwordInput = page.locator("input[formcontrolname='password']");
        signUpButton = page.locator("button:has-text('Sign up')");
        signInMenu = page.locator("a:has-text('Sign in')");
        signInButton = page.locator("button:has-text('Sign in')");
    }

    // Click the sign-up menu dropdown
    public void clickSignUpMenu() {
            signUpMenu.click();
    }

    public void clickSignInMenu() {
        signInMenu.click();
    }

    public void clickSignInBtn() {
        signInButton.click();
    }
    // Click the general user link

    // Method to navigate to a specified URL
    public void navigateUrl(String url) {
        page.navigate(url);
    }
    // Get the signup title element
    public String getSignUpTitleElement() {
        return signUpTitleElement.textContent();
    }


    // Enter user name
    public void enterUserName(String userName) {
        userNameInput.fill(userName);
    }

    // Enter email
    public void enterEmail(String email) {
        emailInput.fill(email);
    }


    // Enter password
    public void enterPassword(String password) {
        passwordInput.fill(password);
    }

    // Click the sign-up button
    public void clickSignUpButton() {
        signUpButton.click();
    }
}

