import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class OnlinePaymentPage extends BasePage {
    @FindBy(xpath = "//h2[contains(text(), 'Онлайн пополнение без комиссии')]/ancestor::div[contains(@class, 'section')]")
    private WebElement paymentBlock;

    @FindBy(id = "pay")
    private WebElement paymentTypeDropdown;

    @FindBy(xpath = ".//input[@placeholder='Номер телефона']")
    private WebElement phoneInput;

    @FindBy(xpath = ".//input[@placeholder='Номер абонента']")
    private WebElement abonentPhoneInput;

    @FindBy(xpath = ".//input[@placeholder='Сумма']")
    private WebElement amountInput;

    @FindBy(xpath = ".//input[@placeholder='E-mail для отправки чека']")
    private WebElement emailInput;

    @FindBy(xpath = ".//input[@placeholder='Номер договора']")
    private WebElement contractInput;

    @FindBy(xpath = ".//button[contains(text(), 'Продолжить')]")
    private WebElement continueButton;

    public OnlinePaymentPage(WebDriver driver) {
        super(driver);
    }

    public Select getPaymentTypeSelect() {
        return new Select(paymentTypeDropdown);
    }

    public void selectPaymentType(String type) {
        getPaymentTypeSelect().selectByVisibleText(type);
    }

    public List<String> getAvailablePaymentTypes() {
        return getPaymentTypeSelect().getOptions().stream()
                .map(WebElement::getText)
                .toList();
    }

    public boolean isPhoneInputDisplayed() {
        return phoneInput.isDisplayed();
    }

    public boolean isAbonentPhoneInputDisplayed() {
        return abonentPhoneInput.isDisplayed();
    }

    public boolean isAmountInputDisplayed() {
        return amountInput.isDisplayed();
    }

    public boolean isEmailInputDisplayed() {
        return emailInput.isDisplayed();
    }

    public boolean isContractInputDisplayed() {
        return contractInput.isDisplayed();
    }

    public boolean isContinueButtonDisplayed() {
        return continueButton.isDisplayed();
    }




    @FindBy(xpath = "//div[contains(@class, 'payment-popup')]//div[contains(@class, 'phone-number')]")
    private WebElement popupPhoneNumber;

    @FindBy(xpath = "//div[contains(@class, 'payment-popup')]//div[contains(@class, 'amount')]")
    private WebElement popupAmount;

    public void enterPhoneNumber(String phone) {
        type(phoneInput, phone);
    }

    public void enterEmail(String email) {
        type(emailInput, email);
    }

    public void enterAmount(String amount) {
        type(amountInput, amount);
    }

    public void clickContinueButton() {
        click(continueButton);
    }

    public boolean isPaymentPopupDisplayed() {
        try {
            waitForVisibility(paymentPopup);
            return paymentPopup.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getPopupPhoneNumber() {
        waitForVisibility(popupPhoneNumber);
        return popupPhoneNumber.getText();
    }

    public String getPopupAmount() {
        waitForVisibility(popupAmount);
        return popupAmount.getText();
    }

    @FindBy(className = "bepaid-app")
    private WebElement paymentPopup;

    public void switchToPaymentIframe() {
        waitForVisibility(paymentPopup);
        WebElement iframe = paymentPopup.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
    }

    public void switchBackToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public boolean isPaymentIframeVisible() {
        try {
            waitForVisibility(paymentPopup);
            WebElement iframe = paymentPopup.findElement(By.tagName("iframe"));
            return iframe.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
