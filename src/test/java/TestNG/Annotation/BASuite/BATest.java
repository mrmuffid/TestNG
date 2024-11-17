package TestNG.Annotation.BASuite;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BATest {


    @BeforeTest
    void beforeTest()
    {
        System.out.println("This is beforeTest");
    }

    @AfterTest
    void AfterTest()
    {
        System.out.println("This is afterTest");
    }


}
