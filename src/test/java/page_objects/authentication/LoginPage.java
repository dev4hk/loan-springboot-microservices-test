package page_objects.authentication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page_objects.BasePageComponent;

public class LoginPage extends BasePageComponent {

    @FindBy(id = "kc-header-wrapper")
    private WebElement pageTitle;

    @FindBy(id = "kc-page-title")
    private WebElement formTitle;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "kc-login")
    private WebElement loginButton;

    @FindBy(linkText = "Register")
    private WebElement registerLink;

    public LoginPage(WebDriver driver) {
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
