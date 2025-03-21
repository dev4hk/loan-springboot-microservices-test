package page_objects.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page_objects.BasePageComponent;

import java.util.List;

public class ManagerTermsPage extends BasePageComponent {

    @FindBy(css = ".create-link.cursor-pointer")
    private WebElement toggleForm;

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "termsDetail")
    private WebElement termsDetailInput;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    @FindBy(tagName = "form")
    private WebElement form;

    @FindBy(css = ".mat-mdc-snack-bar-label.mdc-snackbar__label")
    private WebElement toast;

    @FindBy(css = "table tbody tr")
    private List<WebElement> tableData;

    public ManagerTermsPage(WebDriver driver) {
        super(driver);
    }

    public void toggleForm() {
        this.toggleForm.click();
    }

    public void setNameInput(String name) {
        this.nameInput.clear();
        this.nameInput.sendKeys(name);
    }

    public void setTermsDetailInput(String detail) {
        this.termsDetailInput.clear();
        this.termsDetailInput.sendKeys(detail);
    }

    public void submit() {
        this.submitButton.click();
    }

    public boolean isFormDisplayed() {
        return this.form.isDisplayed();
    }

    public String getToastMessage() {
        this.wait.until(ExpectedConditions.visibilityOf(toast));
        return this.toast.getText();
    }

    public boolean termExists(String name) {
        By termBy = By.xpath("//a[normalize-space()=" + name + "]");
        return this.driver.findElement(termBy).isDisplayed();
    }

    public void clickUpdate(String name) {
        for(var row : tableData) {
            if(row.findElement(By.cssSelector("td:nth-child(2) a")).getText().equalsIgnoreCase(name)) {
                row.findElement(By.cssSelector("td:nth-child(4) button:nth-child(1)")).click();
                break;
            }
        }
    }

    public boolean isTermDisplayed(String name) throws InterruptedException {
        Thread.sleep(3000);
        for(var row : tableData) {
            if(row.findElement(By.cssSelector("td:nth-child(2) a")).getText().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void clickDelete(String name) {
        for(var row : tableData) {
            if(row.findElement(By.cssSelector("td:nth-child(2) a")).getText().equalsIgnoreCase(name)) {
                row.findElement(By.cssSelector("td:nth-child(4) button:nth-child(2)")).click();
                break;
            }
        }
    }
}
