package Screens.Home;

import PKG_Screens.homeSc;
import PKG_Screens.loginSc;
import TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class SortProducts extends TestBase {


    @BeforeMethod
    public void initializer (){
        lSc = new loginSc(driver);
        hSc = new homeSc(driver);

    }
    @Test
    public void sortItemsByPriceAsc (){
        lSc.standardUserLogin();
        hSc.sortByPriceAsc();
        HashMap<String,Float> prices = hSc.compareItems();
        float p1 = prices.get("price1");
        float p2 = prices.get("price2");
        float p3 = prices.get("price3");
       Assert.assertTrue( p3 > p2 && p2 > p1);
       System.out.println("Lowest price: " + p1 +'\n'+"Highest price: " + p3 );
    }


}
