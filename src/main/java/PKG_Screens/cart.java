package PKG_Screens;

import PKG_Actions.mobileActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class cart extends base {
    mobileActions act = new mobileActions();
    public cart(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "test-Description")
    private WebElement addedProductName;
    @AndroidFindBy(accessibility = "test-Price")
    private WebElement addedProductPrice;
    @AndroidFindBy(accessibility = "test-CHECKOUT")
    private WebElement checkout;

    public String getAddedProductName(){
//        WebElement parent2 = driver1.findElement(AppiumBy.accessibilityId("test-Description"));
        act.waitToBeVisible("accessibility id","test-Description");
        WebElement name2 = addedProductName.findElement(By.xpath(".//android.widget.TextView[1]"));
        String currentName = name2.getText();
        System.out.println(currentName);
        return currentName;
    }

    public float getAddedProductPrice(){
        WebElement parent3 = driver1.findElement(AppiumBy.accessibilityId("test-Price"));
        WebElement price = parent3.findElement(By.xpath(".//android.widget.TextView[1]"));
        String x = price.getText();
        float currentPrice = act.extractInt(x);
        System.out.println(currentPrice);
        return currentPrice;
    }
    public void checkout (){
        checkout.click();
    }


}
