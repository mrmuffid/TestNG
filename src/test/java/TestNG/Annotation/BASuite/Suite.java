package TestNG.Annotation.BASuite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Suite {

    @BeforeSuite
    void suite ()
    {
        System.out.println("This is BeforeSuite...");
    }

    @AfterSuite
    void ASuite()
    {
        System.out.println("This is afterSuite...");
    }

}
