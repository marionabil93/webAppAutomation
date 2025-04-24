package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='logo']")
    WebElement homePageLogo;


    @FindBy(xpath = "//span[@class='base']")
    WebElement homePageTitle;


    @FindBy(xpath = "//h2[@class='title']")
    WebElement hotSellersSection;

    public void navigateToHomePage(){
        clickElement(homePageLogo);
        Assert.assertTrue(homePageTitle.isDisplayed(),"HomePage Title is Displayed");
    }

    public void scrollToHotSellers() {
        scrollToElement(hotSellersSection);
    }

    public void NavigateToHotSellersSection(){
        this.navigateToHomePage();
        this.scrollToHotSellers();
        Assert.assertTrue(hotSellersSection.isDisplayed(),"HomePage Title is Displayed");
    }
}
