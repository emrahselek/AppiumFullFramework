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
       3- Typing "appium2" name to text box
       4- Click done
       5- Verify "appium2" name on the app
       6- Close the gesture app
     */

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:/Users/BelomeX/IdeaProjects/appiumfullFramework/app/gestureTool.apk");

        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);

        driver.findElementById("com.davemac327.gesture.tool:id/addButton").click();
        Thread.sleep(1000);
        driver.findElementById("com.davemac327.gesture.tool:id/gesture_name").sendKeys("appium2");
        Thread.sleep(1000);
        driver.findElementById("com.davemac327.gesture.tool:id/gestures_overlay").click();
        Thread.sleep(1000);
        driver.findElementById("com.davemac327.gesture.tool:id/done").click();
        Thread.sleep(1000);

        String expectedTitle = "appium2";
        Thread.sleep(1000);
        String actualTitle = driver.findElementByXPath("(//*[@text='appium2'])[1]").getText();
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
          "appium:app": "C:/Users/BelomeX/IdeaProjects/appiumfullFramework/app/gestureTool.apk"
        }

     */

    }
}