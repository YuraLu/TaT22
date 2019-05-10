package practiceTests.googleCloudeServices.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import practiceTests.googleCloudeServices.page.*;

public class HurtMePlentyTest {
    private WebDriver driver;
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private HomePage homePage;
    private ProductPage productPage;
    private PricingPage pricingPage;
    private CalculatorsPage calculatorsPage;

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

    @Test(groups = "HurtMePlentyTest", description = "Check that Vm class is correct")
    public void testVmClass() {
        String vmClassFromPage = calculatorsPage.getVmClassFieldContent();
        String expectedVmClass = "VM class: regular";
        Assert.assertEquals(expectedVmClass, vmClassFromPage);
    }

    @Test(description = "Check that Instance type is correct")
    public void testInstanceType() {
        String instanceTypeFromPage = calculatorsPage.getInstanceTypeFieldContent();
        String expectedInstanceType = "Instance type: n1-standard-8";
        Assert.assertEquals(expectedInstanceType, instanceTypeFromPage);
    }

    @Test(description = "Check that region is correct")
    public void testRegion() {
        String regionFromPage = calculatorsPage.getRegionFieldContent();
        String expectedRegion = "Region: Frankfurt";
        Assert.assertEquals(expectedRegion, regionFromPage);
    }

    @Test(description = "Check that SSD space is correct")
    public void testAvailableSsdSpace() {
        String ssdFromPage = calculatorsPage.getSsdSpaceFieldContent();
        String expectedSsd = "Total available local SSD space 2x375 GB";
        Assert.assertEquals(expectedSsd, ssdFromPage);
    }

    @Test(description = "Check that commitment period is correct")
    public void testCommitmentPeriod() {
        String commitmentPeriodFromPage = calculatorsPage.getCommitmentPeriodFieldContent();
        String expectedCommitmentPeriod = "Commitment term: 1 Year";
        Assert.assertEquals(expectedCommitmentPeriod, commitmentPeriodFromPage);
    }

    @Test(description = "Check that cost is correct")
    public void testIsCostCorresponds() {
        String costFromPage = calculatorsPage.getCostFieldContent();
        String expectedCost = "Estimated Component Cost: USD 1,187.77 per 1 month";
        Assert.assertEquals(expectedCost, costFromPage);
    }
}




