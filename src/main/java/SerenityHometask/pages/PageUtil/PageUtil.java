package SerenityHometask.pages.PageUtil;

import com.google.common.base.Predicate;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.google.common.base.Predicate;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Dauren_Altynbekov on 8/26/2015.
 */
public class PageUtil {

    public static void takeScreenShot(WebDriver driver) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFileToDirectory(screenshot, new File("screenshots"));
        } catch (IOException e) {
        }
    }

    public static void waitForMailCountChanging(WebDriver driver) {
        final int numberOfMailLabels = driver
                .findElements(By.xpath("//div[@class='BltHke nH oy8Mbf' and @role='main']//tr[@class='zA yO']//div[@class='y6']/span[1]"))
                .size();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(new Predicate<WebDriver>() {
            @Override
            public boolean apply(WebDriver driver) {
                List<WebElement> mailLabelList = driver.findElements(By.xpath("//div[@class='BltHke nH oy8Mbf' and @role='main']//tr[@class='zA yO']//div[@class='y6']/span[1]"));
                return numberOfMailLabels != mailLabelList.size();
            }
        });
    }

    public static void waitForNewMailDialogTitleAppering(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(new Predicate<WebDriver>() {
            @Override
            public boolean apply(WebDriver driver) {
                String newMailDialogTitle = driver.findElement(By.xpath("//div[@class='aYF']")).getText();
                return newMailDialogTitle.equals("Новое сообщение");
            }
        });
    }

    public static void waitForChangingPage(WebDriver driver, String url) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.urlContains(url));
    }

    public static void highlightElement(WebDriver driver, WebElement element) {
        String background = element.getCssValue("backgroundColor");
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].style.backgroundColor = 'red'", element);
        takeScreenShot(driver);
        executor.executeScript("arguments[0].style.backgroundColor = '" + background + "'", element);
    }


}
