package ru.yandex.practicum.tests;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.yandex.practicum.pages.MainPage;
import ru.yandex.practicum.pages.FirstOrderPage;
import ru.yandex.practicum.pages.SecondOrderPage;
import ru.yandex.practicum.utils.DriverFactory;


@RunWith(Parameterized.class)
public class OrderFormTest {
    private final int scrollTo;
    private final String textForNameField;
    private final String textForSurnameField;
    private final String textForAddressField;
    private final String textForMetroStationField;
    private final String textForPhoneNumberField;
    private final String textForDateField;
    private final int durationOption;
    private final String colorId;
    private final String textForCommentField;

    @Rule
    public DriverFactory factory = new DriverFactory();

    public OrderFormTest(int scrollTo, String textForNameField, String textForSurnameField, String textForAddressField, String textForMetroStationField, String textForPhoneNumberField, String textForDateField, int durationOption, String colorId, String textForCommentField) {
        this.scrollTo = scrollTo;
        this.textForNameField = textForNameField;
        this.textForSurnameField = textForSurnameField;
        this.textForAddressField = textForAddressField;
        this.textForMetroStationField = textForMetroStationField;
        this.textForPhoneNumberField = textForPhoneNumberField;
        this.textForDateField = textForDateField;
        this.durationOption = durationOption;
        this.colorId = colorId;
        this.textForCommentField = textForCommentField;

    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getParametersForFAQ(){
        return new Object[][] {
            {0, "Иван", "Иванов", "г. Москва", "Бульвар Рокосовского", "87776665544", "10.09.2030", 0, "black", "Жду"},
            {1, "Джон", "Константин", "Лос Анжелес", "Лубянка", "12223334455", "20.11.2027", 3, "grey", "Боюсь, не дождусь"},
        };
    }

    @Test
    public void testSuccessScooterOrder() {
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.closeCookie();
        FirstOrderPage firstOrderPage = mainPage.clickOnOrderButton(scrollTo);
        firstOrderPage.fillTheNameField(textForNameField);
        firstOrderPage.fillTheSurnameField(textForSurnameField);
        firstOrderPage.fillTheAddressField(textForAddressField);
        firstOrderPage.fillTheMetroStationField(textForMetroStationField);
        firstOrderPage.fillThePhoneNumberField(textForPhoneNumberField);
        SecondOrderPage secondOrderPage = firstOrderPage.clickOnNextButton();
        secondOrderPage.fillTheDateField(textForDateField);
        secondOrderPage.fillTheDurationField(durationOption);
        secondOrderPage.chooseTheColorCheckbox(colorId);
        secondOrderPage.fillTheCommentField(textForCommentField);
        secondOrderPage.clickOnOtherOrderButton();
        secondOrderPage.clickOnYesButton();
        secondOrderPage.checkIfTheOrderIsCreated();
    }

}
