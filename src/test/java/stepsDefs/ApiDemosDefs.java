package stepsDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.android.ApiDemosMainPage;
import pages.android.ApiDemosPage;
import pages.android.PreferenceDependenciesPage;
import pages.android.PreferenceMainPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class ApiDemosDefs {
    ApiDemosMainPage apiDemosMainPage = new ApiDemosMainPage();
    ApiDemosPage apiDemosPage= new ApiDemosPage();
    PreferenceMainPage preferenceMainPage = new PreferenceMainPage();
    PreferenceDependenciesPage preferenceDependenciesPage = new PreferenceDependenciesPage();

    @Given("open on the phone")
    public void openOnThePhone() {
        Driver.getAppiumDriver();
    }

    @And("click Api Demos button")
    public void clickApiDemosButton() {
        apiDemosMainPage.apiDemos.click();
    }

    @And("click Preference button")
    public void clickPreferenceButton() {
        apiDemosPage.preference.click();
    }

    @And("click Preference dependencies button")
    public void clickPreferenceDependenciesButton() {
        preferenceMainPage.preferenceDependencies.click();
    }

    @And("click checkbox icon")
    public void clickCheckboxIcon() {
        if (preferenceDependenciesPage.checkBox.getAttribute("checked").equals("false")) {
            preferenceDependenciesPage.checkBox.click();
        }
            System.out.println(preferenceDependenciesPage.checkBox.getAttribute("checked"));
        }

    @Then("check wifi settings is activated")
    public void checkWifiSettingsIsActivated() {
        preferenceDependenciesPage.wifiSettings.click();
        ReusableMethods.waitFor(2);
    }

    @And("close app")
    public void closeApp() {
        Driver.quitAppiumDriver();
    }
}
