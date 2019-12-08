package pages;

import common.Application;
import common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;


//страница статей
public class ArticlePage extends ArticleListPage {

    @FindBy(xpath = "//div[@id='dataCard']")
    private WebElement articleBlock;

    @FindBy(xpath = "//textarea")
    private WebElement articleText;

    @FindBy(xpath = "//div[@id='loader']")
    private WebElement loader;

    @FindBy(xpath = "//button[text()='Download info']")
    private WebElement downloadButton;


    public void ensurePageLoaded() {
        waitUntilElementInvisibile(loader);
        waitWhileElemIsVisible(articleBlock);
    }

    public String getArticleText() {
        return getText(articleText);

    }

    public void downloadArticle() throws IOException {
        clickAndMakeScreenshot(downloadButton, "Download  article");

    }

    //проверяем что файл загружен корректно
    public static String fileContent() throws IOException {
        String path = Application.getProperty("downloadPath");
        MainPage.waitSeconds(5);
        String fileText = readFile(path);
        deleteFile(path);
        return fileText;
    }
}


