package steps;

import common.Application;
import cucumber.api.java.en.When;
import flow.ArticleFlow;
import io.qameta.allure.Step;

import java.io.IOException;

public class ArticleSteps {

    //авторизация
    @Step("User checks Main page opens")
    @When("User checks Main page opens (.*)")
    public void checkMainPageOpens(String result)  {
        ArticleFlow.ensurePageLoaded(result);
    }

}
