package PKG_Screens;

import PKG_Actions.mobileActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class checkoutSc extends base {
    public checkoutSc(AppiumDriver driver) {
        super(driver);
    }

    mobileActions act = new mobileActions();
    @AndroidFindBy(accessibility = "test-First Name")
    private WebElement customerFirstName;
    @AndroidFindBy(accessibility = "test-Last Name")
    private WebElement customerLastName;
    @AndroidFindBy(accessibility = "test-Zip/Postal Code")
    private WebElement customerPostalCode;
    @AndroidFindBy(accessibility = "test-CANCEL")
    private WebElement cancelCheckout;
    @AndroidFindBy(accessibility = "test-CONTINUE")
    private WebElement continueCheckout;

    public void continueCheckout (String firstname, String lastName, String postalCode){
        act.enterText(customerFirstName,firstname);
        act.enterText(customerLastName,lastName);
        act.enterText(customerPostalCode,postalCode);
        act.tapbtn(continueCheckout);


    }


}
