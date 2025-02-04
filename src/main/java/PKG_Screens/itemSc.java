package PKG_Screens;

import PKG_Actions.mobileActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class itemSc extends base {

    mobileActions act = new mobileActions();
    public itemSc(AppiumDriver driver) {
        super(driver);
    }
    @AndroidFindBy(accessibility = "test-Description" )
    private WebElement itemName;
    @AndroidFindBy(accessibility = "test-Price")
    private WebElement itemPrice;
    @AndroidFindBy(accessibility = "test-ADD TO CART")
    private WebElement addItemToCartBtn;


    public void addProductToCart(){
        act.scrollUntil("text", "ADD TO CART");
        addItemToCartBtn.click();
    }

    public float getProductPrice(){
        String x = itemPrice.getText();
        float currentPrice = act.extractInt(x);
        return currentPrice;
    }

    public String getProductName(){
        WebElement name = itemName.findElement(By.xpath(".//android.widget.TextView[1]"));
        String currentName = name.getText();
        System.out.println(currentName);
        return currentName;
    }

}
