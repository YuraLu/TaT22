package practiceTests.googleCloudeServices.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import practiceTests.googleCloudeServices.page.*;

public class HurtMePlentyTest {
    private WebDriver driver;
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private static final int TIMEOUT = 15;

    private HomePage homePage;
    private ProductPage productPage;
    private PricingPage pricingPage;
    private CalculatorsPage calculatorsPage;

    private WebElement waitForElementLocatedBy(WebDriver driver, By locator) {
        return new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    @BeforeClass
    public void oneTimeSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HOMEPAGE_URL);
        homePage = new HomePage(driver);
        homePage.clickProductsButton();
        productPage = new ProductPage(driver);
        productPage.clickOnSeePricingButton();
        pricingPage = new PricingPage(driver);
        pricingPage.clickOnCalculatorsButton();
        calculatorsPage = new CalculatorsPage(driver);
        calculatorsPage.fill();
    }

    @AfterClass(alwaysRun = true)
    public void after() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test(groups = "HurtMePlenty")
    public void testVmClass() {
        String vmClassFromPage = waitForElementLocatedBy(driver, By.xpath("//*[@id='resultBlock']//md-list-item[2]/div")).getText();
        String expectedVmClass = "VM class: regular";
        Assert.assertEquals(expectedVmClass, vmClassFromPage);
    }

    @Test(groups = "HurtMePlenty")
    public void testInstanceType() {
        String instanceTypeFromPage = waitForElementLocatedBy(driver, By.xpath("//*[@id='resultBlock']//md-list-item[3]/div")).getText();
        String expectedInstanceType = "Instance type: n1-standard-8";
        Assert.assertEquals(expectedInstanceType, instanceTypeFromPage);
    }

    @Test(groups = "HurtMePlenty")
    public void testRegion() {
        String regionFromPage = waitForElementLocatedBy(driver, By.xpath("//*[@id='resultBlock']//md-list-item[4]/div")).getText();
        String expectedRegion = "Region: Frankfurt";
        Assert.assertEquals(expectedRegion, regionFromPage);
    }

    @Test(groups = "HurtMePlenty")
    public void testAvailableSsdSpace() {
        String ssdFromPage = waitForElementLocatedBy(driver, By.xpath("//*[@id='resultBlock']//md-list-item[5]/div")).getText();
        String expectedSsd = "Total available local SSD space 2x375 GB";
        Assert.assertEquals(expectedSsd, ssdFromPage);
    }

    @Test(groups = "HurtMePlenty")
    public void testCommitmentPeriod() {
        String commitmentPeriodFromPage = waitForElementLocatedBy(driver, By.xpath("//*[@id='resultBlock']//md-list-item[6]/div")).getText();
        String expectedCommitmentPeriod = "Commitment term: 1 Year";
        Assert.assertEquals(expectedCommitmentPeriod, commitmentPeriodFromPage);
    }

    @Test(groups = "HurtMePlenty")
    public void testIsCostCorresponds() {
        String costFromPage = waitForElementLocatedBy(driver, By.xpath("//*[@id='resultBlock']//md-list-item[7]/div")).getText();
        String expectedCost = "Estimated Component Cost: USD 1,187.77 per 1 month";
        Assert.assertEquals(expectedCost, costFromPage);
    }
}




