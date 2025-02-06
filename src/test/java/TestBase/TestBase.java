package TestBase;

import PKG_GlobalDriver.appiumDriver;
import PKG_Screens.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class TestBase extends appiumDriver {

    public loginSc lSc;
    public homeSc hSc;
    public drawSc dSc;
    public itemSc iSc1;
    public cart cSc;
    public checkoutSc checkSc;
    public overViewSc oSc;


    @BeforeClass
    public void Caps() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

//        S.service = new AppiumServiceBuilder().withAppiumJS(new File("C:/Users/huabdelhafez/AppData/Roaming/npm/node_modules/appium/build/lib/main.js"))
//            .withIPAddress("http://127.0.0.1").usingPort(4723).build();
//
//        S.service.start();

        caps.setCapability("appium:platformName", "Android");

        caps.setCapability("appium:version", "14");


        caps.setCapability("appium:deviceName", "RK8W2000KQH");

        caps.setCapability("appium:appPackage", "com.swaglabsmobileapp");

        caps.setCapability("appium:appActivity", "com.swaglabsmobileapp.SplashActivity");

        caps.setCapability("appium:automationName", "UIAutomator2");

        // caps.setCapability("noReset", "true");

         driver = new AppiumDriver(new URL("http://127.0.0.1:4723"), caps);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        lSc = new loginSc(driver);

    }

    public List<HashMap<String,Object>> getJsonData (String dataPath) throws IOException {

        String jsonContent = FileUtils.readFileToString(new File(dataPath), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String,Object>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, Object>>>() {
        });
            return data;
    }



}
