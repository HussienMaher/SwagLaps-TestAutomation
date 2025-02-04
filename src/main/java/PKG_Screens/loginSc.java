package PKG_Screens;

import PKG_Actions.mobileActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class loginSc extends base {

    mobileActions act = new mobileActions();


    public loginSc(AppiumDriver driver) {
        super(driver);
    }
    @AndroidFindBy(accessibility = "test-standard_user")
//    @iOSXCUITFindBy(accessibility = "test-standard_user")
    private WebElement standardUser;

    @AndroidFindBy(accessibility = "test-locked_out_user")
    private WebElement lockedOutUser;

    @AndroidFindBy(accessibility = "test-problem_user")
    private WebElement problemUser;

    @AndroidFindBy(accessibility = "test-LOGIN")
//    @iOSXCUITFindBy(accessibility = "test-LOGIN")
    private WebElement loginBtn;
    @AndroidFindBy(accessibility = "test-Error message")
    private WebElement loginErrorMessage;



    public void standardUserLogin ( ){
        act.waitToBeVisibleAndClickable("accessibility id", "test-LOGIN");
        act.scrollUntilEnd(driver1,"down");
        act.tapbtn(standardUser);
        act.tapbtn(loginBtn);
//        return new homeSc(driver1);
    }
    public void lockedOutUserLogin ( ){
        act.waitToBeVisibleAndClickable("accessibility id", "test-LOGIN");
        act.scrollUntilEnd(driver1,"down");
        act.tapbtn(lockedOutUser);
        act.tapbtn(loginBtn);
    }
    public void problemUserLogin ( ){
        act.waitToBeVisibleAndClickable("accessibility id", "test-LOGIN");
        act.scrollUntilEnd(driver1,"down");
        act.tapbtn(problemUser);
        act.tapbtn(loginBtn);
//        return new homeSc(driver1);
    }
    public boolean isErrorMessageDisplayed (){
        boolean x = act.isVisible(loginErrorMessage);
        return x;
    }
    public WebElement setErrorMessage (){
       WebElement e =loginErrorMessage;
        return e;
    }


}
