package page_objects;

import org.openqa.selenium.WebDriver;
import page_objects.customer.*;

public class PageObjectManager {
    private WebDriver driver;
    private CustomerLoginPage customerLoginPage;
    private CustomerRegisterPage customerRegistrationPage;
    private CustomerSummaryPage customerSummaryPage;
    private CustomerApplicationPage customerApplicationPage;
    private CustomerCounselPage customerCounselPage;
    private CustomerRepaymentPage customerRepaymentPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public CustomerLoginPage getCustomerLoginPage() {
        if (this.customerLoginPage == null) {
            this.customerLoginPage = new CustomerLoginPage(this.driver);
        }
        return this.customerLoginPage;
    }

    public CustomerRegisterPage getCustomerRegistrationPage() {
        if (this.customerRegistrationPage == null) {
            this.customerRegistrationPage = new CustomerRegisterPage(this.driver);
        }
        return this.customerRegistrationPage;
    }

    public CustomerSummaryPage getCustomerSummaryPage() {
        if(this.customerSummaryPage == null) {
            this.customerSummaryPage = new CustomerSummaryPage(this.driver);
        }
        return this.customerSummaryPage;
    }

    public CustomerApplicationPage getCustomerApplicationPage() {
        if(this.customerApplicationPage == null) {
            this.customerApplicationPage = new CustomerApplicationPage(this.driver);
        }
        return this.customerApplicationPage;
    }

    public CustomerCounselPage getCustomerCounselPage() {
        if(this.customerCounselPage == null) {
            this.customerCounselPage = new CustomerCounselPage(this.driver);
        }
        return this.customerCounselPage;
    }

    public CustomerRepaymentPage getCustomerRepaymentPage() {
        if(this.customerRepaymentPage == null) {
            this.customerRepaymentPage = new CustomerRepaymentPage(this.driver);
        }
        return this.customerRepaymentPage;
    }
}
