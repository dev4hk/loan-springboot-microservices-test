package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import page_objects.customer.CustomerCounselPage;
import page_objects.customer.CustomerSummaryPage;
import utils.TestContext;

import java.util.List;

public class CounselStepDefinitions {
    TestContext testContext;
    CustomerSummaryPage customerSummaryPage;
    CustomerCounselPage customerCounselPage;

    public CounselStepDefinitions(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("customer is on counsel page")
    public void customer_is_on_counsel_page() {
        this.customerSummaryPage = this.testContext.getPageObjectManager().getCustomerSummaryPage();
        this.customerSummaryPage.goToCustomerCounsel();
        this.customerCounselPage = this.testContext.getPageObjectManager().getCustomerCounselPage();
        Assert.assertTrue(this.customerCounselPage.getUrl().contains("/counsel"));
    }

    @When("customer types counsel information")
    public void customer_types_counsel_information(List<String> data) {
        this.customerCounselPage.setCellPhoneInput(data.get(0));
        this.customerCounselPage.setAddress1Input(data.get(1));
        this.customerCounselPage.setAddress2Input(data.get(2));
        this.customerCounselPage.setCityInput(data.get(3));
        this.customerCounselPage.setStateInput(data.get(4));
        this.customerCounselPage.setZipcodeInput(data.get(5));
        this.customerCounselPage.setMemoInput(data.get(6));
    }

    @When("customer clicks on counsel Submit button")
    public void customer_clicks_on_counsel_Submit_Button() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) this.testContext.getTestBase().getDriver();
        js.executeScript("window.scrollBy(0, 500)");
        Thread.sleep(500);
        this.customerCounselPage.submit();
    }

    @Then("customer sees counsel information")
    public void customer_sees_counsel_information() {
        Assert.assertEquals(this.customerCounselPage.getCounselCardHeaderText(), "Loan Counsel Details");
    }

    @When("customer clicks to open memo")
    public void customer_clicks_to_open_memo() {
        this.customerCounselPage.openMemo();
    }

    @Then("customer is able to see the counsel memo")
    public void customer_is_able_to_see_the_counsel_memo() {
        Assert.assertTrue(this.customerCounselPage.isMemoDisplayed());
    }

    @When("counsel FAQ question is clicked")
    public void counsel_faq_question_is_clicked() {
        this.customerCounselPage.openFaqQuestion();
    }

    @Then("counsel FAQ answer is displayed")
    public void faq_answer_is_displayed() {
        Assert.assertTrue(this.customerCounselPage.isFaqAnswerDisplayed());
    }

    @When("customer clicks update button")
    public void customer_clicks_update_button() {
        this.customerCounselPage.openUpdate();
    }

    @When("customer updates memo as {string}")
    public void customer_updates_memo(String memo) {
        this.customerCounselPage.updateMemo(memo);
    }

    @Then("counsel memo is updated as {string}")
    public void counsel_memo_is_update_as(String memo) {
        Assert.assertEquals(this.customerCounselPage.getMemo(), memo);
    }
}
