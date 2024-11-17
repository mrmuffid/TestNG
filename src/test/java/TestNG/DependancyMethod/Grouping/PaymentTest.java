package TestNG.DependancyMethod.Grouping;

import org.testng.annotations.Test;

public class PaymentTest {

    @Test(priority = 1, groups = {"sanity","regration","FB"})
    void facebookPayment()
    {
        System.out.println("This is Facebook Payment...");
    }
    @Test(priority = 2, groups = {"sanity","regration","insta"})
    void instaPayment()
    {
        System.out.println("This is Insta Payment...");
    }
    @Test(priority = 3, groups = {"sanity","regration"})
    void youtubePayment()
    {
        System.out.println("This is YouTube Payment...");


    }
}
