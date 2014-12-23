package com.mobile.automation;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by srikanthvejendla on 12/23/14.
 */
public class LaunchAppOnSauce {

    public static void main(String[] args) throws Exception{
        //To Upload the apk file to sauce cloud
        //curl -u qa2322:2e34b9de-7fb9-48da-8bcc-505471db6d6e -X POST "http://saucelabs.com/rest/v1/storage/qa2322/flickr.apk?overwrite=true" -H "Content-Type: application/octet-stream" --data-binary @flickr.apk
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability("appiumVersion","1.3.4");
        capabilities.setCapability("app","sauce-storage:flickr.apk");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","4.2");
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("deviceType","phone");
        capabilities.setCapability("appActivity","com.yahoo.mobile.client.android.flickr.ui.misc.LoginActivity");
        capabilities.setCapability("appPackage","com.yahoo.mobile.client.android.flickr");

        RemoteWebDriver driver=new RemoteWebDriver(new URL("http://qa2322:2e34b9de-7fb9-48da-8bcc-505471db6d6e@ondemand.saucelabs.com:80/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(5000);
        driver.quit();
    }
}
