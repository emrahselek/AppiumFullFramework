package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class Appium04_GestureToolApp {
     /*
       1- Run GestureTool app
       2- Click addGesture button
       3- Typing "testing manx" name to text box
       4- Click done
       5- Verify "testing manx" name on the app
       6- Close the gesture app
     */

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "D:/_QA_SDET/_TechProEd21/13-PROJECTs/appiumMan/appiumManProject/App/gestureTool.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);//(default value= false, if you don't use that code)
        // False means App.apk file on the framework to install on the phone again to again when we run the code.
        // True means just one time install apk file and then doesn't install again to again.



        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);

        driver.findElementById("com.davemac327.gesture.tool:id/addButton").click();
        Thread.sleep(1000);
        driver.findElementById("com.davemac327.gesture.tool:id/gesture_name").sendKeys("testing manx");
        Thread.sleep(1000);
        driver.findElementById("com.davemac327.gesture.tool:id/gestures_overlay").click();
        Thread.sleep(1000);
        driver.findElementById("com.davemac327.gesture.tool:id/done").click();
        Thread.sleep(1000);


        String expectedTitle = "testing manx";
        Thread.sleep(1000);
        String actualTitle = driver.findElementByXPath("(//*[@text='testing manx'])[1]").getText();
        Thread.sleep(1000);
        System.out.println(actualTitle);
        Thread.sleep(1000);
        Assert.assertEquals(actualTitle, expectedTitle);


    /*
        Appium inspector:
        {
          "appium:automationName": "UiAutomator2",
          "appium:platformName": "Android",
          "appium:deviceName": "AndroidEmulator",
          "appium:platformVersion": "8.0",
          "appium:app": "D:/_QA_SDET/_TechProEd21/13-PROJECTs/appiumMan/appiumManProject/App/gestureTool.apk"
        }

     */


    }
}
