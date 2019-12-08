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
public class ArticlePage extends MainPage {

    @FindBy(xpath = "//div[text()='Articles to read']")
    private WebElement mainPageHeader;

    @FindBy(xpath = "//div[text()='Articles to read']")
    private List<WebElement> mainPageHeaders;

    @FindBy(xpath = "//div[@id='loader']")
    private WebElement loader;

    @FindBy(xpath = "//div[@class='sub-tree'][not(@style='display: none;')]//button")
    private List<WebElement> visibleArticles;

    @FindBy(xpath = "//textarea")
    private WebElement articleText;

    @FindBy(xpath = "//button[text()='Download info']")
    private WebElement downloadButton;


    public void ensurePageLoaded() {
        waitUntilElementInvisibile(loader);
        waitWhileElemIsVisible(mainPageHeader);
    }

    public void ensurePageNotLoaded() {
        waitUntilElementInvisibile(loader);
        Assert.assertEquals(mainPageHeaders.size(), 0, "Main page isn't open");
    }

    public void clickBySectionButton(String section) throws IOException {
        clickAndMakeScreenshot(Browser.getDriver().findElement(By.xpath("//button[text()='" + section + "']")), "Open section " + section);
        waitForLoad();
    }

    public void checkVisibleArticlesQuantity(int articleQuantity) {
        Assert.assertEquals(visibleArticles.size(), articleQuantity, "Correct visible articles quantity in section");
    }

    public void openArticle(int articleNumber) throws IOException {
        clickAndMakeScreenshot(visibleArticles.get(articleNumber), "Open article");

    }

    public String getArticleText() {
        return getText(articleText);

    }

    public void downloadArticle() throws IOException {
        clickAndMakeScreenshot(downloadButton, "Download  article");

    }

    //проверяем что файл загружен корректно
    public static String fileContent() throws IOException {
        MainPage.waitSeconds(5);
        String fileText = readFile("C:\\Users\\User\\Downloads");
        deleteFile("C:\\Users\\User\\Downloads");
        return fileText;
    }
}


