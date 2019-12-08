package flow;

import common.Browser;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import pages.MainPage;
import org.openqa.selenium.UnhandledAlertException;

import java.io.IOException;

public class LoginFlow {

    private static LoginPage loginPage = PageFactory.initElements(
            Browser.getDriver(), LoginPage.class
    );

    //Успешная авторизация
    public static void login(String login, String password) throws IOException {
        loginPage.ensurePageLoaded();
        loginPage.setLogin(login);
        loginPage.setPassword(password);
        loginPage.sendLoginForm();

    }

    //алерты после авторизации
    public static void acceptAlert(String alertAction)  {
        if (alertAction.equals("accept")) {
            MainPage.acceptAlert();
        } else {
            MainPage.dismissAlert();
        }
    }

}