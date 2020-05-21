package common;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import base_screen.BaseScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class Helper extends BaseScreen {

    /**
     * Realiza o scrool
     */
    public static void scroll(double inicio, double fim) {
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int start_y = (int) (size.height * inicio);
        int end_y = (int) (size.height * fim);
        new TouchAction<>(driver).press(PointOption.point(x, start_y)).moveTo(PointOption.point(x, end_y)).release()
                .perform();
    }

    /**
     * verifica se o elemento existe
     */
    public static boolean elementExists(String xpath) {
        return driver.findElements(By.xpath(xpath)).size() != 0;
    }

    /**
     * verifica se o elemento existe
     */
    public static void clicarElementoCustom(String xpath) {
        driver.findElementByXPath(xpath).click();
    }

    /**
     * Fechar o teclado do Android
     */
    public static void fecharTeclado() {
        if(VariaveisStaticas.getPlatformType().equals("android")){
            driver.hideKeyboard();
        }else{

        }
    }

    /**
     * Realiza swipe down
     */
    public static void swipeDown(String xpath) {

        try {
            TouchAction action = new TouchAction(driver);
            Dimension size = driver.manage().window().getSize();
            int width = (int) (size.width / 2);
            int startPoint = (int) (size.height - 11);
            int endPoint = (int) (6);
            while (elementExists(xpath)) {
                action.press(PointOption.point(width, startPoint))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(400)))
                        .moveTo(PointOption.point(width, endPoint)).release().perform();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Realiza swipe vertical na tela
     */
    public static void swipeVertical(double startPercentage, double finalPercentage, int durantion) {
        try {
            TouchAction action = new TouchAction(driver);
            Dimension size = driver.manage().window().getSize();
            int widht = (int) size.width / 2;
            int startPoint = (int) (size.height * startPercentage);
            int endPoint = (int) (size.height * finalPercentage);
            action.press(PointOption.point(widht, startPoint))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(durantion)))
                    .moveTo(PointOption.point(widht, endPoint)).release().perform();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Realiza swipe ate encontrar o elemento desejado
     */
    public static void swipeAteEncontrarElemento(String xpath) {
        int num = 0;
        while (!elementExists(xpath) && num <= 9) {
            swipeVertical(0.5, 0.08, 0);
            num++;
        }
    }

    /**
     * Realiza swipe horizontal na tela
     */
    public static void swipeHorizontal(int startX, int startY, int endX, int endY) {

        try {
            TouchAction action = new TouchAction(driver);
            action.press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2000))).moveTo(PointOption.point(endX, endY))
                    .release().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Retornar o proximo dia
     */
    public static String retornaProximaDia() {
        GregorianCalendar dateFormat = new GregorianCalendar();
        dateFormat.setTime(new Date());
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.add(Calendar.DATE, 1);
        return dateFormat.getTime().toString();

    }

    /**
     * Clicar no elemento com TouchAction
     */
    public static void clicaElementoTouchAction(MobileElement elemento) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(elemento))).perform();
    }
}
