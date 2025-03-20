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
    WebElement emailElement;

    @FindBy(id = "judgementAmountInput")
    WebElement judgementAmountInput;

    @FindBy(id = "startDateInput")
    WebElement startDateInput;

    @FindBy(id = "endDateInput")
    WebElement endDateInput;

    @FindBy(id = "payDayInput")
    WebElement payDayInput;

    @FindBy(id = "interestInput")
    WebElement interestInput;

    @FindBy(xpath = "//button[normalize-space()=\"Submit Judgment\"]")
    WebElement submitJudgementButton;

    @FindBy(xpath = "//button[normalize-space()=\"Update\"]")
    WebElement updateButton;

    @FindBy(css = ".mat-mdc-snack-bar-label.mdc-snackbar__label")
    WebElement toast;

    @FindBy(id = "judgementAmount")
    WebElement judgementAmount;

    @FindBy(id = "startDate")
    WebElement startDate;

    @FindBy(id = "endDate")
    WebElement endDate;

    @FindBy(id = "payDay")
    WebElement payDay;

    @FindBy(id = "interest")
    WebElement interest;

    public ManagerApplicationDetailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public boolean isApplicationBy(String email) {
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
}
