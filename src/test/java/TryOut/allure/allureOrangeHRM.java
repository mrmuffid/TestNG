package TryOut.allure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class allureOrangeHRM {
    WebDriver driver;



    @BeforeMethod
    @Parameters({"browser"})
    void setUp(String browser)
    {
        switch (browser.toLowerCase())
        {
            case "chrome": driver = new ChromeDriver(); break;
            case "edge" : driver = new EdgeDriver(); break;
            case "firefox": driver = new FirefoxDriver(); break;
            default: return;
        }



        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }


    @AfterMethod
    void closeSetUp()
    {
        if(driver!=null)
        {
            driver.quit();
        }
    }

    @Test  (priority = 3)
    void testLogoPresent()
    {
        Boolean logoStatus = driver.findElement(By.xpath("//h5[normalize-space()='Login']")).isDisplayed();
        Assert.assertTrue(logoStatus);


    }


    @Test  (priority = 1)
    void testURL()
    {
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,"0https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test (priority = 2, dependsOnMethods = "testURL")
    void testtitle()
    {
        String actuaTitle = driver.getTitle();
        Assert.assertEquals(actuaTitle,"OrangeHRM");
    }







}
