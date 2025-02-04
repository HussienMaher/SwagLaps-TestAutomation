package PKG_Screens;

import PKG_Actions.mobileActions;
import PKG_Actions.mobileGestures;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class base {

    loginSc lSc;
    homeSc hSc;
    drawSc dSc;

    public AppiumDriver driver1;
    public base(AppiumDriver driver) {
        this.driver1 = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver1), this);
    }






}
