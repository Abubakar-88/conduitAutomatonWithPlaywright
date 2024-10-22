package stepDefinitions;

import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ArticlePage;
import static org.junit.Assert.assertEquals;

public class ArticleStep extends Base {

    ArticlePage articlePage;

    // Use the page from the Hooks class
    public ArticleStep() {
        this.articlePage = new ArticlePage(Hooks.getPage());

    }
    @Given("I click on newArticle menu")
    public void iClickOnNewArticleMenu() {
       articlePage.clickOnNewArticleMenu();
    }
    @When("I fill Article Title {string}")
    public void iFillArticleTitle(String articleTitle) {
        articlePage.enterTitle(articleTitle);
    }
    @Then("I fill Article Title {string} for update")
    public void iFillArticleTitleForUpdate(String articleTitle) {
        delay(2);
        articlePage.enterTitle(articleTitle);
    }

    @And("I fill about Article {string} for update")
    public void iFillAboutArticleForUpdate(String aboutArticle) {
        delay(2);
     articlePage.enterDescription(aboutArticle);
    }
    @When("I fill about Article {string}")
    public void iFillAboutArticle(String aboutArticle) {
        articlePage.enterDescription(aboutArticle);
    }
    @Then("I write the Article {string}")
    public void i_write_the_article(String articleContent) {
        articlePage.enterBody(articleContent);

    }

    @And("I fill tag name {string}")
    public void iFillTagName(String tagName) {
      articlePage.enterTags(tagName);
    }

    @Then("I click on the publish article btn")
    public void iClickOnThePublishArticleBtn() {
         delay(2);
        articlePage.clickPublishButton();
     delay(3);
    }
    @Given("I click on the Technology article")
    public void i_click_on_the_technology_article() {

        articlePage.clickTechnologyArticleLink();
    }
    @When("I click on the Edit Article button")
    public void i_click_on_the_edit_article_button() {
        // Call the page object method to click the "Edit Article" button
        articlePage.clickEditArticle();
    }

    @When("I filter by the java tag")
    public void i_filter_by_the_java_tag() {
        // Call the page object method to click the "java" tag
        delay(2);
        articlePage.clickJavaTag();
    }


    @Then("I should see the article titled {string} in the list")
    public void i_should_see_the_article_titled_in_the_list(String expectedTitle) {
        String actualTitle = articlePage.getJavaTaggedArticleTitles();

      System.out.println("Actual article title is: " + actualTitle);
        // Assert the actual title against the expected title
        assertEquals(expectedTitle, actualTitle);


    }

}
