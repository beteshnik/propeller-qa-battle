package steps;

import common.Application;
import common.Assertion;
import cucumber.api.Result;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.runtime.ScenarioImpl;
import org.apache.commons.lang3.reflect.FieldUtils;
import pages.MainPage;
import common.Browser;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;


public class MainSteps {

    @Before()
    public void beforeSteps() {
        Assertion.error = "";
        Assertion.message = "";
        Browser.getDriver().manage().deleteAllCookies();
        Browser.getDriver().navigate().to(Application.getProperty("homePage"));
        MainPage.waitForLoad();

    }

    @After()
    public void afterSteps(Scenario scenario) {
        String comment = String.valueOf(getErrorComment(scenario));
        String scenarioId = String.valueOf(scenario.getSourceTagNames());
        if (!comment.equals("null")) {
            System.out.println(scenarioId + ": " + comment);
        }

    }

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        Application.log("Scenario is completed");
        Application.log(scenario.getName());
        if (scenario.isFailed()) {
            MainPage.makeScreenShot("Test Failed");
        }
        //Browser.getDriver().quit();
    }

    public static Throwable getErrorComment(Scenario scenario) {
        Field field = FieldUtils.getField(((ScenarioImpl) scenario).getClass(), "stepResults", true);
        field.setAccessible(true);
        try {
            ArrayList<Result> results = (ArrayList<Result>) field.get(scenario);
            return results.stream().map(Result::getError).filter(Objects::nonNull).findFirst().orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to parse results!");
        }
    }
}