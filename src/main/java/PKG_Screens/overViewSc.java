package PKG_Screens;

import PKG_Actions.mobileActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class overViewSc extends base{
    public overViewSc(AppiumDriver driver) {
        super(driver);
    }
    mobileActions act = new mobileActions();

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Item total:')]")
    private WebElement itemTotal;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Tax:')]")
    private WebElement tax;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Total:')]")
    private WebElement total;
    @AndroidFindBy(accessibility = "test-FINISH")
    private WebElement completeCheckoutBtn;
    private float pItem;
    private float pTax;
    private float pTotal;

    public void scrollToCTA (){
        act.scrollUntil("text", "CANCEL");
    }
    public HashMap<String,Float> getPriceDetails (){
        Map<String,Float> prices = new HashMap<>();
        pItem = act.extractInt(itemTotal.getText());
        prices.put("itemPrice",pItem);
        pTax = act.extractInt(tax.getText());
        prices.put("tax",pTax);
        pTotal = act.extractInt(total.getText());
        prices.put("total",pTotal);
        return (HashMap<String, Float>) prices;
    }
    public float calTax () {
        float taxCal = (float) (act.extractInt(itemTotal.getText()) / 12.48);
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        float taxVal = Float.parseFloat(df.format(taxCal));
        System.out.println(" calcualted tax: " + taxVal);
        return taxVal ;
    }
    public void completeCheckout (){
        act.tapbtn(completeCheckoutBtn);
    }

}
