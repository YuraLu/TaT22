package practiceTests.googleCloudeServices.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PricingPage extends BasePage {
    private final By calculatorsButton = By.xpath("//a[@track-name='pricingNav/calculators']");
    private WebDriver driver;

    public PricingPage(WebDriver driver) {
        this.driver=driver;
    }

    public CalculatorsPage clickOnCalculatorsButton() {
        searchForElementsOnPageToClick(driver, calculatorsButton);
        return new CalculatorsPage(driver);
    }
}