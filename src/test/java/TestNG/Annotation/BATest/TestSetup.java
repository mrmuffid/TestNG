package TestNG.Annotation.BATest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestSetup {

    @AfterTest
    void logout()
    {
        System.out.println("This is afterTest...");
    }

    @BeforeTest
    void login()
    {
        System.out.println("This is BeforeTest...");
    }
}
