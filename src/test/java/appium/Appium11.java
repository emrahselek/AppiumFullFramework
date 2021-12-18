package appium;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Appium11  extends AppiumBase {

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        AndroidDriver driver = androidDriver();
        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        Thread.sleep(1000);
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        Thread.sleep(1000);
        driver.findElementByXPath("//android.widget.TextView[3]").click();

        //check box a gore kosul
//        String isChecked = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").checkable(true)").getAttribute("checked");
//
//        if (isChecked.equals("false")) {
//            driver.findElementById("android:id/checkbox").click();
//            Thread.sleep(2000);
//        }

//Wifi Settings e gore yapilan
        List<MobileElement> list = driver.findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"WiFi settings\").enabled(false)");
        if (list.size() > 0) {
            String isEnabled = driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"WiFi settings\").enabled(false)").getAttribute("enabled");
            if (isEnabled.equals("false")) {
                driver.findElementById("android:id/checkbox").click();
            }

            driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
            Thread.sleep(1000);
            driver.findElementById("android:id/edit").sendKeys("test");
            Thread.sleep(1000);
            driver.findElementById("android:id/button1").click();
        }
    }
}

