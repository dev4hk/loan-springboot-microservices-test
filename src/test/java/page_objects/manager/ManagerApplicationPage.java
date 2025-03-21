package page_objects.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page_objects.BasePageComponent;

import java.util.List;

public class ManagerApplicationPage extends BasePageComponent {

    @FindBy(tagName = "table")
    private WebElement table;

    @FindBy(css = "table tbody tr")
    private List<WebElement> rows;

    private By byEmailCell = By.cssSelector("td:nth-of-type(4)");

    public ManagerApplicationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public boolean isDataTableDisplayed() {
        return this.table.isDisplayed();
    }

    public int getApplicationCount() {
        return rows.size();
    }

    public boolean dataExists(String email) {
        for (var row : rows) {
            WebElement rowEmail = row.findElement(byEmailCell);
            if (rowEmail.getText().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public void clickDetail(String email) {
        for(var row : rows) {
            WebElement rowEmail = row.findElement(byEmailCell);
            if(rowEmail.getText().equalsIgnoreCase(email)) {
                row.findElement(By.tagName("a")).click();
                break;
            }
        }
    }
}
