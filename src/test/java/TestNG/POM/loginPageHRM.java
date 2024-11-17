package TestNG.POM;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPageHRM {

    WebDriver driver;

    // Constractor
    public  loginPageHRM(WebDriver driver)
    {
        this.driver =driver;

    }

    // Locators

    By userName_field = By.xpath("//input[@placeholder='Username']");
    By password_field = By.xpath("//input[@placeholder='Password']");
    By login_Button =  By.xpath("//button[normalize-space()='Login']");


    //Action

    public void setUserName (String userName)
    {
        driver.findElement(userName_field).sendKeys(userName);

    }

    public void setPassword (String password)
    {
        driver.findElement(password_field).sendKeys(password);

    }

    public void clickLoginButton()
    {
        driver.findElement(login_Button).click();
    }














}
