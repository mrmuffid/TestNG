package TestNG.Listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.*;
import org.testng.annotations.*;

import java.time.Duration;

public class listenersDemo implements ITestListener {

    WebDriver driver;

    public void onTestStart(ITestResult result) {
        System.out.println("This is before test start");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("This is aftre test pases");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("This is aftre test failed");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("This is aftre test skipped");
    }

    public void onStart(ITestContext context) {
        System.out.println("This is before the execusion");
    }

    public void onFinish(ITestContext context) {
        System.out.println("This is after finish the Execusion");
    }




    @AfterMethod
    void closeSetup()
    {
        if(driver!=null)
        {
            driver.quit();
        }
    }


    @BeforeMethod
    @Parameters({"browser"})
    void Setup(String browser)
    {
        switch (browser.toLowerCase())
        {
            case "chrome" : driver = new ChromeDriver(); break;
            case "edge" : driver = new EdgeDriver(); break;
            case  "firefox" : driver = new FirefoxDriver(); break;
            default: System.out.println("Invalid Browser"); return;

        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(priority = 3)
    void testLogo()
    {
        boolean logoStatus = driver.findElement(By.xpath("//h5[normalize-space()='Login']")).isDisplayed();
        Assert.assertEquals(logoStatus,true);
    }

    @Test(priority = 2)
    void testLoginBUtton()
    {
        boolean logoStatus = driver.findElement(By.xpath("//button[normalize-space()='Login']")).isDisplayed();
        Assert.assertEquals(logoStatus,false);

    }

    @Test(priority = 1,dependsOnMethods = {"testLoginBUtton"})
    void testPasswordFieldPlaceholder()
    {
        boolean logoStatus = driver.findElement(By.xpath("//button[normalize-space()='Login']")).isDisplayed();
        String placeholder = driver.findElement(By.xpath("//label[normalize-space()='Password']")).getText();
        Assert.assertEquals(placeholder,"username");
    }



}
