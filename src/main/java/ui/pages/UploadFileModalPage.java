package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.utils.Waiters;

import java.io.File;

@Log4j2
public class UploadFileModalPage extends ProjectRepositoryPage {

    public UploadFileModalPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='file']")
    private static WebElement uploadFile;
    @FindBy(xpath = "//*[contains(text(), 'Drop files here')]")
    private static WebElement dropZoneMessage;

    @Step("Upload the '{fileName}' file")
    public static void uploadFile(WebDriver driver, String fileName) {
        File filePath = new File(String.format("src/test/resources/%s", fileName));
        Waiters.waitForElementLocated(driver, dropZoneMessage, 5);
        log.info("Attaching the " + fileName + " file");
        uploadFile.sendKeys(filePath.getAbsolutePath());
    }
}
