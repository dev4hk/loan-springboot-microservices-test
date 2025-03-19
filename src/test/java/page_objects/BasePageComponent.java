package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageComponent {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(xpath = "//a[normalize-space()=\"Summary\"]")
    WebElement customerSummaryLink;

    @FindBy(xpath = "//a[normalize-space()=\"Application\"]")
    WebElement applicationLink;

    @FindBy(xpath = "//a[normalize-space()=\"Counsel\"]")
    WebElement counselLink;

    @FindBy(xpath = "//a[normalize-space()=\"Repayment\"]")
    WebElement repaymentLink;

    @FindBy(xpath = "//a[normalize-space()=\"Terms\"]")
    WebElement termsLink;

    public BasePageComponent(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        PageFactory.initElements(this.driver, this);
    }

    public void goToCustomerSummary() {
        this.customerSummaryLink.click();
    }

    public void goToCustomerApplication() {
        this.applicationLink.click();
    }

    public void goToCustomerCounsel() {
        this.counselLink.click();
    }

    public void goToCustomerRepayment() {
        this.repaymentLink.click();
    }

    public void goToManagerTerms() {
        this.termsLink.click();
    }

    public void goToManagerApplicationPage() {
        this.applicationLink.click();
    }
}
