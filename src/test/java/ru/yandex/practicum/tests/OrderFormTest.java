package ru.yandex.practicum.tests;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.yandex.practicum.pages.MainPage;
import ru.yandex.practicum.pages.OrderPage1;
import ru.yandex.practicum.pages.OrderPage2;
import ru.yandex.practicum.utils.DriverFactory;


@RunWith(Parameterized.class)
public class OrderFormTest {
    private final String orderButton;
    private final String scrollTo;
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

    public OrderFormTest(String orderButton, String scrollTo, String textForNameField, String textForSurnameField, String textForAddressField, String textForMetroStationField, String textForPhoneNumberField, String textForDateField, int durationOption, String colorId, String textForCommentField) {
        this.orderButton = orderButton;
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

    @Parameterized.Parameters
    public static Object[][] getParametersForFAQ(){
        return new Object[][] {
            {"button.Button_Button__ra12g", "Header_Header__214zg", "Иван", "Иванов", "г. Москва", "Бульвар Рокосовского", "87776665544", "10.09.2030", 0, "black", "Жду"},
            {"button.Button_Button__ra12g", "Home_FinishButton__1_cWm", "Джон", "Константин", "Лос Анжелес", "Лубянка", "12223334455", "20.11.2027", 3, "grey", "Боюсь, не дождусь"},
        };
    }

    @Test
    public void testSuccessScooterOrder() {
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.closeCookie();
        OrderPage1 orderPage1 = mainPage.clickOnOrderButton(scrollTo, orderButton);
        orderPage1.fillTheNameField(textForNameField);
        orderPage1.fillTheSurnameField(textForSurnameField);
        orderPage1.fillTheAddressField(textForAddressField);
        orderPage1.fillTheMetroStationField(textForMetroStationField);
        orderPage1.fillThePhoneNumberField(textForPhoneNumberField);
        OrderPage2 orderPage2 = orderPage1.clickOnNextButton();
        orderPage2.fillTheDateField(textForDateField);
        orderPage2.fillTheDurationField(durationOption);
        orderPage2.chooseTheColorCheckbox(colorId);
        orderPage2.fillTheCommentField(textForCommentField);
        orderPage2.clickOnOtherOrderButton();
        orderPage2.clickOnYesButton();
        orderPage2.checkIfTheOrderIsCreated();
    }

}
