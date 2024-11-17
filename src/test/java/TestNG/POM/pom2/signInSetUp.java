package TestNG.POM.pom2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class signInSetUp {

    WebDriver driver;

    signInSetUp (WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);  //mandotory



    }

    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement userField;
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordField;
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButton;



    @FindBy(tagName = "a")
    List<WebElement> tags ;




    public void setUsername (String UN)
    {
        userField.sendKeys(UN);
    }

    public void setPassword(String PSS)
    {
        passwordField.sendKeys(PSS);
    }


    public void clickLoginButton()
    {
        loginButton.click();
    }












}
