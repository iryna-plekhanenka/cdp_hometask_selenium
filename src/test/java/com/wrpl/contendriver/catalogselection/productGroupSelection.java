package com.wrpl.contendriver.catalogselection;

import com.wrpl.contentdriver.main.ContentDriverMainClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class productGroupSelection extends ContentDriverMainClass {

        @BeforeTest(description = "Start browser and navigate to application URL")
        public void launchApplication() {
            super.driverSetUp();
            super.startBrowser();
        }

        @BeforeMethod(description = "Login")
        public void loginToApplication () {
            super.submitCredentials();
        }

        @Test(description = "Select product group")
        public void selectProductGroup () {
            try {
                WebDriverWait wait = new WebDriverWait(driver, 20);
                WebElement ProductGroupSelection = driver.findElement(By.xpath("//span[contains(.,'All product groups')]"));
                wait.until(ExpectedConditions.elementToBeClickable(ProductGroupSelection));
                ProductGroupSelection.click();
                WebElement selectedOption = driver.findElement(By.xpath("//span[contains(.,'Air Conditioner')]"));
                selectedOption.click();
                WebElement searchButton = driver.findElement(By.cssSelector("button.search-btn"));
                searchButton.click();
                List<WebElement> numberOfProducts = driver.findElements(By.xpath(".//div/mat-checkbox/label/div"));
                Assert.assertEquals(numberOfProducts.size(), 2);
                System.out.println("Test passed: number of found products is " + numberOfProducts.size());
                //count number of returned products
//                List<WebElement> checkboxes = driver.findElements(By.cssSelector(".cdk-overlay-backdrop"));
//                Assert.assertEquals(checkboxes.size(), 1);
            } catch (Exception e) {
                System.out.println("Product group selection failed.");
        }
    }

    @AfterTest(description = "Browser shut down")
     public void browserShutDown() {
            super.browserShutDown();
        }
    }


