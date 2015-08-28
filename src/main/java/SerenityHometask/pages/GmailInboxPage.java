package SerenityHometask.pages;

import SerenityHometask.pages.PageUtil.PageUtil;
import SerenityHometask.pages.blocks.*;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

/**
 * Created by Dauren_Altynbekov on 8/28/2015.
 */
@DefaultUrl("https://mail.google.com/mail/#inbox")
public class GmailInboxPage extends PageObject {
    public static final String GMAIL_INBOX_PAGE = "https://mail.google.com/mail/#inbox";
    private MainMenuBlock mainMenu;
    private MailsListBlock mailsList;
    private CreatingMailDialogBlock mailDialog;
    private SettingsDialogBlock settingsDialog;
    private ToolBarBlock helpToolBar;
    private HeaderBlock header;
    private ErrorMessageBlock errorMessage;


    public void startNewMail() {
        mainMenu.startNewMail();
        PageUtil.waitForNewMailDialogTitleAppering(getDriver());
    }

    public void writeNewMail(String mailAddress, String mailTheme, String mailBody) {
        mailDialog.writeNewMail(mailAddress, mailTheme, mailBody);
    }

    public void closeNewMailDialog() {
        mailDialog.closeNewMailDialog();
    }


    public void openSettingsDialog() {
        helpToolBar.openSettingsDialog();
    }


    public String getCreatingDialogTitle() {
        return mailDialog.getTitle();
    }

    public void logout() {
        header.openAccountManagementDialog();
        header.logout();
    }

    public WebElement getHeader() {
        return header;
    }

    public void sentNewMail() {
        mailDialog.sendMailFromDialog();
    }

    public WebElement getErrorMessage() {
        return errorMessage.getErrorMessage();
    }

    public void closeErrorMessage() {
        errorMessage.closeErrorMessage();
    }

    public void waitForErrorMessageAppering() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(errorMessage.getErrorMessage()));
    }

    public void sentNewMailWithError() {
        mailDialog.sendMailFromDialog();
        waitForErrorMessageAppering();
    }
}
