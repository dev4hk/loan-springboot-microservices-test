package page_objects;

import org.openqa.selenium.WebDriver;
import page_objects.authentication.LoginPage;
import page_objects.authentication.RegisterPage;
import page_objects.customer.*;
import page_objects.customer.CustomerApplicationPage;
import page_objects.manager.ManagerApplicationDetailPage;
import page_objects.manager.ManagerApplicationPage;
import page_objects.manager.ManagerSummaryPage;
import page_objects.manager.ManagerTermsPage;

public class PageObjectManager {
    private WebDriver driver;
    private LoginPage loginPage;
    private RegisterPage registrationPage;
    private CustomerSummaryPage customerSummaryPage;
    private CustomerApplicationPage customerApplicationPage;
    private CustomerCounselPage customerCounselPage;
    private CustomerRepaymentPage customerRepaymentPage;
    private ManagerSummaryPage managerSummaryPage;
    private ManagerTermsPage managerTermsPage;
    private ManagerApplicationPage managerApplicationPage;
    private ManagerApplicationDetailPage managerApplicationDetailPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getCustomerLoginPage() {
        if (this.loginPage == null) {
            this.loginPage = new LoginPage(this.driver);
        }
        return this.loginPage;
    }

    public RegisterPage getRegistrationPage() {
        if (this.registrationPage == null) {
            this.registrationPage = new RegisterPage(this.driver);
        }
        return this.registrationPage;
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

    public ManagerSummaryPage getManagerSummaryPage() {
        if(this.managerSummaryPage == null) {
            this.managerSummaryPage = new ManagerSummaryPage(this.driver);
        }
        return this.managerSummaryPage;
    }

    public ManagerTermsPage getManagerTermsPage() {
        if(this.managerTermsPage == null) {
            this.managerTermsPage = new ManagerTermsPage(this.driver);
        }
        return this.managerTermsPage;
    }

    public ManagerApplicationPage getManagerApplicationPage() {
        if(this.managerApplicationPage == null) {
            this.managerApplicationPage = new ManagerApplicationPage(this.driver);
        }
        return this.managerApplicationPage;
    }

    public ManagerApplicationDetailPage getManagerApplicationDetailPage() {
        if(this.managerApplicationDetailPage == null) {
            this.managerApplicationDetailPage = new ManagerApplicationDetailPage(this.driver);
        }
        return this.managerApplicationDetailPage;
    }
}
