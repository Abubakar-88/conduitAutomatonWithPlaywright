package stepDefinitions;

import base.Base;
import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class Hooks extends Base {
    private String currentBrowserName;
    protected String browserName;
    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;
    private static Properties property = new Properties();

    @Before
    public void setup() {
        try (var fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config/app.properties")) {
            property.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties", e);
        }

        playwright = Playwright.create();

         // Read the browser name from the system property (default to Chrome if not provided)
        browserName = System.getProperty("browser", "chrome");
        System.out.println("Running tests on: " + browserName);

        playwright = Playwright.create();

        // Launch the selected browser
        switch (browserName.toLowerCase()) {
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "webkit":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }

        context = browser.newContext();
        page = context.newPage();
        host = property.getProperty("baseUrl");

    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                String screenshotName = scenario.getName().replaceAll(" ", "_") + "_" + System.currentTimeMillis();
                byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(screenshotName + ".png")).setFullPage(true));
                scenario.attach(screenshot, "image/png", screenshotName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (page != null) {
                page.close();
            }
            if (context != null) {
                context.close();
            }
            if (browser != null) {
                browser.close();
            }
            if (playwright != null) {
                playwright.close();
            }
        }
    }

    public static Page getPage() {
        return page;
    }
}
