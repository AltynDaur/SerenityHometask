package SerenityHometask.steps;

import SerenityHometask.pages.GmailStartPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

/**
 * Created by Dauren_Altynbekov on 8/28/2015.
 */
public class LoginSteps extends ScenarioSteps {
    GmailStartPage startPage;

    @Step
    public void openStartPage(){
        startPage.open();
    }

    @Step
    public void login(String login, String password){
        startPage.login(login, password);
    }

    @Step
    public void shouldSeeTitle(String expectedTitle){
        Assert.assertEquals(expectedTitle, startPage.getTitle());
    }
    @Step
    public void complexLogin(String login, String password){
        openStartPage();
        login(login,password);
    }
}
