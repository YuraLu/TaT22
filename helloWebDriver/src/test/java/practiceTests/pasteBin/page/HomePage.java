package practiceTests.pasteBin.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {
    private static final String CODE_I_CAN_WIN = "Hello from WebDriver";
    private static final String CODE_BRING_IT_ON = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "//        git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "//        git push origin master --force";
    private static final String PASTE_NAME_I_CAN_WIN = "helloweb";
    private static final String PASTE_NAME_BRING_IT_ON  = "how to gain dominance among developers";

    private static final String EXPIRATION_TIME = "10 Minutes";
    private static final String STYLE = "Bash";
    private static final int TIMEOUT = 10;
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='header_new_paste']")
    private WebElement headerText;
    @FindBy(xpath = "//*[@id='paste_code']")
    private WebElement pasteCode;
    @FindBy(xpath = "//div[contains(text(),'Paste Expiration:')]/following::span[@class='select2-selection__arrow']")
    private WebElement arrowForSelectExpiration;
    @FindBy(xpath = "//*[@class='select2-results']/descendant::li[contains(text(),'" + EXPIRATION_TIME + "')]")
    private WebElement expirationTime;
    @FindBy(xpath = "//div[contains(text(),'Syntax Highlighting:')]/following::span[@class='select2-selection__arrow']")
    private WebElement arrowForSelectSyntax;
    @FindBy(xpath = "//*[@class='select2-results']/descendant::li[contains(text(),'" + STYLE + "')]")
    private WebElement syntaxHighlighting;
    @FindBy(xpath = "//div[contains(text(),'Paste Name / Title:')]/following::input[@name='paste_name']")
    private WebElement pasteName;
    @FindBy(xpath = "//*[@id='submit']")
    private WebElement submitButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }

    public ResultPage fillPageForBringItOn() {
        headerText.click();
        pasteCode.sendKeys(CODE_BRING_IT_ON);
        arrowForSelectSyntax.click();
        syntaxHighlighting.click();
        arrowForSelectExpiration.click();
        expirationTime.click();
        pasteName.sendKeys(PASTE_NAME_BRING_IT_ON);
        submitButton.click();
        return new ResultPage(driver);
    }

    public HomePage firstFill() {
        headerText.click();
        pasteCode.sendKeys(CODE_I_CAN_WIN);
        arrowForSelectExpiration.click();
        expirationTime.click();
        pasteName.sendKeys(PASTE_NAME_I_CAN_WIN);
        submitButton.click();
        return this;
    }
}






