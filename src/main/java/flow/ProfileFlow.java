package flow;

import common.Assertion;
import common.Browser;
import org.openqa.selenium.support.PageFactory;
import pages.MainPage;
import pages.ArticleListPage;
import pages.ProfilePage;

import java.io.IOException;

public class ProfileFlow {

    private static ArticleListPage articleListPage = PageFactory.initElements(
            Browser.getDriver(), ArticleListPage.class
    );

    private static ProfilePage profilePage = PageFactory.initElements(
            Browser.getDriver(), ProfilePage.class
    );

    //открываем профиль
    public static void openUserProfileSetting() throws IOException {
        articleListPage.openProfile();
        profilePage.ensurePageLoaded();
        profilePage.openUserProfileSettings();

    }

    //заполняем имя
    public static void setUserProfileSetting(String firstName, String lastName) throws IOException {
        profilePage.setFirstName(firstName);
        profilePage.setLastName(lastName);
        profilePage.clickSaveButton();
    }

    //проверяем имя
    public static void checkUserProfileData(String firstName, String lastName) throws IOException {
        Browser.getDriver().navigate().refresh();
        profilePage.ensurePageLoaded();
        String nameExpected = firstName + " " + lastName;
        String nameUi = profilePage.getFirstName() + " " + profilePage.getLastName();
        Assertion.assertEqualWithMessage(nameUi,nameExpected);
    }


}