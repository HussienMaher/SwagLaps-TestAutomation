package Screens.Login;

import PKG_Screens.loginSc;
import TestBase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StandredUserLogin extends TestBase {


   @BeforeMethod
    public void initializer (){
       lSc = new loginSc(driver);

   }

    @Test
    public void Login() {

        lSc.standardUserLogin();
    }

}
