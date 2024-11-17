package TestNG;

import org.testng.annotations.Test;

public class practice {


    @Test(priority = 0)
    void Aprioritytest()
    {
        System.out.println("This is 1");
    }

    @Test(priority = 3)
    void Bprioritytest()
    {
        System.out.println("This is 2");
    }

    @Test(priority = 1)
    void CpriorityTest()
    {
        System.out.println("This is 3");
    }




}
