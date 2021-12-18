package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class Appium02_OpenAppExistOnPhone {

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");

        desiredCapabilities.setCapability("appPackage", "com.seslisozluk");
        desiredCapabilities.setCapability("appActivity", "com.seslisozluk.activities.MainActivity");

//        desiredCapabilities.setCapability("appPackage","com.ted.android");
//        desiredCapabilities.setCapability("appActivity","com.ted.android.MainActivity");
//        desiredCapabilities.setCapability("appPackage","com.newsinlevels");
//        desiredCapabilities.setCapability("appActivity","com.english_news_in_levels.MainActivity");

        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);


 /*
    1-For Exist aplication on your cell phone, You can do Command Prompt and type: C:\Users\BelomeX>
      adb shell
      dumpsys window | grep -E "mCurrentFocus"
      dumpsys window windows | grep -E 'mCurrentFocus'
      mCurrentFocus=Window{96cdbcd u0 com.seslisozluk/com.seslisozluk.activities.MainActivity}

    2-Check the device connection, You can do Command Prompt and type: C:\Users\BelomeX>
      adb devices

    3-Appium Inspector:
      {
      "appium:automationName": "UiAutomator2",
      "appium:platformName": "Android",
      "appium:deviceName": "AndroidEmulator",
      "appium:platformVersion": "8.0",
      "appium:appPackage": "com.seslisozluk",
      "appium:appActivity": "com.seslisozluk.activities.MainActivity"
       }
*/
    }
}
