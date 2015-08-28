package SerenityHometask.pages;

import SerenityHometask.pages.PageUtil.PageUtil;
import SerenityHometask.pages.blocks.EditingMailMainBlock;
import SerenityHometask.pages.blocks.MailsListBlock;
import SerenityHometask.pages.blocks.MainMenuBlock;
import SerenityHometask.pages.blocks.ToolBarBlock;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

import java.util.List;

/**
 * Created by Dauren_Altynbekov on 8/28/2015.
 */
@DefaultUrl("https://mail.google.com/mail/#drafts")
public class GmailDraftPage extends PageObject {
    public static final String GMAIL_DRAFTS_PAGE = "https://mail.google.com/mail/#drafts";

    private MainMenuBlock mainMenu;
    private MailsListBlock mailsList;
    private EditingMailMainBlock mailMainBlock;
    private ToolBarBlock toolBar;

    public String getLastMailThemeInCategory() {
        return mailsList.getLastMailThemeInCategory().getText();
    }

    public void openLastMailInCategory() {
        mailsList.openLastMailInCategory();
    }

    public String getMailAddressFromDialog() {
        return mailMainBlock.getMailAddressFromDialog();
    }

    public String getMailThemeFromDialog() {
        return mailMainBlock.getMailThemeFromDialog();
    }

    public String getMailBodyFromDialog() {
        return mailMainBlock.getMailBodyFromDialog();
    }

    public void sendMailFromDialog() {
        mailMainBlock.sendMailFromDialog();
    }



    public int getMailListSizeWithTheme(String mailTheme) {
        return mailsList.getMailsWithTheme(mailTheme).size();
    }

    public void goBackToMailsList() {
        toolBar.backToMailList();
    }

    public void goToDrafts() {
        mainMenu.goToDrafts();
        PageUtil.waitForMailCountChanging(getDriver());
    }


    public List<WebElement> getMailList() {

        return mailsList.getMailList();
    }

}
