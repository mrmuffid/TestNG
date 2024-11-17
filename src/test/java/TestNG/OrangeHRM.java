package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import javax.swing.*;
import java.time.Duration;

public class OrangeHRM {

    WebDriver driver;


    @Test(priority = 1)
    void openapp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Actions abs = new Actions(driver);
        abs.scrollByAmount(0,1000);



    }

    @Test(priority = 2)
    void capturelogo()
    {
        WebElement  logo = driver.findElement(By.xpath("//img[@ alt='company-branding']"));
        boolean isNotDisplayed = logo.isSelected();
        String title = driver.getTitle();

        boolean titleN = title.equals("hello");
        System.out.println(titleN);

    }


    @Test(priority = 3)
    void login() throws InterruptedException {

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        Thread.sleep(5000);


    }

    @Test(priority = 4)
    void logout()
    {

        driver.quit();

    }






}
