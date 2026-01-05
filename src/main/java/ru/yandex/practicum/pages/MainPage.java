package ru.yandex.practicum.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.practicum.pages.utils.EnvConfig;

import java.time.Duration;
import java.util.List;

public class MainPage {
    private final WebDriver driver;

    private final By questionButton = By.cssSelector(".accordion__button");
    private final By FAQSection = By.xpath("//div[contains(text(), 'Вопросы о важном')]");
    private final By cookieCloseButton = By.className("App_CookieButton__3cvqF");
    private final By scrollToTopOrderButton = By.className("Header_Header__214zg");
    private final By scrollToBottomOrderButton = By.className("Home_FinishButton__1_cWm");
    private final By orderButton = By.cssSelector("button.Button_Button__ra12g");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkTheText(int questionNumber, String expectedAnswer) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement answer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#accordion__panel-" + questionNumber)
        ));
        Assert.assertNotNull(answer);
        Assert.assertEquals(expectedAnswer, answer.getText());
    }

    public void clickOnQuestionButton(int questionNumber) {
        List<WebElement> dropdownButtons = driver.findElements(questionButton);
        dropdownButtons.get(questionNumber).click();
    }

    public void scroll() {
        WebElement questionsSection = driver.findElement(FAQSection);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", questionsSection);
    }

    public void closeCookie() {
        driver.findElement(cookieCloseButton).click();
    }

    public void openMainPage() {
        driver.get(EnvConfig.BASE_URL);
    }

    public FirstOrderPage clickOnOrderButton(int scrollTo) {
        WebElement orderSection;
        if (scrollTo == 0) {
            orderSection = driver.findElement(scrollToTopOrderButton);
        } else {
            orderSection = driver.findElement(scrollToBottomOrderButton);
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", orderSection);
        driver.findElement(orderButton).click();
        return new FirstOrderPage(driver);
    }
}
