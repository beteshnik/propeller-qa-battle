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

    //Успешная авторизация
    public static void ensurePageLoaded(String result)  {
        if(result.equals("true")){
        articlePage.ensurePageLoaded();}
        else{articlePage.ensurePageNotLoaded();}
    }

    //алерты после авторизации
    public static void acceptAlert(String alertAction) throws IOException {
        if (alertAction.equals("accept")) {
            MainPage.acceptAlert();
        } else {
            MainPage.acceptAlert();
        }
    }

}