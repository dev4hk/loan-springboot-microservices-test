package page_objects.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page_objects.BasePageComponent;

import java.util.List;

public class ManagerCounselPage extends BasePageComponent {

    @FindBy(css = "table tbody tr")
    private List<WebElement> rows;

    private By emailCell = By.cssSelector("td:nth-child(4)");
    private By viewDetailsButton = By.cssSelector(".view-details-link");

    public ManagerCounselPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void goToCounselDetailPage(String email) {
        for(var row : rows) {
            String rowEmail = row.findElement(emailCell).getText();
            if(rowEmail.equalsIgnoreCase(email)) {
                row.findElement(viewDetailsButton).click();
                break;
            }
        }
    }
}
