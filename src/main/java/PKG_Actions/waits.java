package PKG_Actions;

import PKG_Locators.locators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class waits extends locators {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(65));
    public void waitToBeVisibleAndClickable (String locatorType , String locatedElement){
        wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOfElementLocated(locatedBY(locatorType,locatedElement)), ExpectedConditions.elementToBeClickable(locatedBY(locatorType, locatedElement))));
    }
    public void waitToBeClickable (String locatorType , String locatedElement){
        wait.until(ExpectedConditions.elementToBeClickable(locatedBY(locatorType,locatedElement)));
    }
    public void waitToBeVisible (String locatorType, String locatedElement) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locatedBY(locatorType,locatedElement)));
    }
    public void waitToBeInvisible (String locatorType ,String locatedElement) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locatedBY(locatorType,locatedElement)));
    }
    public void waitTextToBeVisible (String locatorType, String locatedElement, String text){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locatedBY(locatorType,locatedElement),text));
    }
    public void impWait (int sec){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
    }


}
