package screens;

import common.Helper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base_screen.BaseScreen;
import page_objects.UtilsPage;

public class Utils extends BaseScreen {

    private UtilsPage utilsPage;
   

    public Utils() {
        this.utilsPage = new UtilsPage(driver);
        
    }


    public void setFocusOnElementTxt(MobileElement element) {
        element.sendKeys("mapear");
        Helper.fecharTeclado();
    }



}
