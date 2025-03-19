package page_objects.authentication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page_objects.BasePageComponent;

public class RegisterPage extends BasePageComponent {

    @FindBy(id = "kc-header-wrapper")
    WebElement pageTitle;

    @FindBy(id = "kc-page-title")
    WebElement formTitle;

    @FindBy(id = "username")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "password-confirm")
    WebElement passwordConfirmInput;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "firstName")
    WebElement firstNameInput;

    @FindBy(id = "lastName")
    WebElement lastNameInput;

    @FindBy(id = "kc-form-buttons")
    WebElement registerButton;

    @FindBy(partialLinkText = "Back to Login")
    WebElement backToLoginLink;

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
