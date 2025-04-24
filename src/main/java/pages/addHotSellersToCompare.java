package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class addHotSellersToCompare extends BasePage{
    public addHotSellersToCompare(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".block.widget.block-products-list .product-item")
    List<WebElement> hotSellerProducts;


    @FindBy(xpath = "//div[@data-ui-id='message-success']")
    WebElement compareMessage;

    @FindBy(xpath = "//a[@title='Compare Products']")
    WebElement compareProductsAction;

    private WebElement getCompareButton(WebElement product) {
        return product.findElement(By.cssSelector(".action.tocompare"));
    }

    public void addFirstTwoHotSellersToCompare(int count) {
        List<String> addedProductNames = new ArrayList<>();

        int added = 0;
        waitingListElementsToView(hotSellerProducts);
        for (int i = 0; i < count; i++) {
            try {
            WebElement product = hotSellerProducts.get(i);
            WebElement compareBtn = getCompareButton(product);
            Actions actions = new Actions(driver);
            actions.moveToElement(product).perform();
            waitingElementToView(compareBtn);
            clickElement(compareBtn);

            // Wait and assert
            waitingElementToView(compareMessage);    // Small wait to ensure UI updates
            Assert.assertTrue(compareMessage.isDisplayed());
            added++;
        } catch (Exception e) {
            System.out.println("Error adding product " + (i + 1) + " to compare list: " + e.getMessage());
        }
    }
    System.out.println("Total products added to compare: " + added);
}


    public void CompareProducts(){
        waitingElementToView(compareProductsAction);
        String actualAddProductsSize = compareProductsAction.getText();
        System.out.println(actualAddProductsSize);
        Assert.assertTrue(actualAddProductsSize.contains("2 items"),"The Comparison is Correct");
    }
}
