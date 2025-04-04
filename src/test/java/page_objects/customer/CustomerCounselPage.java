package page_objects.customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page_objects.BasePageComponent;

public class CustomerCounselPage extends BasePageComponent {

    @FindBy(id = "cellPhone")
    private WebElement cellPhoneInput;

    @FindBy(id = "address1")
    private WebElement address1Input;

    @FindBy(id = "address2")
    private WebElement address2Input;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "zipCode")
    private WebElement zipcodeInput;

    @FindBy(id = "memo")
    private WebElement memoInput;

    @FindBy(xpath = "//button[normalize-space()=\"Submit\"]")
    private WebElement submitButton;

    @FindBy(xpath = "//span[normalize-space()=\"Loan Counsel Details\"]")
    private WebElement counselCardHeader;

    @FindBy(css = ".memo-button")
    private WebElement memoButton;

    @FindBy(css = ".memo-detail.open")
    private WebElement memo;

    @FindBy(css = ".faq-question")
    private WebElement faqQuestionButton;

    @FindBy(css = ".faq-answer.open")
    private WebElement faqAnswer;

    @FindBy(xpath = "//button[normalize-space()=\"Update\"]")
    private WebElement updateButton;

    public CustomerCounselPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getUrl() {
        return this.driver.getCurrentUrl();
    }

    public void setCellPhoneInput(String cellPhone) {
        this.cellPhoneInput.sendKeys(cellPhone);
    }

    public void setAddress1Input(String address1) {
        this.address1Input.sendKeys(address1);
    }

    public void setAddress2Input(String address2) {
        this.address2Input.sendKeys(address2);
    }

    public void setCityInput(String city) {
        this.cityInput.sendKeys(city);
    }

    public void setStateInput(String state) {
        this.stateInput.sendKeys(state);
    }

    public void setZipcodeInput(String zipCode) {
        this.zipcodeInput.sendKeys(zipCode);
    }

    public void setMemoInput(String memo) {
        this.memoInput.sendKeys(memo);
    }

    public void submit() {
        this.submitButton.click();
    }

    public String getCounselCardHeaderText() {
        return this.counselCardHeader.getText();
    }

    public void openMemo() {
        this.memoButton.click();
    }

    public boolean isMemoDisplayed() {
        return this.memo.isDisplayed();
    }

    public void openFaqQuestion() {
        this.faqQuestionButton.click();
    }

    public boolean isFaqAnswerDisplayed() {
        return this.faqAnswer.isDisplayed();
    }

    public void openUpdate() {
        this.updateButton.click();
    }

    public void updateMemo(String memo) {
        this.memoInput.clear();
        this.memoInput.sendKeys(memo);
    }

    public String getMemo() {
        return this.memo.getText();
    }
}

