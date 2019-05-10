package practiceTests.googleCloudeServices.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MinutesMailPage extends BasePage {
    private final By mailAddressElement = By.id("mailAddress");
//    private final By cellWithEmailTitle = By.xpath("//*[@id='ui-id-1']/span[@class='inc-mail-address']");

    private final By cellWithEmailTitle = By.xpath("//div[@id='messagesList']//h3");
    private final By cellWithTotalCost = By.xpath("//td/h3[contains(text(),'Total Estimated Monthly Cost')]/../following-sibling::td/h3");
    private WebDriver driver;

    public MinutesMailPage(WebDriver driver) {
        this.driver =driver;
    }

    public String getEmailAddress() {
        return waitForElement(driver, mailAddressElement).getAttribute("value");
    }

    public void waitForMailArrived(int timeout) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.presenceOfElementLocated(cellWithEmailTitle))
                .click();
    }

    public String getCostFromEmail() {
        return waitForElement(driver, cellWithTotalCost).getText();
    }
}