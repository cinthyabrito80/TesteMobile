package page_objects;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class UtilsPage {

    // *******Construtor*******//

    public UtilsPage(MobileDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    // *******Elements*******//

    /**
     *
     */
    @AndroidFindBy(id = "id_android")
    @iOSXCUITFindBy(id = "id_ios")
    private MobileElement _centauro;


    // *******getter and setters*******//


    public MobileElement get__centauro() {
        return _centauro;
    }



    // *******getter and setters String*******//


}
