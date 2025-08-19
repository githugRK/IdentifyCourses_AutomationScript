package pageClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }
    

    @FindBy(xpath = "//input[@placeholder='What do you want to learn?']")
    private WebElement searchbox;

    @FindBy(xpath = "//a[text()='For Enterprise']")
    private WebElement forEnterprise;

    @FindBy(xpath = "//a[text()='For Campus']")
    private WebElement forCampus;

    public void searchForCourse(String course) {
        try {
            searchbox.sendKeys(course);
            searchbox.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            Assert.fail("Failed to search for course: " + e.getMessage());
        }
    }

    public void clickEnterprise() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", forEnterprise);
            forEnterprise.click();
        } catch (Exception e) {
            Assert.fail("Failed to click 'For Enterprise': " + e.getMessage());
        }
    }

    public void clickForCampus() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            forCampus.click();
        } catch (Exception e) {
            Assert.fail("Failed to click 'For Campus': " + e.getMessage());
        }
    }
}
