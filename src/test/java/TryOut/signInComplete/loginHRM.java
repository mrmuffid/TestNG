package TryOut.signInComplete;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class loginHRM {

    WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    void setUp(String browser)
    {
        switch (browser.toLowerCase())
        {
            case "chrome" : driver = new ChromeDriver(); break;
            case "edge"   : driver = new EdgeDriver(); break;
            case "firefox" : driver = new FirefoxDriver(); break;
            default: System.out.println("incorect webdriver"); return;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterMethod
    void closeSetUP()
    {
        if (driver!=null)
        {
            driver.quit();
        }
    }

    @DataProvider(name = "loginCredentials")
    public  Object[][] loginData()
    {
        return new Object[][]
                {
                        {"muffid","hello","//p[@class='oxd-text oxd-text--p oxd-alert-content-text']","Invalid credentials1"},
                        {"Admin","123","//p[@class='oxd-text oxd-text--p oxd-alert-content-text']","Invalid credentials2"},
                        {"","admin123","//div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]","Required3"},
                        {"Admin","","//div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]","Required4"},
                        {"Admin","admin123","//h6[normalize-space()='Dashboard']","Dashboard5"}

                };
    }


    @Test(dataProvider = "loginCredentials")
    void testLogin(String userName, String password , String VXpath, String exResult)
    {
        pomLogin plc = new pomLogin(driver);

        plc.setUserName(userName);
        plc.setPassword(password);
        plc.clickLoginButton();


//        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(userName);
//        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
//        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();


        WebElement loginElements = driver.findElement(By.xpath(VXpath));
        boolean status = loginElements.isDisplayed();

        Assert.assertTrue(status);

        Assert.assertEquals(loginElements.getText(),exResult);

    }











}
