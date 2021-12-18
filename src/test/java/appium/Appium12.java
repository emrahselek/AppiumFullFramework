package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.List;

public class Appium12 extends AppiumBase{

    @Test
    public void test () throws MalformedURLException, InterruptedException {

        AndroidDriver driver = androidDriver();

        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        Thread.sleep(1000);
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        Thread.sleep(1000);
        driver.findElementByXPath("//android.widget.TextView[@text='5. Preferences from code']").click();
        Thread.sleep(1000);

//        driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").index(0).checked(false)").click();
//        Thread.sleep(3000);
//        driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").index(0).checked(false)").click();
//        Thread.sleep(3000);
//        driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").index(0).checked(false)").click();

        List <MobileElement> checkBox = driver.findElementsByXPath("(//android.widget.CheckBox)[1]");
        System.out.println(checkBox.size());
        System.out.println(checkBox.get(0).getAttribute("checked")); //check kutusunun tik isaretinin olup olmadigina bakiyoruz. false ise click degildir true ise clicktir bundan sonra if condition yaziyoru

        if(checkBox.get(0).getAttribute("checked").equals("false")){
            checkBox.get(0).click();
        }else {
            Assert.assertEquals(checkBox.get(0).getAttribute("checked"),"true");
        }

    }
}



