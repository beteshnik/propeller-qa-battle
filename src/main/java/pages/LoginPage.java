package pages;

import common.Application;
import common.Browser;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import service.ServicePage;

import java.io.IOException;

//страница авторизации
public class LoginPage extends MainPage {

    @FindBy(xpath = "//h4[text()='Welcome to Propeller Championship!']")
    private WebElement loginPageHeader;

    @FindBy(xpath = "//div[@class='form-group'][@onclick='startInputLogin()']")
    private WebElement loginInputStartElement;

    @FindBy(xpath = "//div[@class='form-group'][@onclick='startInputPassword()']")
    private WebElement passwordInputStartElement;

    @FindBy(xpath = "//input[not(@disabled)][@id='loginInput']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[not(@disabled)][@id='passwordInput']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[contains(text(),'Hover me faster!')]")
    private WebElement hoverMeFasterButton;

    @FindBy(xpath = "//button[contains(text(),'Wait')]")
    private WebElement waitButton;

    @FindBy(xpath = "//div[img[@src='sign.png']]")
    private WebElement signInButton;

    public void ensurePageLoaded() {
        waitWhileElemIsVisible(loginPageHeader);
    }

    public void setLogin(String login) {
        loginInputStartElement.click();
        waitWhileElemIsVisible(loginInput);
        type(loginInput, login);
    }

    public void setPassword(String password) {
        passwordInputStartElement.click();
        waitWhileElemIsVisible(passwordInput);
        type(passwordInput, password);
    }

    public void sendLoginForm() throws IOException {
        hoverElement(hoverMeFasterButton);
        waitWhileElemIsClickable(signInButton);
        try {
            clickAndMakeScreenshot(signInButton, "Sign In button");
            waitForLoad();
        } catch (UnhandledAlertException e) {
        }
    }

}
