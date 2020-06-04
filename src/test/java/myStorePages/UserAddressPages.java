package myStorePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAddressPages {


    public UserAddressPages(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='content']/div[3]/a")
    private WebElement createAddressButton;


    public void clickCreateAddressButton() {
        createAddressButton.click();
    }
}

