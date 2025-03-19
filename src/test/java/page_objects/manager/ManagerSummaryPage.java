package page_objects.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page_objects.BasePageComponent;

public class ManagerSummaryPage extends BasePageComponent {

    public ManagerSummaryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getUrl() {
        return this.driver.getCurrentUrl();
    }
}
