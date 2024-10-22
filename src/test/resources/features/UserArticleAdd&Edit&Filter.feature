Feature: Article Add, Edit and Filter
  ** As a user I want to add a article
  So that I can the article edit and filter **

  Background:
    Given I am on the homepage
    When I click on the SignIn Menu
    Then I fill email "abdur.rahman@gmail.com"
    And I fill password "abdur@#890"
    And I click on the Sign In button

  @regression
  Scenario Outline: User can add article with successfully
    Given I click on newArticle menu
    When I fill Article Title "Technology"
    Then I fill about Article "Programming language java"
    And I write the Article "<articleContent>"
    And I fill tag name "java"
    Then I click on the publish article btn
    Examples:
    | articleContent  |
    |  Programming languages are tools used to communicate with computers and create software applications. They provide a set of rules and syntax to write programs that perform tasks, from simple calculations to complex systems. Popular programming languages include Python, Java.  |

  @regression
  Scenario: User filters by the java tag
    Given I filter by the java tag
    When I should see the article titled "Technology" in the list

  @regression
  Scenario Outline: User can Update article with successfully
    Given I click on the Technology article
    When I click on the Edit Article button
    Then I fill Article Title "Job Search" for update
    And I fill about Article "Job in backend developer" for update
    And I write the Article "<articleContent>"
    And I fill tag name "Python"
    Then I click on the publish article btn
    Examples:
      | articleContent  |
      |  THis is a job requirement article body   |
