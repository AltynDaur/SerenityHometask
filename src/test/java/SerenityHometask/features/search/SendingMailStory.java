package SerenityHometask.features.search;

import SerenityHometask.steps.LoginSteps;
import SerenityHometask.steps.SendingSteps;
import SerenityHometask.steps.StepsUtil;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by Dauren_Altynbekov on 8/28/2015.
 */
@RunWith(SerenityRunner.class)
public class SendingMailStory {
    public static final String TESTING_EMAIL = "autodaurtest@gmail.com";
    public static final String TESTING_EMAIL_PASSWORD = "autodaurtest1";
    public static final String MAIL_ADDRESS = "test.auto@inbox.ru";
    public static final String MAIL_THEME = "Nice test";
    public static final String MAIL_BODY = "You're the best";

    @Managed
    public WebDriver driver;

    @Steps
    public SendingSteps sendingSteps;

    @Steps
    public LoginSteps loginSteps;

    @Before
    public void login(){
        loginSteps.complexLogin(TESTING_EMAIL,TESTING_EMAIL_PASSWORD);
    }

    @Test
    public void saveNewMailToDraft(){
        sendingSteps.startNewMail();
        sendingSteps.writeNewMail(MAIL_ADDRESS, MAIL_THEME, MAIL_BODY);
        sendingSteps.shouldLastMailThemeBe(MAIL_THEME);
    }
}
