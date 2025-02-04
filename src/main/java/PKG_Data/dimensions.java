package PKG_Data;

import PKG_Actions.waits;

import org.openqa.selenium.Dimension;

public class dimensions extends waits {

    public Dimension screenSize;
    public int height;
    public int width;



    public int getHeight(){
        return height = driver.manage().window().getSize().getHeight();
    };
    public int getWidth(){
        return width = driver.manage().window().getSize().getWidth();
    };
    public Dimension screenSize(){
        return screenSize = driver.manage().window().getSize();
    };



}
