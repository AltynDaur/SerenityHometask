package SerenityHometask.features.search;

import SerenityHometask.steps.LoginSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by Dauren_Altynbekov on 8/28/2015.
 */
@RunWith(SerenityRunner.class)
public class LoginStory {

    public static final String TESTING_EMAIL = "autodaurtest@gmail.com";
    public static final String TESTING_EMAIL_PASSWORD = "autodaurtest1";
    public static final String EXPECTED_TITLE = "Входящие - autodaurtest@gmail.com - Gmail";

    @Managed
    public WebDriver driver;

    @Steps
    public LoginSteps loginSteps;

    @Test
    public void loginShouldSeeCorrectTitle(){
        loginSteps.openStartPage();
        loginSteps.login(TESTING_EMAIL, TESTING_EMAIL_PASSWORD);
        loginSteps.shouldSeeTitle(EXPECTED_TITLE);
    }
}
