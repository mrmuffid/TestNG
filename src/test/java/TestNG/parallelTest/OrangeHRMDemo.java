package TestNG.parallelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.lang.model.element.Element;
import java.time.Duration;

public class OrangeHRMDemo {
    WebDriver driver;

    @BeforeMethod
    void setUp ()
    {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

    }

    @AfterMethod
    void closeSetUp()
    {
        if (driver!=null)
        {
            driver.quit();
        }
    }

    @DataProvider(name = "lognCredentials")
    Object[][] loginCredential()
    {
        return new Object[][]
        {
                {"admin","admin123","//h6[normalize-space()='Dashboard']","Dashboard"},
                {"","admin123","//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']","Requied"},
                {"Admin","","//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']","Requied"},
                {"cevrr","v4vtv4","//p[@class='oxd-text oxd-text--p oxd-alert-content-text']","Invalid"},
                {"Admin","admin123","//h6[normalize-space()='Dashboard']","Dashboard"}
        };

    }

    @Test(dataProvider = "lognCredentials")
    void testLoginPage(String userName,String password,String validateLocation , String expectedResultText) throws InterruptedException {

//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement userNamefield = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));

        userNamefield.clear();
        passwordField.clear();

        userNamefield.sendKeys(userName);
        passwordField.sendKeys(password);

        Thread.sleep(3000);
        loginButton.click();

        boolean expectedElementVisibility = driver.findElement(By.xpath(validateLocation)).isDisplayed();
        Assert.assertTrue(expectedElementVisibility);











        //WebElement txts = driver.findElement(By.xpath("//h5[normalize-space()='Login']"));
       // System.out.println(txts.getText());






    }


}
