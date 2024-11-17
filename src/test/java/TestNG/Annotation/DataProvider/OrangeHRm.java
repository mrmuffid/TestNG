package TestNG.Annotation.DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class OrangeHRm {
    WebDriver driver;

    @BeforeClass
    void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    @AfterClass
    void closeSetUp()
    {
        if(driver!=null)
        {
            driver.quit();
        }
    }

    @DataProvider(name = "loginData",indices = {0,2})
    Object[][] loginData()
    {
        return new Object[][]
                {
                        {"admin","123"},
                        {"cfvf","255"},
                        {"Admin","admin123"}
                };
    }

    @Test(dataProvider = "loginData")
    void testUserLogin(String userName, String password) throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement userNameField = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement loginButton  = driver.findElement(By.xpath("//button[normalize-space()='Login']"));


        userNameField.clear();
        passwordField.clear();

        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        loginButton.click();

        Thread.sleep(3000);

        //div[@role='alert']
        //https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index

        if("Admin".equals(userName) && "admin123".equals(password))
        {
            String currentUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/indexs";
            Assert.assertEquals(currentUrl,driver.getCurrentUrl());
            System.out.println("User Name:- "+userName +" And password:- "+password);
        }
        else
        {
            boolean alertVisibility = driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed();
            Assert.assertTrue(alertVisibility);
            System.out.println("User Name:- "+userName +" And password:- "+password);

        }







    }



}
