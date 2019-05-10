package practiceTests.googleCloudeServices.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    private final By seePricingButton = By.xpath("//*[@track-name='seePricing']");
    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver =driver;
    }

    public PricingPage clickOnSeePricingButton() {
        searchForElementsOnPageToClick(driver, seePricingButton);
        return new PricingPage(driver);
    }
}