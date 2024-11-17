package TestNG.parallelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class parallelTest {

    WebDriver driver;

    @BeforeClass
    void setUp()
    {
        driver = new ChromeDriver();


    }
    @AfterClass
    void closeSetUp()
    {
        if (driver!=null)
        {
            driver.quit();
        }
    }

    @BeforeMethod
    void signUp() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement userNameField = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement loginButton  = driver.findElement(By.xpath("//button[normalize-space()='Login']"));

        userNameField.clear();
        passwordField.clear();

        userNameField.sendKeys("Admin");
        passwordField.sendKeys("admin123");
        loginButton.click();

        Thread.sleep(3000);
    }

    @Test
    void testLogo()
    {
        boolean logoVisibility = driver.findElement(By.xpath("//img[@alt='client brand banner']")).isDisplayed();
        Assert.assertTrue(logoVisibility);

    }

    @Test
    void testCurrentUrl()
    {
        String hrmurl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String curentUrl = driver.getCurrentUrl();
        Assert.assertEquals(hrmurl,curentUrl);

    }

    @Test
    void testTitle()
    {
        String hrmTitle = "orangeHrm";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(hrmTitle,actualTitle);


    }

    @AfterMethod
    void logOut()
    {
        driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
    }


/*
1
2
3
Test one
3
3
Test two
3
2
1


 */





}
