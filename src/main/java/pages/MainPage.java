package pages;

import common.Application;
import service.ServicePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnhandledAlertException;

import static common.Browser.getDriver;


public class MainPage extends ServicePage {
    private static final int periodElementWait = Integer.parseInt(Application.getProperty("periodElementWait"));
    private static final int periodLoadWait = Integer.parseInt(Application.getProperty("periodElementWait"));
    private static final int periodInvisibleWait = Integer.parseInt(Application.getProperty("periodInvisibleWait"));

    public static void waitForLoad() {
        new WebDriverWait(getDriver(), periodLoadWait).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    public static boolean pageIsLoaded() {
        return ((JavascriptExecutor) getDriver()).executeScript("return document.readyState").equals("complete");
    }

    public static void waitWhileElemIsVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), periodElementWait);
        wait.until(
                ExpectedConditions.visibilityOf(element));
    }

    public static void waitWhileElemIsClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), periodElementWait);
        wait.until(
                ExpectedConditions.elementToBeClickable(element));
    }

    public static void type(WebElement element, String value) {
        element.click();
        element.sendKeys(value);
    }

    //принудительное удаление
    public static void hoverElement(WebElement element) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).build().perform();
    }

    //принудительное удаление
    public static void clearByDell(WebElement element) {
        //очистка вручную
        element.sendKeys(Keys.HOME);
        element.sendKeys(Keys.chord(Keys.SHIFT, Keys.END));
        element.sendKeys(Keys.DELETE);
    }

    //выделить текст
    public static void selectByKeys(WebElement element) {
        //очистка вручную
        element.sendKeys(Keys.HOME);
        element.sendKeys(Keys.chord(Keys.SHIFT, Keys.END));
    }

    public static String getValueText(WebElement field) {
        return field.getAttribute("value");
    }

    public static String getInnerText(WebElement field) {
        return field.getAttribute("InnerText");
    }

    public static String getText(WebElement field) {
        return field.getText();
    }


    public static void setCheckBox(WebElement element, String message) throws IOException {
        if (!element.isSelected()) ServicePage.clickAndMakeScreenshot(element, message);
    }

    public static void unSetCheckBox(WebElement element, String message) throws IOException {
        if (element.isSelected()) ServicePage.clickAndMakeScreenshot(element, message);
    }

    //ожидаем исчезновение элемента
    public static void waitUntilElementInvisibile(WebElement webElement) {
        int counter = 0, second = 1; // интервал проверки

        getDriver().manage().timeouts().implicitlyWait(periodInvisibleWait, TimeUnit.SECONDS);
        try {
            while (webElement.isDisplayed()) {
                ServicePage.waitSeconds(second);
                counter += second;
                System.out.println(counter);

                if (counter > periodElementWait)
                    throw new RuntimeException("The element is visible after (sec): " + periodElementWait);
            }
        } catch (Exception e) {
        }
    }

    public static void acceptAlert() {
        int i = 0;
        while (i++ < 4) {
            try {
                Alert alert = getDriver().switchTo().alert();
                alert.accept();
            } catch (NoAlertPresentException e) {
                waitSeconds(3);
            } catch (UnhandledAlertException e) {
            }

        }
    }


    public static void dismissAlert() {
        int i = 0;
        while (i++ < 4) {
            try {
                Alert alert = getDriver().switchTo().alert();
                alert.dismiss();
                waitForLoad();
            } catch (NoAlertPresentException e) {
                waitSeconds(3);
            } catch (UnhandledAlertException e) {
            }

        }
    }
}

