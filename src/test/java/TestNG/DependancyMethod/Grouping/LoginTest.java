package TestNG.DependancyMethod.Grouping;

import org.testng.annotations.Test;

public class LoginTest {

    @Test(priority = 1, groups = {"sanity","FB"})
    void facebookLogin()
    {
        System.out.println("This is Facebook Login...");
    }
    @Test(priority = 2, groups = {"sanity","insta"})
    void instaLogin()
    {
        System.out.println("This is Insta Login...");
    }
    @Test(priority = 3, groups = {"sanity"})
    void youtubeLogin()
    {
        System.out.println("This is YouTube Login...");
    }



}
