package Login;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import myStorePages.AddressesPages;
import myStorePages.LoginPage;
import myStorePages.UserAddressPages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private AddressesPages addressesPage;
    private UserAddressPages userAddressPage;


    @Given("^Login user to My Store$")
    public void userIsLoggedInToTheShop() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=addresses");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("roujhcvaispqndcwux@awdrt.org", "coderslab");
        //Assert.assertEquals("Ewa Gumowska", loginPage.getLoggedUsername());
    }


    @When("^User go to page - add new address$")
    public void userGoesToNewAddressPage() {
        UserAddressPages yourAddressPage = new UserAddressPages(driver);
        yourAddressPage.clickCreateAddressButton();
    }


    @And("^User completed information (.*), (.*), (.*), (.*), (.*), (.*) on address page$")
    public void userEnterAliasAddressCityPostCodeCountryPhoneOnYourAccountPage
            (String alias, String address, String city, String postCode, String country, String phone) {
        this.addressesPage = new AddressesPages(driver);
        addressesPage.setAlias(alias);
        Assert.assertEquals("Wacek", addressesPage.getAliasCheck());

        addressesPage.setAddress(address);
        Assert.assertEquals("Blotna", addressesPage.getAddressCheck());

        addressesPage.setCityInput(city);
        Assert.assertEquals("Wachock", addressesPage.getCityCheck());

        addressesPage.setPostCodeInput(postCode);
        Assert.assertEquals("11-111", addressesPage.getPostCodeCheck());

        addressesPage.roleDropCountry(country);
        Assert.assertEquals("United Kingdom", addressesPage.getCountryCheck());

        addressesPage.setPhoneInput(phone);
        Assert.assertEquals("+48 111 111 111", addressesPage.getPhoneCheck());

        addressesPage.clickSaveButton();
    }


    @Then("^User delete 'My address'$")
    public void delateAddress() {
       // WebElement delateAddress = driver.findElement(By.xpath("//*[@id=\"address-3586\"]/div[2]/a[2]"));
       // delateAddress.click();
        // zły xpath
    }


    @And("^Close browser$")
    public void tearDown() {
        //driver.quit();
    }


}





