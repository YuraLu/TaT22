package practiceTests.googleCloudeServices.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private WebDriver driver;
    private final By seeProductsButton = By.xpath("//*[@track-name='seeProducts']");

    public HomePage(WebDriver driver) {
        this.driver =driver;
    }

    public ProductPage clickProductsButton() {
            searchForElementsOnPageToClick(driver, seeProductsButton);
        return new ProductPage(driver);
    }
}
