package com.wrpl.contendriver.catalogselection;

import com.wrpl.contentdriver.main.ContentDriverMainClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class countrySelection extends ContentDriverMainClass {

    @BeforeTest(description = "Start browser and navigate to application URL")
    public void launchApplication() {
       super.driverSetUp();
       super.startBrowser();
    }

    @BeforeMethod(description = "Login")
    public void loginToApplication () {
        super.submitCredentials();
    }


    @Test(description = "Select country")
    public void selectCountry () {
            try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            WebElement CountrySelection = driver.findElement(By.xpath("//span[contains(.,'Austria')]"));
            wait.until(ExpectedConditions.elementToBeClickable(CountrySelection));
            CountrySelection.click();
            WebElement selectedOption = driver.findElement(By.xpath("//span[contains(.,'Belgium')]"));
            selectedOption.click();
            String selectedCountry = driver.findElement(By.cssSelector(".mat-select-value-text > .ng-tns-c14-1")).getText();
            System.out.println("Country " + selectedCountry + " is selected");
            Assert.assertEquals(selectedCountry, "Belgium");
            } catch (Exception e) {
                System.out.println("Country selection failed.");
            }
        }



    @AfterTest(description = "Browser shut down")
     public void browserShutDown() {
            super.browserShutDown();
        }
    }

