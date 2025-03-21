package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import page_objects.authentication.LoginPage;
import page_objects.authentication.RegisterPage;
import page_objects.customer.CustomerSummaryPage;
import page_objects.manager.ManagerSummaryPage;
import utils.TestContext;

public class AuthenticationStepDefinitions {

    private TestContext testContext;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private CustomerSummaryPage customerSummaryPage;

    ManagerSummaryPage managerSummaryPage;

    public AuthenticationStepDefinitions(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("user is on login page")
    public void user_is_on_login_page() {
        this.loginPage = this.testContext.getPageObjectManager().getCustomerLoginPage();
        Assert.assertEquals(loginPage.getPageTitle(), "MSLOAN");
        Assert.assertEquals(loginPage.getFormTitle(), "Sign in to your account");
    }

    @When("customer clicks on Register link")
    public void customer_clicks_on_register_link() {
        this.loginPage.goToRegister();
        this.registerPage = this.testContext.getPageObjectManager().getRegistrationPage();
    }

    @Then("customer is routed to register page")
    public void customer_is_routed_to_register_page() {
        Assert.assertEquals(this.registerPage.getPageTitle(), "MSLOAN");
        Assert.assertEquals(this.registerPage.getFormTitle(), "Register");
    }

    @Given("customer is on register page")
    public void customer_is_on_register_page() {
        this.loginPage = this.testContext.getPageObjectManager().getCustomerLoginPage();
        this.loginPage.goToRegister();
        this.registerPage = this.testContext.getPageObjectManager().getRegistrationPage();
    }

    @When("customer type all the customer information in the register form")
    public void customer_type_all_the_customer_information_in_the_register_form() {
        this.registerPage.setUsernameInput(this.testContext.getCredentials().get("customer_username"));
        this.registerPage.setPasswordInput(this.testContext.getCredentials().get("customer_password"));
        this.registerPage.setPasswordConfirmInput(this.testContext.getCredentials().get("customer_password"));
        this.registerPage.setEmailInput(this.testContext.getCredentials().get("customer_email"));
        this.registerPage.setFirstNameInput(this.testContext.getCredentials().get("customer_firstname"));
        this.registerPage.setLastNameInput(this.testContext.getCredentials().get("customer_lastname"));
    }

    @When("customer clicks on Register button")
    public void customer_clicks_on_register_button() {
        this.registerPage.register();
        this.customerSummaryPage = this.testContext.getPageObjectManager().getCustomerSummaryPage();
    }

    @When("customer types customer credentials and click on sign in button")
    public void customer_types_customer_credentials_and_click_on_sign_in_button() {

        this.loginPage.setUsernameInput(this.testContext.getCredentials().get("customer_username"));
        this.loginPage.setPasswordInput(this.testContext.getCredentials().get("customer_password"));
        this.loginPage.clickLoginButton();
        this.customerSummaryPage = this.testContext.getPageObjectManager().getCustomerSummaryPage();
    }

    @Then("customer is routed to customer summary page")
    public void customer_is_routed_to_customer_summary_page() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(this.customerSummaryPage.getUrl(), this.testContext.getTestBase().getRootUrl());
    }

    @When("manager types manager credentials and click on sign in button")
    public void manager_types_manager_credentials_and_click_on_sign_in_button() {

        this.loginPage.setUsernameInput(this.testContext.getCredentials().get("manager_username"));
        this.loginPage.setPasswordInput(this.testContext.getCredentials().get("manager_password"));
        this.loginPage.clickLoginButton();
        this.managerSummaryPage = this.testContext.getPageObjectManager().getManagerSummaryPage();
    }

    @Then("manager is routed to manager summary page")
    public void manager_is_routed_to_manager_summary_page() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(this.managerSummaryPage.getUrl(), this.testContext.getTestBase().getRootUrl() + "admin-home");
    }

}
