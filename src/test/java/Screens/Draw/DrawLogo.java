package Screens.Draw;

import PKG_Screens.drawSc;
import PKG_Screens.homeSc;
import PKG_Screens.loginSc;
import TestBase.TestBase;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

import static java.lang.Math.sqrt;

public class DrawLogo extends TestBase {

    @BeforeMethod
    public void initializer () {
        lSc = new loginSc(driver);
        hSc = new homeSc(driver);
        dSc = new drawSc(driver);
    }


    public void myDraw (){
        // Locate the element to drag

        // Get the starting location of the element
        int startX = 530; // Center X
        int startY = 940; // Center Y

        // Define the intermediate points for the drag path
        int[] pointsX = {170, 540, 910}; // X coordinates
        int[] pointsY = {1300, 1960, 1300}; // Y coordinates

        // Create a PointerInput object for the touch action
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        // Create a Sequence object to define the gesture

//        driver.perform(Collections.singletonList(drag));
       // double xincV = 1; //, xi   1 = 1 ,xi2=3;
        int yincV, yi1= 1 , yi2=1;
        int i = 0;
        // Move through the intermediate points
        for (int x=530, y =940  ; x >= pointsX[0] & y <= pointsY[0]; x-=0, y+=0 ) {
            Sequence drag = new Sequence(finger, 0);

            // Move to the starting point
            drag.addAction(finger.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), x, y));
            drag.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//            yincV = yi1 + yi2;
//            yi1 = yincV;
//            xincV = xi2 + xi1;
//            xi2 = xincV;

            double [] xincV = {-1, -0.75 , -0.5 , -0.25 , 0 , 0.25 , 0.5 , 0.75 , 1};
            x-= 360 * xincV[i];
            y+= 360 * sqrt(1 - Math.pow(xincV[i] , 2));
            i++;
            drag.addAction(finger.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), x, y));
            driver.perform(Arrays.asList(drag));

        }

//        drag.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//        driver.perform(Collections.singletonList(drag));
        //Move through the intermediate points
//        for (int x = pointsX[0], y = pointsY[0] ; x < pointsX[1] & y > pointsY[1]; x+=5, y+=10 ) {
//            drag.addAction(finger.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), pointsX[x], pointsY[y]));
//        }
//// Move through the intermediate points
//        for (int x = pointsX[1], y = pointsY[1] ; x < pointsX[2] & y > pointsY[2]; x+=5, y+=10 ) {
//            drag.addAction(finger.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), pointsX[x], pointsY[y]));
//        }

        // Release at the last point
//        drag.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//
//        // Perform the gesture
//        driver.perform(Arrays.asList(drag));
    }
//    public void myDraw2 (){
//        // Get the starting location of the element
//        int startX = 530; // Center X
//        int startY = 940; // Center Y
//
//        // Define the intermediate points for the drag path
//        int[] pointsX = {170, 540, 910}; // X coordinates
//        int[] pointsY = {1300, 1960, 1300}; // Y coordinates
//
//        int stepX = (targetX > startX) ? 5 : -5; // Move right if targetX > startX, else left
//        int stepY = (targetY > startY) ? 10 : -10; // Move down if targetY > startY, else up
//
//// Loop until the target point is reached
//        for (int x = startX, y = startY;
//             (stepX > 0 ? x < targetX : x > targetX) || (stepY > 0 ? y < targetY : y > targetY);
//             x += stepX, y += stepY) {
//
//            // Perform the drag action at the current (x, y) coordinates
//            new TouchAction(driver)
//                    .press(PointOption.point(x, y))
//                    .moveTo(PointOption.point(x + stepX, y + stepY))
//                    .release()
//                    .perform();
//
//            // Optional: Add a small delay to control the speed of the drag
//            try {
//                Thread.sleep(50); // 50ms delay
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }



    @Test
    public void webview () throws InterruptedException {
        lSc.standardUserLogin();
        hSc.openSideMenu();
        dSc.switchToWebview();
        //myDraw();
        dSc.drawLogo();
        dSc.drawSign();
    }

}
