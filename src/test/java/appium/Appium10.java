package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class Appium10 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:/Users/orcun/IdeaProjects/com.techproedjavaproject/App/apiDemos.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
        Thread.sleep(4000);

        //driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();

        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"API Demos\")").click();
        Thread.sleep(1000);
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        Thread.sleep(1000);
        driver.findElementByXPath("//android.widget.TextView[3]").click();
        Thread.sleep(1000);
        driver.findElementById("android:id/checkbox").click();
        Thread.sleep(1000);
        driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
        Thread.sleep(1000);
        driver.findElementById("android:id/edit").sendKeys("test");
        Thread.sleep(1000);
        driver.findElementById("android:id/button1").click();

    }
}
