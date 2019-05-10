package practiceTests.googleCloudeServices.page;

import org.openqa.selenium.*;

public class CalculatorsPage extends BasePage {
    private WebDriver driver;
    private static final String FRAME_ID = "idIframe";
    private static final String NUM_OF_INSTANCES = "4";
    private final By computeEnginesButton = By.xpath("//md-tab-item/div[contains(@title,'Compute Engine')]");
    private final By numOfInstanceInput = By.xpath("//md-input-container/label[contains(text(),'Number of instances')]/..//input");
    private final By operationSystemsSelect = By.xpath("//md-input-container/label[contains(text(),'Operating System / Software')]/..//md-select");
    private final By osNeededOption = By.id("select_option_51");
    private final By vmClassSelect = By.xpath("//md-input-container/label[contains(text(),'VM Class')]/..//md-select");
    private final By vmClassNeededOption = By.id("select_option_63");
    private final By instanceTypeSelect = By.xpath("//md-select[@id='select_96']");
    private final By instanceTypeNeededOption = By.xpath("//md-option[@id ='select_option_73']");
    private final By addGPUCheckBox = By.xpath("//*[contains(text(),'Add GPU')]/../div[1]");
    private final By numberOfGPUSelect = By.xpath("//md-input-container/label[contains(text(),'Number of GPUs')]/..//md-select");
    private final By numOfGPUNeededOption = By.xpath("//md-option[@id ='select_option_337']");
    private final By gpuTypeSelect = By.xpath("//md-input-container/label[contains(text(),'GPU type')]/..//md-select");
    private final By gpuTypeNeededOption = By.xpath("//md-option[@id ='select_option_344']");
    private final By localSSDSelect = By.xpath("//*[@placeholder='Local SSD']");
    private final By localSSDNeededOption = By.xpath("//md-option[@id ='select_option_185']");
    private final By dataCenterSelect = By.xpath("//*[@placeholder='Datacenter location']");
    private final By dataCenterNeededOption = By.xpath("//*[@id ='select_option_199']");
    private final By committedUsageSelect = By.id("select_105");
    private final By committedUsageNeededOption = By.xpath("//md-option[@id ='select_option_103']");
    private final By submitButton = By.xpath("//button[@aria-label='Add to Estimate']");
    private final By emailEstimateButton = By.xpath("//button[contains(text(),'Email Estimate')]");
    private final By inputFieldForEmail = By.xpath("//form[@name='emailForm']//input[@type='email']");
    private final By emailSendButton = By.xpath("//button[contains(text(),'Send Email')]");

    private final By vmClassElement = By.xpath("//*[@id='resultBlock']//md-list-item[2]/div");
    private final By instanceTypeElement = By.xpath("//*[@id='resultBlock']//md-list-item[3]/div");
    private final By regionElement = By.xpath("//*[@id='resultBlock']//md-list-item[4]/div");
    private final By ssdSpaceElement = By.xpath("//*[@id='resultBlock']//md-list-item[5]/div");
    private final By commitmentPeriodElement = By.xpath("//*[@id='resultBlock']//md-list-item[6]/div");
    private final By costElement = By.xpath("//*[@id='resultBlock']//md-list-item[7]/div");



    public CalculatorsPage(WebDriver driver) {
        this.driver =driver;
    }

    public CalculatorsPage fill() {
        waitForFrameToSwitchToIt(driver, By.id(FRAME_ID));
        searchForElementsOnPageToClick(driver, computeEnginesButton);
        searchElementsOnPageToFillData(driver, numOfInstanceInput, NUM_OF_INSTANCES);
        searchForElementsOnPageToClick(driver, operationSystemsSelect);
        searchForElementsOnPageToClick(driver, osNeededOption);
        searchForElementsOnPageToClick(driver, vmClassSelect);
        searchForElementsOnPageToClick(driver, vmClassNeededOption);
        searchForElementsOnPageToClick(driver, instanceTypeSelect);
        searchForElementsOnPageToClick(driver, instanceTypeNeededOption);
        searchForElementsOnPageToClick(driver, addGPUCheckBox);
        searchForElementsOnPageToClick(driver, numberOfGPUSelect);
        searchForElementsOnPageToClick(driver, numOfGPUNeededOption);
        searchForElementsOnPageToClick(driver, gpuTypeSelect);
        searchForElementsOnPageToClick(driver, gpuTypeNeededOption);
        searchForElementsOnPageToClick(driver, localSSDSelect);
        searchForElementsOnPageToClick(driver, localSSDNeededOption);
        searchForElementsOnPageToClick(driver, dataCenterSelect);
        searchForElementsOnPageToClick(driver, dataCenterNeededOption);
        searchForElementsOnPageToClick(driver, committedUsageSelect);
        searchForElementsOnPageToClick(driver, committedUsageNeededOption);
        searchForElementsOnPageToClick(driver, submitButton);
        return this;
    }

    public CalculatorsPage clickOnEmailEstimateButton() {
        searchForElementsOnPageToClick(driver, emailEstimateButton);
        return new CalculatorsPage(driver);
    }

    public void inputEmailToFieldAndSendTo(String email) {
        searchElementsOnPageToFillData(driver, inputFieldForEmail, email);
        searchForElementsOnPageToClick(driver, emailSendButton);
    }

    public String getVmClassFieldContent() {
        return waitForElement(driver, vmClassElement).getText();
    }

    public String getInstanceTypeFieldContent() {
        return waitForElement(driver, instanceTypeElement).getText();
    }

    public String getRegionFieldContent() {
        return waitForElement(driver, regionElement).getText();
    }

    public String getSsdSpaceFieldContent() {
        return waitForElement(driver, ssdSpaceElement).getText();
    }

    public String getCommitmentPeriodFieldContent() {return waitForElement(driver, commitmentPeriodElement).getText(); }

    public String getCostFieldContent() {
        return waitForElement(driver, costElement).getText();
    }
}



