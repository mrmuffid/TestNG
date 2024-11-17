package TestNG.DependancyMethod;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependancyMethod {


    @Test(priority = 1)
    void openApp()
    {
        Assert.assertTrue(true);
    }

    @Test(priority = 2,dependsOnMethods = {"openApp"})
    void login()
    {
        Assert.assertTrue(true);
    }

    @Test(priority = 3,dependsOnMethods = {"openApp","login"})
    void search()
    {
        Assert.assertTrue(false);
    }
    @Test(priority = 4,dependsOnMethods = {"login","search"})
    void Advancesearch()
    {
        Assert.assertTrue(true);
    }

    @Test(priority = 5,dependsOnMethods = {"openApp","login"})
    void Logout()
    {
        Assert.assertTrue(true);
    }

}
