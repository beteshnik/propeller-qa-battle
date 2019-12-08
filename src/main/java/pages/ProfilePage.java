package pages;

import common.Application;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;


//страница статей
public class ProfilePage extends ArticleListPage {

    @FindBy(xpath = "//div[text()='User profile settings']")
    private WebElement articleBlock;

    @FindBy(xpath = "//a[text()='User Profile']")
    private WebElement userProfileButton;

    @FindBy(xpath = "//div[@id='loader']")
    private WebElement loader;

    @FindBy(xpath = "//input[@id='firstNameInput']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastNameInput']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//button[text()='Save user info']")
    private WebElement saveButton;


    public void ensurePageLoaded() {
        waitUntilElementInvisibile(loader);
        waitWhileElemIsVisible(articleBlock);
    }

    public void openUserProfileSettings()  throws IOException {
        clickAndMakeScreenshot(userProfileButton, "User Profile Button");
    }

    public void setFirstName(String firstName)  {
        waitWhileElemIsVisible(firstNameInput);
        type(firstNameInput, firstName);
    }

    public void setLastName(String lastName)  {
        type(lastNameInput, lastName);
    }

    public void clickSaveButton()  throws IOException {
        clickAndMakeScreenshot(saveButton, "User Profile Button");
        waitForLoad();
    }

    public String getLastName()  {
        return getValueText(lastNameInput);
    }

    public String getFirstName()  {
        return getValueText(firstNameInput);
    }


}


