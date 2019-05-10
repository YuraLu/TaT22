package practiceTests.googleCloudeServices.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import practiceTests.googleCloudeServices.page.*;
import java.util.logging.Logger;

public class HardCoreTest {

    private static Logger log = Logger.getLogger(HardCoreTest.class.getName());

    private WebDriver driver;
    private WebDriver minuteMailDriver;
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private static final String MINUTE_MAIL = "https://10minutemail.com";
    private static final int WAIT_FOR_MAIL_TIMEOUT = 180;

    private HomePage homePage;
    private ProductPage productPage;
    private PricingPage pricingPage;
    private CalculatorsPage calculatorsPage;
    private MinutesMailPage minutesMailPage;


    @BeforeClass()
    public void setUp() {
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

        minuteMailDriver = new ChromeDriver();
        minuteMailDriver.manage().window().maximize();
        minuteMailDriver.get(MINUTE_MAIL);
        minutesMailPage = new MinutesMailPage(minuteMailDriver);
        String email = minutesMailPage.getEmailAddress();
        log.info("We get 10 minutes mail = " + email);

        calculatorsPage.clickOnEmailEstimateButton();
        calculatorsPage.inputEmailToFieldAndSendTo(email);
        log.info("We have sent the email to address - " + email);

        minutesMailPage.waitForMailArrived(WAIT_FOR_MAIL_TIMEOUT);
    }

    @AfterClass(alwaysRun = true)
    public void after() {
        driver.manage().deleteAllCookies();
        driver.quit();
//        minuteMailDriver.manage().deleteAllCookies();
//        minuteMailDriver.quit();
    }

    @Test
    public void testGetCorrectCostInMail() {
        String emailCostOnPage = minutesMailPage.getCostFromEmail();
        log.info("Cost on the page is " + emailCostOnPage);
        String expectedEmailCostOnPage = "USD 1,187.77";
        Assert.assertEquals(expectedEmailCostOnPage, emailCostOnPage);
    }
}

