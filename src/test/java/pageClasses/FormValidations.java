package pageClasses;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class FormValidations extends BasePage 
{

    public FormValidations(WebDriver driver) 
    {
        super(driver);
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(xpath = "//h2[text()='Get in touch with our sales team']")
    private WebElement transFormationForm;

    @FindBy(id = "FirstName")
    private WebElement name;

    @FindBy(id = "LastName")
    private WebElement LastName;

    @FindBy(id = "Email")
    private WebElement Email;

    @FindBy(id = "Phone")
    private WebElement Phone;

    @FindBy(id = "Institution_Type__c")
    private WebElement InstituteType;

    @FindBy(id = "Company")
    private WebElement InstitueName;

    @FindBy(id = "Title")
    private WebElement Title;

    @FindBy(id = "Department")
    private WebElement Department;

    @FindBy(id = "What_the_lead_asked_for_on_the_website__c")
    private WebElement discription;

    @FindBy(id = "Country")
    private WebElement country;

    @FindBy(id = "State")
    private WebElement state;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submit;

    @FindBy(xpath = "//div[@class='mktoErrorMsg']")
    private WebElement findInvalidInput;

    public void findForm() 
    {
        try 
        {
            js.executeScript("arguments[0].scrollIntoView(true);", transFormationForm);
        } 
        catch (Exception e) 
        {
            Assert.fail("Failed to scroll to form header: " + e.getMessage());
        }
    }

    public void setFirstName(String fname) 
    {
        try 
        {
            name.sendKeys(fname);
        } 
        catch (Exception e) 
        {
            Assert.fail("Failed to set first name: " + e.getMessage());
        }
    }

    public void setLastName(String lname) 
    {
        try 
        {
            LastName.sendKeys(lname);
        } 
        catch (Exception e) 
        {
            Assert.fail("Failed to set last name: " + e.getMessage());
        }
    }

    public void setEmail(String email) 
    {
        try 
        {
            Email.sendKeys(email);
        } 
        catch (Exception e) 
        {
            Assert.fail("Failed to set email: " + e.getMessage());
        }
    }

    public void setTelephone(String tel) 
    {
        try 
        {
            Phone.sendKeys(tel);
        } 
        catch (Exception e) 
        {
            Assert.fail("Failed to set phone number: " + e.getMessage());
        }
    }

    public void setInstituteType(String Itype) 
    {
        try 
        {
            InstituteType.sendKeys(Itype);
        } 
        catch (Exception e) 
        {
            Assert.fail("Failed to set institute type: " + e.getMessage());
        }
    }

    public void setInstituteName(String IName) 
    {
        try 
        {
            InstitueName.sendKeys(IName);
        } 
        catch (Exception e) 
        {
            Assert.fail("Failed to set institute name: " + e.getMessage());
        }
    }

    public void setJobRole(String role) 
    {
        try {
            Title.sendKeys(role);
        } catch (Exception e) {
            Assert.fail("Failed to set job role: " + e.getMessage());
        }
    }

    public void setDepartment(String dept) 
    {
        try {
            Department.sendKeys(dept);
        } catch (Exception e) {
            Assert.fail("Failed to set department: " + e.getMessage());
        }
    }

    public void setDiscription(String dis) 
    {
        try {
            discription.sendKeys(dis);
        } catch (Exception e) {
            Assert.fail("Failed to set description: " + e.getMessage());
        }
    }

    public void setCountry(String ctry) 
    {
        try {
            country.sendKeys(ctry);
        } catch (Exception e) {
            Assert.fail("Failed to set country: " + e.getMessage());
        }
    }

    public void setState(String State) 
    {
        try {
            state.sendKeys(State);
        } catch (Exception e) {
            Assert.fail("Failed to set state: " + e.getMessage());
        }
    }

    public void submit() 
    {
        try 
        {
            submit.click();
            if (findInvalidInput.isDisplayed()) 
            {
                js.executeScript("arguments[0].scrollIntoView(false);", findInvalidInput);
                Thread.sleep(2000);
                captureScreen();
            }

        } 
        catch (InterruptedException | IOException e) 
        {
            Assert.fail("Error during form submission or screenshot capture: " + e.getMessage());
        }
    }

    public String captureScreen() throws IOException 
    {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\error_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;
    }
}
