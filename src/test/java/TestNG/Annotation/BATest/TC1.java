package TestNG.Annotation.BATest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC1 {

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



    @Test(priority = 2)
    void AA1()
    {
        System.out.println("This is from AA1");
    }

    @Test(priority = 3)
    void AA2()
    {
        System.out.println("This is from AA2");
    }

    @Test(priority = 1)
    void AA3()
    {
        System.out.println("This is from AA3");
    }


}
