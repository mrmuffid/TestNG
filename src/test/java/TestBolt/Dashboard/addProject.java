package TestBolt.Dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class addProject {

    WebDriver driver;

    @BeforeClass
    void chromeSetUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Login.....

        String emailAddress = "muffid@expernetic.com";
        String  password = "Roja1533&";
        driver.get("https://qa-app.testbolt.io/");
        WebElement emailField = driver.findElement(By.xpath("//input[@id='Input_Username']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='Input_Password']"));
        WebElement signInBUtton = driver.findElement(By.xpath("//button[normalize-space()='Sign In']"));

        emailField.sendKeys(emailAddress);
        passwordField.sendKeys(password);
        signInBUtton.click();
        Thread.sleep(5000);
    }
    @AfterTest
    void closeSetUp()
    {
        if(driver!=null)
        {
            driver.quit();
        }
    }

    @DataProvider(name = "projectDrawer")
    Object[][] projectDrawer()
    {
        return new Object[][]{
                {"50Charac50Charac50Charac50Charac50Charac50Charac50c","New-description","//p[@id='create-new-project-name-helper-text']"},
                {"Hello new project","600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charc600charcx","//p[@id='create-new-project-description-helper-text']"},
//                {"NewProject001","","//p[@id='create-new-project-description-helper-text']"}
        };
    }

    @BeforeMethod
    void Opendrawer()
    {
        // Access Add project drawer
        WebElement addProjectButton = driver.findElement(By.xpath("//div[contains(text(),'New Project')]"));
        addProjectButton.click();
    }


    @Test(dataProvider ="projectDrawer")
    void testAddProjectFunctionOnProjectDashboard(String title,String description,String validatonMessageXpath) throws InterruptedException {






        WebElement titleField = driver.findElement(By.xpath("//input[@id='create-new-project-name']"));
        WebElement descriptionField = driver.findElement(By.xpath("//textarea[@id='create-new-project-description']"));
        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(), 'Add Project')]"));

        // Provide Data to the field
        titleField.clear();
        descriptionField.clear();

        titleField.sendKeys(title);
        descriptionField.sendKeys(description);






//        WebElement validationMessage = driver.findElement(By.xpath(validatonMessageXpath));
//        WebElement cancelButton = driver.findElement(By.xpath("//button[contains(text(), 'Add Project')]"));
//        submitButton.click();










    }









}
