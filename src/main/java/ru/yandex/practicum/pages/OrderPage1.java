package ru.yandex.practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage1 {
    private final WebDriver driver;

    public OrderPage1(WebDriver driver) {
        this.driver = driver;
    }

    public OrderPage2 clickOnNextButton() {
        driver.findElement(By.cssSelector("button.Button_Middle__1CSJM")).click();
        return new OrderPage2(driver);
    }

    public void fillThePhoneNumberField(String textForPhoneNumberField) {
        driver.findElement(By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']")).sendKeys(textForPhoneNumberField);
    }

    public void fillTheMetroStationField(String textForMetroStationField) {
        driver.findElement(By.className("select-search__input")).click();
        driver.findElement(By.cssSelector("input[placeholder='* Станция метро']")).sendKeys(textForMetroStationField);
        driver.findElement(By.className("select-search__select")).click();
    }

    public void fillTheAddressField(String textForAddressField) {
        driver.findElement(By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']")).sendKeys(textForAddressField);
    }

    public void fillTheSurnameField(String textForSurnameField) {
        driver.findElement(By.cssSelector("input[placeholder='* Фамилия']")).sendKeys(textForSurnameField);
    }

    public void fillTheNameField(String textForNameField) {
        driver.findElement(By.cssSelector("input[placeholder='* Имя']")).sendKeys(textForNameField);
    }
}
