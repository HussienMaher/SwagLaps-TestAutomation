package PKG_Locators;


import PKG_GlobalDriver.appiumDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class locators extends appiumDriver {

    public WebElement locator (String locatorType, String element) {

        WebElement locatedElement = null;

        switch (locatorType.toLowerCase()) {
            case "id":
                locatedElement = driver.findElement(By.id(element));
                break;
            case "accessibility id":
                locatedElement = driver.findElement(AppiumBy.accessibilityId(element));
                break;
            case "xpath":
                locatedElement = driver.findElement(By.xpath(element));
                break;
            case "class name":
                locatedElement = driver.findElement(By.className(element));
                break;
            case "name":
                locatedElement = driver.findElement(AppiumBy.name(element));
                break;
            default:
                System.out.println("Locator error");
        }
        return locatedElement;
    }

    public By locatedBY (String locatorType, String element) {

        By el = null;
        switch (locatorType.toLowerCase()) {
            case "id":
                el = By.id(element);
                break;
            case "accessibility id":
                el = AppiumBy.accessibilityId(element);
                break;
            case "xpath":
                el = By.xpath(element);
                break;
            case "class name":
                el = By.className(element);
                break;
            case "name":
                el = AppiumBy.name(element);
                break;
            default:
                System.out.println("Locator error");
        }

        return el;
    }
}
