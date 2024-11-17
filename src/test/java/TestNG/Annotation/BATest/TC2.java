package TestNG.Annotation.BATest;

import org.testng.annotations.Test;

public class TC2 {

    @Test(priority = 2)
    void BB1()
    {
        System.out.println("This is from BB1");
    }

    @Test(priority = 3)
    void BB2()
    {
        System.out.println("This is from BB2");
    }

    @Test(priority = 1)
    void BB3()
    {
        System.out.println("This is from BB3");
    }
}
