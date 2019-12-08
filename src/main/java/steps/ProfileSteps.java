package steps;

import cucumber.api.java.en.When;
import flow.ArticleFlow;
import flow.ProfileFlow;
import io.qameta.allure.Step;

import java.io.IOException;

public class ProfileSteps {

    //проверяем, что страница открылась
    @Step("User open User profile settings")
    @When("User open User profile settings")
    public void openUserProfileSetting() throws IOException {
        ProfileFlow.openUserProfileSetting();
    }

    @Step("User sets first name <firstName> and last name <lastName>")
    @When("User sets first name (.*) and last name (.*)")
    public void setUserProfileSetting(String firstName, String lastName) throws IOException {
        ProfileFlow.setUserProfileSetting(firstName, lastName);
    }

    @Step("User checks first name <firstName> and last name <lastName> saved")
    @When("User checks first name (.*) and last name (.*) saved")
    public void checkUserProfileData(String firstName, String lastName) throws IOException {
        ProfileFlow.checkUserProfileData(firstName, lastName);
    }



}
