package TestNG.Annotation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BAclass {

    @BeforeClass
    void login()
    {
        System.out.println("This is loging...");
    }


    @AfterClass
    void logout ()
    {
        System.out.println("This is Logout...");

    }

    @Test(priority = 1)
    void Search()
    {
        System.out.println("This is search...");

    }

    @Test(priority = 2 )
    void AdvanceSearch()
    {
        System.out.println("This is advance search...");
    }
}
