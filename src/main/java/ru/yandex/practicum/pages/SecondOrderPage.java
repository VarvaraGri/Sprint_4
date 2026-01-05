package ru.yandex.practicum.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SecondOrderPage {
    private final WebDriver driver;

    private final By orderHeader = By.className("Order_ModalHeader__3FDaJ");
    private final By yesButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    private final By otherOrderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    private final By commentField = By.cssSelector("input[placeholder='Комментарий для курьера']");
    private final By durationArrowButton = By.className("Dropdown-arrow");
    private final By durationOptions = By.className("Dropdown-option");
    private final By dateField = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN");

    public SecondOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkIfTheOrderIsCreated() {
        Assert.assertTrue(driver.findElement(orderHeader).getText().contains("Заказ оформлен"));
    }

    public void clickOnYesButton() {
        driver.findElement(yesButton).click();
    }

    public void clickOnOtherOrderButton() {
        driver.findElement(otherOrderButton).click();
    }

    public void fillTheCommentField(String textForCommentField) {
        driver.findElement(commentField).sendKeys(textForCommentField);
    }

    public void chooseTheColorCheckbox(String colorId) {
        driver.findElement(By.id(colorId)).click();
    }

    public void fillTheDurationField(int durationOption) {
        driver.findElement(durationArrowButton).click();
        List<WebElement> dropDownOptions = driver.findElements(durationOptions);
        dropDownOptions.get(durationOption).click();
    }

    public void fillTheDateField(String textForDateField) {
        driver.findElement(dateField).sendKeys(textForDateField);
    }
}
