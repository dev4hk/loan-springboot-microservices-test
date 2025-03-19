package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import page_objects.manager.ManagerSummaryPage;
import page_objects.manager.ManagerTermsPage;
import utils.TestContext;

public class TermsStepDefinitions {
    TestContext testContext;
    ManagerSummaryPage managerSummaryPage;
    ManagerTermsPage managerTermsPage;

    public TermsStepDefinitions(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("manager is on terms page")
    public void manager_is_on_terms_page() {
        this.managerSummaryPage = this.testContext.getPageObjectManager().getManagerSummaryPage();
        this.managerSummaryPage.goToManagerTerms();
        this.managerTermsPage = this.testContext.getPageObjectManager().getManagerTermsPage();
    }

    @When("manager open terms form")
    public void manager_open_terms_form() {
        this.managerTermsPage.toggleForm();
        Assert.assertTrue(this.managerTermsPage.isFormDisplayed());
    }

    @When("manager types terms name {string} and detail {string}")
    public void manager_types_terms_name_and_detail(String name, String detail) {
        this.managerTermsPage.setNameInput(name);
        this.managerTermsPage.setTermsDetailInput(detail);
    }

    @When("manager clicks on submit button")
    public void manager_clicks_on_submit_button() {
        this.managerTermsPage.submit();
    }

    @Then("successful create message pops up")
    public void successful_create_message_pops_up() {
        Assert.assertEquals(this.managerTermsPage.getToastMessage(), "Term created successfully!");
    }

    @Then("successful update message pops up")
    public void successful_update_message_pops_up() {
        Assert.assertEquals(this.managerTermsPage.getToastMessage(), "Term updated successfully!");
    }

    @When("manager clicks on update button of name {string}")
    public void manager_clicks_on_update_button(String name) {
        this.managerTermsPage.clickUpdate(name);
    }

    @Then("term name {string} is displayed in table")
    public void term_name_is_displayed_in_table(String name) throws InterruptedException {
        Assert.assertTrue(this.managerTermsPage.isTermDisplayed(name));
    }

    @When("manager deletes term {string}")
    public void manager_deletes_term(String name) {
        this.managerTermsPage.clickDelete(name);
        this.testContext.getTestBase().getDriver().switchTo().alert().accept();
    }

    @Then("term {string} is deleted")
    public void term_is_deleted(String name) throws InterruptedException {
        Assert.assertFalse(this.managerTermsPage.isTermDisplayed(name));
    }
}
