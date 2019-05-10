package practiceTests.pasteBin.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import practiceTests.pasteBin.page.HomePage;
import practiceTests.pasteBin.page.ResultPage;

public class BringItOnTest {
    private WebDriver driver;
    private HomePage homePage;
    private ResultPage resultPage;
    private static final String HOMEPAGE_URL = "https://pastebin.com";

    @BeforeClass()
    public void oneTimeSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HOMEPAGE_URL);
        homePage = new HomePage(driver);
        homePage
                .fillPageForBringItOn();
        resultPage = new ResultPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void after() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test(groups = "BringItOnTest", description = "Check that title corresponds to entered Paste Name / Title")
    public void testGetCorrectTitle() {
        String expectedTitle = "how to gain dominance among developers";
        String actualTitleFromPage = resultPage.getCorrectTitle();
        Assert.assertEquals(expectedTitle, actualTitleFromPage);
    }

    @Test(groups = "BringItOnTest", description = "Check that syntax corresponds to entered Syntax")
    public void testGetCorrectSyntax() {
        String expectedSyntaxStyle = "Bash";
        String actualSyntaxStyleFromPage = resultPage.getCorrectSyntax();
        Assert.assertEquals(expectedSyntaxStyle, actualSyntaxStyleFromPage);
    }

    @Test(groups = "BringItOnTest", description = "Check that code corresponds to entered")
    public void testGetCorrectCode() {
        String expectedCode = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "//        git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "//        git push origin master --force";
        String actualCodeFromPage = resultPage.getCorrectCode();
        Assert.assertEquals(expectedCode, actualCodeFromPage);
    }
}

//    С помощью Selenium WebDriver автоматизировать следующий сценарий:
//
//        Открыть https://pastebin.com в любом браузере
//        Создать New Paste со следующими деталями:
//        * Код:
//
//        git config --global user.name  "New Sheriff in Town"
//        git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
//        git push origin master --force

//        * Syntax Highlighting: "Bash"
//
//        * Paste Expiration: "10 Minutes"
//
//        * Paste Name / Title: "how to gain dominance among developers"
//
//        3. Сохранить paste и проверить следующее:
//
//        * Заголовок страницы браузера соответствует Paste Name / Title
//
//        * Синтаксис подвечен для bash
//
//        * Проверить что код соответствует введенному в пункте 2





