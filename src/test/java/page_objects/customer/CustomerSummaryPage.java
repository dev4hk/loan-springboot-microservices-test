package page_objects.customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CustomerSummaryPage extends CustomerBasePageComponent {
    public CustomerSummaryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getUrl() {
        return this.driver.getCurrentUrl();
    }
}
