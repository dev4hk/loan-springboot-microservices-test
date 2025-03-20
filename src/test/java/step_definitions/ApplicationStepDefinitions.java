package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import page_objects.customer.CustomerApplicationPage;
import page_objects.customer.CustomerSummaryPage;
import page_objects.manager.ManagerApplicationDetailPage;
import page_objects.manager.ManagerApplicationPage;
import page_objects.manager.ManagerSummaryPage;
import utils.TestContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class ApplicationStepDefinitions {

    TestContext testContext;
    CustomerSummaryPage customerSummaryPage;
    CustomerApplicationPage customerApplicationPage;
    ManagerSummaryPage managerSummaryPage;
    ManagerApplicationPage managerApplicationPage;
    ManagerApplicationDetailPage managerApplicationDetailPage;

    public ApplicationStepDefinitions(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("customer is on application page")
    public void customer_is_on_application_page() throws InterruptedException {
        this.customerSummaryPage = this.testContext.getPageObjectManager().getCustomerSummaryPage();
        this.customerSummaryPage.goToCustomerApplication();
        this.customerApplicationPage = this.testContext.getPageObjectManager().getCustomerApplicationPage();
        Thread.sleep(500);
        Assert.assertTrue(this.customerApplicationPage.getUrl().contains("/application"));
    }

    @Then("customer is able to see application form")
    public void customer_is_able_to_see_application_form() {
        Assert.assertTrue(this.customerApplicationPage.isFormDisplayed());
    }

    @When("customer fills out application form with data")
    public void customer_fills_out_application_form(List<String> data) {
        String cellPhone = data.get(0);
        String hopeAmount = data.get(1);
        this.customerApplicationPage.setCellPhone(cellPhone);
        this.customerApplicationPage.setHopeAmount(hopeAmount);
    }

    @When("customer clicks on application Submit button")
    public void customer_clicks_on_application_Submit_Button() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) this.testContext.getTestBase().getDriver();
        js.executeScript("window.scrollBy(0, 500)");
        Thread.sleep(500);
        this.customerApplicationPage.submitApplication();
    }

    @Then("successful application creation message pops up")
    public void successful_application_creation_message_pops_up() {
        Assert.assertEquals(this.customerApplicationPage.getToastMessage(), "Application submitted successfully!");
    }

    @Then("application information is displayed with data")
    public void application_information_is_displayed_with_data(List<String> data) {
        Assert.assertTrue(this.customerApplicationPage.isDataDisplayed(data.get(0)));
        Assert.assertTrue(this.customerApplicationPage.isDataDisplayed(data.get(1)));
    }

    @When("customer agrees terms and submit")
    public void customer_agrees_terms_and_submit() {
        this.customerApplicationPage.checkTerms();
        this.customerApplicationPage.submitTerms();
    }

    @When("application FAQ question is clicked")
    public void application_faq_question_is_clicked() {
        this.customerApplicationPage.openFaqQuestion();
    }

    @Then("application FAQ answer is displayed")
    public void faq_answer_is_displayed() {
        Assert.assertTrue(this.customerApplicationPage.isFaqAnswerDisplayed());
    }

    @Then("number of applications is not zero")
    public void number_of_applications_is_not_zero() {
        this.managerSummaryPage = this.testContext.getPageObjectManager().getManagerSummaryPage();
        Assert.assertTrue(this.managerSummaryPage.countApplication() != 0);
    }

    @Given("manager is on application page")
    public void manager_is_on_application_page() {
        this.managerSummaryPage = this.testContext.getPageObjectManager().getManagerSummaryPage();
        this.managerSummaryPage.goToManagerApplicationPage();
        this.managerApplicationPage = this.testContext.getPageObjectManager().getManagerApplicationPage();
    }

    @When("application data table is displayed")
    public void application_data_table_is_displayed() {
        Assert.assertTrue(this.managerApplicationPage.isDataTableDisplayed());
    }

    @Then("application count in table is not zero")
    public void application_count_in_table_is_not_zero() {
        Assert.assertTrue(this.managerApplicationPage.getApplicationCount() != 0);
    }

    @Then("application from customer email {string} exists")
    public void application_from_customer_email_exists(String email) {
        Assert.assertTrue(this.managerApplicationPage.dataExists(email));
    }

    @When("manager clicks on details button of application by customer with email {string}")
    public void manager_clicks_on_details_button_of_application_by_customer_with_email(String email) {
        this.managerApplicationPage.clickDetail(email);
    }

    @Then("manager is routed to application detail page by customer with email {string}")
    public void manager_is_routed_to_application_detail_page_by_customer_with_email(String email) {
        this.managerApplicationDetailPage = this.testContext.getPageObjectManager().getManagerApplicationDetailPage();
        Assert.assertTrue(this.managerApplicationDetailPage.isApplicationBy(email));
    }

    @When("manager types judgement information")
    public void manager_types_judgement_information(Map<String, String> data) {
        this.managerApplicationDetailPage.setJudgementAmount(data.get("Judgement Amount"));
        this.managerApplicationDetailPage.setStartDate(data.get("Start Date"));
        this.managerApplicationDetailPage.setEndDate(data.get("End Date"));
        this.managerApplicationDetailPage.setPayDay(data.get("Pay Day"));
        this.managerApplicationDetailPage.setInterest(data.get("Interest"));
    }

    @When("manager clicks on Submit Judgement button")
    public void manager_clicks_on_submit_judgement_button() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) this.testContext.getTestBase().getDriver();
        js.executeScript("window.scrollBy(0, 1000)");
        Thread.sleep(500);
        this.managerApplicationDetailPage.submitJudgement();
    }

    @Then("submit success message pops up")
    public void submit_success_message_pops_up() {
        Assert.assertEquals(this.managerApplicationDetailPage.getToastMessage(), "Approval amount created.");
    }

    @Then("judgement information is updated with data")
    public void judgement_information_is_updated_with_data(Map<String, String> data) throws InterruptedException {
        String judgementAmount = data.get("Judgement Amount");
        String startDate = data.get("Start Date");
        String endDate = data.get("End Date");
        String payDay = data.get("Pay Day");
        String interest = data.get("Interest");
        Assert.assertTrue(this.managerApplicationDetailPage.getJudgementAmount().contains(judgementAmount));
        Assert.assertTrue(this.managerApplicationDetailPage.getStartDate().contains(startDate));
        Assert.assertTrue(this.managerApplicationDetailPage.getEndDate().contains(endDate));
        Assert.assertTrue(this.managerApplicationDetailPage.getPayDay().contains(payDay));
        Assert.assertTrue(this.managerApplicationDetailPage.getInterest().contains(interest));
    }

    @When("manager clicks on Update button")
    public void manager_clicks_on_update_button() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) this.testContext.getTestBase().getDriver();
        js.executeScript("window.scrollBy(0, 1000)");
        Thread.sleep(500);
        this.managerApplicationDetailPage.updateJudgement();
    }

    @When("manager clicks on Grant Approval Amount button")
    public void manager_clicks_on_grant_approval_amount_button() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) this.testContext.getTestBase().getDriver();
        js.executeScript("window.scrollBy(0, 1000)");
        Thread.sleep(500);
        this.managerApplicationDetailPage.grantAmount();
    }

    @Then("approval amount granted message pops up")
    public void approval_amount_granted_message_pops_up() {
        Assert.assertEquals(this.managerApplicationDetailPage.getToastMessage(), "Approval amount has been granted.");
    }

    @Then("approval amount of {string} is fixed")
    public void approval_amount_is_fixed(String amount) {
        Assert.assertTrue(this.managerApplicationDetailPage.getApprovalAmount().toLowerCase().contains(amount.toLowerCase()));
    }


    @When("customer clicks on Click to Contract button")
    public void customerClicksOnClickToContractButton() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) this.testContext.getTestBase().getDriver();
        js.executeScript("window.scrollBy(0, 1000)");
        Thread.sleep(500);
        this.customerApplicationPage.contract();
    }

    @Then("loan application is contracted")
    public void loanApplicationIsContracted() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatted = today.format(formatter);
        Assert.assertTrue(this.customerApplicationPage.getContractedAt().contains(formatted));
    }
}
