package page_objects.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page_objects.BasePageComponent;

import java.util.List;

public class CustomerRepaymentPage extends BasePageComponent {

    @FindBy(id = "monthlyPayment")
    private WebElement monthlyPayment;

    @FindBy(id = "paymentInput")
    private WebElement paymentInput;

    @FindBy(id = "paymentSubmit")
    private WebElement paymentSubmit;

    @FindBy(css = ".mat-mdc-snack-bar-label.mdc-snackbar__label")
    private WebElement toast;

    @FindBy(css = ".card-body ul li")
    private List<WebElement> historyItems;

    public CustomerRepaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getUrl() {
        return this.driver.getCurrentUrl();
    }

    public String getMonthlyPayment() {
        return this.monthlyPayment.getText();
    }

    public void setPaymentInput(String monthlyAmount) {
        this.paymentInput.sendKeys(monthlyAmount);
    }

    public boolean isPaymentAddedAfterSubmission() throws InterruptedException {
        int initial = historyItems.size();
        this.paymentSubmit.click();
        this.wait.until(driver -> historyItems.size() == initial + 1);
        return historyItems.size() == initial + 1;
    }

    public String getToastMessage() {
        this.wait.until(ExpectedConditions.visibilityOf(toast));
        return this.toast.getText();
    }

}
