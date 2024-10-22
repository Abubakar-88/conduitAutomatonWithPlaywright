Feature: Signup Without Any error
  ** As a User I want to create Article
     So That I can edit and delete the created Article **
  Background:
    Given I am on the homepage
   @signup
  Scenario: User can be Signup with successfully
    Given I click on the Signup Menu
    When I should see the "Sign up" title on the signup page
    Then I fill userName "abdurrahman22"
    And I fill email "abdur.rahman@gmail.com"
    And I fill password "abdur@#890"
    Then I click on the Sign Up button


