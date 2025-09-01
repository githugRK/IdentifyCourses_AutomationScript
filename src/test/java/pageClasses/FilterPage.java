package pageClasses;

import java.time.Duration;
import java.util.List;
import java.util.regex.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FilterPage extends BasePage {
    WebDriverWait wait;
  
    public FilterPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(xpath = "(//span[text()='Beginner'])[2]")
    private WebElement beginner;

    @FindBy(xpath = "//span[text()='Intermediate']")
    private WebElement intermediate;

    @FindBy(xpath = "//span[text()='Advanced']")
    private WebElement advanced;

    @FindBy(xpath = "//span[text()='Mixed']")
    private WebElement mixed;

    @FindBy(xpath = "//span[@id='cds-react-aria-:R8qlmphel6dakqdqla:-label-text']")
    private WebElement english;

    @FindBy(css = ".cds-9.css-0.cds-11.cds-grid-item.cds-56.cds-64.cds-76.cds-90")
    private List<WebElement> course;

    @FindBy(xpath = "//h3")
    private List<WebElement> courseTitles;

    @FindBy(xpath = "//p[@class='css-vac8rf']")
    private List<WebElement> skills;

    @FindBy(xpath = "//span[@class='css-6ecy9b']")
    private List<WebElement> courseRatings;

    @FindBy(xpath = "//div[@class='cds-CommonCard-metadata']")
    private List<WebElement> duration;

    @FindBy(xpath = "//span[@class='cds-checkboxAndRadio-labelContent css-tvqrra']")
    private List<WebElement> filterlist;

    @FindBy(xpath = "//span[@class='cds-button-label']")
    private List<WebElement> showButton;

    public void clickBeginner() {
        try {
            beginner.click();
        } catch (Exception e) {
            Assert.fail("Failed to click Beginner filter: " + e.getMessage());
        }
    }

    public void clickEnglish() {
        try {
            english.click();
        } catch (Exception e) {
            Assert.fail("Failed to click English filter: " + e.getMessage());
        }
    }

    public void coursesDetails() {
        try {
            for (int i = 0; i < 2 && i < course.size(); i++) 
            {
                String name = courseTitles.get(i).getText();
                String hours = skills.get(i * 2).getText();
                String rating = courseRatings.get(i).getText();
                String courseDuration = duration.get(i).getText();

                System.out.println("Course " + (i + 1) + ":");
                System.out.println("Title: " + name);
                System.out.println(hours);
                System.out.println("Duration: " + courseDuration);
                System.out.println("Rating: " + rating);
                System.out.println("------------------------");

            }
        } catch (Exception e) {
            Assert.fail("Error while fetching course details: " + e.getMessage());
        }
    }

    public void selectLanguage() 
    {
        clickOnShow();

        for (int i = 4; i <= Math.min(filterlist.size(), 8); i++) 
        {
            try 
            {	
                String value = filterlist.get(i).getText();
                String languageName = value.replaceAll("\\(\\d{1,3}(,\\d{3})?\\)", "").trim();

                WebElement checkbox = filterlist.get(i);
                wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
                js.executeScript("arguments[0].scrollIntoView(true);", checkbox);

                Thread.sleep(2000);
                
                System.out.println("Name of language: "+languageName);
                System.out.println("Beginners level course count: " + filterString(beginner.getText()));
                System.out.println("Intermediate level course count: " + filterString(intermediate.getText()));
                System.out.println("Advanced level course count: " + filterString(advanced.getText()));
                System.out.println("Mixed level course count: " + filterString(mixed.getText()));
                System.out.println("-----------------");

                WebElement remove = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Clear all']")));
                js.executeScript("window.scrollTo(0, 0);");
                remove.click();

            } 
            catch (Exception e) 
            {
                Assert.fail("Error during language selection and filtering: " + e.getMessage());
            }
        }
    }

    public void clickOnShow() 
    {
        try {
            showButton.get(2).click();
        } catch (Exception e) {
            Assert.fail("Failed to click Show button: " + e.getMessage());
        }
    }
    
    public String filterString(String count) 
    {
        Pattern pattern = Pattern.compile("\\((\\d+(?:,\\d{3})*)\\)");
        Matcher matcher = pattern.matcher(count);

        if (matcher.find()) 
        {
            return matcher.group(1);
        } 
        else 
        {
            return "level count not available.";
        }
    }
}



