package PKG_Actions;

import PKG_Data.dimensions;
import PKG_Locators.locators;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class mobileGestures extends waits {

    dimensions dim = new dimensions();
    waits w8 = new waits();
    locators locate = new locators();
    public void scrollUntil(AppiumDriver driver, String dyniamicXpath) {
//        while (true) {
            WebElement e1;
            try {
                try {
                    e1 = driver.findElement(By.xpath(dyniamicXpath));
                } catch (NoSuchElementException a) {
                    e1 = null;
                }
//                if (e1 != null) {
//                    break;
//                }
            }
            catch (Exception ignored) {
                }
                //boolean canScrollMore;
                Map<String, Object> params = new HashMap<>();
                params.put("left", 100);
                params.put("top", 100);
                params.put("width", 200);
                params.put("height", 200);
                params.put("direction", "down");
                params.put("percent", 3);
//                do {
                    ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", params);
                   // canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", params);
//                }
                //while (canScrollMore);
            }
//        }
    public int scrollByItemSize (float h1 , String dir){
        dim.screenSize();
        int x =0;
        float s = h1/dim.screenSize.height;
        boolean canScrollMore1;
        Map<String, Object> params = new HashMap<>();
        params.put("left", dim.screenSize.width /4);
        params.put("top", dim.screenSize.height /4);
        params.put("width", dim.screenSize.width /2 );
        params.put("height", h1);
        params.put("direction", dir);
        params.put("percent",1);
        params.put("speed",1500);


        do {
            canScrollMore1 = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", params);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            x ++;
        } while (canScrollMore1);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return x*2;
    }


    public void scrollUntil(String locatedEle){

                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                                ".setAsVerticalList().scrollForward()" +
                                ".scrollIntoView(new UiSelector().resourceId(\"" + locatedEle + "\"))"
                ));

    }
    public void scrollUntil(String locatorType, String elementlocator) {
        switch (locatorType.toLowerCase()) {
            case "accessibility id":
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).setSwipeDeadZonePercentage(0.3).scrollIntoView(new UiSelector().description(\""+ elementlocator +"\"));"
                ));
            case "resource id":
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                                ".setAsVerticalList().scrollForward()" +
                                ".setSwipeDeadZonePercentage(0.3).scrollIntoView(new UiSelector().resourceId(\"" + elementlocator + "\"))"
                ));
                break;
            case "text":
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                                ".setAsVerticalList().scrollForward()" +
                                ".setSwipeDeadZonePercentage(0.3).scrollIntoView(new UiSelector().textContains(\"" + elementlocator + "\"))"
                ));
                break;
            case "class name":
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                                ".setAsVerticalList().scrollForward()" +
                                ".setSwipeDeadZonePercentage(0.3).scrollIntoView(new UiSelector().className(\"" + elementlocator + "\"))"
                ));
                break;

            default:
                System.out.println("scroll error");
        }
    }

    public void scrollUntil(String locatorType, String elementlocator , int index){
        switch (locatorType.toLowerCase()) {
            case "resource id":
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                                ".setAsVerticalList().scrollForward()" +
                                ".scrollIntoView(new UiSelector().resourceId(\"" + elementlocator + "\").instance("+ index +"))"
                ));
                break;
            case "text":
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                                ".setAsVerticalList().scrollForward()" +
                                ".scrollIntoView(new UiSelector().text(\"" + elementlocator + "\").instance("+ index +"))"
                ));                break;
            case "class name":
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                                ".setAsVerticalList().scrollForward()" +
                                ".scrollIntoView(new UiSelector().className(\"" + elementlocator + "\").instance("+ index +"))"
                ));                break;

            default:
                System.out.println("scroll error");
        }
    }
    public void scrollUntil(String locatorType, String resourceId , String className){
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                        ".setAsVerticalList().scrollForward()" +
                        ".scrollIntoView(new UiSelector().resourceId(\"" + resourceId + "\").className(\"" + className + "\"))"
        ));
    }
    public void scrollUntil(String locatorType, String resourceId , String className, int index){
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                        ".setAsVerticalList().scrollForward()" +
                        ".scrollIntoView(new UiSelector().resourceId(\"" + resourceId + "\").className(\"" + className + "\").instance("+ index +"))"
        ));
    }

    public void scrollUntilEnd (AppiumDriver driver, String direction) {
        boolean canScrollMore;
        Map<String, Object> params = new HashMap<>();
        params.put("left", 300);
        params.put("top", 600);
        params.put("width", 200);
        params.put("height", 500);
        params.put("direction", direction);
        params.put("percent", 1);
        params.put("speed",1500);
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", params);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        } while (canScrollMore);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    //Swipe ----------------------------------------------------


    public void swipeto (String locatorType, String locatedElement , String direction) {
        w8.waitToBeVisibleAndClickable(locatorType, locatedElement);
        WebElement e = locate.locator(locatorType, locatedElement);
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) e).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }
    public void swipeUntil (String locatorType, String elementLocator){

        switch (locatorType.toLowerCase()) {
            case "resource id":
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                                ".setAsHorizontalList().scrollForward()" +
                                ".scrollIntoView(new UiSelector().resourceId(\"" + elementLocator + "\"))"
                ));
                break;
            case "text":
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                                ".setAsHorizontalList().scrollForward()" +
                                ".scrollIntoView(new UiSelector().text(\"" + elementLocator + "\"))"
                ));                break;
            case "class name":
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                                ".setAsHorizontalList().scrollForward()" +
                                ".scrollIntoView(new UiSelector().className(\"" + elementLocator + "\"))"
                ));                break;

            default:
                System.out.println("swipe error");
        }
    }
    public void swipeUntil(String locatorType, String elementlocator , int index){
        switch (locatorType.toLowerCase()) {
            case "resource id":
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                                ".setAsHorizontalList().scrollForward()" +
                                ".scrollIntoView(new UiSelector().resourceId(\"" + elementlocator + "\").instance("+ index +"))"
                ));
                break;
            case "text":
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                                ".setAsHorizontalList().scrollForward()" +
                                ".scrollIntoView(new UiSelector().text(\"" + elementlocator + "\").instance("+ index +"))"
                ));                break;
            case "class name":
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                                ".setAsHorizontalList().scrollForward()" +
                                ".scrollIntoView(new UiSelector().className(\"" + elementlocator + "\").instance("+ index +"))"
                ));                break;

            default:
                System.out.println("swipe error");
        }
    }
    public void swipeUntil(String locatorType, String resourceId , String className){
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                        ".setAsHorizontalList().scrollForward()" +
                        ".scrollIntoView(new UiSelector().resourceId(\"" + resourceId + "\").className(\"" + className + "\"))"
        ));
    }
    public void swipeUntil(String locatorType, String resourceId , String className, int index){
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                        ".setAsHorizontalList().scrollForward()" +
                        ".scrollIntoView(new UiSelector().resourceId(\"" + resourceId + "\").className(\"" + className + "\").instance("+ index +"))"
        ));
    }




}
