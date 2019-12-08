package flow;

import common.Assertion;
import common.Browser;
import org.openqa.selenium.support.PageFactory;
import pages.ArticleListPage;
import pages.ArticlePage;

import java.io.IOException;

public class ArticleFlow {

    private static ArticleListPage articleListPage = PageFactory.initElements(
            Browser.getDriver(), ArticleListPage.class
    );

    private static ArticlePage articlePage = PageFactory.initElements(
            Browser.getDriver(), ArticlePage.class
    );

    //Успешная авторизация, открылась страница статей
    public static void ensurePageLoaded(String result)  {
        if(result.equals("true")){
        articleListPage.ensurePageLoaded();}
        else{
            articleListPage.ensurePageNotLoaded();}
    }

    //Открываем секцию
    public static void clickSection(String section) throws IOException  {
        articleListPage.clickBySectionButton(section);
    }

    //Проверяем кол-во статей
    public static void checkArticlesQuantity(int articleQuantity)   {
        articleListPage.checkVisibleArticlesQuantity(articleQuantity);
    }

    //Проверяем текст в отображении и в файле
    public static void checkArticlesText(String articleName) throws IOException  {
        articleListPage.openArticle(articleName);
        articlePage.ensurePageLoaded();
        articlePage.downloadArticle();
        String articleText = articlePage.getArticleText();
        String fileText = articlePage.fileContent();
        Assertion.assertEqualWithMessage(fileText,articleText);

    }

}