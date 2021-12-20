package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium03_Calculator_InstallAppFromAPKAppFiles {

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:/Users/BelomeX/IdeaProjects/appiumfullFramework/app/Calculator.apk");//It is just use for if we download apk file on pc and call them.
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        //(default value= false, if you don't use that code)
        // False means App.apk file on the framework to install on the phone again to again when we run the code.
        // True means just one time install apk file and then doesn't install again to again.

        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);

        driver.findElementById("com.google.android.calculator:id/digit_1").click();
        driver.findElementById("com.google.android.calculator:id/digit_2").click();
        driver.findElementById("com.google.android.calculator:id/digit_5").click();
        driver.findElementById("com.google.android.calculator:id/op_mul").click();
        Thread.sleep(1000);
        driver.findElementById("com.google.android.calculator:id/digit_1").click();
        driver.findElementById("com.google.android.calculator:id/digit_2").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();
        Thread.sleep(1000);

        String actualData = driver.findElementById("com.google.android.calculator:id/result_final").getText();
        String expectedData = "1500";
        Assert.assertEquals(actualData,expectedData);
//        driver.quit();


    /*
    Appium inspector:
    {
      "appium:automationName": "UiAutomator2",
      "appium:platformName": "Android",
      "appium:deviceName": "AndroidEmulator",
      "appium:platformVersion": "8.0",
      "appium:app": "C:/Users/BelomeX/IdeaProjects/appiumfullFramework/app/Calculator.apk"
    }

     */


    }
}
