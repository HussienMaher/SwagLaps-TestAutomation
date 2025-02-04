package PKG_Screens;

import PKG_Actions.mobileActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class homeSc extends base {

    mobileActions act = new mobileActions();

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-Item\"])[1]/android.view.ViewGroup/android.widget.ImageView")
        private WebElement firstItemCard;

        @AndroidFindBy(accessibility = "test-Menu")
        private WebElement sideMenu;
        @AndroidFindBy(accessibility = "test-Toggle")
        private WebElement listView;
        @AndroidFindBy(accessibility = "test-Modal Selector Button")
        private WebElement sort;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Price (low to high)\"]")
        private WebElement lowToHighPrice;
        @AndroidFindBy(accessibility = "test-Cart")
        private WebElement cart;

        String lowestPrice;
        String secondLowestPrice;
        String highestPrice;
        private int itemsCount;

        private int i;
        private float p1;
        private float p2;
        private float p3;

    public homeSc(AppiumDriver driver) {
        super(driver);
    }

        public void openCart(){
        cart.click();
        }

        public int countItems (){
        try {
            for ( i =2 ;i<10 ; i+=2){
                // i need to something that rest item 3 to rest to 1
                String product = "(//android.view.ViewGroup[@content-desc=\"test-Item\"])[" + i + "]";
              act.scrollUntil(driver1, product);
            }
        }catch (Exception e) {
                itemsCount = i;
            }
            return itemsCount;
        }

        public float extractInt (String text){
//            Pattern pattern = Pattern.compile("\\d+");
//            Matcher matcher = pattern.matcher(text);
//            List<Integer> n = new ArrayList<>();
//            while (matcher.find()) {
//                n.add(Integer.parseInt(matcher.group()));
//            }
//            int num = n.getFirst();
//            return num;
            String text1 = text.replaceAll("[^\\d.]", "");
            Float num = Float.parseFloat(text1);
            return num;
        }

        public int countByScroll (){
            float h1 = firstItemCard.getSize().getHeight();
            itemsCount = act.scrollByItemSize(h1, "down");

            return itemsCount;
        }

        public void openFirstProduct (){
        firstItemCard.click();
        }

        public drawSc openSideMenu (){
            sideMenu.click();
            return new drawSc(driver1);
        }

        public void changeToListView (){listView.click();}

        public void sortByPriceAsc (){
        changeToListView();
        sort.click();
        lowToHighPrice.click();
    }

        public HashMap<String, Float> compareItems (){
            Map<String,Float> prices = new HashMap<>();
        lowestPrice =  driver1.findElement(By.xpath("(//android.widget.TextView[@content-desc=\"test-Price\"])[1]")).getText();
        secondLowestPrice = driver1.findElement(By.xpath("(//android.widget.TextView[@content-desc=\"test-Price\"])[2]")).getText();
        p1 = extractInt(lowestPrice);
            prices.put("price1",p1);
        p2 = extractInt(secondLowestPrice);
            prices.put("price2",p2);
        act.scrollUntilEnd(driver1, "down");
        highestPrice = driver1.findElement(By.xpath("(//android.widget.TextView[@content-desc=\"test-Price\"])[2]")).getText();
        p3 = extractInt(highestPrice);
            prices.put("price3",p3);
        return (HashMap<String, Float>) prices;
        }


}
