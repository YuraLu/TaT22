package practiceTests.pasteBin.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import practiceTests.pasteBin.page.HomePage;

public class ICanWinTest {
    private WebDriver driver;
    private HomePage homePage;
    private static final String HOMEPAGE_URL = "https://pastebin.com";

    @BeforeClass()
    public void oneTimeSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HOMEPAGE_URL);
        homePage = new HomePage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void after() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test(description = "Just fill the page")
    public void justFillPage() {
        homePage.firstFill();
    }
}

//    С помощью Selenium WebDriver автоматизировать следующий сценарий:
//
//        Открыть https://pastebin.com в любом браузере
//        Создать New Paste со следующими деталями:
//        * Код: "Hello from WebDriver"
//
//        * Paste Expiration: "10 Minutes"
//
//        * Paste Name / Title: "helloweb"
