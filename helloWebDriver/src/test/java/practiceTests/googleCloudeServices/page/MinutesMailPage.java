package practiceTests.googleCloudeServices.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MinutesMailPage extends BasePage {
    private WebDriver driver;
    private final By mailAddressElement = By.id("mailAddress");
    private final By cellWithEmailTitle = By.xpath("//*[@id='ui-id-1']/span[@class='inc-mail-address']");
    private final By cellWithTotalCost = By.xpath("//td/h3[contains(text(),'Total Estimated Monthly Cost')]/../following-sibling::td/h3");
    private By linkForPopUpLine = By.xpath("//*[@class='cc_btn cc_btn_accept_all']");
    private By linkToClosePopUpFrame = By.xpath("//*[@class='ezmob-footer-close']");

    public MinutesMailPage(WebDriver driver) {
        this.driver =driver;
    }

    public String getEmailAddress() {
        return waitForElement(driver, mailAddressElement).getAttribute("value");
    }

    public void waitForMailArrived(int timeout) {
        try {
            searchForElementsOnPageToClickWithTimeOut(driver, linkToClosePopUpFrame,timeout);
            searchForElementsOnPageToClickWithTimeOut(driver, linkForPopUpLine,timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
        searchForElementsOnPageToClickWithTimeOut(driver, cellWithEmailTitle,timeout);
    }

    public String getCostFromEmail() {
        return waitForElement(driver, cellWithTotalCost).getText();
    }
}