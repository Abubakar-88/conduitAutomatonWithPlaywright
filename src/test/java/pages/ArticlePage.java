package pages;

import base.Base;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArticlePage extends Base {
    private Locator newArticleMenu;
    private Locator titleInput;
    private Locator descriptionInput;
    private Locator bodyTextarea;
    private Locator tagsInput;
    private Locator publishButton;
    private Locator technologyArticleLink;
    private Locator editArticleButton;
    private Locator javaTag;
  //  private Locator articlesWithJavaTag;
   private Locator articles;
    public ArticlePage(Page page){
        this.page = page;
        // Initialize locators using Playwright's Locator API
        this.newArticleMenu = page.locator("a[href='/editor']");
        this.titleInput = page.locator("input[formcontrolname='title']");
        this.descriptionInput = page.locator("input[formcontrolname='description']");
        this.bodyTextarea = page.locator("textarea[formcontrolname='body']");
        this.tagsInput = page.locator("input[placeholder='Enter tags']");
        this.publishButton = page.locator("button.btn-primary:has-text('Publish Article')");
        this.technologyArticleLink = page.locator("a.preview-link h1:has-text('Technology')");
        this.editArticleButton = page.locator("div.banner > div > app-article-meta > div > span > a");
        this.javaTag = page.locator("a.tag-default.tag-pill:has-text('java')");
        this.articles = page.locator(".article-preview h1");

    }


    public void clickOnNewArticleMenu(){
        newArticleMenu.click();
    }
    // Method to fill in the article title
    public void enterTitle(String title) {
        titleInput.fill("");
        titleInput.fill(title);
    }

    // Method to fill in the article description
    public void enterDescription(String description) {
        descriptionInput.fill("");
        descriptionInput.fill(description);
    }

    // Method to fill in the article body
    public void enterBody(String body) {
        bodyTextarea.fill("");
        bodyTextarea.fill(body);
    }

    // Method to enter tags
    public void enterTags(String tags) {
        tagsInput.fill(tags);
    }

    // Method to click the "Publish Article" button
    public void clickPublishButton() {
        publishButton.click();
    }
    public void clickTechnologyArticleLink() {
        technologyArticleLink.click();
    }

    public void clickEditArticle() {
        editArticleButton.click();
    }
    // Method to click the "java" tag
    public void clickJavaTag() {
        javaTag.click();
    }
    public String getJavaTaggedArticleTitles() {

        return articles.textContent();  // Return the list of article titles
    }



}
