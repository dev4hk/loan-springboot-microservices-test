package page_objects.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page_objects.BasePageComponent;

public class ManagerCounselDetailPage extends BasePageComponent {

    @FindBy(css = ".btn.btn-custom-inverse")
    WebElement markAsCompleteButton;

    @FindBy(xpath = "//span[normalize-space()=\"Completed\"]")
    WebElement completedMark;

    @FindBy(id = "email")
    WebElement email;

    public ManagerCounselDetailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void markAsComplete() {
        this.markAsCompleteButton.click();
    }

    public boolean isCompleted() {
        return this.completedMark.isDisplayed();
    }

    public String getEmail() {
        return this.email.getText();
    }
}
