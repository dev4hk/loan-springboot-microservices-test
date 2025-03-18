package page_objects.customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginPage extends CustomerBasePageComponent {

    @FindBy(id = "kc-header-wrapper")
    WebElement pageTitle;

    @FindBy(id = "kc-page-title")
    WebElement formTitle;

    @FindBy(id = "username")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "kc-login")
    WebElement loginButton;

    @FindBy(linkText = "Register")
    WebElement registerLink;

    public CustomerLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void setUsernameInput(String username) {
        this.usernameInput.sendKeys(username);
    }

    public void setPasswordInput(String password) {
        this.passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        this.loginButton.click();
    }

    public void goToRegister() {
        this.registerLink.click();
    }

    public String getPageTitle() {
        return this.pageTitle.getText();
    }

    public String getFormTitle() {
        return this.formTitle.getText();
    }
}
