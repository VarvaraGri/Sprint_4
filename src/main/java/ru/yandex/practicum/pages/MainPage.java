package ru.yandex.practicum.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {
    private final WebDriver driver;

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
        List<WebElement> dropdownButtons = driver.findElements(By.cssSelector(".accordion__button"));
        dropdownButtons.get(questionNumber).click();
    }

    public void scroll() {
        WebElement questionsSection = driver.findElement(By.xpath("//div[contains(text(), 'Вопросы о важном')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", questionsSection);
    }

    public void closeCookie() {
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
    }

    public void openMainPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public OrderPage1 clickOnOrderButton(String scrollTo, String orderButton) {
        WebElement orderSection = driver.findElement(By.className(scrollTo));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", orderSection);
        driver.findElement(By.cssSelector(orderButton)).click();
        return new OrderPage1(driver);
    }
}
