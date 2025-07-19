import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.*;

public class MtsOnlinePaymentTest {
    private WebDriver driver;
    private MtsHomePage homePage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new MtsHomePage(driver);
        driver.get("https://www.mts.by/");
        homePage.acceptCookiesIfPresent();
    }

    @Test
    public void testOnlinePaymentBlock() {
        OnlinePaymentPage paymentPage = homePage.getOnlinePaymentSection();

         List<String> paymentTypes = paymentPage.getAvailablePaymentTypes();
        assertEquals(4, paymentTypes.size());
        assertTrue(paymentTypes.contains("Услуги связи"));
        assertTrue(paymentTypes.contains("Домашний интернет"));
        assertTrue(paymentTypes.contains("Рассрочка"));
        assertTrue(paymentTypes.contains("Задолженность"));

        verifyConnectionServicesInputs(paymentPage);

        paymentPage.selectPaymentType("Домашний интернет");
        verifyHomeInternetInputs(paymentPage);

        paymentPage.selectPaymentType("Рассрочка");
        verifyInstallmentInputs(paymentPage);

        paymentPage.selectPaymentType("Задолженность");
        verifyArrearsInputs(paymentPage);
    }




    private void verifyConnectionServicesInputs(OnlinePaymentPage page) {
        assertTrue(page.isPhoneInputDisplayed());
        assertTrue(page.isAmountInputDisplayed());
        assertTrue(page.isEmailInputDisplayed());
        assertTrue(page.isContinueButtonDisplayed());
    }

    private void verifyHomeInternetInputs(OnlinePaymentPage page) {
        assertTrue(page.isAmountInputDisplayed());
        assertTrue(page.isEmailInputDisplayed());
        assertFalse(page.isAbonentPhoneInputDisplayed());
    }

    private void verifyInstallmentInputs(OnlinePaymentPage page) {
        assertTrue(page.isPhoneInputDisplayed());
        assertTrue(page.isAmountInputDisplayed());
        assertTrue(page.isEmailInputDisplayed());
    }

    private void verifyArrearsInputs(OnlinePaymentPage page) {
        assertTrue(page.isPhoneInputDisplayed());
        assertTrue(page.isAmountInputDisplayed());
        assertTrue(page.isEmailInputDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
