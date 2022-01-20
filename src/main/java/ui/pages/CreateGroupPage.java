package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.elements.InputField;
import ui.utils.Waiters;

public class CreateGroupPage extends UserGroupsPage {

    public CreateGroupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "inputDescription")
    private WebElement descriptionField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement createBtn;
    @FindBy(xpath = "//*[contains(@class, 'feedback')]")
    private WebElement emptyDescriptionFieldMessage;

    @Step("Enter the group title: '{groupTitle}' and the description: '{description}'")
    public UserGroupsPage createGroupFillingInAllFields(String groupTitle, String description) {
        new InputField(driver, GROUP_TITLE_LABEL).writeTextIntoInputField(groupTitle);
        descriptionField.sendKeys(description);
        clickOnCreateButton();
        return new UserGroupsPage (driver);
    }

    @Step("Enter the group title: '{groupTitle}' and the description: '{description}'")
    public CreateGroupPage createGroupFillingInOneOfRequiredFields(String groupTitle, String description) {
        new InputField(driver, GROUP_TITLE_LABEL).writeTextIntoInputField(groupTitle);
        descriptionField.sendKeys(description);
        clickOnCreateButton();
        return this;
    }

    @Step("Click on the 'Create' button")
    public void clickOnCreateButton() {
        createBtn.click();
    }

    public String getEmptyDescriptionFieldErrorMessage() {
        Waiters.waitForElementLocated(driver, emptyDescriptionFieldMessage, 5);
        return emptyDescriptionFieldMessage.getText();
    }
}
