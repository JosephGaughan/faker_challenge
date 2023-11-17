package exercise_1;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.microsoft.playwright.*;


public class AppTest {
    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;

    @BeforeSuite
    public void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @Test
    public void details301TooLong() {
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://defect-logger.onrender.com/");
        Locator nameField = page.getByTestId("name");
        Locator summaryField = page.getByTestId("summary");
        Locator detailsField = page.getByTestId("details");
        Locator submitButton = page.getByTestId("submit");

        nameField.fill("Alice");
        summaryField.fill("Bug");
        detailsField.fill(
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy buggy"
        );
        submitButton.click();
        String url = page.url();
        Assert.assertEquals(url, "https://defect-logger.onrender.com/defects");
    }

    @Test
    public void details99TooShort() {
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://defect-logger.onrender.com/");
        Locator nameField = page.getByTestId("name");
        Locator summaryField = page.getByTestId("summary");
        Locator detailsField = page.getByTestId("details");
        Locator submitButton = page.getByTestId("submit");

        nameField.fill("Eddie");
        summaryField.fill("Bug");
        detailsField.fill(
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bug"
        );
        submitButton.click();
        String url = page.url();
        Assert.assertEquals(url, "https://defect-logger.onrender.com/defects");
    }

    @Test
    public void name31TooLong() {
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://defect-logger.onrender.com/");
        Locator nameField = page.getByTestId("name");
        Locator summaryField = page.getByTestId("summary");
        Locator detailsField = page.getByTestId("details");
        Locator submitButton = page.getByTestId("submit");

        nameField.fill("Roll Alie Kantar Frentsasu Sena");
        summaryField.fill("Bug");
        detailsField.fill(
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg"
        );
        submitButton.click();
        String url = page.url();
        Assert.assertEquals(url, "https://defect-logger.onrender.com/defects");
    }

    @Test
    public void summary51TooLong() {
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://defect-logger.onrender.com/");
        Locator nameField = page.getByTestId("name");
        Locator summaryField = page.getByTestId("summary");
        Locator detailsField = page.getByTestId("details");
        Locator submitButton = page.getByTestId("submit");

        nameField.fill("Bob");
        summaryField.fill("Buggy buggy buggy buggy buggy buggy buggy buggy bug");
        detailsField.fill(
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg"
        );
        submitButton.click();
        String url = page.url();
        Assert.assertEquals(url, "https://defect-logger.onrender.com/defects");
    }

    @Test
    public void validSubmissionDetails100() {
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://defect-logger.onrender.com/");
        Locator nameField = page.getByTestId("name");
        Locator summaryField = page.getByTestId("summary");
        Locator detailsField = page.getByTestId("details");
        Locator submitButton = page.getByTestId("submit");

        nameField.fill("Roll Alie Kantar Frentsasu Sen");
        summaryField.fill("Buggy buggy buggy buggy buggys");
        detailsField.fill(
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg"
        );
        submitButton.click();
        String url = page.url();
        Assert.assertEquals(url, "https://defect-logger.onrender.com/");
    }

    @Test
    public void validSubmissionDetails300() {
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://defect-logger.onrender.com/");
        Locator nameField = page.getByTestId("name");
        Locator summaryField = page.getByTestId("summary");
        Locator detailsField = page.getByTestId("details");
        Locator submitButton = page.getByTestId("submit");

        nameField.fill("Roll Alie Kantar Frentsasu Sen");
        summaryField.fill("Buggy buggy buggy buggy buggys");
        detailsField.fill(
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg" +
            "I found a buggy bugg"
        );
        submitButton.click();
        String url = page.url();
        Assert.assertEquals(url, "https://defect-logger.onrender.com/");
    }

    @AfterSuite
    public void closeBrowser() {
        playwright.close();
    }
}