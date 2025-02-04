package PKG_Actions;

import PKG_Locators.locators;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import java.time.Duration;

public class mobileActions extends mobileGestures {

    waits w8 = new waits();
    locators locate = new locators();
    public void tapbtn (WebElement e){
        e.click();
    }
    public void tapIfExist (String locatorType, String locatedElement) {
        try {
            w8.waitToBeVisibleAndClickable(locatorType, locatedElement);
            WebElement e = locate.locator(locatorType, locatedElement);
            e.click();
        } catch (NoSuchElementException e) {}
    };

    public void longPress (String locatorType, String locatedElement ){
        w8.waitToBeVisibleAndClickable(locatorType,locatedElement);
        WebElement e = locate.locator(locatorType , locatedElement);
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) e).getId() ) , "duration" , 2000);
    }

    public void enterText (String locatorType, String locatedElement , String text){
        w8.waitToBeVisibleAndClickable(locatorType,locatedElement);
        WebElement e = locate.locator(locatorType , locatedElement);
        e.clear();
        e.sendKeys(text);
    }
    public void enterText (WebElement e , String text){
        e.clear();
        e.sendKeys(text);
        driver.executeScript("mobile: hideKeyboard");
    }
    public void turnOnAirplaneMode() {
        // Cast AppiumDriver to AndroidDriver to use Android-specific methods
        AndroidDriver androidDriver = (AndroidDriver) driver;


        androidDriver.toggleAirplaneMode();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        androidDriver.toggleAirplaneMode();
    }
    public void switchToWebview() {
        // Java
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "startX",500,
                "startY",700,
                "endX", 500,
                "endY", 1200
        ));
        }
        public boolean isVisible(WebElement e){
        boolean x = e.isDisplayed();
        return x;
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


}
