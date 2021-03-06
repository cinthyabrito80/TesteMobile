package support;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import io.appium.java_client.MobileDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import support.interfaces.MobileApplication;

public enum Capabilities implements MobileApplication {

    ANDROID {
        @Override
        public AppiumDriver<MobileElement> getDriver() {
            return getDriver(getCapabilitiesAndroid());
        }
    },

    IOS {
        @Override
        public AppiumDriver<MobileElement> getDriver() {
            return getDriver(getCapabilitiesIos());
        }
    };

    private AppiumDriver<MobileElement> driver;

    @Override
    public AppiumDriver<MobileElement> getDriver(DesiredCapabilities caps) {
        driver = new AppiumDriver<MobileElement>(caps);
        return driver;
    }

    private static DesiredCapabilities getCapabilitiesAndroid() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(Runtime.getRuntime()
                    .exec(new String[]{"/bin/bash", "-l", "-c", "adb get-serialno"}).getInputStream());
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        String deviceSerialNumber = (scanner != null && scanner.hasNext()) ? scanner.next() : "";
        scanner.close();

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("noReset", "true");
        caps.setCapability("autoGrantPermission", "true");
        caps.setCapability("deviceName", "26d5ebb81a217ece");
        caps.setCapability("platformName", "Android");
        caps.setCapability("udid", deviceSerialNumber);
        caps.setCapability("appPackage", "br.com.sbf.centauro");
        caps.setCapability("appActivity", "br.com.sbf.centauro.uinovo.home.HomeActivity");
        return caps;
    }

    private static DesiredCapabilities getCapabilitiesIos() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("platformVersion", "12.1");

        return caps;
    }

}
