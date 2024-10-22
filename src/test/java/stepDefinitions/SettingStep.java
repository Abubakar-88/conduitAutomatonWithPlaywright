package stepDefinitions;

import base.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SettingPage;

public class SettingStep extends Base {
    private SettingPage settingsPage;

    public SettingStep() {
        this.settingsPage = new SettingPage(Hooks.getPage()); // Assuming Hooks manages the Playwright Page
    }

    @Given("I click on Settings menu")
    public void i_click_on_settings_menu() {
        delay(2);
        settingsPage.clickSettingsMenu();
    }

    @When("I fill profile picture url {string}")
    public void i_fill_profile_picture_url(String profilePicUrl) {
        delay(2);
        settingsPage.fillProfilePicUrl(profilePicUrl);
    }



    @Then("I fill short bio data")
    public void i_fill_short_bio_data() {
        delay(2);
        settingsPage.fillBio("This is a short bio.");
    }


    @Then("I click on the update settings")
    public void i_click_on_the_update_settings() {
        delay(2);
        settingsPage.clickUpdateSettings();
    }
}
