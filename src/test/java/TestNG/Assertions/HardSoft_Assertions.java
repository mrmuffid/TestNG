package TestNG.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardSoft_Assertions {


    @Test
    void testHardAssertion()
    {
        String exp_title = "Openshop";
        String act_title = "Openshops ";

        System.out.println("Hello HardAssersion before...");
        Assert.assertEquals(exp_title,act_title);
        System.out.println("Hello HardAssersion after...");
    }

    @Test
    void testSoftAssertion()
    {
        String exp_title = "Openshop";
        String act_title = "Openshops ";

        SoftAssert SA = new SoftAssert();

        SA.assertEquals(exp_title,act_title);
        System.out.println("Hello SoftAssersion...");

        SA.assertAll();   //mendotry to use when we use softassert
    }
}
