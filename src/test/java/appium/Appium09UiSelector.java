package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Appium09UiSelector {

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:/Users/orcun/IdeaProjects/com.techproedjavaproject/App/gestureTool.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
        Thread.sleep(4000);

        //resourceId ile bulunan locator u cliklemek icin kullanilir
        //  driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\")").click();
        //classname
        // driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\")").click();
        //classname text ile beraber
        //driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"Add gesture\")").click();
        //classname index ile
//        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").index(1)").click();

//        List<MobileElement> buttons = driver.findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\")");
//        for (MobileElement button : buttons) {
//             if (button.getText().equals("Test")){
//                 button.click();
//                 break;
//             }
//        }

//        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").textContains(\"load\")").click();
//        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").textStartsWith(\"Te\")").click();

        System.out.println(driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\").checkable(false)").getAttribute("checkable")); //false
        System.out.println(driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\").clickable(true)").getAttribute("clickable")); //true
    }
}