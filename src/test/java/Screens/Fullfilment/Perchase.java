package Screens.Fullfilment;

import PKG_Screens.*;
import TestBase.TestBase;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Perchase extends TestBase {


    @BeforeMethod
    public void initializer (){
        lSc = new loginSc(driver);
        hSc = new homeSc(driver);
        iSc1 = new itemSc(driver);
        cSc = new cart(driver);
        checkSc = new checkoutSc(driver);
        oSc = new overViewSc(driver);
    }
    public List<HashMap<String, Object>> checkoutData () throws IOException {
        List<HashMap<String,Object>> userData = getJsonData(System.getProperty("user.dir")+"//src//test//resources//Data//checkoutData.json");


        return userData;
    }

    @Test(dataProvider = "checkoutData")
    public void getItemsCount (){

        lSc.standardUserLogin();
        hSc.openFirstProduct();
        String productName = iSc1.getProductName();
        float productPrice = iSc1.getProductPrice();
        iSc1.addProductToCart();
        hSc.openCart();
        String productNameInCart = cSc.getAddedProductName();
        float productPriceInCart = cSc.getAddedProductPrice();
        Assert.assertEquals(productNameInCart,productName);
        Assert.assertEquals(productPriceInCart,productPrice);
        cSc.checkout();
        checkSc.continueCheckout("Hussein","Maher","11111");
        oSc.scrollToCTA();
        HashMap<String,Float> finalPrices = oSc.getPriceDetails();
        float itemPrice = finalPrices.get("itemPrice");
        float tax = finalPrices.get("tax");
        float total = finalPrices.get("total");
        float taxVal = oSc.calTax();
        Assert.assertEquals(taxVal, tax);
        Assert.assertEquals(total , itemPrice + tax);
        oSc.completeCheckout();
    }



}
