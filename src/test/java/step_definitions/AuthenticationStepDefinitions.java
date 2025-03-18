package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import page_objects.customer.CustomerLoginPage;
import page_objects.customer.CustomerRegisterPage;
import page_objects.customer.CustomerSummaryPage;
import utils.TestContext;

import java.util.List;

public class AuthenticationStepDefinitions {

    TestContext testContext;
    CustomerLoginPage loginPage;
    CustomerRegisterPage registerPage;
    CustomerSummaryPage customerSummaryPage;

    public AuthenticationStepDefinitions(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("customer is on login page")
    public void customer_is_on_login_page() {
        this.loginPage = this.testContext.getPageObjectManager().getCustomerLoginPage();
        Assert.assertEquals(loginPage.getPageTitle(), "MSLOAN");
        Assert.assertEquals(loginPage.getFormTitle(), "Sign in to your account");
    }

    @When("customer clicks on Register link")
    public void customer_clicks_on_register_link() {
        this.loginPage.goToRegister();
        this.registerPage = this.testContext.getPageObjectManager().getCustomerRegistrationPage();
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
        this.registerPage = this.testContext.getPageObjectManager().getCustomerRegistrationPage();
    }

    @When("customer type all the customer information in the register form")
    public void customer_type_all_the_customer_information_in_the_register_form() {
        this.registerPage.setUsernameInput(this.testContext.getCredentials().get("username"));
        this.registerPage.setPasswordInput(this.testContext.getCredentials().get("password"));
        this.registerPage.setPasswordConfirmInput(this.testContext.getCredentials().get("password"));
        this.registerPage.setEmailInput(this.testContext.getCredentials().get("email"));
        this.registerPage.setFirstNameInput(this.testContext.getCredentials().get("firstname"));
        this.registerPage.setLastNameInput(this.testContext.getCredentials().get("lastname"));
    }

    @When("customer clicks on Register button")
    public void customer_clicks_on_register_button() {
        this.registerPage.register();
        this.customerSummaryPage = this.testContext.getPageObjectManager().getCustomerSummaryPage();
    }

    @When("customer types customer credentials and click on sign in button")
    public void customer_types_customer_credentials_and_click_on_sign_in_button() {

        this.loginPage.setUsernameInput(this.testContext.getCredentials().get("username"));
        this.loginPage.setPasswordInput(this.testContext.getCredentials().get("password"));
        this.loginPage.clickLoginButton();
        this.customerSummaryPage = this.testContext.getPageObjectManager().getCustomerSummaryPage();
    }

    @Then("customer is routed to customer summary page")
    public void customer_is_routed_to_customer_summary_page() {
        Assert.assertEquals(this.customerSummaryPage.getUrl(), this.testContext.getTestBase().getRootUrl());
    }

}
