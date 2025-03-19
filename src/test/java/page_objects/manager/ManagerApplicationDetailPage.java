package page_objects.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page_objects.BasePageComponent;

public class ManagerApplicationDetailPage extends BasePageComponent {

    @FindBy(id = "email")
    WebElement emailElement;

    public ManagerApplicationDetailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public boolean isApplicationBy(String email) {
        return this.emailElement.getText().toLowerCase().contains(email.toLowerCase());
    }
}
