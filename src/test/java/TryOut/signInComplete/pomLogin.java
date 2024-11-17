package TryOut.signInComplete;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class pomLogin {


    WebDriver driver;

    pomLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    @FindBy(xpath = ("//input[@placeholder='Username']"))
    WebElement userNameField;
    @FindBy(xpath = ("//input[@placeholder='Password']"))
    WebElement passwordField;
    @FindBy(xpath = ("//button[normalize-space()='Login']"))
    WebElement loginButton;


    public void setUserName(String userName) {
        userNameField.sendKeys(userName);
    }

    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton()
    {
        loginButton.click();
    }











}
