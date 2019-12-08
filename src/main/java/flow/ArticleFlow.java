package flow;

import common.Browser;
import org.openqa.selenium.support.PageFactory;
import pages.ArticlePage;
import pages.MainPage;

import java.io.IOException;

public class ArticleFlow {

    private static ArticlePage articlePage = PageFactory.initElements(
            Browser.getDriver(), ArticlePage.class
    );

    //Успешная авторизация, открылась страница статей
    public static void ensurePageLoaded(String result)  {
        if(result.equals("true")){
        articlePage.ensurePageLoaded();}
        else{articlePage.ensurePageNotLoaded();}
    }

    //Открываем секцию
    public static void clickSection(String section) throws IOException  {
        articlePage.clickBySectionButton(section);
    }

    //Проверяем кол-во статей
    public static void checkArticlesQuantity(int articleQuantity) throws IOException  {
        articlePage.checkVisibleArticlesQuantity(articleQuantity);
    }




}