package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.*;

public class MtsWebsiteTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10); // 10 seconds timeout
    }

    @Test
    public void testHomePageHeading() {
        // Open the website
        driver.get("https://www.mts.by/");

        acceptCookiesIfPresent();

        WebElement heading = driver.findElement(By.xpath("//h2[contains(., 'Онлайн пополнение') and contains(., 'без комиссии')]"));

        assertTrue("Heading element should be displayed", heading.isDisplayed());

        String headingText = heading.getText();
        assertTrue("Heading should contain 'Онлайн пополнение'",
                headingText.contains("Онлайн пополнение"));
        assertTrue("Heading should contain 'без комиссии'",
                headingText.contains("без комиссии"));
    }

    @Test
    public void testPaymentSystemsSection() {

        driver.get("https://www.mts.by/");

        acceptCookiesIfPresent();

        WebElement paymentSection = driver.findElement(By.cssSelector("div.pay__partners"));
        assertTrue("Payment section should be displayed", paymentSection.isDisplayed());

        List<WebElement> paymentSystems = paymentSection.findElements(By.tagName("li"));
        assertFalse("Payment systems list should not be empty", paymentSystems.isEmpty());

        String[] expectedSystems = {
                "Visa",
                "Verified By Visa",
                "MasterCard",
                "MasterCard Secure Code",
                "Белкарт"
        };

        for (String expectedSystem : expectedSystems) {
            WebElement system = driver.findElement(By.cssSelector(
                    String.format("div.pay__partners img[alt='%s']", expectedSystem)
            ));
            assertTrue(
                    String.format("Payment system '%s' should be displayed", expectedSystem),
                    system.isDisplayed()
            );
        }
    }

    @Test
    public void testServiceDetailsButtonRedirect() {
        // 1. Open main page
        driver.get("https://www.mts.by/");

        acceptCookiesIfPresent();

        WebElement detailsButton = new WebDriverWait(driver, 10) // seconds
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[contains(text(),'Подробнее о сервисе')]")
                ));
        detailsButton.click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.not(
                        ExpectedConditions.urlToBe("https://www.mts.by/")
                ));

        assertTrue(driver.getCurrentUrl().contains("poryadok-oplaty"));
    }


    @Test
    public void testFormSubmissionWithPopup() {

        driver.get("https://www.mts.by/");

        acceptCookiesIfPresent();

        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input.phone#connection-phone")
        ));
        phoneInput.clear();
        phoneInput.sendKeys("297777777");

        WebElement emailInput = driver.findElement(By.cssSelector("input[type='email']"));
        emailInput.clear();
        emailInput.sendKeys("test@mail.ru");

        WebElement submitButton = driver.findElement(By.xpath(
                "//button[contains(@class, 'button__default') and contains(text(), 'Продолжить')]"
        ));
        submitButton.click();

        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.modal, div.popup, div[role='dialog']")
        ));
        assertTrue("Popup should be displayed", popup.isDisplayed());

        assertTrue("Popup should contain success message",
                popup.getText().contains("успешно") || popup.getText().contains("отправлено"));
    }

    private void acceptCookiesIfPresent() {
        try {
            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(), 'Принять')]")
            ));
            acceptButton.click();
        } catch (TimeoutException e) {

        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}