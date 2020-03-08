package mytests;

import com.crossasyst.BaseTest;
import com.crossasyst.pages.Authenticate;
import com.crossasyst.pages.AutomationHome;
import com.crossasyst.pages.CartCheckout;
import com.crossasyst.pages.TShirts;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderTShirts extends BaseTest {
    private static WebDriver driver;
    Authenticate authenticate;
    AutomationHome homePage;

    @BeforeClass(alwaysRun = true)
    public void initialize() {
        driver = getDriver();
        driver.get("http://automationpractice.com/index.php");
        authenticate = new Authenticate(driver);
        authenticate.signIn();
        homePage = new AutomationHome(driver);
    }

    @Test(description =  "Order t-shirts and validate the amount")
    public void validateOrderTShirts() throws InterruptedException {
        homePage.selectTShirts();
        CartCheckout checkoput = new CartCheckout(driver);
        TShirts tshirts = new TShirts(driver);
        scrollDownByPixels(400);
        tshirts.quickViewFadedTShirt();

        tshirts.switchFrame();

        tshirts.increaseQuantity();
        tshirts.addToCart();
        tshirts.switchToParentFrame();
        tshirts.clickProceedToCheckout();

        String orderPut = checkoput.totalPrice.getText();
        scrollDownByPixels(800);
        checkoput.clickProceedToCheckout();
        scrollDownByPixels(1000);
        checkoput.clickProceedToShipping();
        scrollDownByPixels(800);
        checkoput.checkAggreTermsOfService();
        checkoput.clickProceedToPayment();
        scrollDownByPixels(800);
        checkoput.payByWire();
        checkoput.confirmOrder();

        checkoput.clickBackToOrders();
        String orderplaced = checkoput.getTotalPriceOrdered();

        Assert.assertTrue(orderPut.trim().equals(orderplaced.trim()), "Successfully placed order.");

    }
}
