package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }


    // Click element with explicit wait
    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    // Send keys with explicit wait
    public void enterText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    // Scroll to element
    public void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollInWindow(WebElement element) {
        js.executeScript("window.scrollBy(0,500)", "");
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Click using JavaScript
    public void clickUsingJS(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    public void waitingElementToView(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitingListElementsToView(List<WebElement> list) {
        wait.until(ExpectedConditions.visibilityOfAllElements(list));
    }
}
