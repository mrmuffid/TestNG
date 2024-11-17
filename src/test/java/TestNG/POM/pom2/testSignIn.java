package TestNG.POM.pom2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class testSignIn {

    WebDriver driver;


    @BeforeClass
    void setup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterClass
    void closeSetUp()
    {
        if (driver!=null)
        {
            driver.quit();
        }
    }

    @Test
    void testSignIn()
    {

        signInSetUp sp = new signInSetUp(driver);

        sp.setUsername("muffid");
        sp.setPassword("jb");
        sp.clickLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(),"erdw");


    }



}
