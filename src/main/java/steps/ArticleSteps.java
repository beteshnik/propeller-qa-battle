package steps;

import cucumber.api.java.en.When;
import flow.ArticleFlow;
import io.qameta.allure.Step;

import java.io.IOException;

public class ArticleSteps {

    //проверяем, что страница открылась
    @Step("User checks Main page opens")
    @When("User checks Main page opens (.*)")
    public void checkMainPageOpens(String result)  {
        ArticleFlow.ensurePageLoaded(result);
    }

    @Step("User opens section (.*)")
    @When("User opens section (.*)")
    public void openSection(String section) throws IOException {
        ArticleFlow.clickSection(section);
    }

    @Step("User checks articles quantity <quantity>")
    @When("User checks articles quantity (.*)")
    public void checkArticlesQuantity(String quantity) throws IOException {
        ArticleFlow.checkArticlesQuantity(Integer.parseInt(quantity));
    }

    @Step("User checks articles downloaded texts for <> articles")
    @When("User checks articles downloaded texts for (.*) articles")
    public void checkArticlesText(String quantity) throws IOException {
        ArticleFlow.checkArticlesText(Integer.parseInt(quantity));
    }

}
