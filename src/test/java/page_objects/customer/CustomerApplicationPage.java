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
    WebElement form;

    @FindBy(id = "cellPhone")
    WebElement cellPhoneInput;

    @FindBy(id = "hopeAmount")
    WebElement hopeAmountInput;

    @FindBy(xpath = "//button[normalize-space()='Submit Application']")
    WebElement submitApplicationButton;

    @FindBy(css = "input[type='checkbox']")
    List<WebElement> checkBoxes;

    @FindBy(xpath = "//button[normalize-space()='Agree & Submit']")
    WebElement agreeAndSubmitButton;

    @FindBy(css = ".mat-mdc-snack-bar-label.mdc-snackbar__label")
    WebElement toast;

    @FindBy(xpath = "//div[normalize-space()=\"Loan Application Details\"]")
    WebElement applicationDataHeaderTitle;

    @FindBy(css = ".faq-question")
    WebElement faqQuestionButton;

    @FindBy(css = ".faq-answer.open")
    WebElement faqAnswer;

    @FindBy(css = ".mat-mdc-dialog-content.mdc-dialog__content")
    WebElement agreeForm;

    @FindBy(id = "contractBtn")
    WebElement contractButton;

    @FindBy(id = "contractedAt")
    WebElement contractedAt;

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
