package pages;

import base.Base;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SettingPage extends Base {
     private Locator settingsMenu;
    // Locators for the form fields
    private Locator profilePicUrlInput;
    private Locator usernameInput;
    private Locator bioTextarea;
    private Locator emailInput;
    private Locator passwordInput;
    private Locator updateSettingsButton;
    public SettingPage(Page page){
        this.page = page;
        // Initialize locators using Playwright's Locator API
        this.settingsMenu = page.locator("a[href='/settings']");
        this.profilePicUrlInput = page.locator("input[formcontrolname='image']");
        this.bioTextarea = page.locator("textarea[formcontrolname='bio']");
        this.updateSettingsButton = page.locator("button:has-text('Update Settings')");
    }

    public void clickSettingsMenu() {
        settingsMenu.click();
    }

    public void fillProfilePicUrl(String profilePicUrl) {
        profilePicUrlInput.fill(profilePicUrl);
    }

    public void fillBio(String bio) {
        bioTextarea.fill(bio);
    }

    public void clickUpdateSettings() {
        updateSettingsButton.click();
    }



}
