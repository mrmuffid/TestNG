package TestNG.DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataprovideDemo {

    WebDriver driver;


    @BeforeClass
    void Setup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Test
    void testLogin() throws InterruptedException {
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("hello.abc@yopmail.com");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("abc123");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

//        Thread.sleep(2000);

        boolean headerprecent = driver.findElement(By.xpath("//a[normalize-space()='Qafox.com']")).isDisplayed();

        //Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Qafox.com']")).isDisplayed());

        if(headerprecent==false)
        {
            System.out.println("Test pass...");
            Assert.assertTrue(true);
        }
        else
        {
            System.out.println("Test  fail...");
            Assert.fail();
//            Assert.assertTrue(false);
        }


    }

    @AfterClass
    void Logout()
    {

        driver.quit();


    }
}
