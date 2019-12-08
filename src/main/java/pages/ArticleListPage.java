package pages;

import common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.*;
import java.nio.file.Files;
import java.io.IOException;
import java.util.List;

import service.ServicePage;


//страница статей
public class ArticleListPage extends MainPage {

    @FindBy(xpath = "//div[text()='Articles to read']")
    private WebElement header;

    @FindBy(xpath = "//div[text()='Articles to read']")
    private List<WebElement> mainPageHeaders;

    @FindBy(xpath = "//div[@id='loader']")
    private WebElement loader;

    @FindBy(xpath = "//div[@class='sub-tree'][not(@style='display: none;')]//button")
    private List<WebElement> visibleArticles;

    @FindBy(xpath = "//button[contains(@class,'tree-main-button')]")
    private List<WebElement> sections;

    @FindBy(xpath = "//div[@id='avatarContainer']/img")
    private WebElement profileIcon;


    public void ensurePageLoaded() {
        waitUntilElementInvisibile(loader);
        waitWhileElemIsVisible(header);
    }

    public void ensurePageNotLoaded() {
        waitUntilElementInvisibile(loader);
        Assert.assertEquals(mainPageHeaders.size(), 0, "Main page isn't open");
    }

    public void clickBySectionButton(String sectionName) throws IOException {
        if (sectionName.equals("all")) {
            for (int i=0;i<sections.size();i++) {
                WebElement section = Browser.getDriver().findElements(By.xpath("//button[contains(@class,'tree-main-button')]")).get(i);
                clickAndMakeScreenshot(section, "Open section");
            }
        } else {
            clickAndMakeScreenshot(Browser.getDriver().findElement(By.xpath("//button[text()='" + sectionName + "']")), "Open section " + sectionName);
        }
        waitForLoad();
    }

    public void checkVisibleArticlesQuantity(int articleQuantity) {
        Assert.assertEquals(visibleArticles.size(), articleQuantity, "Correct visible articles quantity in section");
    }

    public void openArticle(String articleName) throws IOException {
        waitUntilElementInvisibile(loader);
        WebElement article = Browser.getDriver().findElement(By.xpath("//button[text()='" + articleName + "']"));
        clickAndMakeScreenshot(article, "Open article " + article);
    }

    public void openProfile() throws IOException  {
        clickAndMakeScreenshot(profileIcon, "Open profile");
    }


}


