package practiceTests.googleCloudeServices.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class BasePage {
    private WebDriver driver;
    private static final int TIMEOUT = 20;

    BasePage() {
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    void searchForElementsOnPageToClick(WebDriver driver, By locator) {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(locator))
                .click();
    }

    void searchElementsOnPageToFillData(WebDriver driver, By locator, String strToFill) {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locator))
                .sendKeys(strToFill);
    }

    WebDriver waitForFrameToSwitchToIt(WebDriver driver, By locator) {
        return new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    WebElement waitForElement(WebDriver driver, By locator) {
        return new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}






