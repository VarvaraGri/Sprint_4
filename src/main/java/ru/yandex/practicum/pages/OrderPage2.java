package ru.yandex.practicum.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderPage2 {
    private final WebDriver driver;

    public OrderPage2(WebDriver driver) {
        this.driver = driver;
    }

    public void checkIfTheOrderIsCreated() {
        Assert.assertTrue(driver.findElement(By.className("Order_ModalHeader__3FDaJ")).getText().contains("Заказ оформлен"));
    }

    public void clickOnYesButton() {
        driver.findElement(By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']")).click();
    }

    public void clickOnOtherOrderButton() {
        driver.findElement(By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']")).click();
    }

    public void fillTheCommentField(String textForCommentField) {
        driver.findElement(By.cssSelector("input[placeholder='Комментарий для курьера']")).sendKeys(textForCommentField);
    }

    public void chooseTheColorCheckbox(String colorId) {
        driver.findElement(By.id(colorId)).click();
    }

    public void fillTheDurationField(int durationOption) {
        driver.findElement(By.className("Dropdown-arrow")).click();
        List<WebElement> dropDownOptions = driver.findElements(By.className("Dropdown-option"));
        dropDownOptions.get(durationOption).click();
    }

    public void fillTheDateField(String textForDateField) {
        driver.findElement(By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN")).sendKeys(textForDateField);
    }
}
