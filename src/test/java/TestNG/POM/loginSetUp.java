package TestNG.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class loginSetUp {
    WebDriver driver;

    public void setUp()
    {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }

    public  void tearDown ()
    {
        if (driver!=null)
        {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }


}
