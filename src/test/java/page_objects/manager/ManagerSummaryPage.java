package page_objects.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page_objects.BasePageComponent;

public class ManagerSummaryPage extends BasePageComponent {

    @FindBy(id = "applicationCount")
    WebElement applicationCount;

    public ManagerSummaryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getUrl() {
        return this.driver.getCurrentUrl();
    }

    public int countApplication() {
        return Integer.parseInt(applicationCount.getText());
    }

}
