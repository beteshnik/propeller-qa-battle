package steps;

import common.Application;
import cucumber.api.java.en.When;
import flow.LoginFlow;
import io.qameta.allure.Step;


import java.io.IOException;

public class LoginSteps {

    //авторизация
    @Step("User logs in")
    @When("User logs in")
    public void login()  throws IOException {
        String login = Application.getProperty("login");
        String password = Application.getProperty("password");
        LoginFlow.login(login, password);
        LoginFlow.acceptAlert("accept");
        LoginFlow.acceptAlert("accept");
    }

    //авторизация c вариацией данных
    @Step("User logs in with login and password")
    @When("User logs in with (.*) and (.*)")
    public void loginVar(String login, String password)  throws IOException {
        LoginFlow.login(login, password);
    }

    //согласие с условиями c вариацией данных
    @Step("User chooses decision in the alert")
    @When("User chooses (.*) in the alert")
    public void alertDecision(String decision)   {
        LoginFlow.acceptAlert(decision);
    }

}
