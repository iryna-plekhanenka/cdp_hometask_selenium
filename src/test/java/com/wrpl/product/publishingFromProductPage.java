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


public class publishingFromProductPage extends ContentDriverMainClass {

    @BeforeTest(description = "Start browser and navigate to application")
    public void launchApplication (){
        super.driverSetUp();
        super.startBrowser();
    }

    @BeforeMethod (description = "Login")
    public void loginToApplication (){
        super.submitCredentials();
    }

    @Test(description = "Open product")
    public void addToTheCatalog () {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".cd-title > .ng-star-inserted")));
            WebElement searchField = driver.findElement(By.cssSelector("input.search-input"));
            searchField.sendKeys(" 855023701020");
            WebElement searchButton = driver.findElement(By.cssSelector("button.search-btn"));
            searchButton.click();
            WebElement checkbox = driver.findElement(By.xpath(".//div/mat-checkbox/label/div"));
            boolean checkboxIsDisplayed = checkbox.isDisplayed();
            System.out.println("Product is found: "+checkboxIsDisplayed);
            WebElement product = driver.findElement(By.linkText("855023701020"));
            product.click();
            WebElement mediaTab = driver.findElement(By.xpath("//media/h1[1]"));
            boolean productIsOpen = mediaTab.isDisplayed();
            Assert.assertTrue(productIsOpen);
            //wait for page to load
            WebDriverWait wait3 = new WebDriverWait(driver, 30);
            wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn-dark mat-raised-button']")));
            //click on "Add to the catalog" button
            WebElement addToTheCatalogButton = driver.findElement(By.xpath("//button[@class='btn-dark mat-raised-button']"));
            addToTheCatalogButton.click();
            //check that product is added to the catalog - "Remove from the catalog" button appears
            WebDriverWait wait4 = new WebDriverWait(driver, 30);
            wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn-dark unpublish-btn mat-raised-button ng-star-inserted']")));
            WebElement removeFromTheCatalogButton = driver.findElement(By.xpath("//button[@class='btn-dark unpublish-btn mat-raised-button ng-star-inserted']"));
            boolean productIsPublished = removeFromTheCatalogButton.isDisplayed();
            Assert.assertTrue(productIsPublished);
            System.out.println("Test passed: product is published.");
        }catch (Exception e){
            System.out.println("Test failed.");
        }
    }

    @AfterTest(description = "Browser shut down")
    public void browserShutDown () {
        super.browserShutDown();
    }
}

