package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium01_UnlockScreen {

    @Test
    public void test() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2"); //UiAutomator2 -> for android system
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");//whatever name you can use here
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");//check cellphone version. should be same

        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),desiredCapabilities);
//        AndroidDriver<AndroidElement> driver2 = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),desiredCapabilities);

        if (driver.isDeviceLocked()) {
            driver.unlockDevice();
        }


    }
}