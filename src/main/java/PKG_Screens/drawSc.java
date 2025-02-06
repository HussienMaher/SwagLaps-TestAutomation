package PKG_Screens;

import PKG_Actions.mobileActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

import static PKG_GlobalDriver.appiumDriver.driver;

public class drawSc extends base {

    mobileActions act = new mobileActions();

    public drawSc (AppiumDriver driver1){
        super(driver1);
    }

    int centerX = 540;
    int centerY = 1319;
    int radius = 360;
    @AndroidFindBy(accessibility = "test-DRAWING")
    private WebElement drawEntryPoint;



    public void openDrawingScreen (){
    drawEntryPoint.click();
    }


    public void switchToWebview () throws InterruptedException {
        openDrawingScreen();
        Thread.sleep(3000);
        //act.switchToWebview();
    }
    public void drawLogo (){

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence draw = new Sequence(finger, 0);

        int startX = centerX + radius;
        int startY = centerY;

        draw.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        draw.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        for (int x = radius; x >= -360; x -= 15) {
            int y = (int) Math.sqrt(Math.pow(radius, 2) - Math.pow(x, 2));
            draw.addAction(finger.createPointerMove(Duration.ofMillis(50), PointerInput.Origin.viewport(), centerX + x, centerY - y));
        }
//        for (int y = radius; y >= 0; y -= 15) {
//            int x = -(int) Math.sqrt(Math.pow(radius, 2) - Math.pow(y, 2));
//            draw.addAction(finger.createPointerMove(Duration.ofMillis(50), PointerInput.Origin.viewport(), centerX + x, centerY - y));
//        }
        for (int x = -radius; x <= 360; x += 15) {
            int y = (int) Math.sqrt(Math.pow(radius, 2) - Math.pow(x, 2));
            draw.addAction(finger.createPointerMove(Duration.ofMillis(50), PointerInput.Origin.viewport(), centerX + x, centerY + y));
        }
//        for (int y = -radius; y <= 0; y += 15) {
//            int x = (int) Math.sqrt(Math.pow(radius, 2) - Math.pow(y, 2));
//            draw.addAction(finger.createPointerMove(Duration.ofMillis(50), PointerInput.Origin.viewport(), centerX + x, centerY - y));
//        }



        draw.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver1.perform(Collections.singletonList(draw));


    }
    public void drawSign (){
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence draw = new Sequence(finger, 0);

        int radius2 = 285;
        int [] xPoints = { 490, 370, 700, 380, 730,600, 820};
        int [] yPoints = { 1412, 1655, 1320, 1320, 962,1227, 1227};

        draw.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), centerX, centerY - radius2));
        draw.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        for (int y = radius2; y >= -100; y -= 10) {
            int x = -(int) Math.sqrt(Math.pow(radius2, 2) - Math.pow(y, 2));
            draw.addAction(finger.createPointerMove(Duration.ofMillis(50), PointerInput.Origin.viewport(), centerX + x, centerY - y));
        }
        for (int i = 0; i < xPoints.length; i++ ) {
            draw.addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), xPoints[i], yPoints[i]));
        }
        for (int x = radius2; x >= -70; x -= 10) {
            int y = (int) Math.sqrt(Math.pow(radius2, 2) - Math.pow(x, 2));
            draw.addAction(finger.createPointerMove(Duration.ofMillis(50), PointerInput.Origin.viewport(), centerX + x, centerY + y));
        }
        draw.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver1.perform(Collections.singletonList(draw));


    }


    public void drawQuarterCircle1() {


        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence draw = new Sequence(finger, 0);

        int startX = centerX + radius;
        int startY = centerY;

        draw.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        draw.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        for (int x = radius; x >= 0; x -= 4) {
            int y = (int) Math.sqrt(Math.pow(radius, 2) - Math.pow(x, 2));
            draw.addAction(finger.createPointerMove(Duration.ofMillis(50), PointerInput.Origin.viewport(), centerX + x, centerY - y));
        }

//        draw.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver1.perform(Collections.singletonList(draw));
    }
    public void drawQuarterCircle2() {


        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence draw = new Sequence(finger, 0);

        int startX = centerX;
        int startY = centerY - radius;

//        draw.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
//        draw.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        for (int y = radius; y >= 0; y -= 4) {
            int x = -(int) Math.sqrt(Math.pow(radius, 2) - Math.pow(y, 2));
            draw.addAction(finger.createPointerMove(Duration.ofMillis(50), PointerInput.Origin.viewport(), centerX + x, centerY - y));
        }

//        draw.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver1.perform(Collections.singletonList(draw));
    }
    public void drawQuarterCircle3() {


        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence draw = new Sequence(finger, 0);

        int startX = centerX - radius;
        int startY = centerY;

//        draw.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
//        draw.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        for (int x = -radius; x <= 0; x += 4) {
            int y = (int) Math.sqrt(Math.pow(radius, 2) - Math.pow(x, 2));
            draw.addAction(finger.createPointerMove(Duration.ofMillis(50), PointerInput.Origin.viewport(), centerX + x, centerY + y));
        }

//        draw.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver1.perform(Collections.singletonList(draw));
    }
    public void drawQuarterCircle4() {


        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence draw = new Sequence(finger, 0);

        int startX = centerX;
        int startY = centerY + radius;

//        draw.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
//        draw.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        for (int y = -radius; y <= 0; y += 4) {
            int x = (int) Math.sqrt(Math.pow(radius, 2) - Math.pow(y, 2));
            draw.addAction(finger.createPointerMove(Duration.ofMillis(50), PointerInput.Origin.viewport(), centerX + x, centerY - y));
        }

//        draw.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver1.perform(Collections.singletonList(draw));
    }







}
