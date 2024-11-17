package TestNG.Annotation.BASuite;

import org.testng.annotations.*;

public class TC1 {


    @BeforeMethod
    void TC1_BeforeMethod()
    {
        System.out.println("This is TC1_BeforeMethod...");
    }

    @AfterMethod
    void TC1_AfterMethod ()
    {
        System.out.println("This is TC1_AfterMethod...");

    }

    @Test
    void BTC1_Search()
    {
        System.out.println("This is TC1_search Test...");

    }

    @Test(priority =1)
    void ATC1_AdvanceSearch()
    {
        System.out.println("This is TC1_advance Test...");
    }




}
