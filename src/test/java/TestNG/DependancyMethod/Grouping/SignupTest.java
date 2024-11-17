package TestNG.DependancyMethod.Grouping;

import org.testng.annotations.Test;

public class SignupTest {

    @Test(priority = 1, groups = {"regration","FB"})
    void facebookSignup()
    {
        System.out.println("This is Facebook Signup...");
    }
    @Test(priority = 2, groups = {"regration","insta"})
    void instaSignup()
    {
        System.out.println("This is Insta Signup...");
    }
    @Test(priority = 3, groups = {"regration"})
    void youtubeSignup()
    {
        System.out.println("This is YouTube Signup...");
    }
}
