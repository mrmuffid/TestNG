package TestNG.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class loginTestHRM {

    WebDriver driver;


    @BeforeClass
    void doSetUp()
    {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


    }

    @AfterClass
    void DoTearDown ()
    {
        if (driver!=null)
        {
            driver.quit();
        }

    }


    @Test
    void testLoginPage()
    {
        loginPageHRM lpc = new loginPageHRM(driver);

        lpc.setUserName("Admin");
        lpc.setPassword("admin");
        lpc.clickLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(),"vrtgtr");

    }


    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
