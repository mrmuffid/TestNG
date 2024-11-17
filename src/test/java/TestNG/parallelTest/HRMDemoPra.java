package TestNG.parallelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class HRMDemoPra {
    WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    void Setup (String browser1)
    {

        switch (browser1.toLowerCase())
        {
            case "chrome": driver = new ChromeDriver(); break;
            case "edge": driver =new EdgeDriver();break;
            case "firefox": driver = new FirefoxDriver(); break;
            case "safari": driver = new SafariDriver(); break;
            default: System.out.println("Browser is not identified"); return;
        }



        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }

    @AfterMethod
    void closeStep()
    {
        if(driver!=null)
        {
            driver.quit();
        }
    }


    @DataProvider (name = "logingDetails")
    Object[][] loginData(){
        return new Object[][]{
                {"admin","admin123","//h6[normalize-space()='Dashboard']","Dashboard0"},
                {"abc","521","//p[@class='oxd-text oxd-text--p oxd-alert-content-text']","Invalid credentials0"},
                {"","admin123","//div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]","Required"},
                {"Admin","","//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span","Required0"},
                {"Admin","admin123","//h6[normalize-space()='Dashboard']","Dashboard"}

        };

    }


    @Test(dataProvider = "logingDetails")
    void testLogin(String Dusername, String Dpassword, String location, String Eresult){

        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));


        username.clear();
        username.sendKeys(Dusername);

        password.clear();
        password.sendKeys(Dpassword);

        loginButton.click();

        WebElement Xlocation = driver.findElement(By.xpath(location));

        Assert.assertTrue(Xlocation.isDisplayed());

        String Aresult = Xlocation.getText();
        Assert.assertEquals(Aresult,Eresult);

    }
















}
