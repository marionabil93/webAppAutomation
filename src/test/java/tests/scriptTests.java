package tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import pages.CreateNewAccountPage;
import pages.HomePage;
import pages.addHotSellersToCompare;


public class scriptTests extends baseTest {

    @Test(priority = 1)
    public void createAnAccount() {
        ExtentTest test = extent.createTest("Create an Account Successfully.");
        CreateNewAccountPage createAccountObj = new CreateNewAccountPage(driver);
        createAccountObj.registerUser();
        createAccountObj.verifyLoginSuccess();
        test.log(Status.PASS, "Registration Successfully.");
    }

  @Test(priority = 2)
  public void hotSellersSelection() {
      ExtentTest test = extent.createTest("Navigate To Hot sellers Successfully.");
      HomePage homepageObj = new HomePage(driver);
      homepageObj.NavigateToHotSellersSection();
      test.log(Status.PASS, "Navigation Successfully.");
    }

    @Test(priority = 3)
    public void addProducts() {
        ExtentTest test = extent.createTest("Add Products to Compare and Assert on it");
        addHotSellersToCompare addHotSellersProducts = new addHotSellersToCompare(driver);
        addHotSellersProducts.addFirstTwoHotSellersToCompare(2);
        addHotSellersProducts.CompareProducts();
       test.log(Status.PASS, "Products Comparison Successfully");
    }
}

