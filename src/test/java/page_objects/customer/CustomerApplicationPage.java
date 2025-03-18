package page_objects.customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CustomerApplicationPage extends CustomerBasePageComponent{
    public CustomerApplicationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getUrl() {
        return this.driver.getCurrentUrl();
    }
}
