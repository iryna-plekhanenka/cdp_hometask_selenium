package com.wrpl.product;


import com.wrpl.contentdriver.main.ContentDriverMainClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

public class searchByValid12NC extends ContentDriverMainClass {

    @BeforeTest(description = "Start browser and navigate to application")
    public void launchApplication (){
        super.driverSetUp();
        super.startBrowser();
    }

    @BeforeMethod (description = "Login")
    public void loginToApplication (){
        super.submitCredentials();
    }

    @Test(description = "Login and search by valid product code (12NC)")
    public void searchByValidProductCode () {
          try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".cd-title > .ng-star-inserted")));
            WebElement searchField = driver.findElement(By.cssSelector("input.search-input"));
            searchField.sendKeys(" 855023701020,859991570650");
            WebElement searchButton = driver.findElement(By.cssSelector("button.search-btn"));
            searchButton.click();
            List<WebElement> checkboxes = driver.findElements(By.xpath(".//div/mat-checkbox/label/div"));
            Assert.assertEquals(checkboxes.size(), 2);
            System.out.println("Test passed: number of found products is " + checkboxes.size());
          }catch (Exception e){
              System.out.println("Test failed.");
          }

    }


    @AfterTest(description = "Browser shut down")
    public void browserShutDown () {
        super.browserShutDown();
    }
}

