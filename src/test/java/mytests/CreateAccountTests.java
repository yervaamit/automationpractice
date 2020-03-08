package mytests;

import com.crossasyst.BaseTest;
import com.crossasyst.pages.Authenticate;
import com.crossasyst.pages.AutomationHome;
import com.crossasyst.pages.CreateAccount;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateAccountTests extends BaseTest {

    private static WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void initialize() {
        driver = getDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test(description = "To create and verify the account created.")
    public void createAccountTest() throws InterruptedException {
        AutomationHome homePage = new AutomationHome(driver);
        CreateAccount newAccount = new CreateAccount(driver);
        Authenticate newAuthenticate = new Authenticate(driver);
        homePage.signIn();
        newAuthenticate.setNewEmailAddr("test-amit@test.com");
        newAuthenticate.clickCreateAccountButton();

        newAccount.setTitle("Mr");
        newAccount.setFirstNameVal("Amit");
        newAccount.setLastNameVal("Y");
        newAccount.setPasswordVal("12345678");
        newAccount.setDay(1);
        Thread.sleep(5000);
        newAccount.setMonth("January");
        newAccount.setYear(2000);
        newAccount.setSubscribeForNewsLetter(true);
        newAccount.setOptInForSpecialOffers(true);

        newAccount.setFirstNameAddr("Amit");
        newAccount.setLastNameAddr("Y");
        newAccount.setCompany("crossasyst");
        newAccount.setAddrLine("111, Oxford society");
        newAccount.setCityVal("Boston");
        newAccount.setStateVal("Illinois");
        newAccount.setAddrZipCode(123456);

        newAccount.setAddtionalInformation("Hello World..!!");
        newAccount.setMobilePhoneNumb("1234567890");
        newAccount.setAddrAlias("New address");

        newAccount.registerAccount();



    }
}
