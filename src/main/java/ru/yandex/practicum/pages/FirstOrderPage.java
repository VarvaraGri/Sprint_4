package ru.yandex.practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FirstOrderPage {
    private final WebDriver driver;

    private final By nextButton = By.cssSelector("button.Button_Middle__1CSJM");
    private final By phoneNumberField = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    private final By metroFieldButton = By.className("select-search__input");
    private final By metroField = By.cssSelector("input[placeholder='* Станция метро']");
    private final By metroSelect = By.className("select-search__select");
    private final By addressField = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    private final By surnameField = By.cssSelector("input[placeholder='* Фамилия']");
    private final By nameField  = By.cssSelector("input[placeholder='* Имя']");

    public FirstOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public SecondOrderPage clickOnNextButton() {
        driver.findElement(nextButton).click();
        return new SecondOrderPage(driver);
    }

    public void fillThePhoneNumberField(String textForPhoneNumberField) {
        driver.findElement(phoneNumberField).sendKeys(textForPhoneNumberField);
    }

    public void fillTheMetroStationField(String textForMetroStationField) {
        driver.findElement(metroFieldButton).click();
        driver.findElement(metroField).sendKeys(textForMetroStationField);
        driver.findElement(metroSelect).click();
    }

    public void fillTheAddressField(String textForAddressField) {
        driver.findElement(addressField).sendKeys(textForAddressField);
    }

    public void fillTheSurnameField(String textForSurnameField) {
        driver.findElement(surnameField).sendKeys(textForSurnameField);
    }

    public void fillTheNameField(String textForNameField) {
        driver.findElement(nameField).sendKeys(textForNameField);
    }
}
