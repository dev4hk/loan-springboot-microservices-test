package page_objects.customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerBasePageComponent {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//a[normalize-space()=\"Summary\"]")
    WebElement customerSummaryLink;

    @FindBy(xpath = "//a[normalize-space()=\"Application\"]")
    WebElement applicationLink;

    @FindBy(xpath = "//a[normalize-space()=\"Counsel\"]")
    WebElement counselLink;

    @FindBy(xpath = "//a[normalize-space()=\"Repayment\"]")
    WebElement repaymentLink;

    public CustomerBasePageComponent(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        PageFactory.initElements(this.driver, this);
    }

    public CustomerSummaryPage goToSummary() {
        this.customerSummaryLink.click();
        return new CustomerSummaryPage(this.driver);
    }

    public CustomerApplicationPage goToApplication() {
        this.applicationLink.click();
        return new CustomerApplicationPage(this.driver);
    }

    public CustomerCounselPage goToCounsel() {
        this.counselLink.click();
        return new CustomerCounselPage(this.driver);
    }

    public CustomerRepaymentPage goToRepayment() {
        this.repaymentLink.click();
        return new CustomerRepaymentPage(this.driver);
    }


}
