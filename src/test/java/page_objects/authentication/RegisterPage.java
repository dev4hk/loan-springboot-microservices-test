package page_objects.authentication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page_objects.BasePageComponent;

public class RegisterPage extends BasePageComponent {

    @FindBy(id = "kc-header-wrapper")
    private WebElement pageTitle;

    @FindBy(id = "kc-page-title")
    private WebElement formTitle;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "password-confirm")
    private WebElement passwordConfirmInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    @FindBy(id = "kc-form-buttons")
    private WebElement registerButton;

    @FindBy(partialLinkText = "Back to Login")
    private WebElement backToLoginLink;

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void setUsernameInput(String username) {
        this.usernameInput.sendKeys(username);
    }

    public void setPasswordInput(String password) {
        this.passwordInput.sendKeys(password);
    }

    public void setPasswordConfirmInput(String passwordConfirm) {
        this.passwordConfirmInput.sendKeys(passwordConfirm);
    }

    public void setEmailInput(String email) {
        this.emailInput.sendKeys(email);
    }

    public void setFirstNameInput(String firstName) {
        this.firstNameInput.sendKeys(firstName);
    }

    public void setLastNameInput(String lastName) {
        this.lastNameInput.sendKeys(lastName);
    }

    public void register() {
        this.registerButton.click();
    }

    public void goBackToLogin() {
        this.backToLoginLink.click();
    }

    public String getPageTitle() {
        return this.pageTitle.getText();
    }

    public String getFormTitle() {
        return this.formTitle.getText();
    }

}
