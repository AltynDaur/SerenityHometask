package SerenityHometask.steps;

import SerenityHometask.pages.GmailDraftPage;
import SerenityHometask.pages.GmailInboxPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

/**
 * Created by Dauren_Altynbekov on 8/28/2015.
 */
public class SendingSteps extends ScenarioSteps {

    GmailInboxPage inboxPage;
    GmailDraftPage draftPage;

    @Step
    public void writeNewMail(String address, String theme, String messageBody){
        inboxPage.writeNewMail(address, theme, messageBody);
    }


    @Step
    public void startNewMail(){
        inboxPage.startNewMail();
    }

    @Step
    public void saveMailToDraft(){
        inboxPage.closeNewMailDialog();
    }

    @Step
    public void shouldLastMailThemeBe(String expectedTheme){
        draftPage.open();
        Assert.assertEquals(expectedTheme, draftPage.getLastMailThemeInCategory());
    }
    @Step
    public void openInboxPage() {
        inboxPage.open();
    }
}
