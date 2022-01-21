package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.elements.*;
import ui.utils.Waiters;

public class UserMenuPage extends AppMenu {

    public UserMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-menu")
    private WebElement userMenuBtn;

    @Step("Click on the 'User Menu' button")
    public UserMenuPage clickOnUserMenuButton() {
        Waiters.waitForElementLocated(driver, userMenuBtn, 5);
        userMenuBtn.click();
        return this;
    }

    @Step("Sign out from the website")
    public LoginPage signOut() {
        clickOnUserMenuButton();
        new UserMenuDropdown(driver, SIGN_OUT_USER_MENU_OPTION).clickOnOption();
        return new LoginPage(driver);
    }
}
