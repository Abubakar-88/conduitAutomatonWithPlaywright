Feature: User Profile update
  ** As a user I want to update my profile
  So that I can update my profile information without any unexpected error **
  Background:
    Given I am on the homepage
    When I click on the SignIn Menu
    Then I fill email "abdur.rahman@gmail.com"
    And I fill password "abdur@#890"
    And I click on the Sign In button
  @regression
  Scenario: User can profile information update with successfully
    Given I click on Settings menu
    When I fill profile picture url "C:\TestingPicture\bicycle02.jpg"
    Then I fill userName "Abdullah45Update"
    Then I fill short bio data
    And I fill email "abdullah45@gmail.com"
    And I fill password "Abdullah321@!34"
    Then I click on the update settings