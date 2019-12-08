package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;


import java.io.IOException;

//страница статей
public class ArticlePage extends MainPage {

    @FindBy(xpath = "//div[text()='Articles to read']")
    private WebElement mainPageHeader;

    @FindBy(xpath = "//div[text()='Articles to read']")
    private List<WebElement> mainPageHeaders;

    @FindBy(xpath = "//div[contains(@class,'load')]")
    private WebElement loader;


    public void ensurePageLoaded() {
        waitUntilElementInvisibile(loader);
        waitWhileElemIsVisible(mainPageHeader);
    }

    public void ensurePageNotLoaded() {
        waitUntilElementInvisibile(loader);
        Assert.assertEquals(mainPageHeaders.size(),0, "Main page isn't open");
    }


}
