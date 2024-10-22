package base;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.io.FileInputStream;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.*;

public class Base {
    protected static Playwright playwright;
    protected static Browser browser;
    protected static BrowserContext context;
    protected static Page page;
    public Properties property = new Properties();
    public static String host;

    // Click element by locator
    public static void click(String selector) {
        page.click(selector);
    }

    // Check if element is displayed
    public static boolean isDisplayed(String selector) {
        return page.isVisible(selector);
    }

    // Get the text of an element
    public static String getText(String selector) {
        return page.textContent(selector);
    }

    // Navigate to URL
    public static void navigateURL(String url) {
        page.navigate(url);
    }

    // Select dropdown by visible text (Playwright uses select option method)
    public static void dropDownValue(String selector, String value) {
        page.selectOption(selector, value);
    }

    // Hover over an element
    public static void mouseHover(String selector) {
        page.hover(selector);
    }

    // Delay method (Not recommended to use sleeps in automation)
    public static void delay(long seconds) {
        try {
            Thread.sleep(seconds * 1000L);  // Convert seconds to milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // Select date from a dropdown



    // Initialize Playwright, Browser, and Page
    public static void setupPlaywright() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
    }

    // Close Playwright
    public static void tearDownPlaywright() {
        browser.close();
        playwright.close();
    }

    public static void main(String[] args) {
        // Example usage
        setupPlaywright();
        click("#example-button");
        tearDownPlaywright();
    }
}

