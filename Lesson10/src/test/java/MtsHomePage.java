import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MtsHomePage extends BasePage {
    @FindBy(xpath = "//button[contains(text(), 'Принимаю')]")
    private WebElement acceptCookiesButton;

    public MtsHomePage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookiesIfPresent() {
        try {
            click(acceptCookiesButton);
        } catch (Exception e) {
            System.out.println("Cookie popup not found or already accepted");
        }
    }

    public OnlinePaymentPage getOnlinePaymentSection() {
        return new OnlinePaymentPage(driver);
    }
}
