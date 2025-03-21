package page_objects.customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page_objects.BasePageComponent;

import java.util.List;

public class CustomerApplicationPage extends BasePageComponent {

    @FindBy(tagName = "form")
    private WebElement form;

    @FindBy(id = "cellPhone")
    private WebElement cellPhoneInput;

    @FindBy(id = "hopeAmount")
    private WebElement hopeAmountInput;

    @FindBy(xpath = "//button[normalize-space()='Submit Application']")
    private WebElement submitApplicationButton;

    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> checkBoxes;

    @FindBy(xpath = "//button[normalize-space()='Agree & Submit']")
    private WebElement agreeAndSubmitButton;

    @FindBy(css = ".mat-mdc-snack-bar-label.mdc-snackbar__label")
    private WebElement toast;

    @FindBy(xpath = "//div[normalize-space()=\"Loan Application Details\"]")
    private WebElement applicationDataHeaderTitle;

    @FindBy(css = ".faq-question")
    private WebElement faqQuestionButton;

    @FindBy(css = ".faq-answer.open")
    private WebElement faqAnswer;

    @FindBy(css = ".mat-mdc-dialog-content.mdc-dialog__content")
    private WebElement agreeForm;

    @FindBy(id = "contractBtn")
    private WebElement contractButton;

    @FindBy(id = "contractedAt")
    private WebElement contractedAt;

    public CustomerApplicationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getUrl() {
        return this.driver.getCurrentUrl();
    }

    public boolean isFormDisplayed() {
        return this.form.isDisplayed();
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhoneInput.sendKeys(cellPhone);
    }

    public void setHopeAmount(String hopeAmount) {
        this.hopeAmountInput.sendKeys(hopeAmount);
    }

    public String getToastMessage() {
        this.wait.until(ExpectedConditions.visibilityOf(toast));
        return this.toast.getText();
    }

    public boolean isDataDisplayed(String s) {
        return this.applicationDataHeaderTitle.isDisplayed();
    }

    public void checkTerms() {
        this.wait.until(ExpectedConditions.visibilityOf(agreeForm));
        for(var checkbox : checkBoxes) {
            checkbox.click();
        }
    }

    public void submitTerms() {
        this.agreeAndSubmitButton.click();
    }

    public void openFaqQuestion() {
        this.faqQuestionButton.click();
    }

    public boolean isFaqAnswerDisplayed() {
        return this.faqAnswer.isDisplayed();
    }

    public void submitApplication() {
        this.submitApplicationButton.click();
    }

    public void contract() {
        this.contractButton.click();
    }

    public String getContractedAt() {
        return this.contractedAt.getText();
    }
}
