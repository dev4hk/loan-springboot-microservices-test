package page_objects.customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page_objects.BasePageComponent;

public class CustomerRepaymentPage extends BasePageComponent {
    public CustomerRepaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getUrl() {
        return this.driver.getCurrentUrl();
    }
}
