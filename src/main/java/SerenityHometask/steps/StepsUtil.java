package SerenityHometask.steps;

import SerenityHometask.pages.GmailStartPage;

import javax.inject.Inject;

/**
 * Created by Dauren_Altynbekov on 8/28/2015.
 */
public class StepsUtil {

    @Inject
    private static GmailStartPage startPage;

    public static void loginAsUser(String login, String password){
        startPage.open();
        startPage.login(login, password);
    }
}
