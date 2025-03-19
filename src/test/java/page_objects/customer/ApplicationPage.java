package page_objects.customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page_objects.BasePageComponent;

public class ApplicationPage extends BasePageComponent {
    public ApplicationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getUrl() {
        return this.driver.getCurrentUrl();
    }
}
