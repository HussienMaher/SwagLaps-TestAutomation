package Screens.Home;

import PKG_Actions.waits;
import PKG_Screens.homeSc;
import PKG_Screens.loginSc;
import TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CountProdcutCards extends TestBase {

    @BeforeMethod
    public void initializer (){
        lSc = new loginSc(driver);
        hSc = new homeSc(driver);

    }
    @Test
    public void getItemsCount (){
        lSc.standardUserLogin();
        int i = hSc.countByScroll();
        Assert.assertEquals(i,6);
        System.out.println("Items count = " + i);

    }

}
