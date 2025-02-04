package Screens.Login;

import PKG_Screens.loginSc;
import TestBase.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LockedUserLogin extends TestBase {

    @BeforeMethod
    public void initializer (){
        lSc = new loginSc(driver);

    }
    @Test
    public void lockedOutLogin (){
        lSc.lockedOutUserLogin();
        boolean x = lSc.isErrorMessageDisplayed();
        WebElement e = lSc.setErrorMessage();
        Assert.assertEquals(x , true);
        Assert.assertTrue(e.isDisplayed());
    }

}
