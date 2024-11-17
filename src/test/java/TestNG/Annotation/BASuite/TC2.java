package TestNG.Annotation.BASuite;

import org.testng.annotations.*;

public class TC2 {

    @BeforeClass
    void beforeclass()
    {
        System.out.println("This is beforeclass...");
    }
    @AfterClass
    void afterclass()
    {
        System.out.println("This is afterclass...");
    }

    @BeforeMethod
    void TC2_BeforeMethod()
    {
        System.out.println("This is TC2_BeforeMethod...");
    }

    @AfterMethod
    void TC2_AfterMethod()
    {
        System.out.println("This is TC2_AfterMethod...");

    }

    @Test(priority = 1)
    void TC2_Search()
    {
        System.out.println("This is TC2_search Test...");

    }

    @Test(priority = 2 )
    void TC2_AdvanceSearch()
    {
        System.out.println("This is TC2_advance Test...");
    }




}
