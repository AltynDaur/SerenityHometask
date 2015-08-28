package SerenityHometask.pages;

import SerenityHometask.pages.PageUtil.PageUtil;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Dauren_Altynbekov on 8/28/2015.
 */
@DefaultUrl("http://gmail.com")
public class GmailStartPage extends PageObject {
    public static final String HTTP_GMAIL_COM = "http://gmail.com";


    @FindBy(xpath = "//div[@id='gaia_firstform']//input[@id='Email']")
    private WebElement emailInput;

    @FindBy(id = "next")
    private WebElement nextToPasswdBtn;

    @FindBy(id = "Passwd")
    private WebElement passwdInput;

    @FindBy(id = "signIn")
    private WebElement signInBtn;

    public void login(String email, String password) {
        emailInput.sendKeys(email);
        nextToPasswdBtn.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(passwdInput));
        passwdInput.sendKeys(password);
        PageUtil.highlightElement(getDriver(), signInBtn);
        signInBtn.click();
        PageUtil.waitForChangingPage(getDriver(),"https://mail.google.com/mail/#inbox");
    }
}
