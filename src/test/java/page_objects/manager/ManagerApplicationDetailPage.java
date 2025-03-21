package page_objects.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page_objects.BasePageComponent;

public class ManagerApplicationDetailPage extends BasePageComponent {

    @FindBy(id = "email")
    private WebElement emailElement;

    @FindBy(id = "judgementAmountInput")
    private WebElement judgementAmountInput;

    @FindBy(id = "startDateInput")
    private WebElement startDateInput;

    @FindBy(id = "endDateInput")
    private WebElement endDateInput;

    @FindBy(id = "payDayInput")
    private WebElement payDayInput;

    @FindBy(id = "interestInput")
    private WebElement interestInput;

    @FindBy(xpath = "//button[normalize-space()=\"Submit Judgment\"]")
    private WebElement submitJudgementButton;

    @FindBy(xpath = "//button[normalize-space()=\"Update\"]")
    private WebElement updateButton;

    @FindBy(css = ".mat-mdc-snack-bar-label.mdc-snackbar__label")
    private WebElement toast;

    @FindBy(id = "judgementAmount")
    private WebElement judgementAmount;

    @FindBy(id = "startDate")
    private WebElement startDate;

    @FindBy(id = "endDate")
    private WebElement endDate;

    @FindBy(id = "payDay")
    private WebElement payDay;

    @FindBy(id = "interest")
    private WebElement interest;

    @FindBy(id = "grant")
    private WebElement grantButton;

    @FindBy(id = "approvalAmount")
    private WebElement approvalAmount;

    @FindBy(id = "entryInput")
    private WebElement entryInput;

    @FindBy(id = "entryBtn")
    private WebElement entryButton;

    @FindBy(id = "entryAmount")
    private WebElement entryAmount;

    public ManagerApplicationDetailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public boolean isApplicationBy(String email) {
        this.wait.until(ExpectedConditions.visibilityOf(emailElement));
        return this.emailElement.getText().toLowerCase().contains(email.toLowerCase());
    }

    public void setJudgementAmount(String judgementAmount) {
        this.judgementAmountInput.sendKeys(judgementAmount);
    }

    public void setStartDate(String startDate) {
        this.startDateInput.sendKeys(startDate);
    }

    public void setEndDate(String endDate) {
        this.endDateInput.sendKeys(endDate);
    }

    public void setPayDay(String payDay) {
        this.payDayInput.sendKeys(payDay);
    }

    public void setInterest(String interest) {
        this.interestInput.sendKeys(interest);
    }

    public void submitJudgement() {
        this.submitJudgementButton.click();
    }

    public String getToastMessage() {
        this.wait.until(ExpectedConditions.visibilityOf(toast));
        return this.toast.getText();
    }

    public String getJudgementAmount() {
        return this.judgementAmount.getText();
    }

    public String getStartDate() {
        return this.startDate.getText();
    }

    public String getEndDate() {
        return this.endDate.getText();
    }

    public String getPayDay() {
        return this.payDay.getText();
    }

    public String getInterest() {
        return this.interest.getText();
    }

    public void updateJudgement() {
        this.updateButton.click();
    }

    public void grantAmount() {
        this.grantButton.click();
    }

    public String getApprovalAmount() {
        return this.approvalAmount.getText();
    }

    public void setEntryInput(String entry) {
        this.entryInput.sendKeys(entry);
    }

    public void submitEntry() {
        this.entryButton.click();
    }

    public String getEntryAmount() {
        String initialText = this.entryAmount.getText();
        this.wait.until(driver -> !this.entryAmount.getText().equals(initialText));
        return this.entryAmount.getText();
    }

}
