package practiceTests.pasteBin.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ResultPage {
    private static final int TIMEOUT = 10;
    private WebDriver driver;

    @FindBy(xpath = "//*[@class='paste_box_info']/.//h1")
    private WebElement titleElement;

    @FindBy(xpath = "//*[@id='code_buttons']/.//span[2]/a")
    private WebElement syntaxElement;

    @FindBy(xpath = "//*[@id='paste_code']")
    private WebElement codeElement;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }

    public String getCorrectTitle() {
        return titleElement.getText();
    }

    public String getCorrectSyntax() {
        return syntaxElement.getText();
    }

    public String getCorrectCode() {
        return codeElement.getText();
    }
}






