package TestNG.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion {


    @Test(priority = 1)
    void testTile()
    {
        System.out.println("priority = 1");
        String exp_title = "Openshop";
        String act_title = "Openshops ";

        Assert.assertEquals(exp_title,act_title);

        System.out.println("Hello");

    }

    @Test
    void testTiles()
    {
        System.out.println("priority = 0");
        String exp_title = "Openshop";
        String act_title = "Openshop";

        Assert.assertEquals(exp_title,act_title);

    }

    @Test(priority = 3)
    void testTielex()
    {
        String exp_title = "Openshop";
        String act_title = "Openshopx";



        if (exp_title.equals(act_title))
        {
            System.out.println("Test Passed");
            Assert.assertTrue(true);
        }
        else
        {
            System.out.println("Test Failed");
            Assert.assertTrue(false);
        }
    }




}
